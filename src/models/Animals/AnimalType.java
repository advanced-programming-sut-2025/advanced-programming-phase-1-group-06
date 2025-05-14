package models.Animals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Enum representing different types of animals in the game
 * @author hassanp30
 * @since 2025-05-14
 */
public enum AnimalType {
    // Caged Animals
    CHICKEN("Chicken", 800, createChickenProducts(), new ArrayList<>(List.of("CAGE", "UPGRADED_CAGE")), 4),
    DUCK("Duck", 1200, createDuckProducts(), new ArrayList<>(List.of("LARGE_CAGE", "DELUXE_CAGE")), 8),
    RABBIT("Rabbit", 8000, createRabbitProducts(), new ArrayList<>(List.of("DELUXE_CAGE")), 12),
    DINOSAUR("Dinosaur", 14000, createDinosaurProducts(), new ArrayList<>(List.of("LARGE_CAGE")), 8),

    // Barn Animals
    COW("Cow", 1500, createCowProducts(), new ArrayList<>(List.of("BARN", "UPGRADED_BARN", "DELUXE_BARN")), 4),
    GOAT("Goat", 4000, createGoatProducts(), new ArrayList<>(List.of("LARGE_BARN", "DELUXE_BARN")), 8),
    SHEEP("Sheep", 8000, createSheepProducts(), new ArrayList<>(List.of("DELUXE_BARN")), 12),
    PIG("Pig", 16000, createPigProducts(), new ArrayList<>(List.of("DELUXE_BARN")), 12);

    private final String name;
    private final int basePrice;
    private final HashMap<AnimalProductType, Boolean> products;
    private final ArrayList<String> validHouses;
    private final int housingCapacity;

    AnimalType(String name, int basePrice, HashMap<AnimalProductType, Boolean> products, ArrayList<String> validHouses, int housingCapacity) {
        this.name = name;
        this.basePrice = basePrice;
        this.products = products;
        this.validHouses = validHouses;
        this.housingCapacity = housingCapacity;
    }

    // Helper methods to create product maps for each animal
    private static HashMap<AnimalProductType, Boolean> createChickenProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.EGG, true);
        products.put(AnimalProductType.LARGE_EGG, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createDuckProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.DUCK_EGG, true);
        products.put(AnimalProductType.DUCK_FEATHER, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createRabbitProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.WOOL, true);
        products.put(AnimalProductType.RABBIT_FOOT, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createDinosaurProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.DINOSAUR_EGG, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createCowProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.MILK, true);
        products.put(AnimalProductType.LARGE_MILK, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createGoatProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.GOAT_MILK, true);
        products.put(AnimalProductType.LARGE_GOAT_MILK, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createSheepProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.SHEEP_WOOL, true);
        return products;
    }

    private static HashMap<AnimalProductType, Boolean> createPigProducts() {
        HashMap<AnimalProductType, Boolean> products = new HashMap<>();
        products.put(AnimalProductType.TRUFFLE, true);
        return products;
    }

    /**
     * Gets the name of the animal type
     * @return The name of the animal type
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the base price of the animal
     * @return The base price of the animal
     */
    public int getBasePrice() {
        return basePrice;
    }

    /**
     * Gets the map of possible products for this animal type
     * @return HashMap of AnimalProductType to Boolean indicating possible products
     */
    public HashMap<AnimalProductType, Boolean> getProducts() {
        return products;
    }

    /**
     * Gets the list of valid houses for this animal type
     * @return ArrayList of valid house types
     */
    public ArrayList<String> getValidHouses() {
        return validHouses;
    }

    /**
     * Gets the housing capacity required for this animal type
     * @return The housing capacity
     */
    public int getHousingCapacity() {
        return housingCapacity;
    }

    /**
     * Creates a new Animal instance
     * @param name The name of the animal
     * @return A new Animal instance
     */
    public Animal createAnimal(String name) {
        return new Animal(name, basePrice, products, validHouses) {};
    }
}