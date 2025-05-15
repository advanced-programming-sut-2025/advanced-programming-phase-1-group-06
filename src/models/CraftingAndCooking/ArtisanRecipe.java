package models.CraftingAndCooking;

import models.ItemFaces.InventoryItem;
import java.util.ArrayList;


public class ArtisanRecipe {
    private final ArrayList<InventoryItem> ingredients;
    private final InventoryItem result;
    private final int craftingTime;  // in hours
    private final String description;

    public ArtisanRecipe(ArrayList<InventoryItem> ingredients, InventoryItem result, int craftingTime, String description) {
        this.ingredients = ingredients;
        this.result = result;
        this.craftingTime = craftingTime;
        this.description = description;
    }

    public ArtisanRecipe(ArtisanRecipeInfo artisanRecipeInfo){
        ingredients = artisanRecipeInfo.getIngredients();
        craftingTime = artisanRecipeInfo.getTime();
        result = artisanRecipeInfo.getResult();
        description = artisanRecipeInfo.getDescription();
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