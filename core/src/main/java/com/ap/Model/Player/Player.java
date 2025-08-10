package com.ap.Model.Player;


import com.ap.Controller.GameController;
import com.ap.Model.Item.Item;
import com.ap.Model.Recipe;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Player {
    private static final float PLAYER_WIDTH = 8f;
    private static final float PLAYER_HEIGHT = 8f; //fix these later
    private double maxEnergy = 200.0;
    public Vector2 position = new Vector2(100, 100);
    private int x, y;
    private int money;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private double energy;
    private int mapID;
    private String currentBuilding;
    private boolean isPassedOut;
    private Item currentItem;
    private ArrayList<Recipe> cookableFoods;
    private ArrayList<Recipe> craftableItems;
    private ArrayList<Item> artisanDevices;
    private boolean trashcan;

    public Player(){
        money = 200;
        inventory = new Inventory();
        skills = new ArrayList<>();
        for (Skill.SkillType skillType : Skill.SkillType.values()){
            skills.add(skillType.getSkill());
        }
        increaseSkill("fishing");
        increaseSkill("foraging");
        increaseSkill("foraging");
        increaseSkill("foraging");
        increaseSkill("mining");
        increaseSkill("farming");
        increaseSkill("farming");
        increaseSkill("farming");
        cookableFoods = new ArrayList<>();
        artisanDevices = new ArrayList<>();
        craftableItems = new ArrayList<>();
    }

    public void setCurrentItem(Item item){
        currentItem = item;
    }

    public Item getHeldItem() {
        return currentItem;
    }

    public float getSpeed() {
        return 80f;
    }

    public Vector2 getTruePosition() {
        return new Vector2(PLAYER_WIDTH, PLAYER_HEIGHT).add(position);
    }
    private User user;



    public int getMoney() {
        return money;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void diminishEnergy(double energy) {
        this.energy -= energy * GameController.getInstance().getEnergyConsumptionRate();
        if (this.energy <= 0) {
            passOut();
        }
    }

    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }


    public boolean isTrashcan() {
        return trashcan;
    }

    public void setTrashcan(boolean trashcan) {
        this.trashcan = trashcan;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }


    public Skill getSkillByName(String skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)) {
                return skill;
            }
        }
        return null;
    }

    public int getSkillLevel(String skillName) {
        Skill skill = getSkillByName(skillName);
        if (skill != null) {
            return skill.getLevel();
        }
        return 0;
    }

    public void increaseSkill(String skillName) {
        Skill skill = getSkillByName(skillName);
        if (skill != null) {
            skill.increaseXP();
        }
    }


    public boolean removeItem(String name, int amount) {
        if (!inventory.hasItemAmount(name, amount))
            return false;
        inventory.removeItem(name, amount);
        return true;
    }

    public boolean removeItem(String name) {
        if (!inventory.hasItem(name))
            return false;
        inventory.removeItem(name);
        return true;
    }


//    public boolean canWalk(int x, int y) {
//        GameMap gameMap = App.getGame().getBigMap();
//
//        // 1. Check if target coordinates are valid
//        if (x < 0 || x >= gameMap.getLength() || y < 0 || y >= gameMap.getWidth()) {
//            System.out.println("Target coordinates are out of bounds");
//            return false;
//        }
//
//        // 2. Check if player's current position is valid
//        if (this.x < 0 || this.x >= gameMap.getLength() || this.y < 0 || this.y >= gameMap.getWidth()) {
//            System.out.println("Current position is invalid");
//            return false;
//        }
//
//        // 3. Check farm boundaries (existing code)
//        int i = App.getGame().getPlayers().indexOf(this);
////        if ((i == 2 && (x >= 46 ^ y >= 46) || (i == 0 && (x < 44)) || (i == 1 && y < 44))) {
////            System.out.println("cant walk into other farms");
////            return false;
////        }
//
//        // 4. Check if target tile is blocked
//        if (gameMap.isBlocked(x, y)) {
//            System.out.println("Target location is blocked");
//            return false;
//        }
//
//        // 5. Try to find path
//        ArrayList<Coordinates> coordinates = AStar.findPath(gameMap, this.x, this.y, x, y);
//
//        if (coordinates.isEmpty()) {
//            System.out.println("No valid path found to target location");
//            return false;
//        }
//
//        // Calculate energy costs and continue with existing logic
//        ArrayList<Double> energyCosts = AStar.calculateEachMoveCost(coordinates);
//        double sum = energyCosts.stream().mapToDouble(energyCost -> energyCost).sum();
//
////        if (sum * App.getGame().getWeather().getEnergyConsumptionRate() > energy) {
////            System.out.println("not enough energy to do that");
////            return false;
////        }
////        System.out.println(coordinates);
//        walk(coordinates, energyCosts);
//        return true;
//    }



//    public void walk(ArrayList<Coordinates> coordinates, ArrayList<Double> energyCosts) {
//        for (int i = 1; i < coordinates.size(); i++){
//             Coordinates coordinate = coordinates.get(i);
//             double energyCost = energyCosts.get(i - 1);
////             System.out.println(energyCosts);
//             this.x = coordinate.x();
//             this.y = coordinate.y();
//             diminishEnergy(energyCost);
////             System.out.println("current x: " + this.x + ", current y: " + this.y);
//        }
//    }

    public String getName(){
        return this.user.getUsername();
    }
    //backpack


    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        maxEnergy = maxEnergy;
    }

    public void upgradeInventory() {
        inventory.setLevel(inventory.getLevel() + 1);
    }

    public void upgradeTrashcan() {
    }

    public boolean isThereAnySpace(Item item){
        if (inventory.getCapacity() - inventory.getItems().size() > 0)
            return true;
        return inventory.hasItemAmount(item.getName(), 1);
    }

    public void useTrashcan(){
    }

    public void passOut() {
        isPassedOut = true;
        GameController.getInstance().deactivatePlayer(this);
    }

    public void sell(Item item) {
        //TODO
    }

    public void gift(Player player, Item item) {
        //TODO
    }


    public ArrayList<Recipe> getCraftableItems() {
        return craftableItems;
    }

    public void addCraftableItem(Recipe recipe){
        if (recipe != null){
            craftableItems.add(recipe);
        }
    }

    public void setCraftableItems(ArrayList<Recipe> craftableItems) {
        this.craftableItems = craftableItems;
    }

    public ArrayList<Recipe> getCookableFoods() {
        return cookableFoods;
    }

    public void addCookableFood(Recipe recipe){
        cookableFoods.add(recipe);
    }

    public void setCookableFoods(ArrayList<Recipe> cookableFoods) {
        this.cookableFoods = cookableFoods;
    }



}
