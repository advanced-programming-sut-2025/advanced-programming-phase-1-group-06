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

    public void useTool(String direction){
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
                System.out.println("invalid direction");
                return;
        }
        Tool tool = player.getCurrentTool();
        if (tool == null){
            System.out.println("you're not holding a tool right now");
            return;
        }
        if (player.getGameMap().getTileAt(player.getX() + x, player.getY() + y).useTool(tool, player)) {
            player.dimnishEnergy(tool.getSuccessfulEnergyCost());
        }
        else {
            player.dimnishEnergy(tool.getUnsuccessfulEnergyCost());
        }
    }

    public void answerQuestion(String answer) {
        // TODO: Implement answering logic
    }

    public void advanceTime(int hours) {
        // TODO: Implement time advancing logic
        game.getDateTime().advanceHour(hours);
        System.out.println("time advanced by " + hours + " hours.");
    }

    public void advanceDate(int days) {
        // TODO: Implement date advancing logic
        game.getDateTime().advanceDay(days);
        System.out.println("game time advanced by" + days + "d ays");
    }

    public void setWeatherType(String type) {
        Weather weather = WeatherType.getWeatherByName(type);
        game.setWeatherForTomorrow(weather);
        System.out.println("game weather set to" + type + ".");
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

    public void showCurrentTool(Player player) {
        System.out.println(player.getCurrentTool().getName());
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
        return "";
    }

        public void terminateGame() {
            // TODO: Terminate the game
        }

        public void plantSeed(String seed, String direction) {
            // TODO: Plant the given seed in the specified direction
        }

        public void showPlantAt(int x, int y) {
            // TODO: Show plant at coordinates (x, y)
        }

        public void showCraftingRecipes() {
            // TODO: Display all available crafting recipes
        }

        public void craftItem(String itemName) {
            // TODO: Craft the specified item
        }

        public void buyAnimal(String animal, String name) {
            // TODO: Buy the specified animal with a given name
        }

        public void petAnimal(String name) {
            // TODO: Pet the specified animal
        }

        public void setFriendshipLevel(String animalName, int amount) {
            // TODO: Set the friendship level of the specified animal (cheat)
        }

        public void showAnimals() {
            // TODO: Display all owned animals
        }

        public void shepherdAnimal(String animalName, int x, int y) {
            // TODO: Move the specified animal to (
        }

        public void feedAnimalHay(String animalName) {
            // TODO: Feed hay to the specified animal
        }

        public void initiateTrade(String username, String type, String item, int amount, Integer price,
                                  String targetItem, Integer targetAmount) {
            // TODO: Initiate a trade with another user
        }

        public void showTradeList() {
            // TODO: Show the list of current trades
        }

        public void respondToTrade(String response, int id) {
            // TODO: Respond to a trade with acceptance or rejection
        }

        public void showTradeHistory() {
            // TODO: Show the player's trade history
        }

        public void listFriendshipNPCs() {
            // TODO: List all NPCs and their friendship levels
        }

        public void listQuests() {
            // TODO: List all available or active quests
        }

        public void finishQuest(int index) {
            // TODO: Mark the quest at the specified index as finished
        }

        public void runTest() {
            // TODO: Run internal test logic
        }

        public void runCheatCode() {
            // TODO: Execute cheat code logic
        }

        public void useArtisan(String artisanName, String itemName) {
            // TODO: Use an artisan machine with the specified item
        }

        public void getArtisanProduct(String artisanName) {
            // TODO: Retrieve the finished product from an artisan machine
        }



            public String nextTurn () {
                turn++;
                if (turn % 3 == 0) {
                    return "everybody had their turns time has passed by an hour";
                }
                return "next player can enter their command now";
            }

        }
