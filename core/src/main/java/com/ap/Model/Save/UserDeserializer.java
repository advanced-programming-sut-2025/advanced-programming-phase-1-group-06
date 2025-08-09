package com.ap.Model.Save;

import com.ap.Model.Player.User;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UserDeserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
        String email = jsonObject.get("email").getAsString();
        String nickname = jsonObject.get("nickname").getAsString();
        int gender = jsonObject.get("gender").getAsInt();
        int questionNumber = jsonObject.get("questionNumber").getAsInt();
        String answer = jsonObject.get("answer").getAsString();

        return new User(username, password, email, nickname, gender, questionNumber, answer);
    }
}
