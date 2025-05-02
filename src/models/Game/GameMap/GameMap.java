package models.Game.GameMap;

import com.google.gson.Gson;
import models.Game.Coordinates;
import models.Tiles.Tile;


public class GameMap {
    private final int length;
    private final int width;
    private Tile[][] lowerLayerMap; // for the base ground like dirt, grass, water, sand
    private Tile[][] upperLayerMap; // for the objects on top like rocks, trees, plants, etc

    public GameMap(int mapPreset) {
        Gson gson = new Gson();
        this.lowerLayerMap = gson.fromJson("Maps/GameMap".concat(String.valueOf(mapPreset)).concat(".json"), Tile[][].class);
        length = lowerLayerMap.length;
        width = lowerLayerMap[0].length;
    }

    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }

    public String printMap(int x, int y, int size) {
        return null;
    }
    public Tile getTile(int x, int y) {
        return (upperLayerMap[y][x] != null) ? upperLayerMap[y][x] : lowerLayerMap[y][x];
    }

    public void setTile(Coordinates coordinates, Tile tile) {
    }

    public void changeTile(Tile tile1 , Tile tile2){

    }
}
