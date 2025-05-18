package models.Game.NPCs;

import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Robin extends NPC {

    public Robin(Building home, GameMap currentMap) {
        super("Robin", "architect", home, currentMap);
    }

    @Override
    protected void initializeDialogues() {
        dialogue.put("what's your name?", "Robin");
        dialogue.put("hello", "hi how are you?what do you do on vacation");
        dialogue.put("i'm fine how are you", "i'm fine,");
        dialogue.put("where is this?", "this is a village in iran.");
        dialogue.put("goodbye", "bye , be careful,the weather is very hot.go home quickly.");
        dialogue.put("how is the weather?", "the weather is very hot!");
        dialogue.put("what is your job?", "I am a architect");

        dialogue2.put("what's your name?", "Robin");
        dialogue2.put("hello", "hi how are you?");
        dialogue2.put("i'm fine how are you", "i'm fine");
        dialogue2.put("where is this?", "this is a village in iran.");
        dialogue2.put("goodbye", "bye , take care of yourself.");
        dialogue2.put("how is the weather?", "the weather is very cold!");
        dialogue2.put("what is your job?", "I am a architect");
    }

    @Override
    protected void initializeFavorites() {
        favorites.add(ItemFinder.IRON_BAR.getItem());
        favorites.add(ItemFinder.WOOD.getItem());
        favorites.add(ItemFinder.valueOf("SPAGHETTI").getItem());
    }

    @Override
    protected void initializeQuests() {
        quests.add(new Quest("Delivery of 80 sticks", 0, false, "WOOD", 80));
        quests.add(new Quest("Delivery of 10 iron ingots", 1, false, "IRON_BAR", 10));
        quests.add(new Quest("Delivery of 1000 sticks", 2, false, "WOOD", 1000));
    }

    @Override
    public void giveReward(Player player, int index) {
        switch(index) {
            case 0:
                player.setMoney(player.getMoney() + 1000);
                break;
            case 1:
                // Give 3 Bee Houses
                for (int i = 0; i < 3; i++) {
                    Item beeHouse = ItemFinder.valueOf("BEE_HOUSE").getItem();
                    if (beeHouse != null) {
                        player.getInventory().addItem(beeHouse);
                    }
                }
                break;
            case 2:
                player.setMoney(player.getMoney() + 25000);
                break;
        }
    }
}