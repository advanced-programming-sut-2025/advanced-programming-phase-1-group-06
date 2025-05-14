package controllers;

import models.App;
import models.Game.Game;
import models.Game.Weather;
import models.ItemFaces.InventoryItem;
import models.Player.Player;
import models.enums.WeatherType;
import models.tools.Tool;

import java.util.regex.Matcher;

public class GameMenuController {
    Game game = App.getGame();
    Player player = game.getCurrentPlayer();
    private static int turn = 0;

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
        if (!(item instanceof Tool tool)){
            return "you can't equip this item as a tool";
        }
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
                return "invalid direction";
        }
        Tool tool = player.getCurrentTool();
        if (tool == null){
            return "you're not holding a tool right now";
        }

//            TODO
//        return (player.getCurrentTool().use(new Coordinates(player.getX() + x, player.getY() + y)));
        return null;
    }

    public String buildArtisanDevice(Matcher matcher){
        
    }

    public String nextTurn(){
        turn ++;
        if (turn % 3 == 0){

            return "everybody had their turns time has passed by an hour";
        }
        return "next player can enter their command now";
    }

}
