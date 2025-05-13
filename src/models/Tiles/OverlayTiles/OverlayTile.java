package models.Tiles.OverlayTiles;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.tools.Tool;

public abstract class OverlayTile { //displaying rocks, plants, trees, artisan devices, buildings
    protected boolean isBlocked = false;
    protected int hits;
    protected char symbol;
    protected String color;
    protected GameMap gameMap;
    protected int x, y;
    public char getSymbol() {
        return symbol;
    }
    public boolean isBlocked() {
        return isBlocked;
    }

    public OverlayTile(char symbol, String color, int hits, boolean isBlocked, GameMap gameMap, Coordinates coordinates) {
        this.symbol = symbol;
        this.color = color;
        this.hits = hits;
        this.isBlocked = isBlocked;
        this.gameMap = gameMap;
        x = coordinates.x();
        y = coordinates.y();
    }

    public Coordinates getCoordinates() {
        return new Coordinates(x, y);
    }

    protected void destroy() {
        gameMap.getTileAt(x, y).setOverlayTile(null);
    }

    public int getHits() {
        return hits;
    }
    public String getColor() {
        return color;
    }
    public abstract boolean useTool(Tool tool, Player player); //implement strategy pattern or something for different tiles
}
