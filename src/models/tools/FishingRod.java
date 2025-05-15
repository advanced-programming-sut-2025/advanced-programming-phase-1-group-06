package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class FishingRod extends Tool{

    int price;
    boolean allFishes;

    FishingRod(){}

    @Override
    public int getSuccessfulEnergyCost() {
        return 0;
    }

    @Override
    public int getUnsuccessfulEnergyCost() {
        return 0;
    }

    public void fish() {
        // Implement fishing logic
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade fishing rod
    }
}
