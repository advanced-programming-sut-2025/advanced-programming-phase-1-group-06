package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.MineralsInfo;

public class Mineral implements Sellable, InventoryItem {

    private String name;
    private String description;
    private int sellPrice;

    public Mineral(MineralsInfo mineralsInfo){
        name = mineralsInfo.getName();
        description = mineralsInfo.getDescription();
        sellPrice = mineralsInfo.getSellPrice();
    }
}
