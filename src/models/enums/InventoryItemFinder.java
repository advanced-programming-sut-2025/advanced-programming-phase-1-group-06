package models.enums;

import models.Interfaces.InventoryItem;
import models.PlantsAndForaging.Crop;
import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.TreeProductInfo;

public enum InventoryItemFinder {
    WHEAT(CropInfo.WHEAT.create());

    private InventoryItem inventoryItem;

    InventoryItemFinder(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

}
