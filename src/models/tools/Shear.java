package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class Shear extends Tool{

    public Shear(){
        energyCost = 4;
    }

    @Override
    public int getSuccessfulEnergyCost() {
        return 4;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return 4;
    }

    @Override
    public void use(Coordinates coordinates, Player player) {
//        TODO
    }

    @Override
    public void upgrade() {

    }
}
