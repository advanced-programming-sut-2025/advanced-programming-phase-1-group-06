package models;

import models.growables.Growable;

public class Game {
    private Player[] players;
    private Weather weather;
    private Tile[] map;
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
}

