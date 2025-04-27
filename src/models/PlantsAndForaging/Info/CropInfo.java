package models.PlantsAndForaging.Info;


public enum CropInfo {

        BLUE_JAZZ("Blue Jazz", SeedInfo.JAZZ_SEEDS, true, 45, 50),
        CARROT("Carrot", SeedInfo.CARROT_SEEDS, true, 75, 35),
        CAULIFLOWER("Cauliflower", SeedInfo.CAULIFLOWER_SEEDS, true, 75, 175),
        COFFEE_BEAN("Coffee Bean", SeedInfo.COFFEE_BEAN, false, 0, 15),
        GARLIC("Garlic", SeedInfo.GARLIC_SEEDS, true, 20, 60),
        GREEN_BEAN("Green Bean", SeedInfo.BEAN_STARTER, true, 25, 40),
        KALE("Kale", SeedInfo.KALE_SEEDS, true, 50, 110),
        PARSNIP("Parsnip", SeedInfo.PARSNIP_SEEDS, true, 25, 35),
        POTATO("Potato", SeedInfo.POTATO_SEEDS, true, 25, 80),
        RHUBARB("Rhubarb", SeedInfo.RHUBARB_SEEDS, false, 0, 220),
        STRAWBERRY("Strawberry", SeedInfo.STRAWBERRY_SEEDS, true, 50, 120),
        TULIP("Tulip", SeedInfo.TULIP_BULB, true, 45, 30),
        UNMILLED_RICE("Unmilled Rice", SeedInfo.RICE_SHOOT, true, 3, 30),
        BLUEBERRY("Blueberry", SeedInfo.BLUEBERRY_SEEDS, true, 25, 50),
        CORN("Corn", SeedInfo.CORN_SEEDS, true, 25, 50),
        HOPS("Hops", SeedInfo.HOPS_STARTER, true, 45, 25),
        HOT_PEPPER("Hot Pepper", SeedInfo.PEPPER_SEEDS, true, 13, 40),
        MELON("Melon", SeedInfo.MELON_SEEDS, true, 113, 250),
        POPPY("Poppy", SeedInfo.POPPY_SEEDS, true, 45, 140),
        RADISH("Radish", SeedInfo.RADISH_SEEDS, true, 45, 90),
        RED_CABBAGE("Red Cabbage", SeedInfo.RED_CABBAGE_SEEDS, true, 75, 260),
        STARFRUIT("Starfruit", SeedInfo.STARFRUIT_SEEDS, true, 125, 750),
        SUMMER_SPANGLE("Summer Spangle", SeedInfo.SPANGLE_SEEDS, true, 45, 90),
        SUMMER_SQUASH("Summer Squash", SeedInfo.SUMMER_SQUASH_SEEDS, true, 63, 45),
        SUNFLOWER("Sunflower", SeedInfo.SUNFLOWER_SEEDS, true, 45, 80),
        TOMATO("Tomato", SeedInfo.TOMATO_SEEDS, true, 20, 60),
        WHEAT("Wheat", SeedInfo.WHEAT_SEEDS, false, 0, 25),
        AMARANTH("Amaranth", SeedInfo.AMARANTH_SEEDS, true, 50, 150),
        ARTICHOKE("Artichoke", SeedInfo.ARTICHOKE_SEEDS, true, 30, 160),
        BEET("Beet", SeedInfo.BEET_SEEDS, true, 30, 100),
        BOK_CHOY("Bok Choy", SeedInfo.BOK_CHOY_SEEDS, true, 25, 80),
        BROCCOLI("Broccoli", SeedInfo.BROCCOLI_SEEDS, true, 63, 70),
        CRANBERRIES("Cranberries", SeedInfo.CRANBERRY_SEEDS, true, 38, 75),
        EGGPLANT("Eggplant", SeedInfo.EGGPLANT_SEEDS, true, 20, 60),
        FAIRY_ROSE("Fairy Rose", SeedInfo.FAIRY_SEEDS, true, 45, 290),
        GRAPE("Grape", SeedInfo.GRAPE_STARTER, true, 38, 80),
        PUMPKIN("Pumpkin", SeedInfo.PUMPKIN_SEEDS, false, 0, 320),
        YAM("Yam", SeedInfo.YAM_SEEDS, true, 45, 160),
        SWEET_GEM_BERRY("Sweet Gem Berry", SeedInfo.RARE_SEED, false, 0, 3000),
        POWDERMELON("Powdermelon", SeedInfo.POWDERMELON_SEEDS, true, 63, 60),
        ANCIENT_FRUIT("Ancient Fruit", SeedInfo.ANCIENT_SEEDS, false, 0, 550);


        private final String name;
        private final SeedInfo source;
        private final boolean isEdible;
        private final int energyIncrease;
        private final int sellPrice;

        CropInfo(String name, SeedInfo source, boolean isEdible, int energyIncrease, int sellPrice) {
            this.name = name;
            this.source = source;
            this.isEdible = isEdible;
            this.energyIncrease = energyIncrease;
            this.sellPrice = sellPrice;
        }

        public String getName() {
            return name;
        }
        public SeedInfo getSource() {
            return source;
        }
        public boolean isEdible() {
            return isEdible;
        }
        public int getEnergyIncrease() {
            return energyIncrease;
        }
        public int getSellPrice() {
            return sellPrice;
        }

}
