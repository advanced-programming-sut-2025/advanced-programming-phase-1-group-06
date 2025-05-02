package models.Recipes;

import models.Player.Inventory;

import java.util.Map;

public class Recipe {
    private int ID;
    private String name;
    private Map<String, Integer> ingredients;
    private Type type;

    public boolean canCraft(Inventory inventory) {
        for (Map.Entry<String, Integer> ingredient : ingredients.entrySet()) {
            if (! inventory.hasItemAmount(ingredient.getKey(), ingredient.getValue())) return false;
        }
        return true;
    }

    enum Type {
        CRAFTING,
        COOKING;
    }
}
