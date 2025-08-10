package com.ap.Model;

import com.ap.Model.Item.ConsumableComponent;
import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;

import java.util.Map;

// New class to handle artisan recipes with dynamic pricing
public class ArtisanRecipe {
    private String outputItemId;
    private String outputItemName;
    private String description;
    private int baseEnergy; // for fixed energy items
    private int basePrice; // for fixed price items
    private PricingType pricingType;
    private double priceMultiplier; // for dynamic pricing
    private EnergyType energyType;
    private double energyMultiplier; // for dynamic energy
    private String inputCategory; // "fruit", "vegetable", "any", or specific item ID
    private Map<String, Integer> specificIngredients; // for recipes with specific ingredients

    public enum PricingType {
        FIXED,           // Fixed price (like Beer: 200g)
        MULTIPLIER,      // Price = ingredient base price × multiplier (like Wine: 3x)
        BASE_PLUS_MULTI  // Price = base + (ingredient price × multiplier)
    }

    public enum EnergyType {
        INEDIBLE,
        FIXED,           // Fixed energy (like Beer: 50)
        MULTIPLIER       // Energy = ingredient energy × multiplier (like Juice: 2x)
    }

    // Constructor for fixed price/energy items (like Beer, Mead, Pale Ale)
    public ArtisanRecipe(String outputItemId, String outputItemName, String description,
                        int basePrice, int baseEnergy, Map<String, Integer> specificIngredients) {
        this.outputItemId = outputItemId;
        this.outputItemName = outputItemName;
        this.description = description;
        this.basePrice = basePrice;
        this.baseEnergy = baseEnergy;
        this.pricingType = PricingType.FIXED;
        this.energyType = EnergyType.FIXED;
        this.specificIngredients = specificIngredients;
    }

    // Constructor for dynamic pricing items (like Wine, Juice)
    public ArtisanRecipe(String outputItemId, String outputItemName, String description,
                        PricingType pricingType, double priceMultiplier,
                        EnergyType energyType, double energyMultiplier,
                        String inputCategory) {
        this.outputItemId = outputItemId;
        this.outputItemName = outputItemName;
        this.description = description;
        this.pricingType = pricingType;
        this.priceMultiplier = priceMultiplier;
        this.energyType = energyType;
        this.energyMultiplier = energyMultiplier;
        this.inputCategory = inputCategory;
    }

    // Method to calculate the final price based on input ingredient
    public int calculatePrice(Item inputItem) {
        switch (pricingType) {
            case FIXED:
                return basePrice;
            case MULTIPLIER:
                return (int) (inputItem.getPrice() * priceMultiplier);
            case BASE_PLUS_MULTI:
                return (int) (basePrice + (inputItem.getPrice() * priceMultiplier));
            default:
                return basePrice;
        }
    }

    // Method to calculate the final energy based on input ingredient
    public int calculateEnergy(Item inputItem) {
        switch (energyType) {
            case FIXED:
                return baseEnergy;
            case MULTIPLIER:
                // Get energy from consumable component
                ConsumableComponent consumable = inputItem.getComponent(ConsumableComponent.class);
                if (consumable != null) {
                    return (int) (consumable.getEnergyRestore() * energyMultiplier);
                }
                return 0;
            default:
                return baseEnergy;
        }
    }

    // Method to check if an item can be used in this recipe
    public boolean canUseItem(Item item) {
        // Check specific ingredients first
        if (specificIngredients != null && !specificIngredients.isEmpty()) {
            return specificIngredients.containsKey(item.getId());
        }

        // Check category-based recipes
        if (inputCategory != null) {
            return Factory.getInstance().hasCategory(item, inputCategory);
        }

        return false;
    }


    // Getters
    public String getOutputItemId() { return outputItemId; }
    public String getOutputItemName() { return outputItemName; }
    public String getDescription() { return description; }
    public Map<String, Integer> getSpecificIngredients() { return specificIngredients; }
    public String getInputCategory() { return inputCategory; }
}
