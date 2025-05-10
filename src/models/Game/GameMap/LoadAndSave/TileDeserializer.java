package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Growable;
import models.Tiles.*;

import java.lang.reflect.Type;

public class TileDeserializer implements JsonDeserializer<Tile> {
    @Override
    public Tile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String tileType = jsonObject.get("tileType").getAsString();

        Tile tile;
        switch (tileType) {
            case "Dirt":
                tile = new Dirt();
                ((Dirt) tile).setHoed(jsonObject.get("isHoed").getAsBoolean());
                ((Dirt) tile).setWatered(jsonObject.get("isWatered").getAsBoolean());
                ((Dirt) tile).setFertilized(jsonObject.get("isFertilized").getAsBoolean());
                if (jsonObject.has("growable")) {
                    Growable growable = context.deserialize(jsonObject.get("growable"), Growable.class);
                    ((Dirt) tile).setGrowable(growable);
                }
                break;
            case "Flooring":
                tile = new Flooring();
                //TODO
                break;
            case "Water":
                tile = new Water();
                //TODO
                break;
            default:
                throw new JsonParseException("Unknown tile type: " + tileType);
        }

        // Set common properties
        tile.setBlocked(jsonObject.get("isBlocked").getAsBoolean());
        tile.setSymbol(jsonObject.get("symbol").getAsCharacter());
        tile.setColor(jsonObject.get("color").getAsInt());

        // Set OverlayTile if it exists
        if (jsonObject.has("overlayTile")) {
            OverlayTile overlayTile = context.deserialize(jsonObject.get("overlayTile"), OverlayTile.class);
            tile.setOverlayTile(overlayTile);
        }

        return tile;
    }
}
