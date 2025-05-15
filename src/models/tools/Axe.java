package models.tools;

import models.Game.Coordinates;

public class Axe extends Tool {

    public Axe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 5 - level;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return getSuccessfulEnergyCost() - 1;
    }

    public void chop() {
        // Implement chopping logic
    }

    public int getDamage() {
        return level * 2;
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade axe
    }
}
