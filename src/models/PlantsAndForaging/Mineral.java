package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.MineralsInfo;

public class Mineral extends InventoryItem implements Sellable {
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
    public void setPrice(int price) {
        sellPrice = price;
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
