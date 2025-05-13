package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class MilkPail extends Tool{
    int price = 1000;
    public MilkPail(){
        energyCost = 4;
    }
    @Override
    public void use(Coordinates coordinates, Player player) {

    }

    @Override
    public void upgrade() {
        return;
    }
}
