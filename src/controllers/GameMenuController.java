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

    public String equipTool(String toolName) {
        InventoryItem item = player.getInventory().getItemByName(toolName);
        if (item == null){
            return "you don't have this tool in your inventory.";
        }
        if (!(item instanceof Tool tool)){
            return "you can't equip this item as a tool";
        }
        player.setCurrentTool(tool);
        return "tool set to equipped";
    }

    public String useTool(String direction){
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

    public void answerQuestion(String answer) {
        // TODO: Implement answering logic
    }

    public void advanceTime(int hours) {
        // TODO: Implement time advancing logic
    }

    public void advanceDate(int days) {
        // TODO: Implement date advancing logic
    }

    public void setWeatherType(String type) {
        Weather weather = WeatherType.getWeatherByName(type);
        game.setWeatherForTomorrow(weather);
    }

    public void callThor(int x, int y) {
        // TODO: Implement cheat to call Thor at location
    }

    public void buildGreenhouse() {
        // TODO: Implement normal greenhouse building logic
    }

    public void buildGreenhouseCheat() {
        // TODO: Implement cheat greenhouse building logic
    }

    public void walkTo(int x, int y) {
        // TODO: Implement walk logic
    }

    public void printMapAt(int x, int y, int size) {
        // TODO: Implement logic to print part of map
    }

    public void showMapHelp() {
        // TODO: Show map reading help/instructions
    }

    public void showCurrentTool() {
        // TODO: Show the currently equipped tool
    }

    public void showAvailableTools() {
        // TODO: Show all available tools
    }

    public void upgradeTool(String toolName) {
        // TODO: Upgrade the specified tool
    }

    public void sendGift(String username, String item, int amount) {
        // TODO: Send a gift to another user
    }

    public void showGiftList() {
        // TODO: Show list of all giftable items
    }

    public void rateGift(int giftNumber, int rate) {
        // TODO: Rate a gift
    }

    public void showGiftHistory(String username) {
        // TODO: Show gift history with specific user
    }

    public void hugUser(String username) {
        // TODO: Hug a user
    }

    public void sendFlower(String username) {
        // TODO: Send a flower to a user
    }

    public void showAllProducts() {
        // TODO: Show all products in game
    }

    public void showAvailableProducts() {
        // TODO: Show products currently available for purchase
    }

    public void purchaseProduct(String product, int count) {
        // TODO: Handle product purchase logic
    }


    public String buildArtisanDevice(Matcher matcher){
        // TODO: craft ArtisanDevice
    }

    public String nextTurn(){
        turn ++;
        if (turn % 3 == 0){

            return "everybody had their turns time has passed by an hour";
        }
        return "next player can enter their command now";
    }

}
