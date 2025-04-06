package models;


// we use this to place items on the ground
// placing items in chests and inventory has a different mechanism and doesn't require this class
public abstract class Placeable {

    public void place(int x, int y){}

}
