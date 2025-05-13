package models.ItemFaces;

public abstract class InventoryItem {
    String name;
    int amount;

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
