package models.PlantsAndForaging;

import models.Animals.Animal;
import models.ItemFaces.*;

public class AnimalProduct extends InventoryItem implements Sellable, Edible{

    Animal source;
    String name;
    int price;
    boolean isEdible;
    int quality;


    AnimalProduct(Item item){
        name = item.getName();
        price = item.getPrice();
        isEdible = item.isEdible();
    }

    public Animal getSource() {
        return source;
    }

    public void setSource(Animal source) {
        this.source = source;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

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
