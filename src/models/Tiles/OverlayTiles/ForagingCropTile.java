package models.Tiles.OverlayTiles;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Info.ForagingCropInfo;
import models.Player.Player;
import models.enums.Color;
import models.tools.Scythe;
import models.tools.Tool;

import java.util.Objects;

public class ForagingCropTile extends OverlayTile{
    ForagingCropInfo info;
    public ForagingCropTile(ForagingCropInfo info, GameMap gameMap, Coordinates coordinates) {
        super('^', Color.CYAN_TEXT.getColorCode(), 0, false, gameMap, coordinates);
        this.info = info;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        if (Objects.requireNonNull(tool) instanceof Scythe) {
            player.getInventory().addItem(info.create());
            player.increaseSkill("foraging");
            this.destroy();
            return true;
        }
        return false;
    }
}
