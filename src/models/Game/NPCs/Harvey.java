package models.Game.NPCs;

import models.Game.GameMap.GameMap;
import models.Player.Player;
import models.buildings.Building;
import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Harvey extends NPC {

    public Harvey(Building home, GameMap currentMap) {
        super("Harvey", "teacher", home, currentMap);
    }

    @Override
    protected void initializeDialogues() {
        dialogue.put("what's your name?", "Harvey");
        dialogue.put("hello", "hi how are you?what do you do on vacation");
        dialogue.put("i'm fine how are you", "i'm fine,");
        dialogue.put("where is this?", "this is a village in iran.");
        dialogue.put("goodbye", "bye , be careful,the weather is very hot.go home quickly.");
        dialogue.put("how is the weather?", "the weather is very hot!");
        dialogue.put("what is your job?", "I am a teacher");

        dialogue2.put("what's your name?", "Harvey");
        dialogue2.put("hello", "hi how are you?");
        dialogue2.put("i'm fine how are you", "i'm fine");
        dialogue2.put("where is this?", "this is a village in iran.");
        dialogue2.put("goodbye", "bye , take care of yourself.");
        dialogue2.put("how is the weather?", "the weather is very cold!");
        dialogue2.put("what is your job?", "I am a teacher");
    }

    @Override
    protected void initializeFavorites() {
        favorites.add(ItemFinder.valueOf("WINE").getItem());
        favorites.add(ItemFinder.valueOf("PICKLED_POTATO").getItem());  // Using a pickled item from your system
        favorites.add(ItemFinder.COFFEE.getItem());
    }

    @Override
    protected void initializeQuests() {
        quests.add(new Quest("Delivery of 12 pieces of a desired CarrotSeed", 0, false, "CARROT", 12));
        quests.add(new Quest("Delivery of a salmon fish", 1, false, "SALMON", 1));
        quests.add(new Quest("Delivery of a bottle of wine", 2, false, "WINE", 1));
    }

    @Override
    public void giveReward(Player player, int index) {
        switch(index) {
            case 0:
                player.setMoney(player.getMoney() + 750);
                break;
            case 1:
                if (player.getFriendShipsWithNPCs() != null) {
                    int currentLevel = player.getFriendShipsWithNPCs().getOrDefault(this, 0);
                    player.getFriendShipsWithNPCs().put(this, Math.min(799, currentLevel + 200));
                }
                break;
            case 2:
                // Give 5 Salads
                Item salad = ItemFinder.valueOf("SALAD").getItem(5);
                if (salad != null) {
                    player.getInventory().addItem(salad);
                }
                break;
        }
    }
}