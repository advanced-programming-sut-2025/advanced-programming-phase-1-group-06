package models.PlantsAndForaging;


import models.App;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.ItemFaces.InventoryItem;
import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.PlantsAndForaging.Item;
import models.Player.Player;
import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;
import models.tools.Axe;
import models.tools.Scythe;
import models.tools.Tool;

import java.util.Arrays;

public class Tree extends OverlayTile implements Growable {


    private int regrowthTime;
    private boolean oneTime;
    private final TreeSeedInfo treeSeedInfo;
    private final String seasons;
    private final String growingStagesString;
    private long lastChangeInGrowthDay;
    private boolean isMatured;
    private boolean isHarvestable;
    private final int[] growingStages;
    private final int daysSincePlanting;
    private final TreeProductInfo product;

    public int getDaysSincePlanting() {
        return daysSincePlanting;
    }

    public TreeSeedInfo getTreeSeedInfo() {
        return treeSeedInfo;
    }

    public Tree(TreeSeedInfo treeSeedInfo, GameMap gameMap, Coordinates c) {
        super('T', Color.GREEN_TEXT.getColorCode(), 15, true, gameMap, c);
        this.treeSeedInfo = treeSeedInfo;
        this.seasons = treeSeedInfo.getSeasons();
        this.growingStagesString = treeSeedInfo.getGrowingStages();
        String[] stages = growingStagesString.split("-");
        this.growingStages = new int[stages.length];
        for (int i = 0; i < stages.length; i++) {
            this.growingStages[i] = Integer.parseInt(stages[i]);
        }
        daysSincePlanting = 0;
        product = treeSeedInfo.getProductInfo();
    }
    public Tree(TreeSeedInfo treeSeedInfo, int daysSincePlanting, GameMap gameMap, Coordinates coordinates) {
        super('T', Color.GREEN_TEXT.getColorCode(), 15, true, gameMap, coordinates);
        this.treeSeedInfo = treeSeedInfo;
        this.seasons = treeSeedInfo.getSeasons();
        this.growingStagesString = treeSeedInfo.getGrowingStages();
        String[] stages = growingStagesString.split("-");
        this.growingStages = new int[stages.length];
        for (int i = 0; i < stages.length; i++) {
            this.growingStages[i] = Integer.parseInt(stages[i]);
        }
        this.daysSincePlanting = daysSincePlanting;
        product = treeSeedInfo.getProductInfo();
    }

    public void chop() {
    }

    @Override
    public void grow(long currentDay) {
        if (isHarvestable) return;
        if (isMatured) {
            if (currentDay - lastChangeInGrowthDay >= 1) {
                isHarvestable = true;
            }
        }
        else {
            if (currentDay - lastChangeInGrowthDay >= Arrays.stream(growingStages).sum()) {
                isMatured = true;
                isHarvestable = true;
            }
        }
    }

    @Override
    public boolean harvest(Player player) {
        if (isHarvestable) {
            InventoryItem item;
            if (product != null) item = product.create();
            else item = treeSeedInfo.create();
            player.getInventory().addItem(item);
            isHarvestable = false;
            return true;
        }
        else return false;
    }

    public void registerHit(Axe axe, Player player) {
        hits -= axe.getDamage();
        if (hits <= 0) {

    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public int currentGrowthDay() {
        return 0;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        return switch (tool) {
            case Scythe scythe -> harvest(player); //this one harvests only product not the wood
            case Axe axe -> {
                registerHit(axe, player);
                yield true;
            }

            default -> false;
        };
    }
}

