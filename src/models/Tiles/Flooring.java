package models.Tiles;

import models.Tiles.Info.FlooringInfo;
import models.tools.Tool;

public class Flooring extends Tile{
    public FlooringInfo getFlooringInfo() {
        return flooringInfo;
    }

    FlooringInfo flooringInfo;
    public Flooring(FlooringInfo flooringInfo) {
        color = flooringInfo.getColor();
        this.flooringInfo = flooringInfo;
        isBlocked = false;
    }

    @Override
    public boolean useTool(Tool tool) {
        return true;
    }
}
