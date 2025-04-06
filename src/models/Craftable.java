package models;

import java.util.Map;

public abstract class Craftable extends Placeable {
    protected Map<Craftable, Integer> requiredItems;
    protected Craftable craftedItem;
    protected Recipe recipe;

    public boolean canCraft(Player player) {
    }
    public Craftable craft(){
    }
}