package models.Game.GameMap;


import models.Game.Coordinates;
import models.Tiles.Tile;

public class GameMap {
    Tile[][] tiles;
    int length, width;

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
                System.out.print(tiles[y][x].showTile());
            }
            System.out.println();
        }
        return mapString.toString();
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
