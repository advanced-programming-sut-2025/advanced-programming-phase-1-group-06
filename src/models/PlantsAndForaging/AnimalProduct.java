package models.PlantsAndForaging;

import models.Animals.Animal;
import models.ItemFaces.Edible;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;

public class AnimalProduct extends InventoryItem implements Sellable, Edible{

    Animal source;
    String name;
    int price;
    boolean isEdible;
    int quality;


    @Override
    public void eat() {

    }

    @Override
    public int getEnergy() {
        return 0;
    }

    @Override
    public void setEnergy(int energy) {

    }

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void setPrice(int price) {

    }

}
