package models.Crafting;

import models.ItemFaces.*;
import models.PlantsAndForaging.AnimalProduct;
import models.PlantsAndForaging.Info.AnimalProductInfo;

import java.util.ArrayList;
public enum RecipeInfo {
    CHEESE(null, 4 * 24, 75, 350, "It's a sweet syrup produced by bees.", "honey"),
    CHEESE(100, 230),
    MAYONNAISE(50, 190),
    GOAT_CHEESE(100, 400),
    DUCK_MAYONNAISE(75, 37),
    DINOSAUR_MAYONNAISE(125, 800),
    BEER(new ArrayList<InventoryItem>(){{
        add(ItemFinder.WHEAT.getInventoryItem());
    }} , 24 ,50, 200, "Drink in moderation.","beer"),
    VINEGAR(13, 100),
    COFFEE(75, 150),
    JUICE(2 * BaseIngredientEnergy, 2.25 * BaseIngredientPrice),
    MEAD(100, 300),
    PALE_ALE(50, 300),
    WINE(1.75 * BaseFruitEnergy, 3 * BaseFruitPrice),
    PICKLES(2 * BaseIngredientEnergy + 50, 2 * BasePrice + 50),
    JELLY(2 * BaseFruitEnergy + 50, 2 * BaseFruitPrice + 50),
    DRIED_MUSHROOMS(50, 7.5 * MushroomBasePrice + 25),
    DRIED_FRUIT(75, 7.5 * FruitBasePrice + 25),
    RAISINS(125, 600),
    SMOKED_FISH(1.5 * FishEnergy, 2 * FishPrice),
    //  artisan inedible shit
    CLOTH(470),
    COAL(50),
    ANY_METAL_BAR(10 * OrePrice),
    TRUFFLE_OIL(1065),
    OIL(100),
    ANY_METAL_BAR(10 * OrePrice),


    ;
    private ArrayList<InventoryItem> ingredients;
    private Item craftedItem;
    private int energy;
    private int time; // in hours
    private int price;

    RecipeInfo(ArrayList<InventoryItem> ingredients, int time, int energy, int price, String description, String name){
        Item item = new Item();
        this.ingredients = ingredients;
        this.time = time;
        this.energy = energy;
        this.price = price;
        if (price != 0){
            item.setPrice(price);
            item.setSellable(true);
        }
        if (energy != 0){
            item.setEnergy(energy);
        }
        craftedItem = item;
    }

    RecipeInfo(ArrayList<InventoryItem> ingredients, int time, double energyCoefficient, int basePrice, double priceCoefficient, String description, String name){
        this.ingredients = ingredients;
        this.time = time;
        Item item = new Item();
        if (energyCoefficient != 0) {
            this.energy = (int) (((Edible) ingredients.getFirst()).getEnergy() * energyCoefficient);
            ((Edible)item).setEnergy(energy);
            item.setEnergy(energy);
        }
        if (priceCoefficient != 0 || basePrice != 0) {
            this.price = basePrice + (int) (((Sellable)ingredients.getFirst()).getPrice() * priceCoefficient);
            ((Sellable)item).setPrice(price);
            item.setPrice(price);
        }
        this.craftedItem = item;
    }

    public Item getCraftedItem() {
        return craftedItem;
    }
}
