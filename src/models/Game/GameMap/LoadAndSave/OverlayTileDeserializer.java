package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Info.MineralsInfo;
import models.PlantsAndForaging.Info.SeedInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.PlantsAndForaging.Plant;
import models.PlantsAndForaging.Tree;
import models.Tiles.MineralTile;
import models.Tiles.OverlayTile;

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
                overlayTile = new MineralTile(MineralsInfo.valueOf(jsonObject.get("mineralsInfo").getAsString()));
                break;
            default:
                throw new JsonParseException("Unknown overlay tile type: " + overlayType);
        }


        return overlayTile;
    }
}
