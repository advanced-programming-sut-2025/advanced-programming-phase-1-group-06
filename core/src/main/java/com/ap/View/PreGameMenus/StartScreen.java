package com.ap.View.PreGameMenus;

import com.ap.Main;
import com.ap.Model.GameAssetManager;
import com.ap.Model.Enum.AssetAddresses;
import com.ap.View.PreGameMenus.LoginScreen;
import com.ap.View.PreGameMenus.SignUpScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class StartScreen implements Screen {

    private Stage stage;
    private final Table table;

    // UI elements
    private final TextButton signUpButton;
    private final TextButton loginButton;
    // assets
    private final Texture backgroundTexture;
    private final Image logoImage;

    public StartScreen(){
        Skin skin = Main.getInstance().getSkin();

        signUpButton = new TextButton("sign up", skin);
        loginButton = new TextButton("login", skin);

        signUpButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Main.getInstance().changeScreen(new SignUpScreen());
            }
        });
        loginButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Main.getInstance().changeScreen(new LoginScreen());
            }
        });
        GameAssetManager.getInstance().finishLoading();

        backgroundTexture = (Texture) AssetAddresses.BACKGROUND.get();
        logoImage = new Image((Texture) AssetAddresses.LOGO.get());

        table = new Table(skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();
        table.add(signUpButton).width(240).height(70).padRight(240);
        table.add(loginButton).width(240).height(70);
        TextureRegion backgroundRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(backgroundRegion);
        table.setBackground(backgroundDrawable);

        stage.addActor(table);
        stage.addActor(logoImage);
    }

    @Override
    public void render(float delta) {

        Main.getInstance().getBatch().begin();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 /30f));
        stage.draw();
        Main.getInstance().getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        logoImage.setPosition((float) Gdx.graphics.getWidth() /2 - logoImage.getWidth()/2, (float) Gdx.graphics.getHeight() * 3 / 4);

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
}
