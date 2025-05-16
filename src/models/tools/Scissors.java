package models.tools;

import models.Game.Coordinates;
import models.Player.Player;


public class Scissors extends Tool {

    public Scissors(String name, int level, int energyConsumption){
        super(name, level, energyConsumption);
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 0;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return 0;
    }

    public void cut() {
        // Implement cutting logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade scissors
    }

    @Override
    public String toString (){
        return name;
    }
}
