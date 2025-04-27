package PlantsAndForaging;

import PlantsAndForaging.Info.CropInfo;
import PlantsAndForaging.Info.SeedInfo;
import models.Player.InventoryItem;
import models.Interfaces.Sellable;

public class Seed implements InventoryItem, Sellable {
    private CropInfo cropInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private int regrowthTime;
    private boolean oneTime;
    private String seasons; // like 1, 1-3, 1-2-3-4
    private boolean isGiantable;

    public Seed(SeedInfo seedInfo) {
        this.seedName = seedInfo.getName();
        this.growingStages = seedInfo.getGrowingStages();
        this.totalHarvestTime = seedInfo.getTotalHarvestTime();
        this.regrowthTime = seedInfo.getRegrowthTime();
        this.oneTime = seedInfo.isOneTime();
        this.seasons = seedInfo.getSeasons();
        this.isGiantable = seedInfo.isGiantable();
    }

    public Plant getPlant() {
        return new Plant(cropInfo, growingStages, totalHarvestTime, regrowthTime, oneTime, seasons);
    }

    public GiantPlant getGiantPlant() {

    }
}
