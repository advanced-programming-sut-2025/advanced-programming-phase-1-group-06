package models.saving;

import com.google.gson.*;
import models.User;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserArrayManager {
    private static final String FILE_PATH = "src/models/data/users.json";
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(User.class, new UserSerializer())
            .registerTypeAdapter(User.class, new UserDeserializer())
            .setPrettyPrinting()
            .create();

    public static boolean updateUser(String username, User updatedUser) {
        JsonArray userArray;
        boolean userFound = false;

        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                return false; // File doesn't exist
            }

            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            userArray = JsonParser.parseString(content).getAsJsonArray();

            // Create new array to store updated data
            JsonArray updatedArray = new JsonArray();

            // Iterate through existing users
            for (JsonElement element : userArray) {
                User currentUser = gson.fromJson(element, User.class);
                if (currentUser.getUsername().equals(username)) {
                    // Replace old user data with updated user data
                    updatedArray.add(gson.toJsonTree(updatedUser));
                    userFound = true;
                } else {
                    // Keep existing user data
                    updatedArray.add(element);
                }
            }

            // Write the updated array back to file
            if (userFound) {
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    gson.toJson(updatedArray, writer);
                }
            }

            return userFound;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void appendUser(User newUser) {
        JsonArray userArray;
        
        // Read existing array or create new one
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                userArray = JsonParser.parseString(content).getAsJsonArray();
            } else {
                userArray = new JsonArray();
            }

            // Convert User object to JsonElement and add to array
            JsonElement userElement = gson.toJsonTree(newUser);
            userArray.add(userElement);

            // Write the updated array back to file
            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                gson.toJson(userArray, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> readAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        
        try {
            if (Files.exists(Paths.get(FILE_PATH))) {
                String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
                JsonArray userArray = JsonParser.parseString(content).getAsJsonArray();
                
                for (JsonElement element : userArray) {
                    User user = gson.fromJson(element, User.class);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return users;
    }
}