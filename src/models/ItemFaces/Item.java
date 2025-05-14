package models.ItemFaces;

import models.Game.Coordinates;

public class Item extends InventoryItem implements Edible, Sellable, Placeable {

    private boolean isEdible;
    private boolean isSellable;
    private boolean isPlaceable;
    private int price;
    private int energy;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Item(boolean isEdible, boolean isSellable, boolean isPlaceable, int price, int energy, String description, String name) {
        this.isEdible = isEdible;
        this.isSellable = isSellable;
        this.isPlaceable = isPlaceable;
        this.price = price;
        this.energy = energy;
        this.description = description;
        this.name = name;
        }
        /*
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
    }*/

    public Item(){}

    public Item(String name){
        this.name = name;
    }

    @Override
    public void eat() {

    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public void setEdible(boolean edible) {
        isEdible = edible;
    }

    public boolean isSellable() {
        return isSellable;
    }

    public void setSellable(boolean sellable) {
        isSellable = sellable;
    }

    public boolean isPlaceable() {
        return isPlaceable;
    }

    public void setPlaceable(boolean placeable) {
        isPlaceable = placeable;
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

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
