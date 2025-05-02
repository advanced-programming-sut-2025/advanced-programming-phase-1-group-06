package models.Tiles;

import models.tools.Tool;

public class Tile {
    private boolean isBlocked;
    private char symbol;
    private int color;
    private TileType type;
    private HoedDirtTileState hoedState; //when initialized a hoed dirt tile will replace this tile's symbol and texture

    public boolean isBlocked() {
        return isBlocked;
    }

    public void useTool(Tool tool) {
        switch (tool.getToolType()) {
            case AXE:
                //blah blah
            case SHOVEL:
                //TODO
        }
    }
}
