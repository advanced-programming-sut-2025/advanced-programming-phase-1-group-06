package models.PlantsAndForaging;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Sellable;
import models.PlantsAndForaging.Info.TreeProductInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;

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



    public TreeSeed (TreeSeedInfo treeSeedInfo){
        seedName = treeSeedInfo.getSeedName();
        growingStages = treeSeedInfo.getGrowingStages();
        totalHarvestTime = treeSeedInfo.getTotalHarvestTime();
        productInfo = treeSeedInfo.getProductInfo();
        seasons = treeSeedInfo.getSeasons();

    }
}
