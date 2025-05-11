package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Growable;
import models.Tiles.Dirt;
import models.Tiles.Flooring;
import models.Tiles.Tile;

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
                ((Dirt) tile).setWatered(jsonObject.get("isWatered").getAsBoolean());
                ((Dirt) tile).setFertilized(jsonObject.get("isFertilized").getAsBoolean());
                ((Dirt) tile).setHoed(jsonObject.get("isHoed").getAsBoolean());
                if (jsonObject.has("growable")) {
                    Growable growable = context.deserialize(jsonObject.get("growable"), Growable.class);
                    ((Dirt) tile).setGrowable(growable);
                }
                break;
            case "Flooring":
                tile = new Flooring();
                break;
            default:
                throw new JsonParseException("Unknown tile type: " + tileType);
        }

        // Set common properties
        tile.isBlocked = jsonObject.get("isBlocked").getAsBoolean();
        tile.symbol = jsonObject.get("symbol").getAsCharacter();
        tile.color = jsonObject.get("color").getAsInt();
        tile.type = TileType.valueOf(jsonObject.get("type").getAsString());

        // Set OverlayTile if it exists
        if (jsonObject.has("overlayTile")) {
            OverlayTile overlayTile = context.deserialize(jsonObject.get("overlayTile"), OverlayTile.class);
            tile.setOverlayTile(overlayTile);
        }

        return tile;
    }
}
