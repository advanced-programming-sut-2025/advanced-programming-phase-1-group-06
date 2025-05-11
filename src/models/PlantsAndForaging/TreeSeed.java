package models.PlantsAndForaging;

import models.Interfaces.InventoryItem;
import models.Interfaces.Sellable;

public class TreeSeed implements InventoryItem, Sellable {
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
