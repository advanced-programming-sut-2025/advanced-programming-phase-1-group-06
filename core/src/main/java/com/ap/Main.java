package com.ap;

//import com.ap.Model.InventoryTest.GameScreen;
import com.ap.View.GameView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    private SpriteBatch batch;
    private Texture image;
    private static Main instance;
    private Skin defaultSkin;
    private Skin skin;

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
        instance = this;
        batch = new SpriteBatch();
        Gdx.graphics.setWindowedMode(1920, 1080);
        this.setScreen(new GameView());
        //        this.setScreen(new GameScreen());
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
}
