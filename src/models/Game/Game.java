package models.Game;

import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Growable;
import models.Player.Player;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Weather weather;
    private GameMap[] gameMaps;
    private Growable[] growables;
    private DateTime dateTime;

    Game(ArrayList<Player> players){
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    private Player currentPlayer;

    private int currentTurn;

    public void goNextTurn() {
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String showMap() {
        return "";
    }

    public void advanceDay() {
    }

    public void generateForaging() {
    }

    public void changeWeather(){

    }
}

