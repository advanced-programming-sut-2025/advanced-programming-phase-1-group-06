package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class FishingRod extends Tool {
    private final FishingRodType type;
    private boolean allFishes;
    private int energyConsumption;
    private int price;

    FishingRod(FishingRodType type) {
        this.type = type;
        int price = type.price;
        this.allFishes = type.allFish;
        this.name = type.name;
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return type.energyConsumption;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return type.energyConsumption;
    }

    public void fish() {
        // Implement fishing logic based on rod type
        // Training rod can only catch cheapest fish of the season
        // Other rods can catch any fish
        // Energy consumption varies by rod type
    }

    public FishingRodType getType() {
        return type;
    }

    public boolean isAllFishes() {
        return allFishes;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade fishing rod
        // Training -> Bamboo (requires no fishing skill)
        // Bamboo -> Fiberglass (requires fishing level 2)
        // Fiberglass -> Iridium (requires fishing level 4)
    }

    @Override
    public String toString() {
        return name;
    }
}