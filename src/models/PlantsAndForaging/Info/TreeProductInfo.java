package models.PlantsAndForaging.Info;

import models.ItemFaces.Item;

public enum TreeProductInfo {
    // Spring Fruits
    APRICOT(59, true, 38),
    CHERRY(80, true, 38),

    // Summer Fruits
    BANANA(150, true, 75),
    MANGO(130, true, 100),
    ORANGE(100, true, 38),
    PEACH(140, true, 38),

    // Fall Fruits
    APPLE(100, true, 38),
    POMEGRANATE(140, true, 38),

    // Special Products
    OAK_RESIN(150, false, -1),
    MAPLE_SYRUP(200, false, -1),
    PINE_TAR(100, false, -1),
    SAP(2, true, -2),
    COMMON_MUSHROOM(40, true, 38),
    MYSTIC_SYRUP(1000, true, 500);

    private int sellPrice;
    private boolean isEdible;
    private int energyIncrease;

    TreeProductInfo(int sellPrice, boolean isEdible, int energyIncrease) {
        this.sellPrice = sellPrice;
        this.isEdible = isEdible;
        this.energyIncrease = energyIncrease;
    }

    public Item create(){
        return new Item();
    }
}
