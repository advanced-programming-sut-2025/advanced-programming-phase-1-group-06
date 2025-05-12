package models.PlantsAndForaging;

import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.Tiles.Dirt;
import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;
import models.tools.Tool;


public class Plant extends OverlayTile implements Growable {


//    public Plant(CropInfo cropInfo, String growingStages, int totalHarvestTime, int regrowthTime, boolean oneTime, String seasons) {
//        super();
//    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public boolean isOneTime() {
        return oneTime;
    }

    public String getSeasons() {
        return seasons;
    }

    public int[] getGrowingStages() {
        return growingStages;
    }

    public void setGrowingStages(int[] growingStages) {
        this.growingStages = growingStages;
    }

    public int getDaysSincePlanting() {
        return daysSincePlanting;
    }

    public void setDaysSincePlanting(int daysSincePlanting) {
        this.daysSincePlanting = daysSincePlanting;
    }

    public boolean isHarvestable() {
        return isHarvestable;
    }

    public void setHarvestable(boolean harvestable) {
        isHarvestable = harvestable;
    }

    public boolean isWatered() {
        return isWatered;
    }

    public void setWatered(boolean watered) {
        isWatered = watered;
    }

    public boolean isFertilized() {
        return isFertilized;
    }

    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
    }

    public CropInfo getProduct() {
        return product;
    }

    public void setProduct(CropInfo product) {
        this.product = product;
    }

    private int regrowthTime;
    private boolean oneTime;
    private String seasons;

    public void setOneTime(boolean oneTime) {
        this.oneTime = oneTime;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }
    private SeedInfo seedInfo;
    private String growingStagesString;
    private int[] growingStages;
    private int daysSincePlanting;
    private boolean isHarvestable = false;
    private boolean isWatered;
    private boolean isFertilized;
    private CropInfo product;

    public Plant(Dirt dirt, SeedInfo seedInfo) {
        super('|', Color.GREEN_TEXT.getColorCode(), 1, false);
        this.seedInfo = seedInfo;
        this.product = seedInfo.getCropInfo();
        this.growingStagesString = seedInfo.getGrowingStages();
        String[] stages = growingStagesString.split("-");
        this.growingStages = new int[stages.length];
        for (int i = 0; i < stages.length; i++) {
            this.growingStages[i] = Integer.parseInt(stages[i]);
        }

        this.regrowthTime = seedInfo.getRegrowthTime();
        this.oneTime = seedInfo.isOneTime();
        this.seasons = seedInfo.getSeasons();
        this.isHarvestable = false;
        this.isWatered = dirt.isWatered();
        this.isFertilized = dirt.isFertilized();


    }
    public Plant(SeedInfo seedInfo, int daysSincePlanting, boolean isWatered, boolean isFertilized) {
        super('|', Color.GREEN_TEXT.getColorCode(), 1, false);
        this.seedInfo = seedInfo;
        this.regrowthTime = seedInfo.getRegrowthTime();
        this.oneTime = seedInfo.isOneTime();
        this.seasons = seedInfo.getSeasons();
        this.growingStagesString = seedInfo.getGrowingStages();
        this.daysSincePlanting = daysSincePlanting;
        this.isWatered = isWatered;
        this.isFertilized = isFertilized;
        this.product = seedInfo.getCropInfo();

    }

    public void harvest() {
    }

    @Override
    public String getType() {
        return "PLANT";
    }

    @Override
    public int currentGrowthDay() {
        return daysSincePlanting;
    }

    public void grow() {

    }

    public void setRegrowthTime(int regrowthTime) {
        this.regrowthTime = regrowthTime;
    }

    public SeedInfo getSeedInfo() {
        return seedInfo;
    }

    @Override
    public boolean useTool(Tool tool) {
//        TODO
        return true;
    }
}
