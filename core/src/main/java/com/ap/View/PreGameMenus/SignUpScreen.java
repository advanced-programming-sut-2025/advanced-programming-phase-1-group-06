package com.ap.View.PreGameMenus;

import com.ap.Controller.MenuControllers.RegisterMenuController;
import com.ap.Main;
import com.ap.Model.Enum.AssetAddresses;
import com.ap.Model.GameAssetManager;
import com.ap.Model.Player.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SignUpScreen implements Screen {

    private final String USERNAME_PLACEHOLDER = "username";
    private final String PASSWORD_PLACEHOLDER = "password";
    private final String EMAIL_PLACEHOLDER = "email";
    private final String ANSWER_CONFIRMATION_PLACEHOLDER = "answer confirmation";
    private final String ANSWER_PLACEHOLDER = "answer";
    private final String NICKNAME_PLACEHOLDER = "nickname";

    private final RegisterMenuController controller;
    private final Table table;
    private Stage stage;

    private final TextButton signUpButton;
    private final TextButton backButton;
    private final TextButton generateButton;

    private final TextField usernameField;
    private final TextField passwordField;
    private final TextField answerConfirmationField;
    private final TextField emailField;
    private final TextField answerField;
    private final TextField nicknameField;

    private final Label errorLabel;

    private final SelectBox<String> questionSelectBox;
    private final SelectBox<String> genderSelectBox;

    private final Image logoImage;

    public SignUpScreen() {

        Skin skin = GameAssetManager.getInstance().getSkin();
        table = new Table();
        controller = new RegisterMenuController();

        signUpButton = new TextButton("sign up", skin);
        backButton = new TextButton("back", skin);
        generateButton = new TextButton("generate\npassword", skin);

        usernameField = new TextField(USERNAME_PLACEHOLDER, skin);
        passwordField = new TextField(PASSWORD_PLACEHOLDER, skin);
        emailField = new TextField(EMAIL_PLACEHOLDER, skin);
        answerField = new TextField(ANSWER_PLACEHOLDER, skin);
        answerConfirmationField = new TextField(ANSWER_CONFIRMATION_PLACEHOLDER, skin);
        nicknameField = new TextField(NICKNAME_PLACEHOLDER, skin);

        questionSelectBox = new SelectBox<>(skin);
        genderSelectBox = new SelectBox<>(skin);


        errorLabel = new Label("", skin);
        errorLabel.setColor(Color.WHITE);
        addButtonListeners();
        addSelectBoxItems();


        GameAssetManager.getInstance().finishLoading();

        logoImage = new Image((Texture) AssetAddresses.LOGO.get());
        Texture backgroundTexture = AssetAddresses.BACKGROUND.get();
        TextureRegion backgroundRegion = new TextureRegion(backgroundTexture);
        TextureRegionDrawable backgroundDrawable = new TextureRegionDrawable(backgroundRegion);
        table.setBackground(backgroundDrawable);

    }

    private void addSelectBoxItems() {
        Array<String> questionArray = new Array<>();

        for (String question : User.getQuestions()) {
            questionArray.add(question);
        }

        questionSelectBox.setItems(questionArray);

        Array<String> genders = new Array<>();

        genders.add("male");
        genders.add("female");

        genderSelectBox.setItems(genders);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.center();
        table.add(usernameField).width(600).padBottom(40).padTop(40).colspan(2);
        table.row();
        table.add(nicknameField).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(emailField).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(passwordField).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(genderSelectBox).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(questionSelectBox).width(600).height(70).padBottom(40).colspan(2);
        table.row();
        table.add(answerField).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(answerConfirmationField).width(600).padBottom(40).colspan(2);
        table.row();
        table.add(errorLabel).colspan(2);
        table.row();
        table.add(signUpButton);
        table.add(generateButton);
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
        signUpButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String email = emailField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                String answerConfirmation = answerConfirmationField.getText();
                String question = questionSelectBox.getSelected();
                String answer = answerField.getText();
                String gender = genderSelectBox.getSelected();
                String nickname = nicknameField.getText();
                int questionIndex = questionSelectBox.getSelectedIndex();
                String error = controller.register(username, password, email, nickname, gender, questionIndex, question, answer, answerConfirmation);
                errorLabel.setText(error);
                if (error.equals("user created successfully"))
                    Main.getInstance().changeScreen(new MainMenuScreen());
            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                controller.back();
            }
        });
        generateButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String password = RegisterMenuController.generatePassword();
                passwordField.setText(password);
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
        nicknameField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(NICKNAME_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else {
                    if (textField.getText().isEmpty()) {
                        textField.setText(NICKNAME_PLACEHOLDER);
                    }
                }
            }
        });
        emailField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(EMAIL_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else {
                    if (textField.getText().isEmpty()) {
                        textField.setText(EMAIL_PLACEHOLDER);
                    }
                }
            }
        });
        passwordField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(PASSWORD_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else {
                    if (textField.getText().isEmpty()) {
                        textField.setText(PASSWORD_PLACEHOLDER);
                    }
                }
            }
        });
        passwordField.addListener(new InputListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                if (!passwordField.getText().equals(PASSWORD_PLACEHOLDER)) {
                    String error = RegisterMenuController.checkPassword(passwordField.getText());
                    if (error == null)
                        error = " ";
                    errorLabel.setText(error);
                }
                return true;
            }
        });
        answerConfirmationField.addListener(new InputListener() {
            @Override
            public boolean keyTyped(InputEvent event, char character) {
                if (!answerField.getText().equals(answerConfirmationField.getText()))
                    errorLabel.setText("confirmation doesn't match the answer");
                return true;
            }
        });
        answerConfirmationField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused) {
                    if (textField.getText().equals(ANSWER_CONFIRMATION_PLACEHOLDER)) {
                        textField.setText("");
                    }
                } else {
                    if (textField.getText().isEmpty()) {
                        textField.setText(ANSWER_CONFIRMATION_PLACEHOLDER);
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
