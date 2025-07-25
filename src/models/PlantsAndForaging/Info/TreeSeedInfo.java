package models.PlantsAndForaging.Info;

import models.PlantsAndForaging.TreeSeed;

import java.util.Random;

public enum TreeSeedInfo {
    // Spring Trees
    APRICOT_SAPLING(TreeProductInfo.APRICOT, "Apricot Sapling", "7-7-7-7", 28, "1"),
    CHERRY_SAPLING(TreeProductInfo.CHERRY, "Cherry Sapling", "7-7-7-7", 28, "1"),

    // Summer Trees
    BANANA_SAPLING(TreeProductInfo.BANANA, "Banana Sapling", "7-7-7-7", 28, "2"),
    MANGO_SAPLING(TreeProductInfo.MANGO, "Mango Sapling", "7-7-7-7", 28, "2"),
    ORANGE_SAPLING(TreeProductInfo.ORANGE, "Orange Sapling", "7-7-7-7", 28, "2"),
    PEACH_SAPLING(TreeProductInfo.PEACH, "Peach Sapling", "7-7-7-7", 28, "2"),

    // Fall Trees
    APPLE_SAPLING(TreeProductInfo.APPLE, "Apple Sapling", "7-7-7-7", 28, "3"),
    POMEGRANATE_SAPLING(TreeProductInfo.POMEGRANATE, "Pomegranate Sapling", "7-7-7-7", 28, "3"),

    // Special Trees
//    ACORNS(TreeProductInfo.OAK_RESIN, "Acorns", "7-7-7-7", 28, "1-2-3-4"),
//    MAPLE_SEEDS(TreeProductInfo.MAPLE_SYRUP, "Maple Seeds", "7-7-7-7", 28, "1-2-3-4"),
//    PINE_CONES(TreeProductInfo.PINE_TAR, "Pine Cones", "7-7-7-7", 28, "1-2-3-4"),
//    MAHOGANY_SEEDS(TreeProductInfo.SAP, "Mahogany Seeds", "7-7-7-7", 28, "1-2-3-4"),
//    MUSHROOM_TREE_SEEDS(TreeProductInfo.COMMON_MUSHROOM, "Mushroom Tree Seeds", "7-7-7-7", 28, "0"),
//    MYSTIC_TREE_SEEDS(TreeProductInfo.MYSTIC_SYRUP, "Mystic Tree Seeds", "7-7-7-7", 28, "1-2-3-4");
    ACORNS(null, "Acorns", "7-7-7-7", 28, "1-2-3-4"),
    MAPLE_SEEDS(null, "Maple Seeds", "7-7-7-7", 28, "1-2-3-4"),
    PINE_CONES(null, "Pine Cones", "7-7-7-7", 28, "1-2-3-4"),
    MAHOGANY_SEEDS(null, "Mahogany Seeds", "7-7-7-7", 28, "1-2-3-4"),
    MUSHROOM_TREE_SEEDS(TreeProductInfo.COMMON_MUSHROOM, "Mushroom Tree Seeds", "7-7-7-7", 28, "0"),
    MYSTIC_TREE_SEEDS(null, "Mystic Tree Seeds", "7-7-7-7", 28, "1-2-3-4");
    private TreeProductInfo productInfo;

    public static TreeSeedInfo getRandomly() {
        return switch (new Random().nextInt(4)) {
            case 0 -> ACORNS;
            case 1 -> MAPLE_SEEDS;
            case 2 -> MAHOGANY_SEEDS;
            default -> PINE_CONES;
        };
    }

    public String getSeedName() {
        return seedName;
    }

    public TreeProductInfo getProductInfo() {
        return productInfo;
    }

    public String getGrowingStages() {
        return growingStages;
    }

    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }

    public String getSeasons() {
        return seasons;
    }

    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private String seasons;

    TreeSeedInfo(TreeProductInfo productInfo, String seedName, String growingStages, int totalHarvestTime, String seasons) {
        this.productInfo = productInfo;
        this.seedName = seedName;
        this.growingStages = growingStages;
        this.totalHarvestTime = totalHarvestTime;
        this.seasons = seasons;
    }


    public TreeSeed create(){
        return new TreeSeed(this);
    }
}
