package models.Game.GameMap;

import com.google.gson.*;
import models.Game.Coordinates;
import models.Game.GameMap.LoadAndSave.*;
import models.PlantsAndForaging.Growable;
import models.Tiles.OverlayTile;
import models.Tiles.Tile;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;

public class GameMap {
    private final int length;
    private final int width;
    private Tile[][] tiles;  // Now just a single array of tiles

    public GameMap(int length, int width) {
        this.length = length;
        this.width = width;
        this.tiles = new Tile[length][width];
    }

    public void saveToFile(String filename) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Tile.class, new TileSerializer())
                .registerTypeAdapter(OverlayTile.class, new OverlayTileSerializer())
                .registerTypeAdapter(Growable.class, new GrowableSerializer())
                .setPrettyPrinting()
                .create();

        JsonObject mapJson = new JsonObject();
        mapJson.addProperty("length", length);
        mapJson.addProperty("width", width);
        mapJson.add("tiles", gson.toJsonTree(tiles));

        String json = gson.toJson(mapJson);
        Files.writeString(Path.of(filename), json);
    }

    public static GameMap loadFromFile(String filename) throws IOException {
        String json = Files.readString(Path.of(filename));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Tile.class, new TileDeserializer())
                .registerTypeAdapter(OverlayTile.class, new OverlayTileDeserializer())
                .registerTypeAdapter(Growable.class, new GrowableDeserializer())
                .create();

        JsonObject mapJson = JsonParser.parseString(json).getAsJsonObject();
        int length = mapJson.get("length").getAsInt();
        int width = mapJson.get("width").getAsInt();

        GameMap map = new GameMap(length, width);
        map.tiles = gson.fromJson(mapJson.get("tiles"), Tile[][].class);

        return map;
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
