package models.Tiles;

public abstract class OverlayTile { //displaying rocks, plants, trees, artisan devices, buildings
    protected boolean isBlocked = false;
    protected int hits;
    protected char symbol;
    protected int color;
    public abstract void useTool(); //implement strategy pattern or something for different tiles
    public char getSymbol() {
        return symbol;
    }
    public boolean isBlocked() {
        return isBlocked;
    }
}
