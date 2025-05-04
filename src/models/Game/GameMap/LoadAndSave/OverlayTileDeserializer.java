package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Plant;
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
                Plant plant = new Plant();
                plant.setRegrowthTime(jsonObject.get("regrowthTime").getAsInt());
                plant.setOneTime(jsonObject.get("oneTime").getAsBoolean());
                plant.setSeasons(jsonObject.get("seasons").getAsString());
                plant.setGrowingStages(context.deserialize(jsonObject.get("growingStages"), int[].class));
                plant.setDaysSincePlanting(jsonObject.get("daysSincePlanting").getAsInt());
                plant.setHarvestable(jsonObject.get("isHarvestable").getAsBoolean());
                plant.setWatered(jsonObject.get("isWatered").getAsBoolean());
                plant.setFertilized(jsonObject.get("isFertilized").getAsBoolean());
                plant.setProduct(context.deserialize(jsonObject.get("product"), CropInfo.class));
                overlayTile = plant;
                break;
            case "Tree":
                Tree tree = new Tree();
                tree.setFruitful(jsonObject.get("isFruitful").getAsBoolean());
                if (jsonObject.has("product")) {
                    tree.setProduct(context.deserialize(jsonObject.get("product"), Crop.class));
                }
                overlayTile = tree;
                break;
            default:
                throw new JsonParseException("Unknown overlay tile type: " + overlayType);
        }

        // Set common properties
        overlayTile.setBlocked(jsonObject.get("isBlocked").getAsBoolean());
        overlayTile.setHits(jsonObject.get("hits").getAsInt());

        return overlayTile;
    }
}
