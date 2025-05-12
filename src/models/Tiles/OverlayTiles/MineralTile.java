package models.Tiles.OverlayTiles;

import models.PlantsAndForaging.Info.MineralsInfo;
import models.Tiles.Info.MineralTileInfo;

public class MineralTile extends OverlayTile {
    private int hardness;
    
    public MineralsInfo getMineralsInfo() {
        return mineralsInfo;
    }

    private final MineralsInfo mineralsInfo;

    public MineralTile(MineralTileInfo mineralTileInfo) {
        super(mineralTileInfo.getSymbol(), mineralTileInfo.getColor(), mineralTileInfo.getHardness() * 3, true);
        mineralsInfo = mineralTileInfo.getMineralsInfo();


    }
    
    
    @Override
    public void useTool() {

    }
}
