package models.Player;

import models.*;
import models.CraftingAndCooking.*;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.tools.Tool;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void diminishEnergy(double energy) {
        this.energy -= energy * App.getGame().getWeather().getEnergyConsumptionRate();
        if (energy <= 0) {
            passOut();
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
        this.currentBuilding = currentBuilding;
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

    public Player(User user, int playerID) {
        this.user = user;
//        this.mapID = mapID;
        inventory = new Inventory();
        cookableFoods = new ArrayList<ArtisanRecipe>();
        craftableItems = new ArrayList<>();
        maxEnergy = 200;
        trashcan = false;
        money = 500;
        isPassedOut = false;
        skills = new ArrayList<>();
        for (SkillType skillType : SkillType.values()) {
            skills.add(skillType.getSkill());
        }
        currentBuilding = "none";
        artisanDevices = new ArrayList<>();
        unlockedCraftingRecipes = new ArrayList<models.CraftingAndCooking.CraftingRecipeInfo>();

        x = (playerID % 2) * 46 + 37;
        y = (playerID / 2) * 46 + 7;
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

    public boolean canWalk(Coordinates coordinates) {
        return false;
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


    public boolean canWalk(int x, int y) {
        GameMap gameMap = App.getGame().getBigMap();

        // 1. Check if target coordinates are valid
        if (x < 0 || x >= gameMap.getLength() || y < 0 || y >= gameMap.getWidth()) {
            System.out.println("Target coordinates are out of bounds");
            return false;
        }

        // 2. Check if player's current position is valid
        if (this.x < 0 || this.x >= gameMap.getLength() || this.y < 0 || this.y >= gameMap.getWidth()) {
            System.out.println("Current position is invalid");
            return false;
        }

        // 3. Check farm boundaries (existing code)
        int i = App.getGame().getPlayers().indexOf(this);
//        if ((i == 2 && (x >= 46 ^ y >= 46) || (i == 0 && (x < 44)) || (i == 1 && y < 44))) {
//            System.out.println("cant walk into other farms");
//            return false;
//        }

        // 4. Check if target tile is blocked
        if (gameMap.isBlocked(x, y)) {
            System.out.println("Target location is blocked");
            return false;
        }

        // 5. Try to find path
        ArrayList<Coordinates> coordinates = AStar.findPath(gameMap, this.x, this.y, x, y);

        if (coordinates.isEmpty()) {
            System.out.println("No valid path found to target location");
            return false;
        }

        // Calculate energy costs and continue with existing logic
        ArrayList<Double> energyCosts = AStar.calculateEachMoveCost(coordinates);
        double sum = energyCosts.stream().mapToDouble(energyCost -> energyCost).sum();

        if (sum * App.getGame().getWeather().getEnergyConsumptionRate() > maxEnergy) {
            System.out.println("not enough energy to do that");
            return false;
        }
        System.out.println(coordinates);
        walk(coordinates, energyCosts);
        return true;
    }



    public void walk(ArrayList<Coordinates> coordinates, ArrayList<Double> energyCosts) {
        for (int i = 0; i < coordinates.size() && !isPassedOut; i++){
             Coordinates coordinate = coordinates.get(i);
             double energyCost = energyCosts.get(i);
             this.x = coordinate.x();
             this.y = coordinate.y();
             diminishEnergy(energyCost);
             System.out.println("current x: " + this.x + ", current y: " + this.y);
        }
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
        isPassedOut = true;
        App.getGame().deactivatePlayer(this);
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

    public ArrayList<ArtisanRecipe> getCraftableItems() {
        return craftableItems;
    }

    public void setCraftableItems(ArrayList<ArtisanRecipe> craftableItems) {
        this.craftableItems = craftableItems;
    }

    public ArrayList<ArtisanRecipe> getCookableFoods() {
        return cookableFoods;
    }

    public void setCookableFoods(ArrayList<ArtisanRecipe> cookableFoods) {
        this.cookableFoods = cookableFoods;
    }

    public ArrayList<CraftingRecipeInfo> getUnlockedCraftingRecipes() {
        return unlockedCraftingRecipes;
    }

    public void setUnlockedCraftingRecipes(ArrayList<CraftingRecipeInfo> unlockedCraftingRecipes) {
        this.unlockedCraftingRecipes = unlockedCraftingRecipes;
    }

    public String showCraftingRecipes(){
        StringBuilder output = new StringBuilder();
        for (CraftingRecipeInfo recipe : unlockedCraftingRecipes){
            output.append(recipe.createResult().getName()).append("\n");
        }
        return output.toString();
    }

    public boolean hasArtisanDevcie(String name){
        for (ArtisanDevice artisanDevice : artisanDevices){
            if (artisanDevice.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void getArtisanProduct(String name){
        for (ArtisanDevice artisanDevice : artisanDevices){
            if (artisanDevice.getName().equals(name)){
                if (artisanDevice.isReady()){
                    if (inventory.addItem(artisanDevice.getCraftedItem())){
                        System.out.println("item added to inventory");
                        artisanDevice.setReady(false);
                        return;
                    }
                }else {
                    System.out.println("the item isn't ready yet");
                }
            }else {
                System.out.println("you don't have this device");
            }
        }
    }

//    public boolean canWalk(Coordinates mainTile) {
//        return canWalk(mainTile.x(), mainTile.y());
//    }
}

