package models.PlantsAndForaging;

import models.Interfaces.InventoryItem;
import models.Interfaces.Sellable;

public class Mineral implements Sellable , InventoryItem {


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
}
