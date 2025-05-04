package models.PlantsAndForaging;

import models.PlantsAndForaging.Info.CropInfo;
import models.Tiles.Dirt;
import models.Tiles.OverlayTile;


public class Plant extends OverlayTile implements Growable {

    private final int regrowthTime;
    private final boolean oneTime;
    private final String seasons;
    private int[] growingStages;
    private int daysSincePlanting;
    private boolean isHarvestable = false;
    private boolean isWatered;
    private boolean isFertilized;
    private CropInfo product;

    public Plant(Dirt dirt, CropInfo product, String growingStages, int regrowthTime, boolean oneTime, String seasons) {
        this.product = product;

        String[] stages = growingStages.split("-");
        this.growingStages = new int[stages.length];
        for (int i = 0; i < stages.length; i++) {
            this.growingStages[i] = Integer.parseInt(stages[i]);
        }

        this.regrowthTime = regrowthTime;
        this.oneTime = oneTime;
        this.seasons = seasons;
        this.isHarvestable = false;
        this.isWatered = dirt.isWatered();
        this.isFertilized = dirt.isFertilized();
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
}
