package com.ap.Model.Save;

import com.ap.Model.Player.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

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
