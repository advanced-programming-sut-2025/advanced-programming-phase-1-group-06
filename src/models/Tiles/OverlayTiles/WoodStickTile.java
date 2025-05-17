package models.Tiles.OverlayTiles;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.ItemFaces.ItemFinder;
import models.Player.Player;
import models.enums.Color;
import models.tools.Axe;
import models.tools.Tool;

public class WoodStickTile extends OverlayTile {
    public WoodStickTile(GameMap gameMap, Coordinates c) {
        super('-', Color.BLACK_TEXT.getColorCode() , 1, true, gameMap, c);
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        if (tool instanceof Axe) {
            player.getInventory().addItem(ItemFinder.WOOD.getItem());
            player.increaseSkill("foraging");
            destroy();
            return true;
        }
        else {
            System.out.println("wrong tool");
            return false;
        }
    }
}
