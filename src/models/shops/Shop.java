package models.shops;

import models.Game.Coordinates;
import models.Game.NPC;
import models.ItemFaces.ItemFinder;
import models.Player.Player;
import models.buildings.Building;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Shop extends Building {
    protected NPC owner;
    protected int openingHour;
    protected int closingHour;
    protected HashMap<String, Integer> itemNameToPrice;
    protected HashMap<String, Integer> itemNameToQuantity;

    public Shop() {

    }

    public void openShop() {
    }

    public void closeShop() {
    }

    public void enterShop(Player player) {
    }

    public void checkCommand(String command, Player player) {
        Matcher matcher;
        if ((matcher = Command.PURCHASE.getMatcher(command)) != null) {
            int quantity = (matcher.group("count") != null) ? Integer.parseInt(matcher.group("count")) : 1;
            purchaseItem(matcher.group("name"), quantity, player);
        }
        else {
            System.out.println("invalid command");
        }
    }

    enum Command {
        PURCHASE("purchase\\s+<?name\\S+>(\\s+-n\\s+<?count\\d+>)?"),
        UPGRADE_TOOL("upgrade\\s+(?<name>\\S+)"),
        ;
        private final String pattern;
        Command(String pattern) {
            this.pattern = pattern;
        }
        public Matcher getMatcher(String input) {
            Matcher matcher = Pattern.compile(pattern).matcher(input);
            if (matcher.matches()) return matcher;
            return null;
        }
    }

    public void purchaseItem(String itemName, int quantity, Player player) {
        try {
            if (itemNameToPrice.containsKey(itemName)) {
                int price = itemNameToPrice.get(itemName) * quantity;
                int remainingQuantity = itemNameToQuantity.get(itemName);
                if (remainingQuantity < quantity) {
                    System.out.println("Not enough of this item in the shop");
                    return;
                }
                if (price > player.getMoney()) {
                    System.out.println("insufficient balance");
                    return;
                }
                if (player.getInventory().addItem(
                        ItemFinder.valueOf(itemName.toUpperCase().replace(" ", "_")).getItem())) {
                    player.setMoney(player.getMoney() - quantity);
                    itemNameToQuantity.replace(itemName, itemNameToQuantity.get(itemName) - quantity);
                    System.out.println("item added successfully");
                } else {
                    System.out.println("inventory is full. couldn't add item");
                }

            } else {
                System.out.println("Item " + itemName + " not in shop");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(itemName + " not found");
        }
    }
}
