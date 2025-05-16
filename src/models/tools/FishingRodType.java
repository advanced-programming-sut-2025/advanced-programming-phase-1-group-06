package models.tools;

public enum FishingRodType {
    TRAINING("Training fishing rod", false, 8, 25),
    BAMBOO("Bamboo fishing rod", true, 8, 500),
    FIBERGLASS("Fiberglass fishing rod", true, 6, 1800),
    IRIDIUM("Iridium fishing rod", true, 4, 7500),
    ;

    final String name;
    final boolean allFish;
    final int energyConsumption;
    final int price;

    FishingRodType(String name, boolean allFish, int energyConsumption, int price) {
        this.name = name;
        this.allFish = allFish;
        this.energyConsumption = energyConsumption;
        this.price = price;
    }

    public Tool create(){
        return new FishingRod(this);
    }
}