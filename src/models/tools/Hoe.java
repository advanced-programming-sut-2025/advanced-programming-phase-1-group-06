package models.tools;

import models.Game.Coordinates;

public class Hoe extends Tool {

    public Hoe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 5 - level;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return getSuccessfulEnergyCost();
    }

    public void dig() {
        // Implement digging logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade shovel
    }
}
