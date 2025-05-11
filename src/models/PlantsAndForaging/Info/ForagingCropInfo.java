package models.PlantsAndForaging.Info;

import models.PlantsAndForaging.Crop;

public enum ForagingCropInfo {
    // Foraged items (using a special FORAGE_SOURCE SeedInfo for consistency)
    COMMON_MUSHROOM("Common Mushroom", SeedInfo.FORAGE_SOURCE, true, 38, 40, "0"),
    DAFFODIL("Daffodil", SeedInfo.FORAGE_SOURCE, false, 0, 30, "1"),
    DANDELION("Dandelion", SeedInfo.FORAGE_SOURCE, true, 25, 40, "1"),
    LEEK("Leek", SeedInfo.FORAGE_SOURCE, true, 40, 60, "1"),
    MOREL("Morel", SeedInfo.FORAGE_SOURCE, true, 20, 150, "1"),
    SALMONBERRY("Salmonberry", SeedInfo.FORAGE_SOURCE, true, 25, 5, "1"),
    SPRING_ONION("Spring Onion", SeedInfo.FORAGE_SOURCE, true, 13, 8, "1"),
    WILD_HORSERADISH("Wild Horseradish", SeedInfo.FORAGE_SOURCE, true, 13, 50, "1"),
    FIDDLEHEAD_FERN("Fiddlehead Fern", SeedInfo.FORAGE_SOURCE, true, 25, 90, "2"),
    FORAGED_GRAPE("Grape", SeedInfo.FORAGE_SOURCE, true, 38, 80, "2"),
    RED_MUSHROOM("Red Mushroom", SeedInfo.FORAGE_SOURCE, true, -50, 75, "2"),
    SPICE_BERRY("Spice Berry", SeedInfo.FORAGE_SOURCE, true, 25, 80, "2"),
    SWEET_PEA("Sweet Pea", SeedInfo.FORAGE_SOURCE, false, 0, 50, "2"),
    BLACKBERRY("Blackberry", SeedInfo.FORAGE_SOURCE, true, 25, 25, "3"),
    CHANTERELLE("Chanterelle", SeedInfo.FORAGE_SOURCE, true, 75, 160, "3"),
    HAZELNUT("Hazelnut", SeedInfo.FORAGE_SOURCE, true, 38, 40, "3"),
    PURPLE_MUSHROOM("Purple Mushroom", SeedInfo.FORAGE_SOURCE, true, 30, 90, "3"),
    WILD_PLUM("Wild Plum", SeedInfo.FORAGE_SOURCE, true, 25, 80, "3"),
    CROCUS("Crocus", SeedInfo.FORAGE_SOURCE, false, 0, 60, "4"),
    CRYSTAL_FRUIT("Crystal Fruit", SeedInfo.FORAGE_SOURCE, true, 63, 150, "4"),
    HOLLY("Holly", SeedInfo.FORAGE_SOURCE, true, -37, 80, "4"),
    SNOW_YAM("Snow Yam", SeedInfo.FORAGE_SOURCE, true, 30, 100, "4"),
    WINTER_ROOT("Winter Root", SeedInfo.FORAGE_SOURCE, true, 25, 70, "4");

    private String name;
    private SeedInfo source;
    private boolean isEdible;
    private int energyIncrease;
    private int sellPrice;
    private String seasons;

    ForagingCropInfo(String name, SeedInfo source, boolean isEdible, int energyIncrease, int sellPrice, String seasons) {
        this.name = name;
        this.source = source;
        this.isEdible = isEdible;
        this.energyIncrease = energyIncrease;
        this.sellPrice = sellPrice;
        this.seasons = seasons;
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
    public String getSeasons() {
        return seasons;
    }

    public Crop create (){
        return new Crop(this);
    }

}
