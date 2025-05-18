package models.Game.NPCs;

import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Sebastian extends NPC {

    public Sebastian(Building home, GameMap currentMap) {
        super("Sebastian", "cook", home, currentMap);
    }

    @Override
    protected void initializeDialogues() {
        dialogue.put("what's your name?", "Sebastian");
        dialogue.put("hello", "hi how are you?what do you do on vacation");
        dialogue.put("i'm fine how are you", "i'm fine,");
        dialogue.put("where is this?", "this is a village in iran.");
        dialogue.put("goodbye", "bye , be careful,the weather is very hot.go home quickly.");
        dialogue.put("how is the weather?", "the weather is very hot!");
        dialogue.put("what is your job?", "I am a cook");

        dialogue2.putAll(dialogue);
        dialogue2.put("how is the weather?", "the weather is very cold!");
    }

    @Override
    protected void initializeFavorites() {
        favorites.add(ItemFinder.WOOL.getItem());
        favorites.add(ItemFinder.valueOf("PUMPKIN").getItem());
        favorites.add(ItemFinder.valueOf("PIZZA").getItem());
    }

    @Override
    protected void initializeQuests() {
        quests.add(new Quest("Delivery of 50 units of iron", 0, false, "IRON", 50));
        quests.add(new Quest("Delivery of pumpkin pie", 1, false, "PUMPKIN_PIE", 1));
        quests.add(new Quest("Delivery of 150 units of stone", 2, false, "STONE", 150));
    }

    @Override
    public void giveReward(Player player, int index) {
        switch(index) {
            case 0:
                // Give 2 diamonds
                for (int i = 0; i < 2; i++) {
                    player.getInventory().addItem(ItemFinder.DIAMOND.getItem());
                }
                break;
            case 1:
                player.setMoney(player.getMoney() + 5000);
                break;
            case 2:
                // Give 50 Quartz
                Item quartz = ItemFinder.QUARTZ.getItem(50);
                player.getInventory().addItem(quartz);
                break;
        }
    }
}