package models.Tiles.OverlayTiles;

import models.App;
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

    public MineralTile(MineralTileInfo mineralTileInfo) {
        super(mineralTileInfo.getSymbol(), mineralTileInfo.getColor(), mineralTileInfo.getHardness() * 3, true);
        mineralsInfo = mineralTileInfo.getMineralsInfo();


    }
    
    
    @Override
    public boolean useTool(Tool tool) {
        Player currentPlayer = App.getCurrentPlayer();
        if (tool instanceof Pickaxe){
            durability -= ((Pickaxe) tool).getDamage();
            if (durability == 0){
                this.destory();
            }
            return true;
        }else {
            currentPlayer.setEnergy(currentPlayer.getEnergy() - currentPlayer.getCurrentTool().getEnergyCost());
            System.out.println("wrong tool");
        }
    }

    public void destory(){
//        please implement this shit brothers and sisters.
    }
}
