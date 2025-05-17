package models.shops;

import models.Game.Coordinates;
import models.ItemFaces.InventoryItem;
import models.ItemFaces.ItemFinder;
import models.Player.Player;
import models.tools.Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class Blacksmith extends Shop {

    public Blacksmith(Coordinates balaChap, Coordinates doorCoordinates) {
    }

    public Blacksmith() {

    }

    public void buyItem(InventoryItem item) {
    }



    @Override
    public void checkCommand(String command, Player player) {
        Matcher matcher;
        if ((matcher = Command.PURCHASE.getMatcher(command)) != null) {
            int quantity = (matcher.group("count") != null) ? Integer.parseInt(matcher.group("count")) : 1;
            purchaseItem(matcher.group("name"), quantity, player);
        }
        else if ((matcher = Command.UPGRADE_TOOL.getMatcher(command)) != null) {
            upgradeTool(matcher.group("name"), player);
        }
        else {
            System.out.println("invalid command");
        }
    }

    public void upgradeTool(String toolName, Player player) {
        if (player.getInventory().getItemByName(toolName) instanceof Tool tool) {
            int upgradeCost;
            String ingredientName;
            int ingredientAmount = 5;
            switch (tool.getLevel()) {
                case 0:
                    upgradeCost = 2000;
                    ingredientName = "Copper Bar";
                    break;
                case 1:
                    upgradeCost = 5000;
                    ingredientName = "Iron Bar";
                    break;
                case 2:
                    upgradeCost = 10000;
                    ingredientName = "Gold Bar";
                    break;
                case 3:
                    upgradeCost = 25000;
                    ingredientName = "Iridium Bar";
                    break;
                case 4:
                    System.out.println("your tool is already maxed out");
                    return;
                default:
                    System.out.println("invalid level");
                    return;
            }
            if (!player.getInventory().hasItemAmount(ingredientName, ingredientAmount)){
                System.out.println("not enough ingredients");
                return;
            }
            if (player.getMoney() < upgradeCost) {
                System.out.println("not enough money");
                return;
            }
            player.setMoney(player.getMoney() - upgradeCost);
            player.getInventory().removeItem(tool, 1);
            player.getInventory().removeItem(ingredientName, ingredientAmount);
            tool.setLevel(tool.getLevel() + 1);
            player.getInventory().addItem(tool);
        }

    }
}
