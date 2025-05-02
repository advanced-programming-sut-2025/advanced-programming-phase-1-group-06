package models.Recipes;

import models.Player.Inventory;

import java.util.Map;

public class Recipe {
    private final int ID;
    private final String name;
    private final Map<String, Integer> ingredients;
    private Type type;

    public boolean canCraft(Inventory inventory) {
        for (Map.Entry<String, Integer> ingredient : ingredients.entrySet()) {
            if (! inventory.hasItemAmount(ingredient.getKey(), ingredient.getValue())) return false;
        }
        return true;
    }

    public Recipe(RecipeInfo info) {
        ID = info.getId();
        name = info.getName();
        ingredients = info.getIngredients();
    }

    enum Type {
        CRAFTING,
        COOKING;
    }
}
