package com.ap.Model.Item;

import com.ap.Model.Recipe;
import com.google.gson.*;
import java.io.FileReader;
import java.util.*;

public class Factory {
    private static Factory instance;

    HashMap<String, ItemData> items = new HashMap<>();
    HashMap<String, OverlayData> overlays;

    // Optional: from earlier steps
    HashMap<String, java.util.Map<String, Integer>> recipes;

    // Track which itemIds are artisan devices
    private final Set<String> artisanDeviceIds = new HashSet<>();

    // LEGACY: For each device itemId, store: HashMap<OUTPUT Item, ArrayList<INPUT Item>>
    private final Map<String, HashMap<Item, ArrayList<Item>>> deviceRecipeMaps = new HashMap<>();

    // NEW: device -> (outputId -> (ingredientId -> count))
    private final Map<String, Map<String, Map<String,Integer>>> deviceRecipeMapsCounts = new HashMap<>();

    // NEW: device -> ArrayList<Recipe> (each recipe.itemId == outputId, ingredients == inputs)
    private final Map<String, ArrayList<Recipe>> deviceRecipeLists = new HashMap<>();

    // Also remember processing hours for each OUTPUT (per device)Recipe
    private final Map<String, Map<String,Integer>> deviceProcessingHours = new HashMap<>();

    // --- Category support ---
    private final Map<String, Set<String>> itemCategoriesById = new HashMap<String, Set<String>>(); // itemId -> categories
    private final Map<String, Set<String>> categoryIndex = new HashMap<String, Set<String>>();       // category -> itemIds

    public static Factory getInstance() {
        if (instance == null) instance = new Factory();
        return instance;
    }

