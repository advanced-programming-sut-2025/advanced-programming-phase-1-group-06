package models.tools;

import models.Game.Coordinates;
import models.Player.Player;


public class Scissors extends Tool {

    public Scissors(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    public void cut() {
        // Implement cutting logic
    }

    @Override
    public void use(Coordinates coordinate, Player player) {
        // Implement logic to use scissors on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade scissors
    }
}
