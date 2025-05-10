package models.PlantsAndForaging;

import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.ForagingCropInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.Interfaces.Edible;
import models.Interfaces.InventoryItem;
import models.Interfaces.Sellable;

public class Crop implements Edible, Sellable, InventoryItem {

    private String name;
    private SeedInfo source;
    private boolean isEdible;
    private int energyIncrease;
    private int sellPrice;
    private String seasons;

    public Crop(CropInfo cropInfo) {
        name = cropInfo.getName();
        source = cropInfo.getSource();
        isEdible = cropInfo.isEdible();
        energyIncrease = cropInfo.getEnergyIncrease();
        sellPrice = cropInfo.getSellPrice();
        seasons = source.getSeasons();
    }

    public Crop(ForagingCropInfo info) {
        name = info.getName();
        source = info.getSource();
        isEdible = info.isEdible();
        energyIncrease = info.getEnergyIncrease();
        sellPrice = info.getSellPrice();
        seasons = info.getSeasons();
    }

    public String showDetails() {
        return "";
    }

    @Override
    public void eat() {

    }
}
