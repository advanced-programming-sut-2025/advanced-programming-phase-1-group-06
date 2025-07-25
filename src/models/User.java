package models;

import controllers.RegisterMenuController;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private int gender; // male -> 1 female -> 2 others -> 3 or any number you want we're all open-minded here.
    private int points;
    private int questionNumber;
    private String answer;

    private static final String [] questions =
    {
            ("1. what was the name of your first pet?"),
            ("2. what's the name of the first school you went to?"),
            ("3. what's the name of your favorite movie/show?"),
            ("4. what's the name your favorite signer/band?"),
            ("5. what's the name of your favorite animal?"),
//        add some more questions;
    };
    private static final char [] specialChars = {'?', '<', '>', ',', '"', '\'', ':', ';', '/', '\\', '|', '[', ']', '{', '}', '+', '=', ')', '(', '*', '@', '&', '^', '%', '$', '#', '!'};
    public User(String username, String password, String email, String nickname, int gender, int questionNumber, String answer){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
        this.questionNumber = questionNumber;
        this.answer = answer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getAnswer() {
        return answer;
    }

    public static String[] getQuestions(){
        return questions;
    }

    public String getQuestion(){
        return questions[questionNumber - 1];
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int highScore() {
        return 0;
    }

    public int getGameCount() {
        return 0;
    }
}
