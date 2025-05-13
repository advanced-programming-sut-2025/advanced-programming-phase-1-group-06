package models.tools;

import models.Game.Coordinates;

public class WateringCan extends Tool {

    int maxCapacity;
    int capacity;
    public WateringCan(String name, int level, int energyConsumption) {
        super(name, level, energyConsumption);
        maxCapacity = 40;
        capacity = 40;
    }

    public void water() {
        // Implement watering logic
    }

    @Override
    public void use(Coordinates coordinate) {
        // Implement logic to use watering can on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade watering can
    }

    public void fill() {
    }
}
