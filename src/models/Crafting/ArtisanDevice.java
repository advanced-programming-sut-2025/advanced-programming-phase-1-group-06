package models.Crafting;

import models.App;
import models.ItemFaces.InventoryItem;
import models.Player.Player;

import java.util.ArrayList;

/**
 * Last updated by: hassanp30
 * Last updated at: 2025-05-13 12:44:07 UTC
 */
public class ArtisanDevice {
    private long startTime;
    private int craftingTime;
    private boolean status;
    private boolean ready;
    private ArrayList<Recipe> recipes;
    private InventoryItem craftedItem;

    public ArtisanDevice(ArtisanDeviceTypes type) {
        this.recipes = new ArrayList<>(type.recipes);
        this.status = false;
        this.ready = false;
        this.startTime = 0;
    }
    //  save
    public ArtisanDevice(long startTime, int craftingTime, boolean status, boolean ready, ArrayList<Recipe> recipes, InventoryItem craftedItem) {
        this.startTime = startTime;
        this.craftingTime = craftingTime;
        this.status = status;
        this.ready = ready;
        this.recipes = new ArrayList<>(recipes);
        this.craftedItem = craftedItem;
    }

    public ArtisanDevice(ArrayList<Recipe> recipes, InventoryItem craftedItem) {
        this.recipes = new ArrayList<>(recipes);
        this.craftedItem = craftedItem;
        this.status = false;
        this.ready = true;
        this.startTime = 0;
        this.craftingTime = 0;
    }

    public void craft(Recipe recipe, Player player) {
        if (!recipes.contains(recipe)) {
            return;
        }

        for (InventoryItem item : recipe.getIngredients()) {
            if (!(player.getInventory().checkExistense(item.getId(), item.getAmount()))){
                System.out.println("insufficient materials");
                return;
            }
        }

        // Remove ingredients from player's inventory
        for (InventoryItem ingredient : recipe.getIngredients()) {
            player.getInventory().removeItem(player.getInventory().getItemById(ingredient.getId()), ingredient.getAmount());
        }

        // Start crafting process
        startTime = App.getPreciseTime();
        craftingTime = recipe.getCraftingTime();
        status = true;
        ready = false;
        craftedItem = recipe.getResult();
    }

    public int handleTime() {
        long remainingTime = craftingTime - (App.getPreciseTime() - startTime);
        if (remainingTime > 0) {
            return (int) remainingTime;
        }
        status = false;
        ready = true;
        return 0;
    }

    public boolean isReady() {
        return ready;
    }

    public boolean getStatus() {
        return status;
    }

    public InventoryItem getCraftedItem() {
        return craftedItem;
    }

    public ArrayList<Recipe> getRecipes() {
        return new ArrayList<>(recipes);
    }
}