package com.ap.Model;

import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Recipe {
    private String itemId;
    private String itemName;
    private Map<String, Integer> ingredients;

    private static class Root {
        List<Recipe> recipes;
    }

    private static final ArrayList<Recipe> ALL = new ArrayList<>();
    private static final LinkedHashMap<String, Recipe> BY_ID = new LinkedHashMap<>();

    public static void load() {
        try (Reader reader = Gdx.files.internal("core/src/main/java/com/ap/Data/Recipes.json").reader(StandardCharsets.UTF_8.name())) {
            Gson gson = new GsonBuilder().create();
            Root root = gson.fromJson(reader, Root.class);

            ALL.clear();
            BY_ID.clear();

            if (root != null && root.recipes != null) {
                ALL.addAll(root.recipes);
                for (Recipe r : ALL) {
                    if (r.itemId != null) {
                        BY_ID.put(r.itemId, r);
//                        System.out.println(r.ingredients);
                    }
                }
            }
            Gdx.app.log("Recipe", "Loaded " + ALL.size() + " recipes.");
        } catch (Exception e) {
            Gdx.app.error("Recipe", "Failed to load recipes from Data/Recipes.json", e);
        }
    }

    public ArrayList<Item> getIngredient(){
        ArrayList<Item> items = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            Item item = Factory.getInstance().createItemByName(entry.getKey(), entry.getValue());
            if (item == null){
                System.out.println(entry.getKey());
            }
            items.add(item);
        }
        return items;
    }

    public String getToolTip(){
        StringBuilder sb = new StringBuilder(itemName).append("\n");
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()){
            sb.append(entry.getValue()).append("x ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }

    public Item getItem(){
        return Factory.getInstance().createItem(itemId);
    }

    // --- Convenience accessors ---
    public static List<Recipe> all() { return Collections.unmodifiableList(ALL); }
    public static Recipe getById(String id) { return BY_ID.get(id); }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public Map<String, Integer> getIngredients() { return ingredients; }
}
