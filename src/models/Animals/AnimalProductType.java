package models.Animals;

import models.ItemFaces.Item;

/**
 * Enum representing different types of animal products
 * @author hassanp30
 * @since 2025-05-14
 */
public enum AnimalProductType {
    // Chicken products
    EGG("Egg", 50, true, false, 50, new Item("Egg", 50, true)),
    LARGE_EGG("Large Egg", 95, true, false, 75, new Item("Large Egg", 95, true)),

    // Duck products
    DUCK_EGG("Duck Egg", 95, true, false, 75, new Item("Duck Egg", 95, true)),
    DUCK_FEATHER("Duck Feather", 250, false, false, 0, new Item("Duck Feather", 250, false)),

    // Rabbit products
    WOOL("Wool", 340, false, false, 0, new Item("Wool", 340, false)),
    RABBIT_FOOT("Rabbit's Foot", 565, false, false, 0, new Item("Rabbit's Foot", 565, false)),

    // Dinosaur products
    DINOSAUR_EGG("Dinosaur Egg", 350, true, false, 100, new Item("Dinosaur Egg", 350, true)),

    // Cow products
    MILK("Milk", 125, true, false, 25, new Item("Milk", 125, true)),
    LARGE_MILK("Large Milk", 190, true, false, 50, new Item("Large Milk", 190, true)),

    // Goat products
    GOAT_MILK("Goat Milk", 225, true, false, 50, new Item("Goat Milk", 225, true)),
    LARGE_GOAT_MILK("Large Goat Milk", 345, true, false, 100, new Item("Large Goat Milk", 345, true)),

    // Sheep products
    SHEEP_WOOL("Sheep Wool", 340, false, false, 0, new Item("Sheep Wool", 340, false)),

    // Pig products
    TRUFFLE("Truffle", 625, true, false, 125, new Item("Truffle", 625, true));

    private final String name;
    private final int basePrice;
    private final boolean isEdible;
    private final boolean isPlaceable;
    private final int energy;
    private final Item item;
    private final int quality;
    private final AnimalType source;

    AnimalProductType(String name, int basePrice, boolean isEdible, boolean isPlaceable, int energy, Item item, int quality, AnimalType source) {
        this.name = name;
        this.basePrice = basePrice;
        this.isEdible = isEdible;
        this.isPlaceable = isPlaceable;
        this.energy = energy;
        this.item = item;
        this.quality = quality;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public boolean isPlaceable() {
        return isPlaceable;
    }

    public int getEnergy() {
        return energy;
    }

    public Item getItem() {
        return item;
    }


    public AnimalProduct createProduct() {
        AnimalProduct product = new AnimalProduct(this.item);
        product.setSource(source);
        if (energy != 0) {
            product.setEnergy(this.energy);
            product.isEdible = true;
        }
        return product;
    }
}