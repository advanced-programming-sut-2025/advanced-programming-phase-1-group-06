package models.Tiles;

import models.Tiles.Info.FlooringInfo;

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
}
