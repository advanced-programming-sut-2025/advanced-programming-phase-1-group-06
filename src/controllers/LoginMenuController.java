package controllers;

import models.User;

import java.util.Scanner;
import java.util.regex.Matcher;
import models.App;
import models.enums.Menu;

public class LoginMenuController {
    public String login(Matcher matcher, Scanner scanner){
        String username = matcher.group("username");
        String password = matcher.group("password");
        boolean stay = (matcher.group("stay") != null);
        User user;
        if ((user = App.getUserByUsername(username)) == null){
            return "user not found";
        }
        if ((!user.getPassword().equals(password))){
            return "wrong password!";
        }
        App.setLoggedInUser(user);
        App.setCurrentMenu(Menu.MAIN);
        return "login successful";
    }

    public String forgotPassword(Matcher matcher, Scanner scanner){
        String username = matcher.group("username");
        User user;
        if ((user = App.getUserByUsername(username)) == null){
            return "user not found";
        }
        System.out.println(user.getQuestion());
        System.out.println("enter your answer: \n");
        String userAnswer = scanner.nextLine();
        if (!userAnswer.equalsIgnoreCase(user.getAnswer()))
            return "incorrect answer";
        return ("your password is : \n" + user.getPassword());
    }
}
