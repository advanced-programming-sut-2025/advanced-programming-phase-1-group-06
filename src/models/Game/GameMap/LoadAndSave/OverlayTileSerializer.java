package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
import models.PlantsAndForaging.Plant;
import models.PlantsAndForaging.Tree;
import models.Tiles.OverlayTiles.BuildingTile;
import models.Tiles.OverlayTiles.MineralTile;
import models.Tiles.OverlayTiles.OverlayTile;

import java.lang.reflect.Type;

public class OverlayTileSerializer implements JsonSerializer<OverlayTile> {
    @Override
    public JsonElement serialize(OverlayTile overlayTile, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();

        // Save the concrete class type
        json.addProperty("overlayType", overlayTile.getClass().getSimpleName());
        // Save common OverlayTile properties
        json.addProperty("isBlocked", overlayTile.isBlocked());
        json.addProperty("hits", overlayTile.getHits());
        json.addProperty("symbol", overlayTile.getSymbol());
        json.addProperty("color", overlayTile.getColor());
        // Save Plant-specific properties
        switch (overlayTile) {
            case Plant plant -> {
                json.addProperty("seedInfo", String.valueOf(plant.getSeedInfo()));
                json.addProperty("daysSincePlanting", plant.getDaysSincePlanting());
                //json.addProperty("isHarvestable", plant.isHarvestable());
                json.addProperty("isWatered", plant.isWatered());
                json.addProperty("isFertilized", plant.isFertilized());
            }

            // Save Tree-specific properties
            case Tree tree -> {
                json.addProperty("treeSeedInfo", String.valueOf(tree.getTreeSeedInfo()));
                json.addProperty("daysSincePlanting", tree.getDaysSincePlanting());
            }
            case MineralTile mineralTile ->
                    json.addProperty("mineralsInfo", String.valueOf(mineralTile.getMineralsInfo()));
            case BuildingTile buildingTile -> {
                json.addProperty("buildingTileInfo", String.valueOf(buildingTile.getBuildingTileInfo()));
            }
            default -> {
            }
        }

        return json;
    }
}
