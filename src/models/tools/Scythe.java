package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class Scythe extends Tool {

    public Scythe(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void cut() {
        // Implement cutting logic
    }

    @Override
    public void use(Coordinates coordinate, Player player) {
        // TODO
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade scythe
    }
}
