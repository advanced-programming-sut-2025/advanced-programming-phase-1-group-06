package models.Crafting;

import models.ItemFaces.Item;
import models.ItemFaces.ItemFinder;
import models.Player.Player;

import java.util.Map;

public class CraftingRecipe {
    private final CraftingRecipeInfo info;
    private final Item result;

    public CraftingRecipe(CraftingRecipeInfo info) {
        this.info = info;
        this.result = info.createResult();
    }

    public boolean canCraft(Player player) {
        // Check if player has required skill level
        if (!player.hasSkillLevel(info.getSkillRequired(), info.getLevelRequired())) {
            return false;
        }

        // Check if player has required ingredients
        for (Map.Entry<ItemFinder, Integer> ingredient : info.getIngredients().entrySet()) {
            if (!player.hasItem(ingredient.getKey(), ingredient.getValue())) {
                return false;
            }
        }

        return true;
    }

    public Item craft(Player player) {
        if (!canCraft(player)) {
            return null;
        }

        // Remove ingredients from player's inventory
        for (Map.Entry<ItemFinder, Integer> ingredient : info.getIngredients().entrySet()) {
//         TODO   player.getInventory().removeItem(ingredient.getKey(), ingredient.getValue());
        }

        // Give the crafted item to the player
        return result;
    }

    public String getName() { return info.getName(); }
    public String getDescription() { return info.getDescription(); }
    public Map<ItemFinder, Integer> getIngredients() { return info.getIngredients(); }
    public int getSellPrice() { return info.getSellPrice(); }
}