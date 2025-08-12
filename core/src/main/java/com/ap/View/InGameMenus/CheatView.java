package com.ap.View.InGameMenus;

import com.ap.Main;
import com.ap.Model.Item.Factory;
import com.ap.Model.Item.Item;
import com.ap.Model.Player.Player;
import com.badlogic.gdx.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class CheatView implements Screen, InputProcessor {

    private String ITEM_PLACEHOLDER = "item name";
    private String COUNT_PLACEHOLDER = "item count";
    private String TIME_PLACEHOLDER = "time in hours";

    private Player player;
    private Stage stage;
    private Window window;
    private Skin skin;

    private Label error;

    private TextField itemCheatField;
    private TextField itemCountField;
    private TextField timeCheatField;
    private TextButton cheatButton;


    public CheatView(Player player){
        skin = Main.getInstance().getSkin();
        this.player = player;
        createFields();
        window = new Window("Cheat", skin);
        window.setSize(1600, 1000);
        window.setPosition(160, 80);
        window.center();
        window.add(timeCheatField).padBottom(50).size(600, 150);
        window.row();
        window.add(itemCheatField).padBottom(50).size(600, 150);
        window.row();
        window.add(itemCountField).padBottom(50).size(600, 150);
        window.row();
        window.add(error);
        window.row();
        window.add(cheatButton);
    }

    private void createFields(){
        error = new Label("", skin);
        cheatButton = new TextButton("cheat", skin);
        itemCheatField = new TextField(ITEM_PLACEHOLDER, skin);
        itemCountField = new TextField(COUNT_PLACEHOLDER, skin);
        timeCheatField = new TextField(TIME_PLACEHOLDER, skin);
        itemCheatField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused){
                    if (textField.getText().equals(ITEM_PLACEHOLDER)){
                        textField.setText("");
                    }
                } else if (textField.getText().isEmpty()){
                    textField.setText(ITEM_PLACEHOLDER);
                }
            }
        });
        itemCountField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused){
                    if (textField.getText().equals(COUNT_PLACEHOLDER)){
                        textField.setText("");
                    }
                } else if (textField.getText().isEmpty()){
                    textField.setText(COUNT_PLACEHOLDER);
                }
            }
        });
        timeCheatField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                TextField textField = (TextField) actor;
                if (focused){
                    if (textField.getText().equals(TIME_PLACEHOLDER)){
                        textField.setText("");
                    }
                } else if (textField.getText().isEmpty()){
                    textField.setText(TIME_PLACEHOLDER);
                }
            }
        });
        cheatButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String time = timeCheatField.getText();
                String itemName = itemCheatField.getText();
                String itemCount = itemCountField.getText();
                if (time != null && !time.isEmpty() && !time.equals(TIME_PLACEHOLDER) && time.matches("\\d+")){
                    Main.getInstance().getClock().advanceTime(Integer.parseInt(time));
                }
                System.out.println(itemName);
                if (!itemName.isEmpty() && !itemName.equals(ITEM_PLACEHOLDER)){
                    int count = 1;
                    if (!itemCount.isEmpty() && !itemCount.equals(COUNT_PLACEHOLDER) && itemCount.matches("\\d+")){
                        count = Integer.parseInt(itemCount);
                    }
                    Item item = Factory.getInstance().createItemByName(itemName, count);
                    if (item != null){
                        player.getInventory().addItem(item);
                        System.out.println("item add");
                    }
                }
            }
        });
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        InputMultiplexer multiplexer = new InputMultiplexer(this, stage);
        multiplexer.addProcessor(this); // Add Journal as an InputProcessor for keyboard input
        multiplexer.addProcessor(stage); // Add Stage for UI input (buttons)
        Gdx.input.setInputProcessor(multiplexer);

        stage.addActor(window);
        //        Journal.addButtonsToStage(window, stage, Journal.getImageButtons(), "crafting");
    }

    @Override
    public void render(float delta) {
        Main.getInstance().getBatch().begin();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        stage.act(delta);
        Main.getInstance().getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

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

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE){
            Main.getInstance().changeScreen(Main.getInstance().getGameView());
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
