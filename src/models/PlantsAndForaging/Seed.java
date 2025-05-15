package models.PlantsAndForaging;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Info.CropInfo;
import models.PlantsAndForaging.Info.ForagingSeedInfo;
import models.PlantsAndForaging.Info.MixedSeedInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.Player.Player;
import models.Tiles.Dirt;

public class Seed extends InventoryItem implements Sellable {
    private CropInfo cropInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private int regrowthTime;
    private boolean oneTime;
    private String seasons; // like 1, 1-3, 1-2-3-4
    private boolean isGiantable;
    private SeedInfo seed;

    public Seed(SeedInfo seedInfo) {
        this.seedName = seedInfo.getName();
        this.growingStages = seedInfo.getGrowingStages();
        this.totalHarvestTime = seedInfo.getTotalHarvestTime();
        this.regrowthTime = seedInfo.getRegrowthTime();
        this.oneTime = seedInfo.isOneTime();
        this.seasons = seedInfo.getSeasons();
        this.isGiantable = seedInfo.isGiantable();
    }
    public Seed(ForagingSeedInfo foragingSeedInfo){ //these get planted randomly by the game during day updates
        seed = foragingSeedInfo.getSeed();
        this.seasons = foragingSeedInfo.getSeason();
    }
    public Seed(MixedSeedInfo mixedSeedInfo){ //these are mysterious seeds so you never know what they are unless you plant em
        this.seed = mixedSeedInfo.getSeed();
        this.seasons = mixedSeedInfo.getSeason();
    }

//    public Plant getPlant() {
//        return new Plant(cropInfo, growingStages, totalHarvestTime, regrowthTime, oneTime, seasons);
//    }

    // not sure if we need the player here
    public boolean plant(GameMap gameMap, Coordinates coordinates, Player player) {
        if (gameMap.getTileAt(coordinates) instanceof Dirt dirt) {
            if (dirt.getOverlayTile() == null) return false;

            dirt.setOverlayTile(new Plant(dirt, this.seed, gameMap, coordinates));
            return true;
        }

        else return false;
    }

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void setPrice(int price) {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getAmount() {
        return 0;
    }

//    public GiantPlant getGiantPlant() {
//    }
}
