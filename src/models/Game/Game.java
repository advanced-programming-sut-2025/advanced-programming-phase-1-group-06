package models.Game;

import models.Crafting.ArtisanDevice;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Growable;
import models.Player.Player;
import models.enums.WeatherType;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Weather weather;
    private Weather weather2;
    private ArrayList<GameMap> gameMaps;
    private ArrayList<Growable> growables;
    private ArrayList<ArtisanDevice> artisanDevices;
    private DateTime dateTime;
    private Player currentPlayer;
    private int currentTurn;

    public Game(ArrayList<Player> players){
        this.players = players;
        weather = WeatherType.SUNNY.getWeather();
        gameMaps = new ArrayList<>();
        growables = new ArrayList<>();
        dateTime = new DateTime();
        weather2 = Weather.weatherRandomizer();
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

    public void setWeatherForTomorrow(Weather weather){
        this.weather2 = weather;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void nextTurn() {
        currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public String showMap() {
        return "";
    }


    public void adavanceDay(){
        long currentDay = dateTime.getPreciseDay();
        for (Growable growable : growables){
            growable.grow(currentDay);
        }
        for (ArtisanDevice artisanDevice : artisanDevices){
            if (artisanDevice.getStatus()){
                artisanDevice.handleTime();
            }
        }
    }

    public void advanceHour(){
        for (ArtisanDevice artisanDevice : artisanDevices){
            if (artisanDevice.getStatus()){
                artisanDevice.handleTime();
            }
        }
    }

    public void generateForaging() {
    }

    public void changeWeather(){}

    public void removeGrowable(Growable growable) {
        growables.remove(growable);
    }
}

