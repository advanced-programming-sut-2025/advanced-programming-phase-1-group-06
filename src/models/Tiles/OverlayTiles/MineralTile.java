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

    private int hardness;
    private int maxDurability;
    private int durability;
    private int level;  // 0: stone 1: copper 2: iron 3: gold 4: iridium
    
    public MineralsInfo getMineralsInfo() {
        return mineralsInfo;
    }

    private final MineralsInfo mineralsInfo;

    public MineralTile(MineralTileInfo mineralTileInfo, GameMap gameMap, Coordinates coordinates) {
        super(mineralTileInfo.getSymbol(), mineralTileInfo.getColor(), mineralTileInfo.getHardness() * 3, true,
                gameMap, coordinates);
        mineralsInfo = mineralTileInfo.getMineralsInfo();


    }
    
    
    @Override
    public boolean useTool(Tool tool, Player player) {
        if (tool instanceof Pickaxe pickaxe){
            hits -= pickaxe.getDamage();
            if (hits <= 0){
                player.getInventory().addItem(mineralsInfo.create());
                //COMMENT: idk how you want to change the energy but i suggest you change it
                this.destory();
            }
            return true;
        }else {
            player.setEnergy(player.getEnergy() - player.getCurrentTool().getEnergyCost()); //COMMENT: here too
            System.out.println("wrong tool");
            return false;
        }

    }

    public void destory(){
//        please implement this shit brothers and sisters.
    }
}
