package models.Game;

import models.CraftingAndCooking.ArtisanDevice;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Growable;
import models.Player.Player;
import models.enums.WeatherType;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Player> activePlayers;
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
        this.activePlayers = new ArrayList<>(players);
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
        if (activePlayers.isEmpty()){
            dateTime.advanceDay(1);
        }
        currentPlayer = activePlayers.get((activePlayers.indexOf(currentPlayer) + 1) % activePlayers.size());
        if (currentPlayer.isPassedOut()){
            nextTurn();
        }
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
        for (Player player : players){
            player.setEnergy(player.getMaxEnergy());
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

    public void addMap(GameMap gameMap) {
        gameMaps.add(gameMap);
    }

    public GameMap getMap(int mapID) {
        try {
            return gameMaps.get(mapID);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bounds 💔💔💔💔 sybau");
        }
        return null;
    }
    public int getMapID(GameMap gameMap) {
        return gameMaps.indexOf(gameMap);
    }
}

