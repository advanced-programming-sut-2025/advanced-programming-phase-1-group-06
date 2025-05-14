package models;

import models.Game.Coordinates;
import models.Game.Game;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.Tiles.Tile;
import models.enums.Menu;

import java.util.ArrayList;

public class App {

    private static Menu currentMenu = Menu.REGISTER;
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



    public static User getUserByUsername(String username){
        for (User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
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
