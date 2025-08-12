package com.ap.View.InGameMenus;

import com.ap.Main;
import com.ap.Model.Player.Player;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class InventoryView implements Screen, InputProcessor {

    private Player player;
    private Stage stage;
    private Table table;
    private Window inventoryWindow;
    private Window infoWindow;
    private Image trashcan;
    private Label moneyLabel;
    private Skin skin;

    public InventoryView(Player player){
        this.player = player;
        this.skin = Main.getInstance().getSkin();

        // Create inventory window
        inventoryWindow = new Window("Inventory", skin); // "Skill" might be a typo for "Inventory"?
        inventoryWindow.setSize(1600, 500);
        inventoryWindow.setPosition(160, 580);
        inventoryWindow.top();

        moneyLabel = new Label(player.getMoney()+" g" , skin);
        player.getInventory().setInventoryView(this);
        // Create inventory table

//        // Create ScrollPane
//        ScrollPane scrollPane = new ScrollPane(inventoryTable, skin);
//        scrollPane.setScrollingDisabled(true, false); // Vertical scrolling only
//        scrollPane.isRightEdge();
//        scrollPane.setFadeScrollBars(false); // Keep scrollbars visible
//        scrollPane.setSmoothScrolling(true);
//        scrollPane.setScrollBarPositions(true, true); // Scrollbar on right

        // Add ScrollPane to Window (not the table directly)
//        inventoryWindow.add(scrollPane); // Uniform padding
        inventoryWindow.setMovable(false);
        inventoryWindow.setResizable(false);
        inventoryWindow.setTouchable(Touchable.childrenOnly);

        trashcan = new Image(new Texture(Gdx.files.internal("in-game-menu-stuff/trashcan.png")));

        // Create info window (unchanged)
        infoWindow = new Window("", skin);
        infoWindow.setPosition(160, 80);
        infoWindow.setSize(1600, 500);
        trashcan.setPosition(infoWindow.getX() + infoWindow.getWidth() - 100, infoWindow.getY() + infoWindow.getHeight() + 30);
        trashcan.setSize(trashcan.getWidth() / 2, trashcan.getHeight() / 2);
        player.getInventory().setTrashcanInfo(trashcan.getX(), trashcan.getY(), trashcan.getWidth(), trashcan.getHeight());
        infoWindow.top();
        infoWindow.right();
        infoWindow.add(moneyLabel);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        player.getInventory().initiateInventorySlots();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this); // Add Journal as an InputProcessor for keyboard input
        multiplexer.addProcessor(stage); // Add Stage for UI input (buttons)
        Gdx.input.setInputProcessor(multiplexer);


        stage.addActor(infoWindow);
        Journal.addButtonsToStage(inventoryWindow, stage, Journal.getImageButtons(), "inventory");
        stage.addActor(trashcan);
        player.getInventory().drawInventory(stage);
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
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.ESCAPE){
            Main.getInstance().changeScreen(Main.getInstance().getGameView());
        }
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
