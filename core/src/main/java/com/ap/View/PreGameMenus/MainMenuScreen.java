package com.ap.View.PreGameMenus;

import com.ap.Main;
import com.ap.Model.Enum.AssetAddresses;
import com.ap.Model.GameAssetManager;
import com.ap.View.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.LinkedHashMap;

public class MainMenuScreen implements Screen {

    private final LinkedHashMap<String, TextButton> buttons;
    private final Table table;
    private Stage stage;

    private final Image logoImage;


    public MainMenuScreen(){
        Skin skin = GameAssetManager.getInstance().getSkin();

        table = new Table(skin);

        buttons = new LinkedHashMap<>();
        buttons.put("resume", new TextButton("resume", skin));
        buttons.put("new game", new TextButton("new game", skin));
        buttons.put("load game", new TextButton("load game", skin));
        buttons.put("profile", new TextButton("profile", skin));
        buttons.put("log out", new TextButton("log out", skin));
        buttons.put("exit", new TextButton("exit", skin));

        addListeners();

        logoImage = new Image((Texture) AssetAddresses.LOGO.get());
        Texture backgroundTexture = AssetAddresses.BACKGROUND.get();
        TextureRegion backgroundRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(backgroundRegion);
        table.setBackground(backgroundDrawable);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();

        buttons.forEach((key, value) -> {
            table.add(value).width(200).padBottom(50);
            table.row();
        });

        stage.addActor(table);
        stage.addActor(logoImage);
    }

    @Override
    public void render(float delta) {
        Main.getInstance().getBatch().begin();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        Main.getInstance().getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        logoImage.setPosition((float) Gdx.graphics.getWidth() / 6 - logoImage.getWidth()/2, (float) Gdx.graphics.getHeight() * 3 / 4);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void addListeners(){
//        TODO new game and load game."
        buttons.get("resume").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(Main.getInstance().getGameView());
            }
        });
        buttons.get("profile").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Main.getInstance().changeScreen(new ProfileScreen());
            }
        });
        buttons.get("log out").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Main.getInstance().changeScreen(new StartScreen());
            }
        });
        buttons.get("exit").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().exit();
            }
        });
        buttons.get("new game").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new GameView());
            }
        });
    }
}
