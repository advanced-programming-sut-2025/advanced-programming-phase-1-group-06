package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import models.App;
import models.Game.Game;
import models.Game.GameMap.GameMap;
import models.Game.GameMap.MapInitializer;
import models.Game.GameMap.MapModifier;
import models.Game.GameMap.MapReader;
import models.Player.Player;
import models.User;
import models.enums.Menu;
import models.enums.Regex;
import views.LoginMenu;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;

public class MainMenuController {
    public void goToMenu(String menuName) {
        Menu menu = Menu.getMenuByName(menuName);
        if (menuName.equals("login"))
            App.setLoggedInUser(null);
        App.setCurrentMenu(menu);
        System.out.println("you are now in " + App.getCurrentMenu().getName() + " menu.");
    }

    public MainMenuController() {

    }

    public String newGame(Matcher matcher, Scanner scanner){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 3; i ++) {
            User user = App.getUserByUsername(matcher.group("username"+i));
            if (user == null){
                return "user " + i + " does not exist";
            }
            users.add(user);
        }
        ArrayList<Player> players = new ArrayList<>();
        Matcher mapMatcher;
        int mapNumber;
        String input;
        int userCount = 0;
        ArrayList<GameMap> gameMaps = new ArrayList<>();
        while (userCount != 3){
            System.out.println("pick your map. choose a number between 1 to 2");
            input = scanner.nextLine();
            if ((mapMatcher = Regex.GAME_MAP.getMatcher(input)) != null){
                mapNumber = Integer.parseInt(mapMatcher.group("mapNumber"));
                if (mapNumber > 2 || mapNumber < 1){
                    System.out.println("number out of range please choose a number from 1 to 2.");
                    continue;
                }
                GameMap gameMap;
                try {
                    gameMap = new MapReader().loadMap(Path.of("src/models/Game/GameMap/Maps/map".concat(String.valueOf(mapNumber).concat(".json"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                gameMaps.add(new MapInitializer(gameMap).generateObstacles().getGameMap());
                //App.getGame().addMap(gameMap); i dont think it will be of any use
                Player player = new Player(users.get(userCount), userCount);
                players.add(player);
                userCount ++;
            }else
                System.out.println("please answer in the format bellow.\n\"game map <mapNumber>\"");

        }
        try {
            gameMaps.add(new MapModifier(new MapReader().loadMap(Path.of("src/models/Game/GameMap/Maps/map0.json"))).makeStores());
        } catch (IOException e) {
            e.printStackTrace();
        }
        App.setGame(new Game(players, gameMaps));
        App.setCurrentMenu(Menu.GAME);
        return "game created successfully";
    }
}