    public Factory() {
        try {
            Gson gson = new GsonBuilder().create();

            // Load base items via ItemDataRoot (existing behavior)
            FileReader reader = new FileReader("core/src/main/java/com/ap/Data/ItemData.json");
            ItemDataRoot root = gson.fromJson(reader, ItemDataRoot.class);
            if (root != null) {
                if (root.harvested_crops != null) for (ItemData d : root.harvested_crops) items.put(d.id, d);
                if (root.seeds != null)           for (ItemData d : root.seeds)           items.put(d.id, d);
                if (root.tools != null)           for (ItemData d : root.tools)           items.put(d.id, d);
                if (root.artisan_goods != null)   for (ItemData d : root.artisan_goods)   items.put(d.id, d);
                if (root.craftables != null)      for (ItemData d: root.craftables)       items.put(d.id, d);
                try {
                    if (root.food != null)           for (ItemData d: root.food) {
                        items.put(d.id, d);
                        System.out.println(d.name);
                    }
                    if (root.crafting_ingredients != null) for (ItemData d : root.crafting_ingredients) items.put(d.id, d);
                } catch (Throwable ignored) {}
            }

            // Raw JSON pass: collect categories for ALL items, and build devices
            FileReader rawReader = new FileReader("core/src/main/java/com/ap/Data/ItemData.json");
            JsonObject rawRoot = gson.fromJson(rawReader, JsonObject.class);

            if (rawRoot != null) {
                // --- 2.a Collect categories on every item in every top-level array ---
                for (Map.Entry<String, JsonElement> top : rawRoot.entrySet()) {
                    JsonElement val = top.getValue();
                    if (val == null || !val.isJsonArray()) continue;
                    JsonArray arr = val.getAsJsonArray();
                    for (JsonElement je : arr) {
                        if (je == null || !je.isJsonObject()) continue;
                        JsonObject obj = je.getAsJsonObject();
                        if (!obj.has("id")) continue;
                        String itemId = obj.get("id").getAsString();
                        if (obj.has("categories") && obj.get("categories").isJsonArray()) {
                            JsonArray cats = obj.getAsJsonArray("categories");
                            for (JsonElement ce : cats) {
                                if (ce == null || !ce.isJsonPrimitive()) continue;
                                String cat = ce.getAsString();
                                if (cat == null || cat.isEmpty()) continue;
                                addCategoryForItem(itemId, cat);
                            }
                        }
                    }
                }

                // --- 2.b Devices (build recipe maps & lists) ---
                if (rawRoot.has("artisan_devices") && rawRoot.get("artisan_devices").isJsonArray()) {
                    JsonArray devices = rawRoot.getAsJsonArray("artisan_devices");
                    for (JsonElement el : devices) {
                        if (!el.isJsonObject()) continue;
                        JsonObject dev = el.getAsJsonObject();
                        String id   = optString(dev,"id");
                        String name = optString(dev,"name");
                        String desc = optString(dev,"description");
                        int stack   = optInt(dev,"stackSize",1);
                        String tex  = optString(dev,"texture");
                        int sell    = dev.has("sellPrice") && !dev.get("sellPrice").isJsonNull()
                            ? dev.get("sellPrice").getAsInt() : 0;

                        if (id != null && !id.isEmpty()) {
                            // ensure device itself is an item
                            ItemData data = items.get(id);
                            if (data == null) {
                                data = new ItemData();
                                data.id = id;
                                data.name = name;
                                data.description = desc;
                                data.stackSize = stack;
                                data.texture = tex;
                                data.basePrice = sell;
                                data.componentsData = new ArrayList<>();
                                items.put(id, data);
                            }
                            artisanDeviceIds.add(id);

                            // Per-device maps
                            HashMap<Item, ArrayList<Item>> legacyOutToInputs = new HashMap<>();
                            Map<String,Integer> outToHours = new HashMap<>();
                            Map<String, Map<String,Integer>> outToCounts = new HashMap<>();
                            ArrayList<Recipe> recipeList = new ArrayList<>();

                            if (dev.has("deviceRecipes") && dev.get("deviceRecipes").isJsonArray()) {
                                JsonArray arr = dev.getAsJsonArray("deviceRecipes");
                                for (JsonElement e : arr) {
                                    if (!e.isJsonObject()) continue;
                                    JsonObject r = e.getAsJsonObject();
                                    String outputId = optString(r,"outputId");
                                    int hours = optInt(r,"processingHours", 1);
                                    if (outputId == null) continue;

                                    // --- Build counted ingredients map ---
                                    Map<String,Integer> counted = new HashMap<>();

                                    // Prefer new "ingredients" map
                                    if (r.has("ingredients") && r.get("ingredients").isJsonObject()) {
                                        JsonObject ings = r.getAsJsonObject("ingredients");
                                        for (Map.Entry<String, JsonElement> ing : ings.entrySet()) {
                                            if (ing.getValue() != null && ing.getValue().isJsonPrimitive()) {
                                                counted.put(ing.getKey(), ing.getValue().getAsInt());
                                            }
                                        }
                                    }
                                    // Fallback to legacy "inputIds" list (collapse to counts)
                                    else if (r.has("inputIds") && r.get("inputIds").isJsonArray()) {
                                        JsonArray inArr = r.getAsJsonArray("inputIds");
                                        for (JsonElement ie : inArr) {
                                            String inId = ie.getAsString();
                                            counted.put(inId, counted.getOrDefault(inId, 0) + 1);
                                        }
                                    }

                                    // --- Build LEGACY array list from counts so old code keeps working ---
                                    Item outputItem = createItem(outputId);
                                    if (outputItem == null) {
                                        outputItem = new Item(outputId, outputId, "Virtual output", 999);
                                    }
                                    ArrayList<Item> legacyInputs = new ArrayList<>();
                                    for (Map.Entry<String,Integer> ing : counted.entrySet()) {
                                        String inId = ing.getKey();
                                        int c = Math.max(1, ing.getValue());
                                        for (int i = 0; i < c; i++) {
                                            Item in;
                                            if (inId.startsWith("cat:")) {
                                                in = new Item(inId, inId, "Category placeholder", 999);
                                            } else {
                                                in = createItem(inId);
                                                if (in == null) in = new Item(inId, inId, "Virtual input", 999);
                                            }
                                            legacyInputs.add(in);
                                        }
                                    }

                                    legacyOutToInputs.put(outputItem, legacyInputs);
                                    outToCounts.put(outputId, counted);
                                    outToHours.put(outputId, hours);

                                    // --- Build Recipe object for the device recipe (itemId = outputId) ---
                                    Recipe deviceRecipe = buildRecipeViaReflection(
                                        outputId,
                                        items.get(outputId) != null ? items.get(outputId).name : outputId,
                                        counted
                                    );
                                    if (deviceRecipe != null) {
                                        recipeList.add(deviceRecipe);
                                    }
                                }
                            }

                            deviceRecipeMaps.put(id, legacyOutToInputs);          // legacy list
                            deviceRecipeMapsCounts.put(id, outToCounts);          // counted map
                            deviceRecipeLists.put(id, recipeList);                // ArrayList<Recipe>
                            deviceProcessingHours.put(id, outToHours);
                        }
                    }
                }
            }

            // Load craftable recipes from Recipes.json into 'recipes' as Map<String,Integer>
            try {
                FileReader recipesReader = new FileReader("core/src/main/java/com/ap/Data/Recipes.json");
                JsonObject recipesRoot = gson.fromJson(recipesReader, JsonObject.class);
                if (recipesRoot != null && recipesRoot.has("recipes") && recipesRoot.get("recipes").isJsonArray()) {
                    this.recipes = new HashMap<String, Map<String,Integer>>();
                    JsonArray arr = recipesRoot.getAsJsonArray("recipes");
                    for (JsonElement rel : arr) {
                        if (rel == null || !rel.isJsonObject()) continue;
                        JsonObject r = rel.getAsJsonObject();
                        if (!r.has("itemId")) continue;
                        String itemId = r.get("itemId").getAsString();
                        Map<String,Integer> req = new HashMap<String,Integer>();
                        if (r.has("ingredients") && r.get("ingredients").isJsonObject()) {
                            JsonObject ings = r.getAsJsonObject("ingredients");
                            for (Map.Entry<String, JsonElement> ing : ings.entrySet()) {
                                if (ing.getValue() != null && ing.getValue().isJsonPrimitive()) {
                                    req.put(ing.getKey(), ing.getValue().getAsInt());
                                }
                            }
                        }
                        this.recipes.put(itemId, req);
                    }
                }
            } catch (Exception ignore) {
                // Recipes.json optional; keep existing behavior if absent
            }

            // Keep static Recipe.load as in your original
            Recipe.load();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------------- Category helpers ----------------------

    private void addCategoryForItem(String itemId, String category) {
        Set<String> cats = itemCategoriesById.get(itemId);
        if (cats == null) {
            cats = new HashSet<String>();
            itemCategoriesById.put(itemId, cats);
        }
        cats.add(category);

        Set<String> ids = categoryIndex.get(category);
        if (ids == null) {
            ids = new HashSet<String>();
            categoryIndex.put(category, ids);
        }
        ids.add(itemId);
    }

    /** Test membership: does this itemId belong to 'categoryKey' (e.g., "any_fruit")? */
    public boolean isItemInCategory(String itemId, String categoryKey) {
        Set<String> members = categoryIndex.get(categoryKey);
        return members != null && members.contains(itemId);
    }

    // ---------------------- Item creation ----------------------

    public Item createItem(String itemId) { return createItem(itemId, 1); }

    public Item createItem(String itemId, int amount) {
        ItemData data = items.get(itemId);
        if (data == null) return null;

        Item item = new Item(data.id, data.name, data.description, data.stackSize);
        if (data.getBasePrice() != 0) item.setPrice(data.getBasePrice());
        item.setAmount(amount);
        item.setTexturePath(data.texture);

        // Attach categories collected from ItemData.json
        Set<String> cats = itemCategoriesById.get(itemId);
        if (cats != null && !cats.isEmpty()) {
            item.setCategories(new HashSet<String>(cats));
        }

        if (data.componentsData != null) {
            for (ComponentData component : data.componentsData) {
                if (component == null || component.type == null) continue;
                try {
                    Class<?> cls = Class.forName("com.ap.Model.Item." + component.type);
                    Object instance = cls.getDeclaredConstructor().newInstance();
                    if (instance instanceof Component) {
                        Component comp = (Component) instance;
                        java.lang.reflect.Field[] srcFields = ComponentData.class.getDeclaredFields();
                        for (java.lang.reflect.Field sf : srcFields) {
                            try {
                                java.lang.reflect.Field tf = cls.getDeclaredField(sf.getName());
                                tf.setAccessible(true);
                                sf.setAccessible(true);
                                Object val = sf.get(component);
                                if (val != null && !(val instanceof Number && ((Number) val).intValue() == 0)) {
                                    tf.set(comp, val);
                                }
                            } catch (NoSuchFieldException ignored) {}
                        }
                        comp.setObject(item);
                        item.addComponent(comp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (artisanDeviceIds.contains(item.getId())) {
            ArtisanDeviceComponent deviceComp = new ArtisanDeviceComponent(item);

            // Legacy recipes (ArrayList<Item>) preserved
            HashMap<Item, ArrayList<Item>> legacyMap = deviceRecipeMaps.get(item.getId());
            if (legacyMap != null) {
                try {
                    deviceComp.setRecipes(legacyMap);
                } catch (Throwable ignored) {}
            }

            // New counted-map (if the component wants it via optional methods)
            Map<String, Map<String,Integer>> countedMap = deviceRecipeMapsCounts.get(item.getId());
            if (countedMap != null) {
                try {
                    deviceComp.getClass().getMethod("setRecipesMap", Map.class).invoke(deviceComp, countedMap);
                } catch (Throwable t1) {
                    try {
                        deviceComp.getClass().getMethod("setRecipeCounts", Map.class).invoke(deviceComp, countedMap);
                    } catch (Throwable ignored) {}
                }
            }

            // NEW: pass the ArrayList<Recipe> list
            ArrayList<Recipe> list = deviceRecipeLists.get(item.getId());
            if (list != null) {
                try {
                    deviceComp.setRecipesList(list);
                } catch (Throwable ignored) {}
            }

            Map<String,Integer> hours = deviceProcessingHours.get(item.getId());
            if (hours != null) {
                try {
                    deviceComp.setProcessingHours(hours);
                } catch (Throwable ignored) {}
            }
            item.addComponent(deviceComp);
        }

        return item;
    }

    public Item cloneItem(Item item, int amount) {
        Item n = new Item(item.getId(), item.getName(), item.getDescription(), item.getStackSize());
        for (Component c : item.getComponents().values()) n.addComponent(c);
        n.setAmount(amount);
        return n;
    }

    public Item createItemByName(String name) {
        for (ItemData d : items.values()) if (d.id.equalsIgnoreCase(name)) return createItem(d.id);
        return null;
    }

    public Item createItemByName(String name, int amount) {
        for (ItemData d : items.values()) if (d.id.equalsIgnoreCase(name)) return createItem(d.id, amount);
        return null;
    }

    public boolean isArtisanDevice(String itemId) { return artisanDeviceIds.contains(itemId); }

    // LEGACY getter (unchanged signature):
    public HashMap<Item, ArrayList<Item>> getDeviceRecipes(String deviceItemId) {
        return deviceRecipeMaps.get(deviceItemId);
    }

    // NEW helper (optional): access counted map directly if you need it elsewhere
    public Map<String, Map<String,Integer>> getDeviceRecipeMap(String deviceItemId) {
        return deviceRecipeMapsCounts.get(deviceItemId);
    }

    public Integer getProcessingHoursFor(String deviceItemId, String outputItemId) {
        Map<String,Integer> m = deviceProcessingHours.get(deviceItemId);
        return m == null ? null : m.get(outputItemId);
    }

    private static String optString(JsonObject obj, String key) {
        return obj.has(key) && !obj.get(key).isJsonNull() ? obj.get(key).getAsString() : null;
    }
    private static int optInt(JsonObject obj, String key, int fallback) {
        return obj.has(key) && !obj.get(key).isJsonNull() ? obj.get(key).getAsInt() : fallback;
    }

    /**
     * Build a Recipe instance via reflection (if Recipe has private fields and no public ctor).
     * Sets itemId, itemName, ingredients.
     */
    private Recipe buildRecipeViaReflection(String itemId, String itemName, Map<String,Integer> ingredients) {
        try {
            Class<?> rc = Class.forName("com.ap.Model.Recipe");
            Object r = rc.getDeclaredConstructor().newInstance();

            // itemId
            try {
                java.lang.reflect.Field f = rc.getDeclaredField("itemId");
                f.setAccessible(true);
                f.set(r, itemId);
            } catch (NoSuchFieldException ignored) {}

            // itemName
            try {
                java.lang.reflect.Field f = rc.getDeclaredField("itemName");
                f.setAccessible(true);
                f.set(r, itemName);
            } catch (NoSuchFieldException ignored) {}

            // ingredients
            try {
                java.lang.reflect.Field f = rc.getDeclaredField("ingredients");
                f.setAccessible(true);
                f.set(r, new HashMap<String,Integer>(ingredients));
            } catch (NoSuchFieldException ignored) {}

            return (Recipe) r;
        } catch (Throwable t) {
            // If Recipe changes later, fail gracefully
            return null;
        }
    }
}
