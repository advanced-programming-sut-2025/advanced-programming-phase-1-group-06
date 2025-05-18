package models.Game.NPCs;

import models.Game.Coordinates;
import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.Item;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.ItemFinder;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class NPC {
    protected Coordinates coordinates;
    protected String name;
    protected String job;
    protected ArrayList<Quest> quests = new ArrayList<>();
    protected ArrayList<InventoryItem> favorites;
    protected HashMap<String, String> dialogue = new HashMap<>();
    protected HashMap<String, String> dialogue2 = new HashMap<>();
    protected Building home;
    protected GameMap currentMap;


    public NPC(String name, String job, Building home, GameMap currentMap) {
        this.name = name;
        this.job = job;
        this.home = home;
        this.currentMap = currentMap;
        this.coordinates = new Coordinates(0, 0);
        this.favorites = new ArrayList<>();
        initializeDialogues();
        initializeFavorites();
        initializeQuests();
    }

    protected abstract void initializeDialogues();
    protected abstract void initializeFavorites();
    protected abstract void initializeQuests();
    public abstract void giveReward(Player player, int questIndex);
    public boolean isFavoriteItem(InventoryItem item) {
        if (item == null) return false;
        return favorites.stream()
                .anyMatch(favorite -> favorite.getName().equals(item.getName()));
    }
    // Getters and setters
    public Coordinates getCoordinates() { return coordinates; }
    public void setCoordinates(Coordinates coordinates) { this.coordinates = coordinates; }
    public String getName() { return name; }
    public String getJob() { return job; }
    public ArrayList<InventoryItem> getFavorites() { return favorites; }
    public HashMap<String, String> getDialogue() { return dialogue; }
    public HashMap<String, String> getDialogue2() { return dialogue2; }
    public ArrayList<Quest> getQuests() { return quests; }
}