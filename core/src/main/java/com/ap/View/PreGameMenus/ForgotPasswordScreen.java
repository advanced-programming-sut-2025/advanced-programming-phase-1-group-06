package com.ap.View.PreGameMenus;

import com.ap.Controller.MenuControllers.LoginMenuController;
import com.ap.Main;
import com.ap.Model.Enum.AssetAddresses;
import com.ap.Model.GameAssetManager;
import com.ap.Model.Player.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ForgotPasswordScreen implements Screen {

    private final String USERNAME_PLACEHOLDER = "username";
    private final String ANSWER_PLACEHOLDER = "answer";

    private final LoginMenuController controller;
    private final Table table;
    private Stage stage;

    private final TextButton showQuestionButton;
    private final TextButton backButton;
    private final TextButton showPasswordButton;

    private final TextField usernameField;
    private final TextField answerField;

    private final Label errorLabel;
    private final Label questionLabel;

    private final Image logoImage;

    public ForgotPasswordScreen() {

        Skin skin = GameAssetManager.getInstance().getSkin();
        table = new Table(skin);
        controller = new LoginMenuController();

        showQuestionButton = new TextButton("show\nquestion", skin);
        backButton = new TextButton("back", skin);
        showPasswordButton = new TextButton("show\npassword", skin);

        usernameField = new TextField(USERNAME_PLACEHOLDER, skin);
        answerField = new TextField(ANSWER_PLACEHOLDER, skin);

        errorLabel = new Label("", skin);
        questionLabel = new Label("enter username to see your security question.", skin);

        addButtonListeners();

        GameAssetManager.getInstance().finishLoading();

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
        table.padBottom(10);
        table.add(usernameField).width(600).padBottom(50).padTop(50).colspan(2);
        table.row();
        table.add(questionLabel).padBottom(50).colspan(2);
        table.row();
        table.add(answerField).width(275).padBottom(50).colspan(2);
        table.row();
        table.add(showQuestionButton);
        table.add(showPasswordButton);
        table.row().padBottom(40);
        table.add(errorLabel).colspan(2);
        table.row();
        table.add(backButton).colspan(2);


        stage.addActor(table);
        stage.addActor(logoImage);
    }

    @Override
    public void render(float v) {
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

    private void addButtonListeners() {
        showQuestionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                try {
                    questionLabel.setText(controller.getQuestion(usernameField.getText()));
                    for (User user : User.getUsers()) {
                        System.out.println(user.getUsername());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new StartScreen());
            }
        });
        showPasswordButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                errorLabel.setText(controller.forgotPassword(usernameField.getText(), answerField.getText()));
            }
        });

        usernameField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(USERNAME_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else {
                    if (textField.getText().isEmpty()) {
                        textField.setText(USERNAME_PLACEHOLDER);
                    }
                }
            }
        });
        answerField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(ANSWER_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else if (textField.getText().isEmpty()) {
                    textField.setText(ANSWER_PLACEHOLDER);

                }
            }
        });
    }

}
