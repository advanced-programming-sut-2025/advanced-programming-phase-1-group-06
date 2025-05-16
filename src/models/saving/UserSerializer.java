package models.saving;

import com.google.gson.*;
import models.User;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User user, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("username", user.getUsername());
        jsonObject.addProperty("password", user.getPassword());
        jsonObject.addProperty("email", user.getEmail());
        jsonObject.addProperty("nickname", user.getNickname());
        jsonObject.addProperty("gender", user.getGender());
        jsonObject.addProperty("points", user.getPoints());
        jsonObject.addProperty("questionNumber", user.getQuestionNumber());
        jsonObject.addProperty("answer", user.getAnswer());

        return jsonObject;
    }
}