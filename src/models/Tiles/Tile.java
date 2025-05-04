package models.Tiles;

import models.tools.Tool;

public abstract class Tile {
    protected boolean isBlocked;
    protected char symbol;
    protected int color;
    protected TileType type;
    protected OverlayTile overlayTile;

    public boolean isBlocked() {
        return isBlocked;
    }


}
