package models.Tiles.OverlayTiles;

public abstract class OverlayTile { //displaying rocks, plants, trees, artisan devices, buildings
    protected boolean isBlocked = false;
    protected int hits;
    protected char symbol;
    protected String color;
    public abstract void useTool(); //implement strategy pattern or something for different tiles
    public char getSymbol() {
        return symbol;
    }
    public boolean isBlocked() {
        return isBlocked;
    }

    public OverlayTile(char symbol, String color, int hits, boolean isBlocked) {
        this.symbol = symbol;
        this.color = color;
        this.hits = hits;
        this.isBlocked = isBlocked;
    }

    public int getHits() {
        return hits;
    }
    public String getColor() {
        return color;
    }

}
