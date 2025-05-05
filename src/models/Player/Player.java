package models.Player;

import models.*;
import models.Game.Coordinate;
import models.Game.Recipe;
import models.Interfaces.InventoryItem;
import models.tools.Tool;

public class Player {
    private User user;
    private String name;
    private int money;
    private Inventory inventory;
    private Skill skills;
    private int energy;
    private int maxEnergy;
    private boolean isPassedOut;
    private Tool currentTool;
    private Recipe[] cookableFoods;
    private Recipe[] craftableItems;
    private boolean trashcan;

    public boolean canWalk(Coordinate coordinate) {
        return false;
    }

    public void walk(Coordinate coordinate) {
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

