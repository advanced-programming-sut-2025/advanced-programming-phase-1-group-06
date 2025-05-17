package controllers;

import models.App;
import models.CraftingAndCooking.*;
import models.Game.Coordinates;
import models.Game.Game;
import models.Game.Weather;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.ItemFaces.ItemFinder;
import models.Player.Inventory;
import models.Player.Player;
import models.enums.WeatherType;
import models.tools.Tool;

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
        if (item == null) {
            return "you don't have this tool in your inventory.";
        }
        if (!(item instanceof Tool tool)) {
            return "you can't equip this item as a tool";
        }
        player.setCurrentTool(tool);
        return "tool set to equipped";
    }

    public void useTool(String direction) {
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
        if (tool == null) {
            System.out.println("you're not holding a tool right now");
            return;
        }
        if (App.getGame().getBigMap().getTileAt(player.getX() + x, player.getY() + y).useTool(tool, player)) {
            player.diminishEnergy(tool.getSuccessfulEnergyCost());
        } else {
            player.diminishEnergy(tool.getUnsuccessfulEnergyCost());
        }
    }

    public void advanceTime(int hours) {
        game.getDateTime().advanceHour(hours);
        System.out.println("time advanced by " + hours + " hours.");
    }

    public void advanceDate(int days) {
        game.getDateTime().advanceDay(days);
        System.out.println("game time advanced by " + days + " days");
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
         App.getCurrentPlayer().canWalk(x, y);

    }

    public void printMapAt(int x, int y, int size) {
        App.getGame().getBigMap().print(new Coordinates(x, y), size);
    }

    public void showMapHelp() {
        // TODO: Show map reading help/instructions
    }

    public String showAvailableTools(Player player) {
        return player.getInventory().showTools();
    }

    public void inventoryTrash(Player player, String itemName, int count) {
        if (count == 0) {
            player.removeItem(itemName);
        }
        player.removeItem(itemName, count);
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


    public void buildArtisanDevice(Player player, String name) {
        CraftingRecipe recipe = CraftingRecipeInfo.getCraftingRecipeByName(name);
        if (recipe == null) {
            System.out.println("invalid recipe");
            return;
        }
        if (!recipe.isArtisan()) {
            System.out.println("this is not an artisan device.");
        } else if (recipe.craft(player) != null)
            System.out.println("item crafted successfully");
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

    public void showCraftingRecipes(Player player) {
        System.out.println(player.showCraftingRecipes());
    }

    public void craftItem(String name) {
        CraftingRecipe recipe = CraftingRecipeInfo.getCraftingRecipeByName(name);
        if (recipe == null) {
            System.out.println("invalid recipe");
            return;
        }
        if (recipe.isArtisan()) {
            System.out.println("this is an artisan device.");
        } else if (recipe.craft(player) != null)
            System.out.println("item crafted successfully");

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

    public void useArtisan(Player player, String artisanName, String itemName) {
        ArtisanRecipe recipe = ArtisanRecipeInfo.getArtisanRecipeByName(itemName);
        if (recipe == null) {
            System.out.println("recipe not found");
            return;
        }
        ArtisanDevice artisanDevice = ArtisanDeviceTypes.getArtisanDeviceByName(artisanName);
        if (!player.hasArtisanDevcie(artisanName)) {
            System.out.println("player hasn't unlocked this artisan device yet.");
            return;
        }
        if (artisanDevice == null) {
            System.out.println("artisan device not found");
        }
        artisanDevice.craft(recipe, player);
    }

    public void getArtisanProduct(String artisanName) {
        player.getArtisanProduct(artisanName);
    }

    public void nextTurn() {
        turn++;
        game.nextTurn();
        if (turn % 3 == 0) {
            game.getDateTime().advanceHour(1);
            System.out.println("everybody had their turns time has passed by an hour");
        }
        System.out.println("next player can enter their command now");
    }

    public void giveItemCheat(Player player, String name, int amount) {
        InventoryItem item = null;
        System.out.println(name);
        item = ItemFinder.getItemByName(name);
        if (item == null){
            System.out.println("item not found");
        }
        item.setAmount(amount);
//        try {
//            item = ItemFinder.valueOf(name.toUpperCase().replaceAll("[-\\s]+", "_")).getItem(amount);
//        } catch (IllegalArgumentException e) {
//            System.out.println("item doesn't exist");
//        } catch (ExceptionInInitializerError e) {
//            System.out.println(name.toUpperCase().replaceAll("[-\\s]+", "_"));
//        }
//        if (item == null) {
//            System.out.println("item not found");
//            return;
//        }
        player.getInventory().addItem(item);
    }


}
