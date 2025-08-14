package com.ap.View.InGameMenus;

import com.ap.Main;
import com.ap.Model.Player.Player;
import com.ap.Model.Recipe;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.LinkedHashMap;
import java.util.List;

public class CookingView implements Screen, InputProcessor {

    private Player player;
    private Stage stage;
    private Window cookingWindow;
    private Window inventoryWindow;
    private Window errorwindow;

    private Skin skin;
    private List<Recipe> cookables;

    private LinkedHashMap<String, Image> craftablesImages;


    public CookingView(Player player) {
        craftablesImages = new LinkedHashMap<>();
        cookables = player.getCookableItems();
        skin = Main.getInstance().getSkin();
//        for (Recipe r : cookables){
//            System.out.println(r.getItemName());
//        }
        this.player = player;
        errorwindow = new Window("Message", skin);
        errorwindow.setSize(500, 200);
        errorwindow.setPosition(0, Gdx.graphics.getHeight() - errorwindow.getHeight());
        errorwindow.center();
        cookingWindow = new Window("Cooking", skin);
        inventoryWindow = new Window("Inventory", skin); // "Skill" might be a typo for "Inventory"?
        inventoryWindow.setSize(1600, 500);
        inventoryWindow.setPosition(160, 580);
        inventoryWindow.top();
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        InputMultiplexer multiplexer = new InputMultiplexer(this, stage);
        multiplexer.addProcessor(this); // Add Journal as an InputProcessor for keyboard input
        multiplexer.addProcessor(stage); // Add Stage for UI input (buttons)
        Gdx.input.setInputProcessor(multiplexer);
        cookingWindow.setSize(1600, 500);
        cookingWindow.setPosition(160, 80);
        int counter = 0;
        for (Recipe r : cookables) {
            try {
                Image image = new Image(new Texture(Gdx.files.internal(r.getItem().getTexturePath())));
                image.setSize(image.getImageWidth() * 10, image.getImageHeight() * 10);
                image.addListener(new TextTooltip(r.getToolTip(), skin));
                cookingWindow.add(image).padRight(40);
                addListener(image, r);
                if (counter % 6 == 0){
                    cookingWindow.row();
                }
                counter ++;
            } catch (Exception e) {
                if (r.getItem() != null) {
                    System.out.println("balls");
                    System.out.println(r.getItem().getName() + ": " + r.getItem().getTexturePath());
                } else {
                    System.out.println(r.getItemName() + " is null");
                }
            }
        }
        stage.addActor(cookingWindow);
        stage.addActor(inventoryWindow);
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

    public void addListener(Image image, Recipe r){
        image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked");
                Label label = new Label("label", skin);
                if (!player.getInventory().craft(r)){
                    label.setText("can't craft this item");
                } else {
                    label.setText("item crafted");
                    player.getInventory().initiateInventorySlots();
                    player.getInventory().initiateQuickAccessSlots();
                    player.getInventory().drawInventory(stage);
                }
                label.setPosition(40, errorwindow.getHeight()/2-label.getHeight()/2);
                errorwindow.addActor(label);
                stage.addActor(errorwindow);
                errorwindow.addAction(Actions.sequence(
                    Actions.fadeIn(1f),
                    Actions.delay(3f),              // wait 3 seconds
                    Actions.fadeOut(1f),            // fade out over 1 second
                    Actions.removeActor(label),
                    Actions.removeActor()  // remove from stage
                ));
            }
        });
    }
}
