package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Growable;
import models.Tiles.*;


import java.lang.reflect.Type;

public class TileSerializer implements JsonSerializer<Tile> {
    @Override
    public JsonElement serialize(Tile tile, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        // Save the concrete class type
        json.addProperty("tileType", tile.getClass().getSimpleName());

        // Save common Tile properties
        json.addProperty("isBlocked", tile.isBlocked());
        json.addProperty("symbol", tile.getSymbol());
        json.addProperty("color", tile.getColor());
        //json.addProperty("type", tile.type.toString());

        // Save OverlayTile if it exists
        if (tile.getOverlayTile() != null) {
            json.add("overlayTile", context.serialize(tile.getOverlayTile(), OverlayTile.class));
        }

        // Save Dirt-specific properties
        if (tile instanceof Dirt) {
            Dirt dirt = (Dirt) tile;
            json.addProperty("isHoed", dirt.isHoed());
            json.addProperty("isWatered", dirt.isWatered());
            json.addProperty("isFertilized", dirt.isFertilized());

            if (dirt.getGrowable() != null) {
                json.add("growable", context.serialize(dirt.getGrowable(), Growable.class));
            }
        }
        else if (tile instanceof Flooring) {

        }
        else if (tile instanceof Water) {

        }

        return json;
    }
}