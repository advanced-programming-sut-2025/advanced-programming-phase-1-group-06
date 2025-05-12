package models.Tiles.OverlayTiles;

import models.PlantsAndForaging.Info.ForagingCropInfo;
import models.Player.Player;
import models.tools.Scythe;
import models.tools.Tool;

public class ForagingCropTile extends OverlayTile{
    ForagingCropInfo info;
    ForagingCropTile(ForagingCropInfo info) {
        super();//TODO needs the creation coordinates
        this.info = info;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        switch (tool) {
            case Scythe scythe -> {
                player.getInventory().addItem(info.create());
            }
        }
    }
}
