package models.tools;

import models.Game.Coordinates;

public class Hoe extends Tool {

    public Hoe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void dig() {
        // Implement digging logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade shovel
    }
}
