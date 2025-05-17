package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class JojoMart extends Shop {
    private InventoryItem[] items;

    public JojoMart(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void buyItem(InventoryItem item) {
    }
}
