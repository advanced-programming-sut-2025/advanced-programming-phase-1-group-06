package models.Player;

import models.*;
import models.CraftingAndCooking.ArtisanDevice;
import models.CraftingAndCooking.CraftingRecipeInfo;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.CraftingAndCooking.ArtisanRecipe;
import models.Game.GameMap.MapReader;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.tools.Tool;

import java.util.ArrayList;

public class Player {
    private User user;

    private GameMap currentMap;

    private int x, y;
    private int money;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private double energy;
    private double maxEnergy;
    private int mapID;
    private String currentBuilding;
    private ArrayList<ArtisanDevice> artisanDevices;
    private ArrayList<CraftingRecipeInfo> unlockedCraftingRecipes;
    private boolean isPassedOut;
    private Tool currentTool;
    private ArrayList<ArtisanRecipe> cookableFoods;
    private ArrayList<ArtisanRecipe> craftableItems;
    private boolean trashcan;


    public int getMoney() {
        return money;
    }

    public GameMap getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(GameMap currentMap) {
        this.currentMap = currentMap;
    }

    public Inventory getInventory() {
        return inventory;
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

    public void dimnishEnergy(double energy){
        this.energy -= energy;
        if (energy <= 0){
            isPassedOut = true;
        }
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

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public Player(User user, GameMap currentMap, int x, int y, int money, Inventory inventory, ArrayList<Skill> skills, double energy, double maxEnergy, boolean isPassedOut, Tool currentTool, ArrayList<ArtisanRecipe> cookableFoods, ArrayList<ArtisanRecipe> craftableItems, boolean trashcan, int mapNumber, String currentBuilding, ArrayList<ArtisanDevice> artisanDevices, ArrayList<CraftingRecipeInfo> unlockedCraftingRecipes) {
        this.currentBuilding =currentBuilding;
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
        this.mapID = mapNumber;
        this.artisanDevices = artisanDevices;
        this.unlockedCraftingRecipes = unlockedCraftingRecipes;
    }

    public Player(User user, int mapID){
        this.user = user;
        this.mapID = mapID;
        currentMap = App.getGame().getMap(mapID);
        inventory = new Inventory();
        cookableFoods = new ArrayList<ArtisanRecipe>();
        craftableItems = new ArrayList<>();
        maxEnergy = 200;
        trashcan = false;
        money = 500;
        isPassedOut = false;
        skills = new ArrayList<>();
        for (SkillType skillType : SkillType.values()){
            skills.add(skillType.getSkill());
        }
        currentBuilding = "none";
        artisanDevices = new ArrayList<>();
        unlockedCraftingRecipes = new ArrayList<models.CraftingAndCooking.CraftingRecipeInfo>();
    }

    public Skill getSkillByName(String skillName){
        for (Skill skill : skills){
            if (skill.getName().equals(skillName)){
                return skill;
            }
        }
        return null;
    }

    public int getSkillLevel(String skillName){
        Skill skill = getSkillByName(skillName);
        if (skill != null){
            return skill.getLevel();
        }
        return 0;
    }

    public void increaseSkill(String skillName){
        Skill skill = getSkillByName(skillName);
        if (skill != null){
            skill.increaseXP();
        }
    }

    public boolean canWalk(Coordinates coordinates) {
        return false;
    }

    public void walk(int x, int y) {
        int i = App.getGame().getPlayers().indexOf(this);
        if ((i == 0 && (x >= 46 ^ y >= 46) || (i == 1 && (x < 44)) || (i == 2 && y < 44))){
            System.out.println("cant walk into other farms");
            return;
        }
        ArrayList<Coordinates> coordinates = AStar.findPath(App.getGame().getBigMap(), this.x, this.y, x, y);
        ArrayList<Integer> energyCosts = AStar.calculateEachMoveCost(coordinates); //energy costs should be divided by 200
        // you should do the menus first so we can get confirmation from player that they want to walk
    }

    public String getName(){
        return this.user.getUsername();
    }
    //backpack


    public double getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void upgradeInventory() {
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
    }

    public void sell(InventoryItem item) {
    }

    public void gift(Player player, InventoryItem item) {
    }

    public GameMap getGameMap() {
        return currentMap;
    }

    public ArrayList<ArtisanDevice> getArtisanDevices() {
        return artisanDevices;
    }

}

