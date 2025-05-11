package controllers;

import models.App;
import models.Game.Game;
import models.Interfaces.InventoryItem;
import models.Player.Inventory;
import models.Player.Player;
import models.tools.Tool;

import java.util.regex.Matcher;

public class GameMenuController {
    Game game = App.getGame();
    Player player = game.getCurrentPlayer();

    public void loadGame() {
    }

    public void newGame(String usernames) {
    }

    public void deleteGame() {
    }

    public void saveGame() {
    }

    public String equipTool(Matcher matcher) {
        String name = matcher.group("toolName");
        InventoryItem item = player.getInventory().getItemByName(name);
        if (item == null){
            return "you don't have this tool in your inventory.";
        }
        if (!(item instanceof Tool)){
            return "you can't equip this item as a tool";
        }
        Tool tool = (Tool) item;
        player.setCurrentTool(tool);
        return "tool set to equipped";
    }

}
