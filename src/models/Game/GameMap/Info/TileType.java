package models.Game.GameMap.Info;

public enum TileType {
    DIRT(false, '.', false, 0),
    HOED_DIRT(false, '+', true, 0),
    GRASS(false, ',', false, 0),
    WATER(true, '~', false, 0),
    PLANT(false, '|', false, 0),
    TREE(true, 'T', false, 0);


    TileType(boolean isBlocked, char symbol, boolean isPlantable, int color) {
        this.isBlocked = isBlocked;
        this.symbol = symbol;
        this.isPlantable = isPlantable;
        this.color = color;
    }
    private boolean isBlocked;
    private char symbol;
    private boolean isPlantable;
    private int color;

}
