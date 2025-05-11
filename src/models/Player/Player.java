package models.Player;

import models.*;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Game.Recipe;
import models.ItemFaces.InventoryItem;
import models.tools.Tool;

import java.util.ArrayList;

public class Player {
    private User user;
    private String name;
    private GameMap currentMap;
    private int x, y;
    private int money;
    private Inventory inventory;
    private Skill skills;
    private Double energy;
    private int maxEnergy;
    private boolean isPassedOut;
    private Tool currentTool;
    private Recipe[] cookableFoods;
    private Recipe[] craftableItems;
    private boolean trashcan;

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

