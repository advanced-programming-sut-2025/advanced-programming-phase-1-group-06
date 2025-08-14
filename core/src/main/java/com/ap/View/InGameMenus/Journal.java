package com.ap.View.InGameMenus;

import com.ap.Main;
import com.ap.Model.Player.Player;
import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Journal implements Screen, InputProcessor {

    private static Journal instance;
    private Player player;
    private Stage stage;
    private Window window;
    private Skin skin;
    private static LinkedHashMap<String, ImageButton> imageButtons;

    private TextButton shopButton;
    private TextButton cookingButton;


    private Journal(Player player) {
        skin = Main.getInstance().getSkin();
        this.player = player;
        window = new Window("Journal", skin);
        window.setSize(1600, 1000);
        window.setPosition(160, 80);
        imageButtons = new LinkedHashMap<>();
//        imageButtons.put("crafting", new ImageButton(new Image,))
        imageButtons = loadImageButtonsFromFolder("assets/in-game-menu-stuff");

        shopButton = new TextButton("shopping menu", skin);
        cookingButton = new TextButton("cooking menu", skin);
        shopButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new ShoppingView(player));
            }
        });
        cookingButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new CookingView(player));
            }
        });
        window.center();
        window.add(shopButton).size(300, 150).padBottom(50);
        window.row();
        window.add(cookingButton).size(300, 150).padBottom(50);
        window.row();
    }

    public static Journal getInstance(Player player) {
        if (instance == null) {
            instance = new Journal(player);
        }
        return instance;
    }


    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());

        // Create an InputMultiplexer to handle multiple input processors
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(this); // Add Journal as an InputProcessor for keyboard input
        multiplexer.addProcessor(stage); // Add Stage for UI input (buttons)
        Gdx.input.setInputProcessor(multiplexer);

        addImageButtonsToStage(window, stage, imageButtons, "journal");

    }

    public static void addImageButtonsToStage(Window window, Stage stage, LinkedHashMap<String, ImageButton> imageButtons, String currentScreen) {
        float x = window.getX() + 200;
        float y = window.getY() + window.getHeight();
        float brightness = 1f;
        stage.addActor(window);
        for (Map.Entry<String, ImageButton> entry : imageButtons.entrySet()) {
            ImageButton imageButton = entry.getValue();
            imageButton.setColor(brightness, brightness, brightness, 0.4f);
            imageButton.setPosition(x, y - 5);
            if (currentScreen.equals(entry.getKey())) {
                imageButton.setColor(brightness, brightness, brightness, 1f);
                imageButton.setPosition(x, y - 10);
            }
            imageButton.setTouchable(Touchable.enabled);
            stage.addActor(imageButton);
            x += imageButton.getWidth() + 10;
        }
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
        if (keycode == Input.Keys.ESCAPE) {
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

    public LinkedHashMap<String, ImageButton> loadImageButtonsFromFolder(String folderPath) {
        AssetManager assetManager = Main.getInstance().getAssetManager();
        LinkedHashMap<String, ImageButton> imageButtonMap = new LinkedHashMap<>();
        File folder = new File((folderPath));

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") && (!name.equalsIgnoreCase("trashcan.png")));

            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    String buttonName = fileName.substring(0, fileName.lastIndexOf('.')); // Remove the .png extension
                    // Load the texture using AssetManager
                    assetManager.load(file.getAbsolutePath(), Texture.class);
                    while (!assetManager.update()) {
                        // Optionally, show a loading bar here
                    }
                    Texture texture = assetManager.get(file.getAbsolutePath(), Texture.class);

                    // Create an ImageButtonStyle and set the texture as the up state
                    ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();

                    style.imageUp = new Image(texture).getDrawable(); // Set the button's image
                    style.imageDown = style.imageUp;

                    ImageButton imageButton = new ImageButton(style);

                    // Add the ImageButton to the map with the button name as the key
                    imageButton.setSize((float) (imageButton.getWidth() * 0.5), (float) (imageButton.getHeight() * 0.5));
                    imageButtonMap.put(buttonName, imageButton);
                }
            }
        }
        setButtonListeners(imageButtonMap);
        return imageButtonMap;
    }

    public void setButtonListeners(LinkedHashMap<String, ImageButton> imageButtons) {

        imageButtons.get("skill").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new SkillView(player));
            }
        });
        imageButtons.get("inventory").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new InventoryView(player));
            }
        });
        imageButtons.get("exit").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new SettingsView(player));
            }
        });
        imageButtons.get("crafting").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new CraftingView(player));
            }
        });
        imageButtons.get("map").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new MapView(player));
            }
        });
        imageButtons.get("social").addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Main.getInstance().changeScreen(new SocialView(player));
            }
        });
    }

    public static LinkedHashMap<String, ImageButton> getImageButtons() {
        return imageButtons;
    }
}



