package com.ap.Controller.MenuControllers;

import com.ap.Model.Player.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class LoginMenuController {
    public String login(String username, String password, boolean stayLogged) {
        User user;
        if ((user = User.getUserByUsername(username)) == null) {
            return "user not found";
        }
        if ((!user.getPassword().equals(password))) {
            System.out.println(user.getPassword());
            return "wrong password!";
        }
        try { //saving stayLoggedIn info
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("stayLoggedIn", stayLogged);
            jsonObject.addProperty("username", username);
            FileWriter writer = new FileWriter("C:\\Users\\user\\Desktop\\Proj\\src\\models\\data\\lastGameData.json");
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User.setLoggedInUser(user);
        return "login successful";
    }

    public String getQuestion(String username){
        User user;
        if ((user = User.getUserByUsername(username)) == null) {
            return "user not found";
        }
        return user.getQuestion();
    }

    public String forgotPassword(String username, String userAnswer) {
        User user;
        if ((user = User.getUserByUsername(username)) == null) {
            return "user not found";
        }
        System.out.println(user.getQuestion());
        System.out.println("enter your answer: \n");
        if (!userAnswer.equalsIgnoreCase(user.getAnswer()))
            return "incorrect answer";
        return ("your password is : \n" + user.getPassword());
    }


}
