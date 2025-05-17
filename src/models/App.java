package models;

import com.google.gson.*;
import models.Game.Coordinates;
import models.Game.Game;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.Tiles.Tile;
import models.enums.Menu;
import models.saving.UserArrayManager;
import models.saving.UserSerializer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {

    private static Menu currentMenu = Menu.REGISTER;
//    static {
//        try {
//            String json = Files.readString(Paths.get("src/models/data/lastGameData.json"));
//            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
//            if (jsonObject.get("stayLoggedIn").getAsBoolean()) {
//                App.setLoggedInUser(App.getUserByUsername(jsonObject.get("userName").getAsString()));
//                currentMenu = Menu.MAIN;
//            }
//            else {
//                currentMenu = Menu.REGISTER;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private static ArrayList<User> users = new ArrayList<>();
    private static  Game game;

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game){App.game = game;}

    public static Player getCurrentPlayer(){
        return game.getCurrentPlayer();
    }

    public static GameMap getCurrentMap(Player player){
        return player.getCurrentMap();
    }

    public static Tile getTile(Coordinates coordinates, Player player){
        return player.getCurrentMap().getTileAt(coordinates);
    }

    public static Tile getTile(int x, int y, Player player){
        return getCurrentMap(player).getTileAt(x, y);
    }

    public static void setUsers(ArrayList<User> users) {
        App.users = users;
    }

    public static long getPreciseTime(){
        return game.getDateTime().getPreciseTime();
    }

    public static long getPreciseDay(){
        return game.getDateTime().getPreciseDay();
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }

    private static User loggedInUser;



    public static User getUserByUsername(String username) {
        for (User user : UserArrayManager.readAllUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return UserArrayManager.readAllUsers();
    }

    public static void addUser(User user) {
        UserArrayManager.appendUser(user);
    }

    public static Menu getCurrentMenu(){
        return currentMenu;
    }
    public static void setCurrentMenu(Menu menu){
        currentMenu = menu;
    }

    public static void exit(){
        return;
    }
}
