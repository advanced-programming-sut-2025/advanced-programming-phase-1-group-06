package models;

public abstract class Craftable{
    protected Map<Craftable, Integer> requiredItems;
    protected Craftable craftedItem;
    public boolean isCraftable(Player player) {}
    public Craftable craft(){}
}