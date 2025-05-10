package models.Game.GameMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Game.GameMap.LoadAndSave.GrowableSerializer;
import models.Game.GameMap.LoadAndSave.OverlayTileSerializer;
import models.Game.GameMap.LoadAndSave.TileSerializer;
import models.PlantsAndForaging.Growable;
import models.Tiles.OverlayTile;
import models.Tiles.Tile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class MapReader {
    private Tile[][] tiles;
    int length, width;

    public void saveMap(String filename) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Tile.class, new TileSerializer());
        gsonBuilder.registerTypeAdapter(OverlayTile.class, new OverlayTileSerializer());
        gsonBuilder.registerTypeAdapter(Growable.class, new GrowableSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        JsonObject mapJson = new JsonObject();
        mapJson.addProperty("length", length);
        mapJson.addProperty("width", width);
        mapJson.add("tiles", gson.toJsonTree(tiles));

        String json = gson.toJson(mapJson);
        Files.writeString(Path.of(filename), json);
    }

    public GameMap loadMap(String fileName) throws IOException {
        String json = Files.readString(Path.of(fileName));

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Tile.class, new TileSerializer())
                .registerTypeAdapter(OverlayTile.class, new OverlayTileSerializer())
                .registerTypeAdapter(Growable.class, new GrowableSerializer()).create();

        JsonObject mapJson = JsonParser.parseString(json).getAsJsonObject();
        length = mapJson.get("length").getAsInt();
        width = mapJson.get("width").getAsInt();
        tiles = gson.fromJson(mapJson.get("tiles"), Tile[][].class);
        return new GameMap(tiles, length, width);
    }


}
