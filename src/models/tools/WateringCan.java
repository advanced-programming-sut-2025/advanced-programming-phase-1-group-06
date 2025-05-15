package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class WateringCan extends Tool {

    int maxCapacity;
    int capacity;
    public WateringCan(String name, int level, int energyConsumption) {
        super(name, level, energyConsumption);
        maxCapacity = 40;
        capacity = 40;
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 0;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return 0;
    }

    public void water() {
        // Implement watering logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade watering can
    }

    public void fill() {
    }
}
