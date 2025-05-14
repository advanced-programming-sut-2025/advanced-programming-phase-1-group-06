package models.tools;

import models.Game.Coordinates;
import models.Player.Player;

public class FishingRod extends Tool{

    int price;
    boolean allFishes;

    FishingRod(){}

    public void fish() {
        // Implement fishing logic
    }

    @Override
    public void use(Coordinates coordinates, Player player) {
        // Implement logic to use fishing rod on coordinate
    }

    @Override
    public void upgrade() {
        // Implement logic to upgrade fishing rod
    }
}
