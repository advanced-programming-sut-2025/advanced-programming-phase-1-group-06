package com.ap.Controller;


import com.ap.Model.Direction;
import com.ap.Model.Item.Item;
import com.ap.Model.Item.ToolComponent;
import com.ap.Model.Player;
import com.ap.Model.Position;
import com.ap.Model.Tile.Tile;

public class GameController {
    private static GameController instance;
    private Tile[][] tiles;

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private GameController() {
        tiles = new Tile[300][300];
        for (int i = 0; i < 300; i++) {
            for (int j = 0; j < 300; j++) {
                int tmp = (i + j) % 4;
                tiles[i][j] = new Tile(Integer.toString(tmp));
            }
        }
    }

    public void interactLeftClick(Player player, Position pos, Direction dir) { // get player's held item by a method in Player
        Item item = player.getHeldItem();
        if (item != null) {
            if (item.hasComponent(ToolComponent.class)) {

            }
        }
    }

    public void interactRightClick(Player player, Position pos, Direction dir) {

    }


    public Tile getTileAt(int x, int y) {
        try {
            return tiles[x][y];
        } catch (IndexOutOfBoundsException e) {
            return tiles[0][0];
        }
    }
}
