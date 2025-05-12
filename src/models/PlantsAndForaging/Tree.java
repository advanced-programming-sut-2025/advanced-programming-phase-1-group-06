package models.PlantsAndForaging;


import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.Player.Player;
import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;
import models.tools.Tool;

public class Tree extends OverlayTile implements Growable {
    { //for overlay
        isBlocked = true;
        hits = 15;
        symbol = 'T';
        color = Color.GREEN_TEXT.getColorCode();
    }

    private int regrowthTime;
    private boolean oneTime;


    public int getDaysSincePlanting() {
        return daysSincePlanting;
    }

    public TreeSeedInfo getTreeSeedInfo() {
        return treeSeedInfo;
    }

    private TreeSeedInfo treeSeedInfo;
    private String seasons;
    private String growingStagesString;
    private int[] growingStages;
    private int daysSincePlanting;
    private TreeProductInfo product;

    public Tree(TreeSeedInfo treeSeedInfo) {
        super('T', Color.GREEN_TEXT.getColorCode(), 15, true);
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

    public Tree (TreeSeedInfo treeSeedInfo, int daysSincePlanting) {
        super('T', Color.GREEN_TEXT.getColorCode(), 15, true);
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
    public void grow(){

    }

    @Override
    public void harvest() {

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
//        TODO
        return true;
    }
}

