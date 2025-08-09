package com.ap.Model;

import com.ap.Model.Enum.AssetAddresses;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {

    private Skin defaultSkin;
    private Skin skin;
    private static GameAssetManager instance;
    private final AssetManager assetManager;

    private Label gameTitle;

    public void initialize(){
        defaultSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        skin = new Skin(Gdx.files.internal("skin/NzSkin.json"));
        gameTitle = new Label("Stardew Valley", skin);
        AssetAddresses.LOGO.load();
        AssetAddresses.BACKGROUND.load();
    }

    public Label getGameTitle(){
        return gameTitle;
    }

    public Skin getDefaultSkin() {
        return defaultSkin;
    }

    public Skin getSkin() {
        return skin;
    }

    // The wrapped AssetManager

    // Private constructor to prevent instantiation
    private GameAssetManager() {
        assetManager = new AssetManager();
    }

    // Public method to access the singleton instance (lazy initialization)
    public static GameAssetManager getInstance() {
        if (instance == null) {
            instance = new GameAssetManager();
        }
        return instance;
    }

    // Load an asset (e.g., texture, skin)
    public <T> void load(String path, Class<T> type) {
        try {
            assetManager.load(path, type);
        } catch (Exception e) {
            Gdx.app.error("GameAssetManager", "Failed to load asset: " + path, e);
            throw new RuntimeException("Asset loading failed: " + path, e);
        }
    }

    // Finish loading all queued assets (synchronous)
    public void finishLoading() {
        try {
            assetManager.finishLoading();
        } catch (Exception e) {
            Gdx.app.error("GameAssetManager", "Failed to finish loading assets", e);
            throw new RuntimeException("Asset loading completion failed", e);
        }
    }

    // Get a loaded asset
    public <T> T get(String path, Class<T> type) {
        try {
            if (!assetManager.isLoaded(path)) {
                Gdx.app.error("GameAssetManager", "Asset not loaded: " + path);
                throw new RuntimeException("Asset not loaded: " + path);
            }
            return assetManager.get(path, type);
        } catch (Exception e) {
            Gdx.app.error("GameAssetManager", "Failed to get asset: " + path, e);
            throw new RuntimeException("Asset retrieval failed: " + path, e);
        }
    }

    // Update asset loading (for asynchronous loading)
    public boolean update() {
        return assetManager.update();
    }

    // Get loading progress (for loading screens)
    public float getProgress() {
        return assetManager.getProgress();
    }

    public boolean isLoaded(String address){
        return assetManager.isLoaded(address);
    }

    // Dispose of all assets
    public void dispose() {
        try {
            assetManager.dispose();
            instance = null; // Allow re-creation if needed
        } catch (Exception e) {
            Gdx.app.error("GameAssetManager", "Failed to dispose assets", e);
        }
    }
}

