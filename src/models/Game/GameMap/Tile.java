package models.Game.GameMap;

public class Tile {
    private boolean isBlocked;
    private char symbol;
    private int color;
    private boolean isDirt; // so we can plant stuff
    private boolean isWatered;
    private Tile tileOnTop;

    public boolean isBlocked() {
        return isBlocked;
    }
}
