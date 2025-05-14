package models.Animals;

import models.ItemFaces.*;

public class AnimalProduct extends InventoryItem implements Sellable, Edible{

    AnimalType source;
    String name;
    int price;
    boolean isEdible;
    int quality;


    public AnimalProduct(Item item){
        name = item.getName();
        price = item.getPrice();
        isEdible = item.isEdible();
    }

    public AnimalType getSource() {
        return source;
    }

    public void setSource(AnimalType source) {
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

    public AnimalProduct(AnimalType animalSource, String name, int price, boolean isEdible, int quality) {
        this.source = source;
        this.name = name;
        this.price = price;
        this.isEdible = isEdible;
        this.quality = quality;
    }
}
