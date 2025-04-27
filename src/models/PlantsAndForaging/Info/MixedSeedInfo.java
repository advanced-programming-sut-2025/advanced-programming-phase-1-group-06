package models.PlantsAndForaging.Info;

public enum MixedSeedInfo {
    CAULIFLOWER_SEEDS(SeedInfo.CAULIFLOWER_SEEDS, "1"),
    PARSNIP_SEEDS(SeedInfo.PARSNIP_SEEDS, "1"),
    POTATO_SEEDS(SeedInfo.POTATO_SEEDS, "1"),
    JAZZ_SEEDS(SeedInfo.JAZZ_SEEDS, "1"),
    TULIP_BULB(SeedInfo.TULIP_BULB, "1"),
    CORN_SEEDS(SeedInfo.CORN_SEEDS, "2-3"),
    PEPPER_SEEDS(SeedInfo.PEPPER_SEEDS, "2"),
    RADISH_SEEDS(SeedInfo.RADISH_SEEDS, "2"),
    WHEAT_SEEDS(SeedInfo.WHEAT_SEEDS, "2"),
    POPPY_SEEDS(SeedInfo.POPPY_SEEDS, "2"),
    SUNFLOWER_SEEDS(SeedInfo.SUNFLOWER_SEEDS, "2-3"),
    SPANGLE_SEEDS(SeedInfo.SPANGLE_SEEDS, "2"),
    ARTICHOKE_SEEDS(SeedInfo.ARTICHOKE_SEEDS, "3"),
    EGGPLANT_SEEDS(SeedInfo.EGGPLANT_SEEDS, "3"),
    PUMPKIN_SEEDS(SeedInfo.PUMPKIN_SEEDS, "3"),
    FAIRY_SEEDS(SeedInfo.FAIRY_SEEDS, "3"),
    POWDERMELON_SEEDS(SeedInfo.POWDERMELON_SEEDS, "4");

    private SeedInfo seed;
    private String season;

    MixedSeedInfo(SeedInfo seedInfo, String season) {
        this.seed = seed;
        this.season = season;
    }

    public SeedInfo getSeed() {
        return seed;
    }
}
