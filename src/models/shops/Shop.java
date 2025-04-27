package models.shops;

import models.Player.Player;
import models.buildings.Building;

public abstract class Shop extends Building {
    private NPC owner;
    private int openingHour;
    private int closingHour;

    public void openShop() {
    }

    public void closeShop() {
    }

    public void enterShop(Player player) {
    }
}
