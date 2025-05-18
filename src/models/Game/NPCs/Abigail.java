package models.Game.NPCs;

import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Abigail extends NPC {

    public Abigail(Building home, GameMap currentMap) {
        super("Abigail", "Miner", home, currentMap);
    }

    @Override
    protected void initializeDialogues() {
        // Daytime dialogues
        dialogue.put("what's your name?", "Abigail");
        dialogue.put("hello", "Hey there! Just got back from the mines.");
        dialogue.put("i'm fine how are you", "Energetic! Found some amazing crystals today.");
        dialogue.put("where is this?", "Welcome to the mining district!");
        dialogue.put("goodbye", "Stay safe, and watch out for the hot sun!");
        dialogue.put("how is the weather?", "Perfect for mining - not too hot underground!");
        dialogue.put("what is your job?", "I'm a professional miner, specializing in rare gems.");

        // Evening dialogues
        dialogue2.put("what's your name?", "Abigail");
        dialogue2.put("hello", "Evening! Processing today's findings.");
        dialogue2.put("i'm fine how are you", "A bit tired from mining, but it was worth it!");
        dialogue2.put("where is this?", "This is my workshop, where I sort the day's minerals.");
        dialogue2.put("goodbye", "Bundle up, it's getting cold!");
        dialogue2.put("how is the weather?", "The temperature's dropping pretty quickly.");
        dialogue2.put("what is your job?", "I explore the mines for precious stones and minerals.");
    }

    @Override
    protected void initializeFavorites() {
        favorites.add(ItemFinder.STONE.getItem());
        favorites.add(ItemFinder.IRON.getItem());
        favorites.add(ItemFinder.COFFEE.getItem());
    }

    @Override
    protected void initializeQuests() {
        quests.add(new Quest("Need a Gold Bar for special tools", 0, false, "GOLD_BAR", 1));
        quests.add(new Quest("Looking for fresh Pumpkin for energy", 1, false, "PUMPKIN", 1));
        quests.add(new Quest("Bulk order: 50 Wheat for miners", 2, false, "WHEAT", 50));
    }

    @Override
    public void giveReward(Player player, int index) {
        switch(index) {
            case 0:
                // Significant friendship boost and special item
                player.increaseFriendship(this, 200);
                player.getInventory().addItem(ItemFinder.PRISMATIC_SHARD.getItem());
                break;
            case 1:
                // Money reward
                player.setMoney(player.getMoney() + 500);
                break;
            case 2:
                // Special tool or equipment
                Item sprinkler = ItemFinder.IRIDIUM_SPRINKLER.getItem();
                player.getInventory().addItem(sprinkler);
                break;
        }
    }
}