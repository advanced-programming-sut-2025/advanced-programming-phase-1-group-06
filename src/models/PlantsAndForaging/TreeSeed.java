package models.PlantsAndForaging;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.Tiles.Dirt;

public class TreeSeed extends InventoryItem implements Sellable {
    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getAmount() {
        return 0;
    }

    private TreeProductInfo productInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private String seasons;
    private TreeSeedInfo treeSeedInfo;


    public TreeSeed (TreeSeedInfo treeSeedInfo){
        this.treeSeedInfo = treeSeedInfo;
        seedName = treeSeedInfo.getSeedName();
        growingStages = treeSeedInfo.getGrowingStages();
        totalHarvestTime = treeSeedInfo.getTotalHarvestTime();
        productInfo = treeSeedInfo.getProductInfo();
        seasons = treeSeedInfo.getSeasons();
    }

    public boolean plant(GameMap gameMap, Coordinates coordinates) {
        if (gameMap.getTileAt(coordinates) instanceof Dirt dirt) {
            if (dirt.getOverlayTile() != null) return false;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (gameMap.getTileAt(coordinates.x() + i, coordinates.y() + j).getOverlayTile()
                            instanceof Tree) return false;
                    //if any one the surrounding tiles are trees its unplaceable
                }
            }
            dirt.setOverlayTile(new Tree(this.treeSeedInfo, gameMap, coordinates));
            return true;
        }
        else return false;
    }
}
