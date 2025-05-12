package models.tools;

import models.Game.Coordinates;

public class Axe extends Tool {

    public Axe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void chop() {
        // Implement chopping logic
    }


    @Override
    public void use(Coordinates coordinate) {
        // Implement logic to use axe on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade axe
    }
}
