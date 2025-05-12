package models.PlantsAndForaging;

import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.ForagingSeedInfo;
import models.PlantsAndForaging.Info.MixedSeedInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;

public class Seed implements InventoryItem, Sellable {
    private CropInfo cropInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private int regrowthTime;
    private boolean oneTime;
    private String seasons; // like 1, 1-3, 1-2-3-4
    private boolean isGiantable;
    private SeedInfo seed;

    public Seed(SeedInfo seedInfo) {
        this.seedName = seedInfo.getName();
        this.growingStages = seedInfo.getGrowingStages();
        this.totalHarvestTime = seedInfo.getTotalHarvestTime();
        this.regrowthTime = seedInfo.getRegrowthTime();
        this.oneTime = seedInfo.isOneTime();
        this.seasons = seedInfo.getSeasons();
        this.isGiantable = seedInfo.isGiantable();
    }
    public Seed(ForagingSeedInfo foragingSeedInfo){
        seed = foragingSeedInfo.getSeed();
        this.seasons = foragingSeedInfo.getSeason();
    }
    public Seed(MixedSeedInfo mixedSeedInfo){
        this.seed = mixedSeedInfo.getSeed();
        this.seasons = mixedSeedInfo.getSeason();
    }

//    public Plant getPlant() {
//        return new Plant(cropInfo, growingStages, totalHarvestTime, regrowthTime, oneTime, seasons);
//    }

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

//    public GiantPlant getGiantPlant() {
//    }
}
