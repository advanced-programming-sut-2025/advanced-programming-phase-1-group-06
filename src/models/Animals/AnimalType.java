package models.enums;

import models.Animals.Animal;
import models.enums.AnimalProducts;

import java.util.ArrayList;
import java.util.HashMap;

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
    private final HashMap<AnimalProducts, Boolean> products;
    private final ArrayList<String> validHouses;
    private final int housingCapacity;

    AnimalType(String name, int basePrice, HashMap<AnimalProducts, Boolean> products, ArrayList<String> validHouses, int housingCapacity) {
        this.name = name;
        this.basePrice = basePrice;
        this.products = products;
        this.validHouses = validHouses;
        this.housingCapacity = housingCapacity;
    }

    // Helper methods to create product maps for each animal
    private static HashMap<AnimalProducts, Boolean> createChickenProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.EGG, true);
        products.put(AnimalProducts.LARGE_EGG, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createDuckProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.DUCK_EGG, true);
        products.put(AnimalProducts.DUCK_FEATHER, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createRabbitProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.WOOL, true);
        products.put(AnimalProducts.RABBIT_FOOT, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createDinosaurProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.DINOSAUR_EGG, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createCowProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.MILK, true);
        products.put(AnimalProducts.LARGE_MILK, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createGoatProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.GOAT_MILK, true);
        products.put(AnimalProducts.LARGE_GOAT_MILK, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createSheepProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.WOOL, true);
        return products;
    }

    private static HashMap<AnimalProducts, Boolean> createPigProducts() {
        HashMap<AnimalProducts, Boolean> products = new HashMap<>();
        products.put(AnimalProducts.TRUFFLE, true);
        return products;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public HashMap<AnimalProducts, Boolean> getProducts() {
        return products;
    }

    public ArrayList<String> getValidHouses() {
        return validHouses;
    }

    public int getHousingCapacity() {
        return housingCapacity;
    }

    // Method to create a new Animal instance
    public Animal createAnimal(String name) {
        return new Animal(name, basePrice, products, validHouses) {};
    }
}