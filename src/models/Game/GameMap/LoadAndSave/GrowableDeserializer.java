package models.Game.GameMap.LoadAndSave;

import models.PlantsAndForaging.Growable;
import com.google.gson.*;
import models.PlantsAndForaging.Info.SeedInfo;
import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.PlantsAndForaging.Plant;
import models.PlantsAndForaging.Tree;
import java.lang.reflect.Type;

public class GrowableDeserializer implements JsonDeserializer<Growable> {
    @Override
    public Growable deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String growableType = jsonObject.get("type").getAsString();

        // Create either a Plant or Tree based on the saved type
        Growable growable;
        if (growableType.equals("Plant")) {
            growable = new Plant(SeedInfo.valueOf(jsonObject.get("seedInfo").getAsString()),
                                 jsonObject.get("daysSincePlanting").getAsInt(),
                                 jsonObject.get("isWatered").getAsBoolean(),
                                 jsonObject.get("isFertilized").getAsBoolean());

        } else if (growableType.equals("Tree")) {
            growable = new Tree(TreeSeedInfo.valueOf(jsonObject.get("treeSeedInfo").getAsString()),
                                jsonObject.get("daysSincePlanting").getAsInt());
        } else {
            throw new JsonParseException("Unknown growable type: " + growableType);
        }

        return growable;
    }
}