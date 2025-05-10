package models.Tiles;

import models.PlantsAndForaging.Info.MineralsInfo;

public class MineralTile extends OverlayTile {
    private int hardness = 3;
    {
        super.hits = hardness * 3;
        super.isBlocked = true;
        super.symbol = 'O';
    }
    public MineralsInfo getMineralsInfo() {
        return mineralsInfo;
    }

    private MineralsInfo mineralsInfo;

    public MineralTile(MineralsInfo mineralsInfo) {

    }



    @Override
    public void useTool() {

    }
}
