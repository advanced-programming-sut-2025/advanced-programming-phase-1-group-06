package models.CraftingAndCooking;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;

import java.util.ArrayList;

public enum CookingRecipeInfo {
    FRIED_EGG(),

    ;

    CookingRecipeInfo(){};

    CookingRecipeInfo(String name, int energy, ArrayList<InventoryItem> ingredients, String description, boolean starter, int price) {
        this.name = name;
        this.energy = energy;
        this.ingredients = ingredients;
        this.description = description;
        this.starter = starter;
        this.price = price;
    }

    private  String name;
    private  int energy;
    private  ArrayList<InventoryItem> ingredients;
    private  String description;
    private  boolean starter;
    private  int price;



    public Item createResult(){
        Item result = new Item(name, energy, price);
        result.setAmount(1);
        return result;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public ArrayList<InventoryItem> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStarter() {
        return starter;
    }

    public int getPrice() {
        return price;
    }
}
