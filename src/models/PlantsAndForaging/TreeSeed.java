package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;

public class TreeSeed implements InventoryItem, Sellable {

    private TreeProductInfo productInfo;
    private String seedName;
    private String growingStages;
    private int totalHarvestTime;
    private String seasons;



    public TreeSeed (TreeSeedInfo treeSeedInfo){
        seedName = treeSeedInfo.getSeedName();
        growingStages = treeSeedInfo.getGrowingStages();
        totalHarvestTime = treeSeedInfo.getTotalHarvestTime();
        productInfo = treeSeedInfo.getProductInfo();
        seasons = treeSeedInfo.getSeasons();

    }
}
