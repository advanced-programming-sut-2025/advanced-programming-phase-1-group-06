package models.Game;

import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Growable;
import models.Player.Player;

public class Game {
    private Player[] players;
    private Weather weather;
    private GameMap[] gameMaps;
    private Growable[] growables;
    private DateTime dateTime;
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

