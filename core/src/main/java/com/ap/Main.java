package com.ap;

//import com.ap.Model.InventoryTest.GameScreen;
import com.ap.Model.GameAssetManager;
import com.ap.Model.Player.Player;
import com.ap.View.Clock;
import com.ap.View.GameView;
import com.ap.View.InGameMenus.Journal;
import com.ap.View.InGameMenus.SkillView;
import com.ap.View.PreGameMenus.StartScreen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private SpriteBatch batch;
    private Texture image;
    private static Main instance;
    private Skin defaultSkin;
    private Skin skin;
    private GameView gameView;
    private AssetManager assetManager;
    private Clock clock;

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public Skin getSkin() {
        return skin;
    }

    public Skin getDefaultSkin() {
        return defaultSkin;
    }

    public SpriteBatch getBatch() {
        return batch;
    }
    @Override
    public void create() {
        defaultSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        skin = new Skin(Gdx.files.internal("skin/NzSkin.json"));
        assetManager = new AssetManager();
        instance = this;
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(1920, 1200);
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        GameAssetManager gameAssetManager = GameAssetManager.getInstance();
        gameAssetManager.initialize();
        GameAssetManager.getInstance().finishLoading();
        gameView = new GameView();
        changeScreen(gameView);
//        changeScreen(new StartScreen());
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public GameView getGameView() {
        return gameView;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public void changeScreen(Screen screen){
        if (screen == null){
            return;
        }
        Screen currentScreen = ((Main) Gdx.app.getApplicationListener()).getScreen();
        if (currentScreen != null) {
            currentScreen.dispose();
        }
        ((Main) Gdx.app.getApplicationListener()).setScreen(screen);
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void exit(){
        Gdx.app.exit();
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
