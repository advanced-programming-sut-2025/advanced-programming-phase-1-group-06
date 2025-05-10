package models.tools;

import models.Game.Coordinates;

public class Pickaxe extends Tool {

    public Pickaxe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void mine() {
        // Implement mining logic
    }

    @Override
    public void use(Coordinates coordinate) {
        // Implement logic to use pickaxe on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade pickaxe
    }
}
