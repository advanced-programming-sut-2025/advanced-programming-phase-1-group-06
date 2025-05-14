package models.Crafting;

import models.ItemFaces.InventoryItem;
import java.util.ArrayList;

/**
 * Last updated by: hassanp30
 * Last updated at: 2025-05-13 12:44:07 UTC
 */
public class Recipe {
    private final ArrayList<InventoryItem> ingredients;
    private final InventoryItem result;
    private final int craftingTime;  // in hours
    private final String description;

    public Recipe(ArrayList<InventoryItem> ingredients, InventoryItem result, int craftingTime, String description) {
        this.ingredients = ingredients;
        this.result = result;
        this.craftingTime = craftingTime;
        this.description = description;
    }

    public Recipe(RecipeInfo recipeInfo){
        ingredients = recipeInfo.getIngredients();
        craftingTime = recipeInfo.getTime();
        result = recipeInfo.getResult();
        description = recipeInfo.getDescription();
    }

    public ArrayList<InventoryItem> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public InventoryItem getResult() {
        return result;
    }

    public int getCraftingTime() {
        return craftingTime;
    }

    public String getDescription() {
        return description;
    }
}