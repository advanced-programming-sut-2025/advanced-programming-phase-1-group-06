package models.CraftingAndCooking;

import models.App;
import models.ItemFaces.InventoryItem;
import models.Player.Player;

import java.util.ArrayList;

public class ArtisanDevice {
    private final String name;
    private long startTime;
    private int craftingTime;
    private boolean status;
    private boolean ready;
    private ArrayList<ArtisanRecipe> artisanRecipes;
    private InventoryItem craftedItem;

    public ArtisanDevice(ArtisanDeviceTypes type) {
        this.name = type.getName();
        this.artisanRecipes = new ArrayList<>(type.artisanRecipes);
        this.status = false;
        this.ready = false;
        this.startTime = 0;
    }

    // Updated save constructor
    public ArtisanDevice(String name, long startTime, int craftingTime, boolean status, boolean ready,
                         ArrayList<ArtisanRecipe> artisanRecipes, InventoryItem craftedItem) {
        this.name = name;
        this.startTime = startTime;
        this.craftingTime = craftingTime;
        this.status = status;
        this.ready = ready;
        this.artisanRecipes = new ArrayList<>(artisanRecipes);
        this.craftedItem = craftedItem;
    }

    public ArtisanDevice(String name, ArrayList<ArtisanRecipe> artisanRecipes, InventoryItem craftedItem) {
        this.name = name;
        this.artisanRecipes = new ArrayList<>(artisanRecipes);
        this.craftedItem = craftedItem;
        this.status = false;
        this.ready = true;
        this.startTime = 0;
        this.craftingTime = 0;
    }

    // Add getter for name
    public String getName() {
        return name;
    }

    public void craft(ArtisanRecipe artisanRecipe, Player player) {
        if (!artisanRecipes.contains(artisanRecipe)) {
            return;
        }

        for (InventoryItem item : artisanRecipe.getIngredients()) {
            if (!(player.getInventory().hasItemAmount(item.getName(), item.getAmount()))){
                System.out.println("insufficient materials");
                return;
            }
        }

        // Remove ingredients from player's inventory
        for (InventoryItem ingredient : artisanRecipe.getIngredients()) {
            player.getInventory().removeItem(ingredient.getName(), ingredient.getAmount());
        }

        // Start crafting process
        startTime = App.getPreciseTime();
        craftingTime = artisanRecipe.getCraftingTime();
        status = true;
        ready = false;
        craftedItem = artisanRecipe.getResult();
    }

    public void handleTime() {
        long remainingTime = craftingTime - (App.getPreciseTime() - startTime);
        if (remainingTime > 0) {
            return;
        }
        status = false;
        ready = true;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public boolean getStatus() {
        return status;
    }

    public InventoryItem getCraftedItem() {
        return craftedItem;
    }

    public ArrayList<ArtisanRecipe> getRecipes() {
        return new ArrayList<>(artisanRecipes);
    }


}