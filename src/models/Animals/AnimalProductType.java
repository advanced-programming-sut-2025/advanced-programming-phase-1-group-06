package models.Animals;

import models.ItemFaces.Item;

/**
 * Enum representing different types of animal products with their qualities
 * @author hassanp30
 * @since 2025-05-14
 */
public enum AnimalProductType {
    // Chicken products
    NORMAL_EGG("Egg", 50, true, false, 50, 1, AnimalType.CHICKEN),
    SILVER_EGG("Egg", 62, true, false, 60, 2, AnimalType.CHICKEN),
    GOLD_EGG("Egg", 75, true, false, 70, 3, AnimalType.CHICKEN),
    IRIDIUM_EGG("Egg", 100, true, false, 80, 4, AnimalType.CHICKEN),

    NORMAL_LARGE_EGG("Large Egg", 95, true, false, 75, 1, AnimalType.CHICKEN),
    SILVER_LARGE_EGG("Large Egg", 119, true, false, 85, 2, AnimalType.CHICKEN),
    GOLD_LARGE_EGG("Large Egg", 142, true, false, 95, 3, AnimalType.CHICKEN),
    IRIDIUM_LARGE_EGG("Large Egg", 190, true, false, 105, 4, AnimalType.CHICKEN),

    // Duck products
    NORMAL_DUCK_EGG("Duck Egg", 95, true, false, 75, 1, AnimalType.DUCK),
    SILVER_DUCK_EGG("Duck Egg", 119, true, false, 85, 2, AnimalType.DUCK),
    GOLD_DUCK_EGG("Duck Egg", 142, true, false, 95, 3, AnimalType.DUCK),
    IRIDIUM_DUCK_EGG("Duck Egg", 190, true, false, 105, 4, AnimalType.DUCK),

    NORMAL_DUCK_FEATHER("Duck Feather", 250, false, false, 0, 1, AnimalType.DUCK),
    SILVER_DUCK_FEATHER("Duck Feather", 312, false, false, 0, 2, AnimalType.DUCK),
    GOLD_DUCK_FEATHER("Duck Feather", 375, false, false, 0, 3, AnimalType.DUCK),
    IRIDIUM_DUCK_FEATHER("Duck Feather", 500, false, false, 0, 4, AnimalType.DUCK),

    // Rabbit products
    NORMAL_WOOL("Wool", 340, false, false, 0, 1, AnimalType.RABBIT),
    SILVER_WOOL("Wool", 425, false, false, 0, 2, AnimalType.RABBIT),
    GOLD_WOOL("Wool", 510, false, false, 0, 3, AnimalType.RABBIT),
    IRIDIUM_WOOL("Wool", 680, false, false, 0, 4, AnimalType.RABBIT),

    NORMAL_RABBIT_FOOT("Rabbit's Foot", 565, false, false, 0, 1, AnimalType.RABBIT),
    SILVER_RABBIT_FOOT("Rabbit's Foot", 706, false, false, 0, 2, AnimalType.RABBIT),
    GOLD_RABBIT_FOOT("Rabbit's Foot", 847, false, false, 0, 3, AnimalType.RABBIT),
    IRIDIUM_RABBIT_FOOT("Rabbit's Foot", 1130, false, false, 0, 4, AnimalType.RABBIT),

    // Dinosaur products
    NORMAL_DINOSAUR_EGG("Dinosaur Egg", 350, true, false, 100, 1, AnimalType.DINOSAUR),
    SILVER_DINOSAUR_EGG("Dinosaur Egg", 437, true, false, 115, 2, AnimalType.DINOSAUR),
    GOLD_DINOSAUR_EGG("Dinosaur Egg", 525, true, false, 130, 3, AnimalType.DINOSAUR),
    IRIDIUM_DINOSAUR_EGG("Dinosaur Egg", 700, true, false, 145, 4, AnimalType.DINOSAUR),

    // Cow products
    NORMAL_MILK("Milk", 125, true, false, 25, 1, AnimalType.COW),
    SILVER_MILK("Milk", 156, true, false, 35, 2, AnimalType.COW),
    GOLD_MILK("Milk", 187, true, false, 45, 3, AnimalType.COW),
    IRIDIUM_MILK("Milk", 250, true, false, 55, 4, AnimalType.COW),

    NORMAL_LARGE_MILK("Large Milk", 190, true, false, 50, 1, AnimalType.COW),
    SILVER_LARGE_MILK("Large Milk", 237, true, false, 65, 2, AnimalType.COW),
    GOLD_LARGE_MILK("Large Milk", 285, true, false, 80, 3, AnimalType.COW),
    IRIDIUM_LARGE_MILK("Large Milk", 380, true, false, 95, 4, AnimalType.COW),

    // Goat products
    NORMAL_GOAT_MILK("Goat Milk", 225, true, false, 50, 1, AnimalType.GOAT),
    SILVER_GOAT_MILK("Goat Milk", 281, true, false, 65, 2, AnimalType.GOAT),
    GOLD_GOAT_MILK("Goat Milk", 337, true, false, 80, 3, AnimalType.GOAT),
    IRIDIUM_GOAT_MILK("Goat Milk", 450, true, false, 95, 4, AnimalType.GOAT),

    NORMAL_LARGE_GOAT_MILK("Large Goat Milk", 345, true, false, 100, 1, AnimalType.GOAT),
    SILVER_LARGE_GOAT_MILK("Large Goat Milk", 431, true, false, 115, 2, AnimalType.GOAT),
    GOLD_LARGE_GOAT_MILK("Large Goat Milk", 517, true, false, 130, 3, AnimalType.GOAT),
    IRIDIUM_LARGE_GOAT_MILK("Large Goat Milk", 690, true, false, 145, 4, AnimalType.GOAT),

    // Sheep products
    NORMAL_SHEEP_WOOL("Sheep Wool", 340, false, false, 0, 1, AnimalType.SHEEP),
    SILVER_SHEEP_WOOL("Sheep Wool", 425, false, false, 0, 2, AnimalType.SHEEP),
    GOLD_SHEEP_WOOL("Sheep Wool", 510, false, false, 0, 3, AnimalType.SHEEP),
    IRIDIUM_SHEEP_WOOL("Sheep Wool", 680, false, false, 0, 4, AnimalType.SHEEP),

    // Pig products
    NORMAL_TRUFFLE("Truffle", 625, true, false, 125, 1, AnimalType.PIG),
    SILVER_TRUFFLE("Truffle", 781, true, false, 145, 2, AnimalType.PIG),
    GOLD_TRUFFLE("Truffle", 937, true, false, 165, 3, AnimalType.PIG),
    IRIDIUM_TRUFFLE("Truffle", 1250, true, false, 185, 4, AnimalType.PIG);

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

    /**
     * Creates a new AnimalProduct instance
     * @return A new AnimalProduct instance
     */
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