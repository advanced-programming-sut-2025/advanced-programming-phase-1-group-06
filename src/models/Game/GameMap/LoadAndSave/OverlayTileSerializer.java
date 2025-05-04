package models.Game.GameMap.LoadAndSave;

import com.google.gson.*;
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

        // Save Plant-specific properties
        if (overlayTile instanceof Plant) {
            Plant plant = (Plant) overlayTile;
            json.addProperty("regrowthTime", plant.getRegrowthTime());
            json.addProperty("oneTime", plant.isOneTime());
            json.addProperty("seasons", plant.getSeasons());
            json.add("growingStages", context.serialize(plant.getGrowingStages()));
            json.addProperty("daysSincePlanting", plant.getDaysSincePlanting());
            json.addProperty("isHarvestable", plant.isHarvestable());
            json.addProperty("isWatered", plant.isWatered());
            json.addProperty("isFertilized", plant.isFertilized());
            json.add("product", context.serialize(plant.getProduct()));
        }

        // Save Tree-specific properties
        else if (overlayTile instanceof Tree) {
            Tree tree = (Tree) overlayTile;
            json.addProperty("isFruitful", tree.isFruitful());
            if (tree.getProduct() != null) {
                json.add("product", context.serialize(tree.getProduct()));
            }
        }

        return json;
    }
}
