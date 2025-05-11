package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;

public class Item implements InventoryItem {
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
}
