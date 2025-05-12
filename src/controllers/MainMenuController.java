package controllers;

import models.App;
import models.Game.Game;
import models.Player.Player;
import models.User;
import models.enums.Menu;
import models.enums.Regex;
import views.LoginMenu;

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

    public String newGame(Matcher matcher, Scanner scanner){
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i ++) {
            User user = App.getUserByUsername(matcher.group("username"+i));
            if (user == null){
                return "user " + i + " does not exist";
            }
        }
        ArrayList<Player> players = new ArrayList<>();
        Matcher mapMatcher;
        int mapNumber;
        String input;
        int userCount = 0;
        while (userCount != 3){
            System.out.println("pick your map. choose a number between 1 to 3");
            input = scanner.nextLine();
            if ((mapMatcher = Regex.GAME_MAP.getMatcher(input)) != null){
                mapNumber = Integer.parseInt(mapMatcher.group("map_number"));
                if (mapNumber > 3 || mapNumber < 1){
                    System.out.println("number out of range please choose a number from 1 to 3.");
                    continue;
                }
                Player player = new Player(users.get(userCount), mapNumber);
                userCount ++;
            }else
                System.out.println("please answer in the format bellow.\n\"game map <map_number>\"");

        }
        App.setGame(new Game(players));
        return "game created successfully";
    }
}
