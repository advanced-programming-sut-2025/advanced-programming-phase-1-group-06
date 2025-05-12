package models.tools;

import models.Game.Coordinates;

public class Hoe extends Tool {

    public Hoe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void dig() {
        // Implement digging logic
    }

    public Hoe(int level, String name){
        super(level, name);
    }

    public Hoe(int level, String name){
        super(level, name);
    }

    public Hoe(int level, String name){
        super(level, name);
    }

    @Override
    public void use(Coordinates coordinates) {
        // Implement logic to use shovel on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade shovel
    }
}
