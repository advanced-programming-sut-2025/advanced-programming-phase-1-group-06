package models.Tiles.OverlayTiles;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.enums.Color;
import models.tools.Tool;

public class WoodStickTile extends OverlayTile {
    public WoodStickTile(GameMap gameMap, Coordinates c) {
        super('-', Color.BLACK_TEXT.getColorCode() , 1, true, gameMap, c);
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        return false;
    }
}
