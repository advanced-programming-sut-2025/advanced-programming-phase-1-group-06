package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class Scythe extends Tool {

    public Scythe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 2;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return 2;
    }

    public void cut() {
        // Implement cutting logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade scythe
    }
}
