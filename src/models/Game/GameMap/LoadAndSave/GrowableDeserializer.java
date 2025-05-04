package models.Game.GameMap.LoadAndSave;

import models.PlantsAndForaging.Growable;
import com.google.gson.*;
import models.PlantsAndForaging.Plant;
import models.PlantsAndForaging.Tree;
import java.lang.reflect.Type;

public class GrowableDeserializer implements JsonDeserializer<Growable> {
    @Override
    public Growable deserialize(JsonElement json, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String growableType = jsonObject.get("type").getAsString();
        String species = jsonObject.get("species").getAsString();

        // Create either a Plant or Tree based on the saved type
        Growable growable;
        if (growableType.equals("PLANT")) {
            growable = new Plant(species);
        } else if (growableType.equals("TREE")) {
            growable = new Tree(species);
        } else {
            throw new JsonParseException("Unknown growable type: " + growableType);
        }

        return growable;
    }
}