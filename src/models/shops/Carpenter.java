package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;

public class Carpenter extends Shop {
    private InventoryItem[] items;

    public Carpenter(Coordinates balaChap, Coordinates doorCoordinates) {
        super(balaChap, doorCoordinates);
    }

    public void buyItem(InventoryItem item) {
    }

    public void buildBuilding(String buildingName) {
    }
}
