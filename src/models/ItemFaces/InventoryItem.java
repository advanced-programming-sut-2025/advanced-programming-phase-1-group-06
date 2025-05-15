package models.ItemFaces;

public abstract class InventoryItem {
    protected String name;
    protected int amount;
    protected int id;
    protected int baseId;

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
        return ItemFinder.getIdByItem(this);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        InventoryItem other = (InventoryItem) obj;
        // Compare only by name, ignoring amount
        return getName().equals(other.getName());
    }
}
