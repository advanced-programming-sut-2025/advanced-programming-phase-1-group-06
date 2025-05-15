package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Info.SeedInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.PlantsAndForaging.Plant;
import models.PlantsAndForaging.Tree;
import models.Tiles.Info.BuildingTileInfo;
import models.Tiles.Info.MineralTileInfo;
import models.Tiles.OverlayTiles.BuildingTile;
import models.Tiles.OverlayTiles.MineralTile;
import models.Tiles.OverlayTiles.OverlayTile;

import java.lang.reflect.Type;

public class OverlayTileDeserializer implements JsonDeserializer<OverlayTile> {
    @Override
    public OverlayTile deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String overlayType = jsonObject.get("overlayType").getAsString();

        OverlayTile overlayTile;

        switch (overlayType) {
            case "Plant":
                overlayTile = new Plant(SeedInfo.valueOf(jsonObject.get("seedInfo").getAsString()),
                        jsonObject.get("daysSincePlanting").getAsInt(),
                        jsonObject.get("isWatered").getAsBoolean(),
                        jsonObject.get("isFertilized").getAsBoolean());
                break;
            case "Tree":
                overlayTile = new Tree(TreeSeedInfo.valueOf(jsonObject.get("treeSeedInfo").getAsString()),
                        jsonObject.get("daysSincePlanting").getAsInt());
                break;
            case "MineralTile":
                overlayTile = new MineralTile(MineralTileInfo.valueOf(jsonObject.get("mineralsInfo").getAsString()));
                break;
            case "BuildingTile":
                overlayTile = new BuildingTile(BuildingTileInfo.valueOf(jsonObject.get("buildingTileInfo").getAsString()));
                break;
            default:
                throw new JsonParseException("Unknown overlay tile type: " + overlayType);
        }


        return overlayTile;
    }
}
