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

    public String useTool(Matcher matcher){
        String direction = matcher.group("direction");
        int x, y;
        switch (direction) {
            case "north":
                y = -1;
                x = 0;
                break;
            case "south":
                y = 1;
                x = 0;
                break;
            case "east":
                y = 0;
                x = 1;
                break;
            case "west":
                y = 0;
                x = -1;
                break;
            case "north-east":
                y = -1;
                x = 1;
                break;
            case "north-west":
                y = -1;
                x = -1;
                break;
            case "south-east":
                y = 1;
                x = 1;
                break;
            case "south-west":
                y = 1;
                x = -1;
                break;
            default:
                return;
                break;
        }
    }

}
