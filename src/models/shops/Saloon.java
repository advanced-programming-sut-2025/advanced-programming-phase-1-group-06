package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class Saloon extends Shop {
    private InventoryItem[] items;

    public Saloon(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void buyItem(InventoryItem item) {
    }
}
