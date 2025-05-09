package models.Game.GameMap;

import com.google.gson.Gson;
import models.Tiles.Tile;

import java.util.Arrays;

public class MapReader {
    private Tile[][] baseLayer;
    private char[][] mapToRead;
    String mapName;
    public MapReader(Tile[][] baseLayer, String mapName) {
        this.baseLayer = baseLayer;
        this.mapName = mapName;
    }

    public void loadMap() {
        Gson gson = new Gson();
        baseLayer = gson.fromJson(mapName, Tile[][].class);
    }

    public void newMap() {
        Gson gson = new Gson();
        mapToRead = gson.fromJson(mapName, char[][].class);
        for (int i = 0; i < mapToRead.length; i++) {
            for (int j = 0; j < mapToRead[0].length; j++) {
                baseLayer[i][j] = Arrays.stream(CharacterTranslator.values())
                        .anyMatch(tile -> tile.getSymbol() == mapToRead[i][j]).get().getTile();
            }
        }
    }

    enum CharacterTranslator {
        DIRT('-', "dirt"),
        GRASS(',', "grass");

        private char symbol;
        private String name;

        CharacterTranslator(char symbol, String name) {
            this.symbol = symbol;
            this.name = name;
        }

        public char getSymbol() {
            return symbol;
        }

        public Tile getTile() {

        }
    }
}
