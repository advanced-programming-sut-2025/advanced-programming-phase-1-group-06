package com.ap.Model;

import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FilterOutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Recipe {
    private String itemId;
    private String itemName;
    private Map<String, Integer> ingredients;

    private static class Root {
        List<Recipe> recipes = new ArrayList<>();
        List<Recipe> food_recipes = new ArrayList<>();
    }

    private static final ArrayList<Recipe> RECIPES = new ArrayList<>();
    private static final ArrayList<Recipe> FOOD_RECIPES = new ArrayList<>();
    private static final LinkedHashMap<String, Recipe> BY_ID = new LinkedHashMap<>();

    public static void load() {
        try (Reader reader = Gdx.files.internal("core/src/main/java/com/ap/Data/Recipes.json").reader(StandardCharsets.UTF_8.name())) {
            Gson gson = new GsonBuilder().create();
            Root root = gson.fromJson(reader, Root.class);

            FOOD_RECIPES.clear();
            RECIPES.clear();
            BY_ID.clear();

            if (root != null && root.recipes != null) {
                RECIPES.addAll(root.recipes);
                for (Recipe r : RECIPES) {
                    if (r.itemId != null) {
                        BY_ID.put(r.itemId, r);
//                        System.out.println(r.ingredients);
                    }
                }
//                for (Recipe r : root.food_recipes){
//                    System.out.println(r.itemId);
//                }
                FOOD_RECIPES.addAll(root.food_recipes);
                for (Recipe r : FOOD_RECIPES){
                    if (r.itemId != null) {
                        BY_ID.put(r.itemId, r);
                    }
                }
            }
            for (Recipe r : FOOD_RECIPES){
//                System.out.println(r.getItem().getName());
            }
            Gdx.app.log("Recipe", "Loaded " + RECIPES.size() + " recipes.");
            Gdx.app.log("food Recipe", "Loaded " + FOOD_RECIPES.size() + " recipes.");
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
    public static List<Recipe> getCraftables() { return Collections.unmodifiableList(RECIPES); }

    public static List<Recipe> getCookables() { return Collections.unmodifiableList(FOOD_RECIPES); }

    public static Recipe getById(String id) { return BY_ID.get(id); }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public Map<String, Integer> getIngredients() { return ingredients; }
}
