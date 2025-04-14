package models;

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

    public boolean canWalk(Coordinate coordinate) {
        return false;
    }

    public void walk(Coordinate coordinate) {
    }

    public void upgradeInventory() {
    }

    public void upgradeTrashcan() {
    }

    public void passOut() {
    }

    public void useCurrentTool() {
    }

    public void sell(Item item) {
    }

    public void gift(Player player, Item item) {
    }
}

