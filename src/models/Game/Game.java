package models.Game;

import models.CraftingAndCooking.ArtisanDevice;
import models.Game.GameMap.GameMap;
import models.PlantsAndForaging.Growable;
import models.Player.Player;
import models.Tiles.Flooring;
import models.Tiles.Info.BuildingTileInfo;
import models.Tiles.Info.FlooringInfo;
import models.Tiles.OverlayTiles.BuildingTile;
import models.Tiles.Tile;
import models.enums.WeatherType;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Player> activePlayers;
    private Weather weather;
    private Weather weather2;
    private ArrayList<GameMap> gameMaps;
    private GameMap bigMap;
    private ArrayList<Growable> growables;
    private ArrayList<ArtisanDevice> artisanDevices;
    private DateTime dateTime;
    private Player currentPlayer;
    private int currentTurn;

    public Game(ArrayList<Player> players, ArrayList<GameMap>  gameMaps) {
        this.players = players;
        currentPlayer = players.get(1);
        this.activePlayers = new ArrayList<>(players);
        weather = WeatherType.SUNNY.getWeather();
        this.gameMaps = gameMaps;
        bigMap = makeBigMap(gameMaps);
        growables = new ArrayList<>();
        dateTime = new DateTime();
        artisanDevices = new ArrayList<>();
//        weather2 = Weather.weatherRandomizer();
    }

    private GameMap makeBigMap(ArrayList<GameMap> gameMaps) {
        Tile[][] tiles = new Tile[90][90];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int y = 0; y < 44; y++) {
                    for (int x = 0; x < 44; x++) {
                        tiles[y + 46 * i][x + 46 * j] = gameMaps.get(2 * i + j).getTileAt(x, y);
                    }
                }
            }
        }
        for (int i = 0; i < 90; i++) {
            tiles[i][44] = new Flooring(FlooringInfo.GRASS);
            tiles[i][45] = new Flooring(FlooringInfo.GRASS);
            tiles[44][i] = new Flooring(FlooringInfo.GRASS);
            tiles[45][i] = new Flooring(FlooringInfo.GRASS);
        }
        return new GameMap(tiles, 90, 90);
    }
    public GameMap getBigMap() {
        return bigMap;
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

    public void deactivatePlayer(Player player) {
        activePlayers.remove(player);
        System.out.println("player " + player.getName() + " goes for a nap");
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

