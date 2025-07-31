package com.ap.Controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MapController {
    public static final int TILE_SIZE = 16;
    private final TextureAtlas tilesAtlas = new TextureAtlas("GameMap/test.atlas");
    private TextureAtlas overlayAtlas;


    public void renderMap(SpriteBatch batch, OrthographicCamera camera) {
        // Calculate visible area in world coordinates
        float startX = camera.position.x - camera.viewportWidth * camera.zoom / 2;
        float startY = camera.position.y - camera.viewportHeight * camera.zoom / 2;
        float endX = startX + camera.viewportWidth * camera.zoom;
        float endY = startY + camera.viewportHeight * camera.zoom;

        // Convert to tile coordinates and add padding
        int startTileX = (int) Math.floor(startX / TILE_SIZE) - 1;
        int startTileY = (int) Math.floor(startY / TILE_SIZE) - 1;
        int endTileX = (int) Math.ceil(endX / TILE_SIZE) + 1;
        int endTileY = (int) Math.ceil(endY / TILE_SIZE) + 1;

        // Render visible tiles
        for (int x = startTileX; x <= endTileX; x++) {
            for (int y = startTileY; y <= endTileY; y++) {
                TextureRegion textureRegion = tilesAtlas.findRegion(GameController.getInstance().getTileAt(x, y).getId());
                    batch.draw(textureRegion,
                        x * TILE_SIZE,
                        y * TILE_SIZE,
                        TILE_SIZE,
                        TILE_SIZE);
                }
            }
        }
    }

