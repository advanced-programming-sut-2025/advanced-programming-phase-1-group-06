package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class GeneralStore extends Shop {
    private InventoryItem[] items;

    public GeneralStore(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void buyItem(InventoryItem item) {
    }

    public void upgradeBackpack() {
    }
}
