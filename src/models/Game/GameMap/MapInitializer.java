package models.Game.GameMap;

import models.Game.Coordinates;

import java.util.Random;

import models.PlantsAndForaging.Info.TreeSeedInfo;
import models.PlantsAndForaging.Tree;
import models.Tiles.Dirt;
import models.Tiles.Info.BuildingTileInfo;
import models.Tiles.Info.MineralTileInfo;
import models.Tiles.OverlayTiles.*;
import models.Tiles.Tile;
import models.buildings.House;


public class MapInitializer {
    private static final int MAP_WIDTH = 43;  // Adjust based on your map size
    private static final int MAP_HEIGHT = 43;
    private static final double TREE_CHANCE = 0.15;  // Chance of tree spawning
    private static final double ORE_CHANCE = 0.3;    // Chance of ore spawning
    private static final int MIN_WEED_CLUSTERS = 3;  // Minimum number of weed clusters
    private static final int MAX_WEED_CLUSTERS = 8;  // Maximum number of weed clusters
    private static final int MIN_WEEDS_PER_CLUSTER = 5;  // Minimum weeds per cluster
    private static final int MAX_WEEDS_PER_CLUSTER = 12;  // Maximum weeds per cluster
    private static final int QUARRY_MIN_X = 0;
    private static final int QUARRY_MAX_X = 15;
    private static final int QUARRY_MIN_Y = 0;
    private static final int QUARRY_MAX_Y = 7;
    private static final int HOUSE_MIN_X = 36;
    private static final int HOUSE_MAX_X = 40;
    private static final int HOUSE_MIN_Y = 4;
    private static final int HOUSE_MAX_Y = 8;

    private static final int MAX_ROCK_STICK_COUNT = 60;



    private final GameMap gameMap;



    private final Random random = new Random();


    public MapInitializer(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public GameMap getGameMap() { return gameMap; }


    public MapInitializer generateObstacles() {
        for (int y = 0; y < gameMap.getWidth(); y++) {
            for ( int x = 0; x < gameMap.getLength(); x++){

                    Tile tile = gameMap.getTileAt(x, y);
                    if (tile == null) {
                    System.out.println("Null tile at x=" + x + ", y=" + y);
                    continue;
                }
            }
        }
        generateHouse();
        generateMiningArea();
        generateWeedClusters();
        generateTrees();
        generateRocksAndStick();
        return this;
    }

    private void generateHouse() {
//        for (int y = HOUSE_MIN_Y ; y < HOUSE_MAX_Y ; y++) {
//            for (int x = HOUSE_MIN_X; x < HOUSE_MAX_X; x++) {
//                System.out.println("x: " + x + " y: " + y);
//                gameMap.getTileAt(x, y).setOverlayTile(new BuildingTile(BuildingTileInfo.HOUSE, gameMap,
//                        new Coordinates(x, y)), new House(new Coordinates()));
//            //TODO change the shape of the buildings and their initalization method (choose a corner)
//            }
//        }
        new MapModifier(gameMap).makeBuilding(new Coordinates(HOUSE_MIN_X, HOUSE_MIN_Y), HOUSE_MAX_X - HOUSE_MIN_X,
                HOUSE_MAX_Y - HOUSE_MIN_Y, new House());
    }

    private void generateRocksAndStick() {
        for (int i = 0; i < MAX_ROCK_STICK_COUNT; i++) {
            Coordinates c = findValidPosition();
            if (c != null) {
                OverlayTile tile = switch (random.nextInt(2)) {
                    case 0 -> new WoodStickTile(gameMap, c);
                    case 1 -> new MineralTile(MineralTileInfo.ROCK, gameMap, c);
                    default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(2));
                };
                gameMap.getTileAt(c).setOverlayTile(tile);
            }
        }

    }

    private void generateMiningArea() {
        // Generate ores in the top-left corner
        for (int y = QUARRY_MIN_Y; y < QUARRY_MAX_Y; y++) {
            for (int x = QUARRY_MIN_X; x < QUARRY_MAX_X; x++) {
                if (Math.abs(random.nextDouble()) < ORE_CHANCE && gameMap.getTileAt(x, y).getOverlayTile() == null) { // 30% chance for ore placement
                    gameMap.getTileAt(x, y).setOverlayTile(
                            new MineralTile(MineralTileInfo.getRandomly(), gameMap, new Coordinates(x, y)));
                }
            }
        }
    }

    private void generateWeedClusters() {
        // Generate 3-5 weed clusters
        int numClusters = random.nextInt(MAX_WEED_CLUSTERS - MIN_WEED_CLUSTERS + 1) + MIN_WEED_CLUSTERS;

        for (int i = 0; i < numClusters; i++) {
            // Find a valid starting position for the cluster
            Coordinates clusterCenter = findValidPosition();
            if (clusterCenter != null) {
                generateWeedCluster(clusterCenter, 5 + random.nextInt(4)); // 5-8 weeds per cluster
            }
        }
    }

    private void generateWeedCluster(Coordinates center, int numWeeds) {
        // Generate weeds in a circular pattern around the center
        for (int i = 0; i < numWeeds; i++) {
            int radius = random.nextInt(4) + 2;
            double angle = random.nextDouble() * 2 * Math.PI;

            int x = center.x() + (int)(radius * Math.cos(angle));
            int y = center.y() + (int)(radius * Math.sin(angle));

            if (isValidPosition(x, y) && gameMap.getTileAt(x, y) instanceof Dirt) {
                gameMap.getTileAt(x, y).setOverlayTile(new GrassTile(gameMap, new Coordinates(x, y)));
            }
        }
    }

    private void generateTrees() {
        // Generate trees with minimum spacing
        for (int y = 0; y < MAP_HEIGHT; y += 1) {
            for (int x = 0; x < MAP_WIDTH; x += 1) {
                if (random.nextDouble() < 0.10 && gameMap.getTileAt(x, y) instanceof Dirt &&// 10% chance for tree placement
                    isValidTreePosition(x, y)) {
                    gameMap.getTileAt(x, y).setOverlayTile(new Tree(TreeSeedInfo.getRandomly(), gameMap, new Coordinates(x, y)));
                }
            }
        }
    }

    private boolean isValidTreePosition(int x, int y) {
        // Check if position is valid for tree placement
        if (!isValidPosition(x, y)) return false;

        // Check minimum distance from other trees
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                int newX = x + dx;
                int newY = y + dy;
                if (isInBounds(newX, newY)) {
                    if (gameMap.getTileAt(newX, newY).getOverlayTile() instanceof Tree) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPosition(int x, int y) {
        // Check if position is within bounds
        if (!isInBounds(x, y)) return false;
        return (gameMap.getTileAt(x, y).getOverlayTile() == null);
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < MAP_WIDTH && y >= 0 && y < MAP_HEIGHT;
    }

    private Coordinates findValidPosition() {
        int maxAttempts = 100;
        while (maxAttempts-- > 0) {
            int x = random.nextInt(MAP_WIDTH);
            int y = random.nextInt(MAP_HEIGHT);
            if (isValidPosition(x, y)) {
                return new Coordinates(x, y);
            }
        }
        return null;
    }


}