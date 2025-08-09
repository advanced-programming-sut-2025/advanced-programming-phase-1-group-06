package com.ap.Model.Save;

import com.ap.Model.Player.User;
import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserArrayManager {
    // Build the file path relative to the JVM working dir:
    private static final Path FILE_PATH = Paths.get(
        System.getProperty("user.dir"),
        "core", "src", "main", "java",
        "com", "ap", "Data",
        "users.json"
    );

    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(User.class, new UserSerializer())
        .registerTypeAdapter(User.class, new UserDeserializer())
        .setPrettyPrinting()
        .create();

    public static boolean updateUser(String username, User updatedUser) {
        try {
            // If the file doesn't exist, bail out:
            if (Files.notExists(FILE_PATH)) {
                System.err.println("File not found at: " + FILE_PATH.toAbsolutePath());
                return false;
            }

            // Read existing array:
            JsonArray userArray = new JsonParser()
                .parse(Files.readString(FILE_PATH))
                .getAsJsonArray();

            // Build updated array:
            JsonArray updatedArray = new JsonArray();
            boolean userFound = false;
            for (JsonElement el : userArray) {
                User u = gson.fromJson(el, User.class);
                if (u.getUsername().equals(username)) {
                    updatedArray.add(gson.toJsonTree(updatedUser));
                    userFound = true;
                } else {
                    updatedArray.add(el);
                }
            }

            // If we found and replaced, write back:
            if (userFound) {
                ensureParentExists();
                try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
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
        try {
            JsonArray userArray;

            if (Files.exists(FILE_PATH)) {
                userArray = new JsonParser()
                    .parse(Files.readString(FILE_PATH))
                    .getAsJsonArray();
            } else {
                userArray = new JsonArray();
            }

            userArray.add(gson.toJsonTree(newUser));

            ensureParentExists();
            try (BufferedWriter writer = Files.newBufferedWriter(FILE_PATH)) {
                gson.toJson(userArray, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> readAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            if (Files.exists(FILE_PATH)) {
                JsonArray userArray = new JsonParser()
                    .parse(Files.readString(FILE_PATH))
                    .getAsJsonArray();

                for (JsonElement el : userArray) {
                    users.add(gson.fromJson(el, User.class));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    /** Ensures the parent directory for FILE_PATH exists. */
    private static void ensureParentExists() throws IOException {
        Path parent = FILE_PATH.getParent();
        if (parent != null && Files.notExists(parent)) {
            Files.createDirectories(parent);
        }
    }
}
