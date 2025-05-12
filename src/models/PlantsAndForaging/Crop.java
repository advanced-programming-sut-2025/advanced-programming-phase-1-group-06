package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.ForagingCropInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.ItemFaces.Edible;
import models.ItemFaces.Sellable;

public class Crop extends InventoryItem implements Edible, Sellable {
    private String name;
    private SeedInfo source;
    private boolean isEdible;
    private int energyIncrease;
    private int sellPrice;
    private String seasons;
    private boolean isFertilized;

    public Crop(CropInfo cropInfo, boolean isFertilized) {
        name = cropInfo.getName();
        source = cropInfo.getSource();
        isEdible = cropInfo.isEdible();
        energyIncrease = cropInfo.getEnergyIncrease();
        sellPrice = cropInfo.getSellPrice();
        this.isFertilized = isFertilized;
        if (isFertilized) {
            energyIncrease = (int) (energyIncrease * 1.5);
            sellPrice = (int) (sellPrice * 1.5);
        }
        seasons = source.getSeasons();
    }

    public Crop(ForagingCropInfo info) {
        name = info.getName();
        source = info.getSource();
        isEdible = info.isEdible();
        energyIncrease = info.getEnergyIncrease();
        sellPrice = info.getSellPrice();
        isFertilized = false;
        seasons = info.getSeasons();
    }

    public String showDetails() {
        return "";
    }

    @Override
    public void eat() {

    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return 0;
    }
}
