package com.ap.View.PreGameMenus;

import com.ap.Controller.MenuControllers.RegisterMenuController;
import com.ap.Main;
import com.ap.Model.Enum.AssetAddresses;
import com.ap.Model.GameAssetManager;
import com.ap.Model.Player.User;
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

import java.util.LinkedHashMap;

public class ProfileScreen implements Screen {

    private final Table table;
    private Stage stage;

    private final LinkedHashMap<String, TextField> infoFields;
    private final LinkedHashMap<String, TextButton> changeButtons;
    private final TextButton backButton;

    private final Label errorLabel;

    private final Image logoImage;


    public ProfileScreen() {
        Skin skin = GameAssetManager.getInstance().getSkin();

        table = new Table(skin);

        changeButtons = new LinkedHashMap<>();
        changeButtons.put("username", new TextButton("change\nusername", skin));
        changeButtons.put("nickname", new TextButton("change\nnickname", skin));
        changeButtons.put("email", new TextButton("change\nemail", skin));
        changeButtons.put("password", new TextButton("change\npassword", skin));

        backButton = new TextButton("back", skin);

        infoFields = new LinkedHashMap<>();
        infoFields.put("username", new TextField(User.getLoggedInUser().getUsername(), skin));
        infoFields.put("nickname", new TextField(User.getLoggedInUser().getNickname(), skin));
        infoFields.put("email", new TextField(User.getLoggedInUser().getEmail(), skin));
        infoFields.put("password", new TextField(User.getLoggedInUser().getPassword(), skin));


        errorLabel = new Label("error label", skin);

        logoImage = new Image((Texture) AssetAddresses.LOGO.get());

        addListeners();

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

        changeButtons.forEach((key, value) -> {
            table.add(infoFields.get(key)).width(500).padRight(30).padBottom(50);
            table.add(changeButtons.get(key)).width(200).padBottom(50);
            table.row();
        });
        table.add(errorLabel).colspan(2).padBottom(50);
        table.row();
        table.add(backButton).colspan(2);

        stage.addActor(logoImage);
        stage.addActor(table);
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
        logoImage.setPosition((float) Gdx.graphics.getWidth() / 6 - logoImage.getWidth() / 2, (float) Gdx.graphics.getHeight() * 3 / 4);
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

    public void addListeners() {
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new MainMenuScreen());
            }
        });
        changeButtons.get("username").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = infoFields.get("username").getText();
                if (User.getUserByUsername(username) == null && User.getUserByUsername(username) != User.getLoggedInUser()) {
                    User.getLoggedInUser().setUsername(username);
                    errorLabel.setText("username changed successfully");
                } else {
                    errorLabel.setText("username already in use.");
                }
            }
        });
        changeButtons.get("nickname").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                User.getLoggedInUser().setNickname(infoFields.get("nickname").getText());
                errorLabel.setText("nickname changed successfully");
            }
        });
        changeButtons.get("email").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String email = infoFields.get("email").getText();
                if (RegisterMenuController.checkEmail(email)) {
                    User.getLoggedInUser().setUsername(email);
                    errorLabel.setText("email changed successfully");
                } else
                    errorLabel.setText("invalid email");
            }
        });
        changeButtons.get("password").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String password = infoFields.get("password").getText();
                String error = RegisterMenuController.checkPassword(password);
                if (error == null){
                    User.getLoggedInUser().setPassword(password);
                    errorLabel.setText("password changed successfully");
                } else
                    errorLabel.setText(error);
            }
        });
    }
}
