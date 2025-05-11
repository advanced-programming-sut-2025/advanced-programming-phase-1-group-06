package models.tools;

import models.Game.Coordinates;

public class MilkPail extends Tool{
    int price = 1000;
    public MilkPail(){
        energyConsumption = 4;
    }
    @Override
    public void use(Coordinates coordinates) {

    }

    @Override
    public void upgrade() {
        return;
    }
}
