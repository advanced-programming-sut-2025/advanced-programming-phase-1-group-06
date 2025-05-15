package models.Tiles.OverlayTiles;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.enums.Color;
import models.tools.Tool;

public class GrassTile extends OverlayTile{
    public GrassTile(GameMap gameMap, Coordinates coordinates) {
        super('w', Color.GREEN_TEXT.getColorCode(), 1, false, gameMap, coordinates);
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        return false;
    }
}
