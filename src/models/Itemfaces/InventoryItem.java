package models.Itemfaces;

public abstract class InventoryItem {
    String name;
    int amount;
    int price;
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public String getName(){
        return name;
    }
}
