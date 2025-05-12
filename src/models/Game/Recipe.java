package models.Game;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<InventoryItem> ingredients;
    private Item craftedItem;
    int time; // in hours

    public Recipe(ArrayList<InventoryItem> ingredients, Item craftedItem, int time) {
        this.ingredients = ingredients;
        this.craftedItem = craftedItem;
        this.time = time;
    }

    public boolean canCraft() {
        // Implement logic to check if the recipe can be crafted
        return true;
    }

    public InventoryItem craft() {
        // Implement logic to craft item
        return null;
    }
}

