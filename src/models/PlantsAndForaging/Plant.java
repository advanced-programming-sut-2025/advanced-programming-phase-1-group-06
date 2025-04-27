package models.PlantsAndForaging;

import models.PlantsAndForaging.Info.CropInfo;
import models.Game.Tile;

public class Plant extends Tile implements Growable {

    private int[] growingStages;

    private int totalHarvestTime;
    private int regrowthTime;
    private boolean oneTime;
    private String seasons;

    private boolean isHarvestable = false;
    private boolean isWatered;
    private boolean isFertilized;

    private CropInfo product;

    public Plant(CropInfo product, String growingStages, int totalHarvestTime, int regrowthTime, boolean oneTime, String seasons) {
        this.product = product;

        String[] stages = growingStages.split("-");
        this.growingStages = new int[stages.length];
        for (int i = 0; i < stages.length; i++) {
            this.growingStages[i] = Integer.parseInt(stages[i]);
        }

        this.totalHarvestTime = totalHarvestTime;
        this.regrowthTime = regrowthTime;
        this.oneTime = oneTime;
        this.seasons = seasons;
        this.isHarvestable = false;
        this.isWatered = false;
        this.isFertilized = false;
    }

    public void harvest() {
    }

    public void grow() {

    }
}
