package models.PlantsAndForaging;

import models.App;
import models.Game.GameMap.GameMap;
import models.ItemFaces.InventoryItem;
import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.Player.Player;
import models.Tiles.Dirt;
import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;
import models.tools.Scythe;
import models.tools.*;

import java.util.Currency;
import java.util.Random;


public class Plant extends OverlayTile implements Growable {

    private int regrowthTime;
    private boolean oneTime;
    private String seasons;
    private boolean status;
    private boolean ready;
    private long startDay;
    private int growthTime; // in days

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
    public void goNextGrowingStage() {
        //TODO should be implemented in Growable interface
    }
    private void destroy(GameMap gameMap) {
        App.getGame().removeGrowable(this);
        gameMap.removeOverlayTile(this);
    }
    public boolean harvest(Player player) {


        if (isHarvestable) {
            if (oneTime) {
                destroy(player.getGameMap());
            }
            else {
                goNextGrowingStage();
            }
            InventoryItem item = new Crop(this.product, isFertilized);
            item.setAmount(new Random().nextInt( 3) + 1);
            player.getInventory().addItem(item);
            return true;
        }
        return false;
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

    @Override
    public void harvest() {
//        TODO
    }

    public void setRegrowthTime(int regrowthTime) {
        this.regrowthTime = regrowthTime;
    }

    public SeedInfo getSeedInfo() {
        return seedInfo;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        return switch (tool) {
            case Scythe scythe -> harvest(player);
            case Pickaxe pickaxe -> {
                destroy(player.getGameMap());
                yield false; //holy syntax
            }
            default -> false;
        };
    }

    public void handleTime(long currentDay){
        long remainingDay = growthTime - (startDay - currentDay);
        if (remainingDay > 0)
            return;
        status = false;
        ready = true;
    }
    @Override
    public boolean getStatus() {
        return status;
    }
}
