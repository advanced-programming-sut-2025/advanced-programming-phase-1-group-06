package models.ItemFaces;

public abstract class InventoryItem {
    String name;
    int amount;
    int id;
    int baseId;

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
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
