package models.Player;

import models.*;
import models.Crafting.ArtisanDevice;
import models.Crafting.CraftingRecipeInfo;
import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Crafting.ArtisanRecipe;
import models.Game.NPCs.*;
import models.ItemFaces.InventoryItem;
import models.tools.Tool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private User user;

    private GameMap currentMap;

    private int x, y;
    private int money;
    private Inventory inventory;
    private ArrayList<Skill> skills;
    private double energy;
    private double maxEnergy;
    private int mapNumber;
    private String currentBuilding;
    private ArrayList<ArtisanDevice> artisanDevices;
    private ArrayList<CraftingRecipeInfo> unlockedCraftingRecipes;



    private HashMap<NPC, Integer> friendshipsWithNPCs;
    private HashMap<NPC, LocalDate> lastGiftDates;
    private HashMap<NPC, LocalDate> lastTalkDates;

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

   // private double maxEnergy;
    private boolean isPassedOut;
    private Tool currentTool;
    private ArrayList<ArtisanRecipe> cookableFoods;
    private ArrayList<ArtisanRecipe> craftableItems;
    private boolean trashcan;

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
        this.mapNumber = mapNumber;
        this.artisanDevices = artisanDevices;
        this.unlockedCraftingRecipes = unlockedCraftingRecipes;
        this.friendshipsWithNPCs = new HashMap<>();
    }

    public Player(User user, int mapNumber){
        this.user = user;
        this.mapNumber = mapNumber;
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
        unlockedCraftingRecipes = new ArrayList<models.Crafting.CraftingRecipeInfo>();
        this.friendshipsWithNPCs = new HashMap<>();
        this.lastGiftDates = new HashMap<>();
        this.lastTalkDates = new HashMap<>();
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
        ArrayList<Coordinates> coordinates = AStar.findPath(currentMap, this.x, this.y, x, y);
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

    public void useTrashcan(){
    }

    public void passOut() {
    }

    public void sell(InventoryItem item) {
    }

    public HashMap<NPC, Integer> getFriendShipsWithNPCs() {
        return friendshipsWithNPCs;
    }

    public int getFriendshipLevel(NPC npc) {
        return friendshipsWithNPCs.getOrDefault(npc, 0);
    }

    public void increaseFriendship(NPC npc, int amount) {
        int currentFriendship = getFriendshipLevel(npc);
        int newFriendship = Math.min(799, currentFriendship + amount);
        friendshipsWithNPCs.put(npc, newFriendship);
    }


    public String getFriendshipStatus(NPC npc) {
        int level = getFriendshipLevel(npc);
        if (level < 50) return "Stranger";
        if (level < 200) return "Acquaintance";
        if (level < 400) return "Friend";
        if (level < 600) return "Good Friend";
        if (level < 799) return "Best Friend";
        return "Best Friends Forever";
    }

    public boolean giveGift(NPC npc, InventoryItem item) {
        LocalDate currentDate = LocalDate.parse(App.getDateTime());

        // Check basic conditions
        if (item == null || !inventory.hasItemAmount(item.getName(), 1)) {
            return false;
        }

        // Check if item is a tool
        if (item instanceof Tool) {
            return false;
        }

        // Check if already gave gift today
        if (lastGiftDates.containsKey(npc) &&
                lastGiftDates.get(npc).equals(currentDate)) {
            return false;
        }

        // Check if within 8 surrounding tiles
        if (!isNextToNPC(npc)) {
            return false;
        }

        // Remove item from inventory
        if (!inventory.removeItem(item.getName(), 1)) {
            return false;
        }

        // Update last gift date
        lastGiftDates.put(npc, currentDate);

        // Calculate friendship points
        int pointsToAdd = 50; // Base points for first gift of the day
        if (npc.getFavorites().contains(item)) {
            pointsToAdd = 200; // Override with favorite item points
        }

        // Update friendship
        increaseFriendship(npc, pointsToAdd);
        return true;
    }
    private boolean isNextToNPC(NPC npc) {
        int dx = Math.abs(this.x - npc.getCoordinates().x());
        int dy = Math.abs(this.y - npc.getCoordinates().y());
        return dx <= 1 && dy <= 1;
    }

public boolean talkToNPC(NPC npc) {
    LocalDate currentDate = LocalDate.parse(App.getDateTime());

    // Check if within 8 surrounding tiles
    if (!isNextToNPC(npc)) {
        return false;
    }

    // Give friendship points if first talk of the day
    if (!lastTalkDates.containsKey(npc) ||
            !lastTalkDates.get(npc).equals(currentDate)) {
        increaseFriendship(npc, 20);
        lastTalkDates.put(npc, currentDate);
        return true;
    }

    return false;
}

    public void initializeNPCFriendships(ArrayList<NPC> npcs) {
        for (NPC npc : npcs) {
            friendshipsWithNPCs.put(npc, 0);
        }
    }

    public void gift(Player player, InventoryItem item) {
        if (item == null || !inventory.hasItemAmount(item.getName(), 1)) {
            return;
        }

        inventory.removeItem(item.getName(), 1);
        player.getInventory().addItem(item);
    }


    public GameMap getGameMap() {
        return currentMap;
    }

    public ArrayList<ArtisanDevice> getArtisanDevices() {
        return artisanDevices;
    }

}

