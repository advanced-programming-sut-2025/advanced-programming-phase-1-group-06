package models.Tiles;

import models.Tiles.OverlayTiles.OverlayTile;
import models.enums.Color;

public abstract class Tile {
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public void setOverlayTile(OverlayTile overlayTile) {
        this.overlayTile = overlayTile;
    }

    protected boolean isBlocked;
    protected String color;
    protected TileType type;
    protected OverlayTile overlayTile;



    public String getColor() {
        return color;
    }

    public OverlayTile getOverlayTile() {
        return overlayTile;
    }

    public String showTile() {
        if (overlayTile == null) return color + " " + Color.RESET.getColorCode();
        else return color + overlayTile.getColor() + overlayTile.getSymbol() + Color.RESET.getColorCode();
    }



    public boolean isBlocked() {
        if (overlayTile != null) {
            return overlayTile.isBlocked();
        }
        return isBlocked;
    }


}
