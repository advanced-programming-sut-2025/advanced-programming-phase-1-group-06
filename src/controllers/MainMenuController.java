package controllers;

import models.App;
import models.User;
import models.enums.Menu;
import models.enums.Regex;
import views.LoginMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenuController {
    public void goToMenu(String menuName) {
        Menu menu = Menu.getMenuByName(menuName);
        if (menuName.equals("login"))
            App.setLoggedInUser(null);
        App.setCurrentMenu(menu);
        System.out.println("you are now in " + App.getCurrentMenu().getName() + " menu.");
    }

    public void newGame(Matcher matcher, Scanner scanner){
        User user1 = App.getUserByUsername(matcher.group("username1"));
        User user2 = App.getUserByUsername(matcher.group("username2"));
        User user3 = App.getUserByUsername(matcher.group("username3"));

        Matcher mapMatcher;
        int mapNumber;
        while (true){
            System.out.println("pick your map number choose a number between 1 to 3");
        }

    }
}
