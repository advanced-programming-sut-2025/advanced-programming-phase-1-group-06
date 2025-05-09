package controllers;


import models.App;
import models.User;
import models.enums.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenuController {

    public String changeUsername(Matcher matcher, Scanner scanner) {
        System.out.println("this ran");
        String username = matcher.group("username");
        if (Regex.USERNAME.getMatcher(username) == null){
            return "invalid username";
        }
        App.getLoggedInUser().setUsername(username);
        return "username changed successfully";
    }

    public String changePassword(Matcher matcher, Scanner scanner){
        String password = matcher.group("password");
        String oldPassword = matcher.group("oldPassword");
        User user = App.getLoggedInUser();
        if (!oldPassword.equals(user.getPassword())){
            return "old password doesn't match";
        }
        String output;
        if ((output = RegisterMenuController.checkPassword(password)) != null){
            return output;
        }
        user.setPassword(password);
        return "";
    }

    public String changeNickname(Matcher matcher, Scanner scanner){
        App.getLoggedInUser().setNickname(matcher.group("nickname"));
        return "nickname changed successfully";
    }

    public String changeEmail(Matcher matcher, Scanner scanner){
        String email = matcher.group("email");
        if (Regex.EMAIL.getMatcher(email) == null){
            return "invalid email format";
        }
        App.getLoggedInUser().setEmail(email);
        return "email changed successfully";
    }

    public String showUserInfo() {
        User user = App.getLoggedInUser();
        return (
                "username: " +  user.getUsername()
                + "\nnickname: " + user.getNickname()
                + "\nhighest score " + user.highScore()
                + "\ngames played " + user.getGameCount()
        );
    }
}
