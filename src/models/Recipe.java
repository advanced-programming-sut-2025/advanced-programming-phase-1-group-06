package models;

import java.util.Map;

public class Recipe {
    private Map<String, Integer> ingredientAmounts;

    public boolean canCraft() {
        // Implement logic to check if the recipe can be crafted
        return true;
    }

    public Item craft() {
        // Implement logic to craft item
        return null;
    }
}

