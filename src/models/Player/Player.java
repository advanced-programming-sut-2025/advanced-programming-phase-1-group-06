package models.Player;

import models.*;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Game.Recipe;
import models.Interfaces.InventoryItem;
import models.tools.Tool;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private User user;

    private String name;
    private int gameMap;
    private GameMap currentMap;
    private int x, y;
    private int money;
    private Inventory inventory;
    private Skill skills;
    private Double energy;
    private int maxEnergy;
    private boolean isPassedOut;
    private Tool currentTool;
    private ArrayList<Recipe> cookableFoods;
    private ArrayList<Recipe> craftableItems;
    private boolean trashcan;

    public Player(User user, int gameMap){
        this.user = user;
        this.gameMap = gameMap;
        money = 500;
        Inventory inventory = new Inventory();
        skills = new Skill();

    }

    public Player(User user, String name, GameMap currentMap, int x, int y, int money, Inventory inventory, Skill skills, Double energy, int maxEnergy, boolean isPassedOut, Tool currentTool, ArrayList<Recipe> cookableFoods, ArrayList<Recipe> craftableItems, boolean trashcan, int gameMap) {
        this.gameMap = gameMap;
        this.user = user;
        this.name = name;
        this.currentMap = currentMap;
        this.x = x;
        this.y = y;
        this.money = money;
        this.inventory = inventory;
        this.skills = skills;
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.isPassedOut = isPassedOut;
        this.currentTool = currentTool;
        this.cookableFoods = cookableFoods;
        this.craftableItems = craftableItems;
        this.trashcan = trashcan;
    }


    public boolean canWalk(Coordinates coordinates) {
        return false;
    }

    public void walk(int x, int y) {
        ArrayList<Coordinates> coordinates = AStar.findPath(currentMap, this.x, this.y, x, y);
        ArrayList<Integer> energyCosts = AStar.calculateEachMoveCost(coordinates); //energy costs should be divided by 200
        // you should do the menus first so we can get confirmation from player that they want to walk
    }

    //backpack

    public void upgradeInventory() {
    }

    public void upgradeTrashcan() {
    }

    public void useTrashcan(){
    }

    public void passOut() {
    }

    public void useCurrentTool() {
    }

    public void sell(InventoryItem item) {
    }

    public void gift(Player player, InventoryItem item) {
    }

}

