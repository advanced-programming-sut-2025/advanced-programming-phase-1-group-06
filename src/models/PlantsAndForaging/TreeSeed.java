package models.PlantsAndForaging;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.Tiles.Dirt;

public class TreeSeed extends InventoryItem implements Sellable {

    private TreeProductInfo productInfo;
    private String growingStages;
    private int totalHarvestTime;
    private String seasons;
    private TreeSeedInfo treeSeedInfo;
    private int price;

    @Override
    public void sell() {

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    public TreeSeed (TreeSeedInfo treeSeedInfo){
        this.treeSeedInfo = treeSeedInfo;
        name = treeSeedInfo.getSeedName();
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
