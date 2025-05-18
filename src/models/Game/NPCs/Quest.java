package models.Game.NPCs;

import models.ItemFaces.ItemFinder;
import models.ItemFaces.Item;

public class Quest {
    private final String questExplanation;
    private final int level;
    private boolean completed;
    private final String itemName;
    private final int amount;
    private boolean isActive;

    public Quest(String questExplanation, int level, boolean completed, String itemName, int amount) {
        this.questExplanation = questExplanation;
        this.level = level;
        this.completed = completed;
        this.itemName = itemName;
        this.amount = amount;
        this.isActive = level != 2;
    }

    public Item getRequiredItem() {
        try {
            ItemFinder itemFinder = ItemFinder.valueOf(itemName);
            return itemFinder.getItem(amount);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Getters and setters
    public int getLevel() { return level; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public String getQuestExplanation() { return questExplanation; }
    public int getAmount() { return amount; }
    public String getItemName() { return itemName; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}