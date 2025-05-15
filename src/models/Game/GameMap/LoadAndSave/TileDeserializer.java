package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Growable;
import models.Tiles.*;
import models.Tiles.Info.FlooringInfo;
import models.Tiles.OverlayTiles.OverlayTile;

import java.lang.reflect.Type;

public class TileDeserializer implements JsonDeserializer<Tile> {
    private static int x = 0;
    @Override
    public Tile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String tileType = jsonObject.get("tileType").getAsString();

        Tile tile;
        switch (tileType) {
            case "Dirt":
                tile = new Dirt(jsonObject.get("isWatered").getAsBoolean(), jsonObject.get("isFertilized").getAsBoolean()
                        , jsonObject.get("isHoed").getAsBoolean(), null);
                jsonObject.get("isBlocked").getAsBoolean();
//                                if (jsonObject.has("growable")) {
//                    Growable growable = context.deserialize(jsonObject.get("growable"), Growable.class);
//                    ((Dirt) tile).setGrowable(growable);
//                }
                break;
            case "Flooring":
                tile = new Flooring(FlooringInfo.valueOf(jsonObject.get("flooringInfo").getAsString()));
                break;
            case "Water":
                tile = new Water();
                break;
            default:
                throw new JsonParseException("Unknown tile type: " + tileType);
        }




//        // Set OverlayTile if it exists
//        if (jsonObject.has("overlayTile")) {
//            OverlayTile overlayTile = context.deserialize(jsonObject.get("overlayTile"), OverlayTile.class);
//            tile.setOverlayTile(overlayTile);
//        }

        return tile;
    }
}
