package models.Game.NPCs;

import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Lia extends NPC {

    public Lia(Building home, GameMap currentMap) {
        super("Lia", "waiter", home, currentMap);
    }

    @Override
    protected void initializeDialogues() {
        dialogue.put("what's your name?", "Lia");
        dialogue.put("hello", "hi how are you?");
        dialogue.put("i'm fine how are you", "i'm fine");
        dialogue.put("where is this?", "this is a village in iran.");
        dialogue.put("goodbye", "bye , take care of yourself.");
        dialogue.put("how is the weather?", "excellent!");
        dialogue.put("what is your job?", "I am a waiter");

        // Copy same dialogues to dialogue2
        dialogue2.putAll(dialogue);
    }

    @Override
    protected void initializeFavorites() {
        favorites.add(ItemFinder.GRAPE.getItem());
        favorites.add(ItemFinder.valueOf("SALAD").getItem());
        favorites.add(ItemFinder.valueOf("WINE").getItem());
    }

    @Override
    protected void initializeQuests() {
        quests.add(new Quest("Delivery of 10 woods", 0, false, "WOOD", 10));
        quests.add(new Quest("Delivery of a salmon fish", 1, false, "SALMON", 1));
        quests.add(new Quest("Delivery of 200 woods", 2, false, "WOOD", 200));
    }

    @Override
    public void giveReward(Player player, int index) {
        switch(index) {
            case 0:
                player.setMoney(player.getMoney() + 500);
                break;
            case 1:
                // Give Salmon Dinner
                Item salmonDinner = ItemFinder.valueOf("SALMON").getItem();
                if (salmonDinner != null) {
                    player.getInventory().addItem(salmonDinner);
                }
                break;
            case 2:
                // Give 3 Deluxe Scarecrows
                for (int i = 0; i < 3; i++) {
                    Item scarecrow = ItemFinder.valueOf("DELUXE_SCARECROW").getItem();
                    if (scarecrow != null) {
                        player.getInventory().addItem(scarecrow);
                    }
                }
                break;
        }
    }
}