package models.CraftingAndCooking;

import models.ItemFaces.InventoryItem;
import models.ItemFaces.Item;
import models.Player.Player;

import java.util.ArrayList;

public class CookingRecipe {
    private CookingRecipeInfo info;
    private Item result;


    public CookingRecipe(CookingRecipeInfo info){
        this.info = info;
        this.result = info.createResult();
    }

    public boolean canCraft(Player player) {
        // Check if player has required ingredients
        for (InventoryItem item : info.getIngredients()){
            InventoryItem inventoryItem = player.getInventory().getItemByName(item.getName());
            if (inventoryItem == null){
                return false;
            }
            if (!player.getInventory().hasItemAmount(item.getName(), item.getAmount())){
                return false;
            }
        }
        return true;
    }

    public Item craft(Player player) {
        if (!canCraft(player)) {
            return null;
        }

        //Remove ingredients from player's inventory
        for (InventoryItem item : info.getIngredients()){
            player.getInventory().removeItem(item.getName(), item.getAmount());
        }

        // Give the crafted item to the player
        player.getInventory().addItem(result);

        return result;
    }

    public String getName() { return info.getName(); }
    public String getDescription() { return info.getDescription(); }
    public ArrayList<InventoryItem> getIngredients() { return info.getIngredients(); }
    public int getSellPrice() { return info.getPrice(); }
}
