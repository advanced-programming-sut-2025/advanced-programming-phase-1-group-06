package PlantsAndForaging.Info;

public enum ForagingSeedInfo {
    // Spring Seeds
    JAZZ_SEEDS(SeedInfo.JAZZ_SEEDS, "1"),
    CARROT_SEEDS(SeedInfo.CARROT_SEEDS, "1"),
    CAULIFLOWER_SEEDS(SeedInfo.CAULIFLOWER_SEEDS, "1"),
    COFFEE_BEAN(SeedInfo.COFFEE_BEAN, "1"),
    GARLIC_SEEDS(SeedInfo.GARLIC_SEEDS, "1"),
    BEAN_STARTER(SeedInfo.BEAN_STARTER, "1"),
    KALE_SEEDS(SeedInfo.KALE_SEEDS, "1"),
    PARSNIP_SEEDS(SeedInfo.PARSNIP_SEEDS, "1"),
    POTATO_SEEDS(SeedInfo.POTATO_SEEDS, "1"),
    RHUBARB_SEEDS(SeedInfo.RHUBARB_SEEDS, "1"),
    STRAWBERRY_SEEDS(SeedInfo.STRAWBERRY_SEEDS, "1"),
    TULIP_BULB(SeedInfo.TULIP_BULB, "1"),
    RICE_SHOOT(SeedInfo.RICE_SHOOT, "1"),

    // Summer Seeds
    BLUEBERRY_SEEDS(SeedInfo.BLUEBERRY_SEEDS, "2"),
    CORN_SEEDS(SeedInfo.CORN_SEEDS, "2"),
    HOPS_STARTER(SeedInfo.HOPS_STARTER, "2"),
    PEPPER_SEEDS(SeedInfo.PEPPER_SEEDS, "2"),
    MELON_SEEDS(SeedInfo.MELON_SEEDS, "2"),
    POPPY_SEEDS(SeedInfo.POPPY_SEEDS, "2"),
    RADISH_SEEDS(SeedInfo.RADISH_SEEDS, "2"),
    RED_CABBAGE_SEEDS(SeedInfo.RED_CABBAGE_SEEDS, "2"),
    STARFRUIT_SEEDS(SeedInfo.STARFRUIT_SEEDS, "2"),
    SPANGLE_SEEDS(SeedInfo.SPANGLE_SEEDS, "2"),
    SUMMER_SQUASH_SEEDS(SeedInfo.SUMMER_SQUASH_SEEDS, "2"),
    SUNFLOWER_SEEDS(SeedInfo.SUNFLOWER_SEEDS, "2"),
    TOMATO_SEEDS(SeedInfo.TOMATO_SEEDS, "2"),
    WHEAT_SEEDS(SeedInfo.WHEAT_SEEDS, "2"),

    // Fall Seeds
    AMARANTH_SEEDS(SeedInfo.AMARANTH_SEEDS, "3"),
    ARTICHOKE_SEEDS(SeedInfo.ARTICHOKE_SEEDS, "3"),
    BEET_SEEDS(SeedInfo.BEET_SEEDS, "3"),
    BOK_CHOY_SEEDS(SeedInfo.BOK_CHOY_SEEDS, "3"),
    BROCCOLI_SEEDS(SeedInfo.BROCCOLI_SEEDS, "3"),
    CRANBERRY_SEEDS(SeedInfo.CRANBERRY_SEEDS, "3"),
    EGGPLANT_SEEDS(SeedInfo.EGGPLANT_SEEDS, "3"),
    FAIRY_SEEDS(SeedInfo.FAIRY_SEEDS, "3"),
    GRAPE_STARTER(SeedInfo.GRAPE_STARTER, "3"),
    PUMPKIN_SEEDS(SeedInfo.PUMPKIN_SEEDS, "3"),
    YAM_SEEDS(SeedInfo.YAM_SEEDS, "3"),
    RARE_SEED(SeedInfo.RARE_SEED, "3"),

    // Winter Seeds
    POWDERMELON_SEEDS(SeedInfo.POWDERMELON_SEEDS, "4"),

    // Special Seeds
    ANCIENT_SEEDS(SeedInfo.ANCIENT_SEEDS, "0");

    //mixed seeds are here too


    private SeedInfo seed;
    private String season;

    ForagingSeedInfo(SeedInfo seedInfo, String season) {
        this.seed = seed;
        this.season = season;
    }
}
