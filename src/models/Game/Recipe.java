package models.Game;

import models.Itemfaces.InventoryItem;

import java.util.Map;

public class Recipe {
    private Map<String, Integer> ingredientAmounts;

    public boolean canCraft() {
        // Implement logic to check if the recipe can be crafted
        return true;
    }

    public InventoryItem craft() {
        // Implement logic to craft item
        return null;
    }
}

