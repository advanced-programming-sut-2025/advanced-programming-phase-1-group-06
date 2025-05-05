package controllers;

import models.App;
import models.User;
import models.enums.Menu;
import models.enums.Regex;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

import static java.lang.Integer.parseInt;

public class RegisterMenuController {

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
        if (password.equals("@generate-password")){
            while (true){
                password = randomPassword();
                if (checkPassword(password) != null) {
                    continue;
                }
                System.out.println("suggested password: " + randomPassword() + "\ndo you want to set the generated password as your password? (y/n?)");
                String answer = scanner.nextLine();
                if (answer.equals("y")){
                    break;
                }
            }
            passwordConfirmation = password;
        }

        if (App.getUserByUsername(username) != null)
            return "username already taken!";
        if (Regex.USERNAME.getMatcher(username) == null)
            return "invalid username!";
        if (Regex.EMAIL.getMatcher(email) == null)
            return "invalid email!";
        while (!password.equals(passwordConfirmation)) {
            System.out.println("confirmation doesn't match password");
            System.out.println("password: " + password);
            System.out.println("confirmation: " + passwordConfirmation);
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
        String [] questions = User.getQuestions();
        for(String q : questions){
            System.out.println(q);
        }
        System.out.println("pick a question from the above options.");
        int questionNumber;
        int questionCount = questions.length;
//        while (true) {
//            try {
//                System.out.println("Please enter a question number:");
//                questionNumber = scanner.nextInt();
//                if (questionNumber >= 1 && questionNumber <= questionCount) {
//                    System.out.println("You selected question number: " + questionNumber);
//                    break;
//                } else {
//                    System.out.println("Number is out of range. Please enter a number between 1 and " + questionCount + ".");
//                }
//            } catch (Exception e) {
//                System.out.println("Please enter a valid number.");
//            }
//        }
        String answer;
        Matcher newMatcher;
        while (true){
            String input = scanner.nextLine();
            if ((newMatcher = Regex.PICK_QUESTION.getMatcher(input)) == null){
                System.out.println("invalid format");
                continue;
            }
            questionNumber = parseInt(newMatcher.group("questionNumber"));
            if (questionNumber > questionCount || questionNumber < 1){
                System.out.println("please enter a number between 1 and " + questionCount + ".");
                continue;
            }
            answer = newMatcher.group("answer");
            if (!answer.equals(newMatcher.group("confirmation"))){
                System.out.println("Balls");

                System.out.println("confirmation doesn't match.");
                System.out.println(answer);
                System.out.println(newMatcher.group("confirmation"));
                continue;
            }
            break;
        }
        User user = new User(username, password, email, nickname, gender, questionNumber, answer);
        App.addUser(user);
        App.setCurrentMenu(Menu.Login);
        return null;
    }

    public static String randomPassword() {
        final char [] specialChars = {'?', '<', '>', ',', '"', '\'', ':', ';', '/', '\\', '|', '[', ']', '{', '}', '+', '=', ')', '(', '*', '&', '^', '%', '$', '#', '!'};
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        int randomInt = r.nextInt(8) + 8;
        for (int i = 0; i < randomInt; i ++) {
            int rando = (r.nextInt(4));
            switch (rando){
                case 0:
                    sb.append((specialChars[r.nextInt(specialChars.length)]));
                    break;
                case 1:
                    sb.append((char)(r.nextInt('z' - 'a') + 'a'));
                    break;
                case 2:
                    sb.append((char)(r.nextInt('Z' - 'A') + 'A'));
                    break;
                case 3:
                    sb.append((char)(r.nextInt('9' - '0') + '0'));
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
}
