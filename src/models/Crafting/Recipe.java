package models.Crafting;

import models.ItemFaces.InventoryItem;

import java.util.Map;

public class Recipe {
    private Map<InventoryItem, Integer> ingredientAmounts;

    public boolean canCraft() {
        // Implement logic to check if the recipe can be crafted
        return true;
    }

    public InventoryItem craft() {
        // Implement logic to craft item
        return null;
    }
}

