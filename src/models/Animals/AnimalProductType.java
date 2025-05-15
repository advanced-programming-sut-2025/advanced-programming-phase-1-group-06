package models.Animals;

import models.ItemFaces.Item;

public enum AnimalProductType {
    // Chicken products
    EGG("Egg", 50, true, false, 50, 1, AnimalType.CHICKEN),

    LARGE_EGG("Large Egg", 95, true, false, 75, 1, AnimalType.CHICKEN),

    // Duck products
    DUCK_EGG("Duck Egg", 95, true, false, 75, 1, AnimalType.DUCK),

    DUCK_FEATHER("Duck Feather", 250, false, false, 0, 1, AnimalType.DUCK),

    // Rabbit products
    WOOL("Wool", 340, false, false, 0, 1, AnimalType.RABBIT),

    RABBIT_FOOT("Rabbit's Foot", 565, false, false, 0, 1, AnimalType.RABBIT),

    // Dinosaur products
    DINOSAUR_EGG("Dinosaur Egg", 350, true, false, 100, 1, AnimalType.DINOSAUR),

    // Cow products
    MILK("Milk", 125, true, false, 25, 1, AnimalType.COW),

    LARGE_MILK("Large Milk", 190, true, false, 50, 1, AnimalType.COW),

    // Goat products
    GOAT_MILK("Goat Milk", 225, true, false, 50, 1, AnimalType.GOAT),

    LARGE_GOAT_MILK("Large Goat Milk", 345, true, false, 100, 1, AnimalType.GOAT),

    // Sheep products
    SHEEP_WOOL("Sheep Wool", 340, false, false, 0, 1, AnimalType.SHEEP),

    // Pig products
    TRUFFLE("Truffle", 625, true, false, 125, 1, AnimalType.PIG),

    ;

    private final String name;
    private final int price;
    private final boolean isEdible;
    private final boolean isPlaceable;
    private final int energy;
    private final int quality;
    private final AnimalType source;

    AnimalProductType(String name, int price, boolean isEdible, boolean isPlaceable, int energy, int quality, AnimalType source) {
        this.name = name;
        this.price = price;
        this.isEdible = isEdible;
        this.isPlaceable = isPlaceable;
        this.energy = energy;
        this.quality = quality;
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return price;
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

    public int getQuality() {
        return quality;
    }

    public AnimalType getSource() {
        return source;
    }

    public Item getItem() {
        if (this.isEdible()) {
            return new Item(this.name, this.price, true);
        }
        return new Item(this.name, this.price, false);
    }
    
    public AnimalProduct createProduct() {
        AnimalProduct product = new AnimalProduct(this.getItem());
        product.setQuality(this.quality);
        if (energy != 0) {
            product.setEnergy(this.energy);
            product.isEdible = true;
        }
        return product;
    }
}