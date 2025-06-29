package models.Tiles.OverlayTiles;

import models.App;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Info.MineralsInfo;
import models.Player.Player;
import models.Tiles.Info.MineralTileInfo;
import models.tools.Pickaxe;
import models.tools.Tool;

public class MineralTile extends OverlayTile {

    private final MineralsInfo mineralsInfo;
    private int hardness;
    private int maxDurability;
    private int durability;
    private int level;  // 0: stone 1: copper 2: iron 3: gold 4: iridium

    public MineralTile(MineralTileInfo mineralTileInfo, GameMap gameMap, Coordinates coordinates) {
        super(mineralTileInfo.getSymbol(), mineralTileInfo.getColor(), mineralTileInfo.getHardness(), true,
                gameMap, coordinates);
        mineralsInfo = mineralTileInfo.getMineralsInfo();


    }

    public MineralsInfo getMineralsInfo() {
        return mineralsInfo;
    }

    @Override
    public boolean useTool(Tool tool, Player player) {
        if (tool instanceof Pickaxe pickaxe) {
                player.getInventory().addItem(mineralsInfo.create());
                player.increaseSkill("mining");
                this.destroy();
            System.out.println("destroyed!");
            return true;
        } else {
            System.out.println("wrong tool");
            return false;
        }

    }


}
