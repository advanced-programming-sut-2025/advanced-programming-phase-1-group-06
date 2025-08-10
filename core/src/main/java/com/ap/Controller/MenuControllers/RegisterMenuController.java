package com.ap.Controller.MenuControllers;

import com.ap.Main;
import com.ap.Model.Enum.Regex;
import com.ap.Model.Player.User;
import com.ap.View.PreGameMenus.StartScreen;

import java.util.Random;

public class RegisterMenuController {

    public String register(String username, String password, String email, String nickname, String genderString, int questionNumber, String question, String answer, String answerConfirmation) {
        String output;
        int gender;

        if (User.getUserByUsername(username) != null)
            return "username already taken!";
        if (Regex.USERNAME.getMatcher(username) == null)
            return "invalid username!";
        if (!checkEmail(email))
            return "invalid email!";
        if ((output = checkPassword(password)) != null) {
            return output;
        }
        if (!(answer.equals(answerConfirmation)))
            return "answer confirmation doesn't match";
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
                return "gender not valid (i'm sorry)";
        }

        User user = new User(username, password, email, nickname, gender, questionNumber, answer);
        User.addUser(user);
        User.setLoggedInUser(user);
        return "user created successfully";
    }

    public static String generatePassword() {
        String password;
        while (true) {
            password = randomPassword();
            if (checkPassword(password) == null) {
                return password;
            }
        }
    }


    public static String randomPassword() {
        final char[] specialChars = {'?', '<', '>', ',', '"', '\'', ':', ';', '/', '\\', '|', '[', ']', '{', '}', '+', '=', ')', '(', '*', '&', '^', '%', '$', '#', '!'};
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        int randomInt = r.nextInt(8) + 8;
        for (int i = 0; i < randomInt; i++) {
            int rando = (r.nextInt(4));
            switch (rando) {
                case 0:
                    sb.append((specialChars[r.nextInt(specialChars.length)]));
                    break;
                case 1:
                    sb.append((char) (r.nextInt('z' - 'a') + 'a'));
                    break;
                case 2:
                    sb.append((char) (r.nextInt('Z' - 'A') + 'A'));
                    break;
                case 3:
                    sb.append((char) (r.nextInt('9' - '0') + '0'));
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }

    public void back() {
        Main.getInstance().changeScreen(new StartScreen());
    }

    public static String checkPassword(String password) {
        if (password.length() < 8) return "Password too short!";
        if (!password.matches(".*[a-z].*")) return "No lowercase letter!";
        if (!password.matches(".*[A-Z].*")) return "No uppercase letter!";
        if (!password.matches(".*\\d.*")) return "No number!";
        if (!password.matches(".*[!#$%^&*()=+{}\\[\\]|/:;'\",<>?].*"))
            return "No special character!";
        if (password.contains("..")) return "back to back dots aren't allowed";
        return null; // OK
    }


    public static boolean checkEmail(String email) {
        return Regex.EMAIL.getMatcher(email) != null;
    }

}
