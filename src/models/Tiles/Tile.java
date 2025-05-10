package models.Tiles;

import models.tools.Tool;

public abstract class Tile {
    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public void setOverlayTile(OverlayTile overlayTile) {
        this.overlayTile = overlayTile;
    }

    protected boolean isBlocked;
    protected char symbol;
    protected int color;
    protected TileType type;
    protected OverlayTile overlayTile;

    public TileType getType() {
        return type;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getColor() {
        return color;
    }

    public OverlayTile getOverlayTile() {
        return overlayTile;
    }

    public char showTile() {
        if (overlayTile != null) {
            return overlayTile.getSymbol();
        }
        return symbol;
    }

    public boolean isBlocked() {
        if (overlayTile != null) {
            return overlayTile.isBlocked();
        }
        return isBlocked;
    }


}
