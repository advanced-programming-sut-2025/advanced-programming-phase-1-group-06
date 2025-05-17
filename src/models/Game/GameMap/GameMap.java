package models.Game.GameMap;


import models.App;
import models.Game.Coordinates;
import models.PlantsAndForaging.Growable;
import models.Tiles.OverlayTiles.OverlayTile;
import models.Tiles.Tile;
import models.enums.Color;

import java.util.Arrays;

public class GameMap {

    Tile[][] tiles;
    int length, width;
    int rockCount;
    int oreCount;
    int weedCount;


    public int getRockCount() {
        return rockCount;
    }

    public int getOreCount() {
        return oreCount;
    }

    public int getWeedCount() {
        return weedCount;
    }

    public int getTreeCount() {
        return treeCount;
    }

    public int getStickCount() {
        return stickCount;
    }

    int treeCount;
    int stickCount;

    public GameMap(Tile[][] tiles, int length, int width) {
        this.tiles = tiles;
        this.length = length;
        this.width = width;
    }

    public String print(Coordinates c, int size) {
        int minX = Math.max(c.x() - size, 0);
        int maxX = Math.min(c.x() + size, length - 1);
        int minY = Math.max(c.y() - size, 0);
        int maxY = Math.min(c.y() + size, width - 1);
        StringBuilder mapString = new StringBuilder();
        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                try {
                    if (x == App.getCurrentPlayer().getX() && y == App.getCurrentPlayer().getY()) {
                        System.out.print(Color.BLACK_BG.getColorCode() + Color.BLUE_TEXT.getColorCode()
                                + "@" + Color.RESET.getColorCode());
                    }
                    else System.out.print(tiles[y][x].showTile());
                } catch (NullPointerException e) {
                    System.out.println("x: " + x + ", y: " + y);
                }
            }
            System.out.println();
        }
        return mapString.toString();
    }

    public Tile getTileAt(int x, int y) {
        // Bounds checking
        if (x < 0 || x >= length || y < 0 || y >= width) {
            return null;
        }
        try {
            return tiles[y][x];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("x: " + x + " y: " + y + "out of bounds");
        }
        return null;
    }

    // Overload for Coordinates object
    public Tile getTileAt(Coordinates coordinates) {
        return getTileAt(coordinates.x(), coordinates.y());
    }

    public void removeOverlayTile(OverlayTile overlayTile) {
        tiles[overlayTile.getCoordinates().y()][overlayTile.getCoordinates().x()].setOverlayTile(null);
        if (overlayTile instanceof Growable g) {
            App.getGame().removeGrowable(g);
        }
    }

    public boolean isBlocked(int newX, int newY) {
        return tiles[newY][newX].isBlocked();
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
