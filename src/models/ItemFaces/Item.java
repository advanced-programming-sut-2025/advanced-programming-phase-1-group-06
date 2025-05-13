package models.ItemFaces;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class Item extends InventoryItem implements Edible, Sellable, Placeable{

    private boolean isEdible;
    private boolean isSellable;
    private boolean isPlaceable;
    private int price;
    private int energy;


    public Item(boolean isEdible, boolean isSellable, boolean isPlaceable, int price, int energy) {
        this.isEdible = isEdible;
        this.isSellable = isSellable;
        this.isPlaceable = isPlaceable;
        this.price = price;
        this.energy = energy;
    }
// for sellable edible items
    public Item(int energy, int price){
        isEdible = true;
        this.energy = energy;
        isSellable = true;
        this.price = price;
    }

//    for sellable only
    public Item(int price){
        isEdible = false;
        this.energy = 0;
        isSellable = true;
        this.price = price;
    }

    @Override
    public void eat() {

    }

    @Override
    public void place(Coordinates coordinate) {

    }

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return price;
    }
}
