package models.enums;

import models.ItemFaces.InventoryItem;
import models.PlantsAndForaging.Info.CropInfo;

public enum InventoryItemFinder {
    WHEAT(CropInfo.WHEAT.create());

    private InventoryItem inventoryItem;

    InventoryItemFinder(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

}
