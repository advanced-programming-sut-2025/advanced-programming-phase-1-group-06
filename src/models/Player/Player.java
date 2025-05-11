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
    private GameMap currentMap;
    private int x, y;
    private int money;
    private Inventory inventory;
    private Skill skills;
    private double energy;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }

    public Tool getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public boolean isTrashcan() {
        return trashcan;
    }

    public void setTrashcan(boolean trashcan) {
        this.trashcan = trashcan;
    }

    private double maxEnergy;
    private boolean isPassedOut;
    private Tool currentTool;
    private ArrayList<Recipe> cookableFoods;
    private ArrayList<Recipe> craftableItems;
    private boolean trashcan;

    public Player(User user, GameMap currentMap, int x, int y, int money, Inventory inventory, Skill skills, double energy, double maxEnergy, boolean isPassedOut, Tool currentTool, ArrayList<Recipe> cookableFoods, ArrayList<Recipe> craftableItems, boolean trashcan) {
        this.user = user;
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

    public Player(User user){
        this.user = user;
        inventory = new Inventory();
        cookableFoods = new ArrayList<Recipe>();
        craftableItems = new ArrayList<>();
        maxEnergy = 200;
        trashcan = false;
        money = 500;
        isPassedOut = false;
        skills = new Skill();

    }


    public boolean canWalk(Coordinates coordinates) {
        return false;
    }

    public void walk(int x, int y) {
        ArrayList<Coordinates> coordinates = AStar.findPath(currentMap, this.x, this.y, x, y);
        ArrayList<Integer> energyCosts = AStar.calculateEachMoveCost(coordinates); //energy costs should be divided by 200
        // you should do the menus first so we can get confirmation from player that they want to walk
    }

    public String getName(){
        return this.user.getUsername();
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

