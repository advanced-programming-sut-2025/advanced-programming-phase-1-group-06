package models.tools;

import models.Game.Coordinates;

public class WateringCan extends Tool {

    public WateringCan(String name, int level, int energyConsumption) {
        super(name, level, energyConsumption);
        capacity = 40;
    }

    int capacity;

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
}
