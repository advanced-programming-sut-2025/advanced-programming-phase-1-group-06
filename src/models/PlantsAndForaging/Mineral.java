package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.MineralsInfo;

public class Mineral implements Sellable, InventoryItem {

    private String name;
    private String description;
    private int sellPrice;

    @Override
    public void sell() {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getAmount() {
        return 0;
    }
    public Mineral(MineralsInfo mineralsInfo){
        name = mineralsInfo.getName();
        description = mineralsInfo.getDescription();
        sellPrice = mineralsInfo.getSellPrice();
    }
}
