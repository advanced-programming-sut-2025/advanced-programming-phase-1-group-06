package models.PlantsAndForaging;

import models.Itemfaces.InventoryItem;
import models.Itemfaces.Sellable;
import models.PlantsAndForaging.Info.MineralsInfo;

public class Mineral extends InventoryItem implements Sellable {

    private String name;
    private String description;
    private int sellPrice;

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return 0;
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
