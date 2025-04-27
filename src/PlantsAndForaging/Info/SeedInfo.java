package PlantsAndForaging.Info;

// info for each seed
// additional (probably temporary forage_source)
public enum SeedInfo {
    JAZZ_SEEDS(CropInfo.BLUE_JAZZ ,"Jazz Seeds", "1-2-2-2", 7, -1, true, "1", false),
    CARROT_SEEDS(CropInfo.CARROT , "Carrot Seeds", "1-1-1", 3, -1, true, "1", false),
    CAULIFLOWER_SEEDS(CropInfo.CAULIFLOWER, "Cauliflower Seeds", "1-2-4-4-1", 12, -1, true, "1", true),
    COFFEE_BEAN(CropInfo.COFFEE_BEAN, "Coffee Bean", "1-2-2-3-2", 10, 2, false, "1-2", false),
    GARLIC_SEEDS(CropInfo.GARLIC ,"Garlic Seeds", "1-1-1-1", 4, -1, true, "1", false),
    BEAN_STARTER(CropInfo.GREEN_BEAN, "Bean Starter", "1-1-1-3-4", 10, 3, false, "1", false),
    KALE_SEEDS(CropInfo.KALE, "Kale Seeds", "1-2-2-1", 6, -1, true, "1", false),
    PARSNIP_SEEDS(CropInfo.PARSNIP, "Parsnip Seeds", "1-1-1-1", 4, -1, true, "1", false),
    POTATO_SEEDS(CropInfo.POTATO, "Potato Seeds", "1-1-1-2-1", 6, -1, true, "1", false),
    RHUBARB_SEEDS(CropInfo.RHUBARB, "Rhubarb Seeds", "2-2-2-3-4", 13, -1, true, "1", false),
    STRAWBERRY_SEEDS(CropInfo.STRAWBERRY, "Strawberry Seeds", "1-1-2-2-2", 8, 4, false, "1", false),
    TULIP_BULB(CropInfo.TULIP, "Tulip Bulb", "1-1-2-2", 6, -1, true, "1", false),
    RICE_SHOOT(CropInfo.UNMILLED_RICE, "Rice Shoot", "1-2-2-3", 8, -1, true, "1", false),
    BLUEBERRY_SEEDS(CropInfo.BLUEBERRY, "Blueberry Seeds", "1-3-3-4-2", 13, 4, false, "2", false),
    CORN_SEEDS(CropInfo.CORN, "Corn Seeds", "2-3-3-3-3", 14, 4, false, "2-3", false),
    HOPS_STARTER(CropInfo.HOPS, "Hops Starter", "1-1-2-3-4", 11, 1, false, "2", false),
    PEPPER_SEEDS(CropInfo.HOT_PEPPER, "Pepper Seeds", "1-1-1-1-1", 5, 3, false, "2", false),
    MELON_SEEDS(CropInfo.MELON, "Melon Seeds", "1-2-3-3-3", 12, -1, true, "2", true),
    POPPY_SEEDS(CropInfo.POPPY, "Poppy Seeds", "1-2-2-2", 7, -1, true, "2", false),
    RADISH_SEEDS(CropInfo.RADISH, "Radish Seeds", "2-1-2-1", 6, -1, true, "2", false),
    RED_CABBAGE_SEEDS(CropInfo.RED_CABBAGE, "Red Cabbage Seeds", "2-1-2-2-2", 9, -1, true, "2", false),
    STARFRUIT_SEEDS(CropInfo.STARFRUIT, "Starfruit Seeds", "2-3-2-3-3", 13, -1, true, "2", false),
    SPANGLE_SEEDS(CropInfo.SUMMER_SPANGLE, "Spangle Seeds", "1-2-3-1", 8, -1, true, "2", false),
    SUMMER_SQUASH_SEEDS(CropInfo.SUMMER_SQUASH, "Summer Squash Seeds", "1-1-1-2-1", 6, 3, false, "2", false),
    SUNFLOWER_SEEDS(CropInfo.SUNFLOWER, "Sunflower Seeds", "1-2-3-2", 8, -1, true, "2-3", false),
    TOMATO_SEEDS(CropInfo.TOMATO, "Tomato Seeds", "2-2-2-2-3", 11, 4, false, "2", false),
    WHEAT_SEEDS(CropInfo.WHEAT, "Wheat Seeds", "1-1-1-1", 4, -1, true, "2-3", false),
    AMARANTH_SEEDS(CropInfo.AMARANTH, "Amaranth Seeds", "1-2-2-2", 7, -1, true, "3", false),
    ARTICHOKE_SEEDS(CropInfo.ARTICHOKE, "Artichoke Seeds", "2-2-1-2-1", 8, -1, true, "3", false),
    BEET_SEEDS(CropInfo.BEET, "Beet Seeds", "1-1-2-2", 6, -1, true, "3", false),
    BOK_CHOY_SEEDS(CropInfo.BOK_CHOY, "Bok Choy Seeds", "1-1-1-1", 4, -1, true, "3", false),
    BROCCOLI_SEEDS(CropInfo.BROCCOLI, "Broccoli Seeds", "2-2-2-2", 8, 4, false, "3", false),
    CRANBERRY_SEEDS(CropInfo.CRANBERRIES, "Cranberry Seeds", "1-2-1-1-2", 7, 5, false, "3", false),
    EGGPLANT_SEEDS(CropInfo.EGGPLANT, "Eggplant Seeds", "1-1-1-1", 5, 5, false, "3", false),
    FAIRY_SEEDS(CropInfo.FAIRY_ROSE, "Fairy Seeds", "1-4-4-3", 12, -1, true, "3", false),
    GRAPE_STARTER(CropInfo.GRAPE, "Grape Starter", "1-1-2-3-3", 10, 3, false, "3", false),
    PUMPKIN_SEEDS(CropInfo.PUMPKIN, "Pumpkin Seeds", "1-2-3-4-3", 13, -1, true, "3", true),
    YAM_SEEDS(CropInfo.YAM, "Yam Seeds", "1-3-3-3", 10, -1, true, "3", false),
    RARE_SEED(CropInfo.SWEET_GEM_BERRY, "Rare Seed", "2-4-6-6-6", 24, -1, true, "3", false),
    POWDERMELON_SEEDS(CropInfo.POWDERMELON, "Powdermelon Seeds", "1-2-1-2-1", 7, -1, true, "4", true),
    ANCIENT_SEEDS(CropInfo.ANCIENT_FRUIT, "Ancient Seeds", "2-7-7-7-5", 28, 7, false, "1-2-3", false),

    FORAGE_SOURCE(null, "Foraging", "", -1, -1, false, "", false);



    private CropInfo cropInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private int regrowthTime;
    private boolean oneTime;
    private String seasons; // like 1, 1-3, 1-2-3-4
    private boolean isGiantable;

    SeedInfo(CropInfo cropInfo, String seedName, String growingStages, int totalHarvestTime,
             int regrowthTime, boolean oneTime, String seasons, boolean isGiantable) {
        this.cropInfo = cropInfo;
        this.seedName = seedName;
        this.growingStages = growingStages;
        this.totalHarvestTime = totalHarvestTime;
        this.regrowthTime = regrowthTime;
        this.oneTime = oneTime;
        this.seasons = seasons;
        this.isGiantable = isGiantable;
    }

    public CropInfo getCropInfo() {
        return cropInfo;
    }

    public String getName() {
        return seedName;
    }
    public String getGrowingStages() {
        return growingStages;
    }
    public int getTotalHarvestTime() {
        return totalHarvestTime;
    }
    public int getRegrowthTime() {
        return regrowthTime;
    }
    public boolean isOneTime() {
        return oneTime;
    }
    public String getSeasons() {
        return seasons;
    }
    public boolean isGiantable() {
        return isGiantable;
    }
}
