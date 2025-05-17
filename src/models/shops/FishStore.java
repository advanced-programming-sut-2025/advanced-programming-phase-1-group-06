package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class FishStore extends Shop {
    private InventoryItem[] items;

    public FishStore(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void buyItem(InventoryItem item) {
    }
}
