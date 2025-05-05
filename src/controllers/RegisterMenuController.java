package controllers;

import models.App;
import models.User;
import models.enums.Regex;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterMenuController {

    private static final ArrayList<String> questions = new ArrayList<>();
    private static final char [] specialChars = {'?', '<', '>', ',', '"', '\'', ':', ';', '/', '\\', '|', '[', ']', '{', '}', '+', '=', ')', '(', '*', '@', '&', '^', '%', '$', '#', '!'};
    {
        questions.add("1. what was the name of your first pet?");
        questions.add("2. what's the name of the first school you went to?");
        questions.add("3. what's the name of your favorite movie/show?");
        questions.add("4. what's the name your favorite signer/band?");
        questions.add("5. what's the name of your favorite animal?");
//        add some more questions;
    }

    public String checkPassword(String password) {
        if (password.length() < 8)          return "Password too short!";
        if (!password.matches(".*[a-z].*")) return "No lowercase letter!";
        if (!password.matches(".*[A-Z].*")) return "No uppercase letter!";
        if (!password.matches(".*\\d.*"))   return "No number!";
        if (!password.matches(".*[!#$%^&*()=+{}\\[\\]|/:;'\",<>?].*"))
            return "No special character!";
        if (password.contains("..")) return "back to back dots aren't allowed";
        return null; // OK
    }

    public String register(Matcher matcher, Scanner scanner) {
        String username = matcher.group("username");
        String password = matcher.group("password");
        String passwordConfirmation = matcher.group("confirmation");
        String email = matcher.group("email");
        String nickname = matcher.group("nickname");
        String genderString = matcher.group("gender");
        String output;
        int gender;

        if (App.getUserByUsername(username) != null)
            return "username already taken!";
        if (Regex.USERNAME.getMatcher(username) == null)
            return "invalid username!";
        if (Regex.EMAIL.getMatcher(email) == null)
            return "invalid email!";
        while (!password.equals(passwordConfirmation)) {
            System.out.println("confirmation doesn't match password");
            passwordConfirmation = scanner.nextLine();
        }
        if((output = checkPassword(password)) != null){
            return output;
        }
        switch (genderString) {
            case "male":
                gender = 1;
                break;
            case "female":
                gender = 2;
                break;
            case "other":
                gender = 3;
                break;
            default:
                return "gender not valid";
        }
        User user = new User(username, password, email, nickname, gender);
        App.addUser(user);
        return null;
    }

    public String randomPassword() {
        final char [] specialChars = {'?', '<', '>', ',', '"', '\'', ':', ';', '/', '\\', '|', '[', ']', '{', '}', '+', '=', ')', '(', '*', '@', '&', '^', '%', '$', '#', '!'};
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        int randomInt = r.nextInt(8,16);
        for (int i = 0; i < randomInt; i ++) {
            int rando = (r.nextInt(0, 4));
            switch (rando){
                case 0:
                    sb.append((specialChars[r.nextInt(0, 27)]));
                    break;
                case 1:
                    sb.append((char)r.nextInt('a', 'z' + 1));
                    break;
                case 2:
                    sb.append((char) r.nextInt('A', 'Z' + 1));
                    break;
                case 3:
                    sb.append((char) r.nextInt('0', '9' + 1));
                    break;
                default:
                    break;
            }
        }
        System.out.println("your password is: " + sb.toString());
        return sb.toString();
    }

    public String login(Matcher matcher, Scanner scanner) {

        return "";
    }

    public String forgetPassword() {
        return "";
    }
}
