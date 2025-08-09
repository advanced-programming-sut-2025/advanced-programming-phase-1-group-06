package com.ap.View;

import com.ap.Controller.GameController;
import com.ap.Controller.MapController;
import com.ap.Controller.PlayerController;
import com.ap.Main;
import com.ap.Model.Direction;
import com.ap.Model.Player.Player;
import com.ap.View.InGameMenus.Journal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameView implements Screen, InputProcessor {

    private final OrthographicCamera camera;
    private Viewport viewport;
    private MapController mapController;
    private PlayerController playerController;
    private Player player;
    private Clock clock;
    private Stage uiStage;
    private Viewport uiViewport;
    private Table inventoryTable;

    public GameView() {
        Main.getInstance().setGameView(this);
        Skin skin = new Skin(Gdx.files.internal("skin/NzSkin.json"));
        inventoryTable = new Table(skin);
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        mapController = new MapController();
        player = new Player();
        playerController = new PlayerController(player);
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 0.2f;
        viewport.apply();
        clock = new Clock(new Skin(Gdx.files.internal("skin/NzSkin.json")));
        // UI viewport and stage setup
        uiViewport = new ScreenViewport(new OrthographicCamera());
        uiStage = new Stage(uiViewport);
        uiStage.addActor(clock);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        player.getInventory().drawQuickAccess(uiStage);
    }


    @Override
    public void render(float v) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        playerController.handleInput();
        Vector2 playerPos = player.getTruePosition();
        camera.position.set(playerPos.x, playerPos.y, 0);

        camera.update();
        Main.getInstance().getBatch().setProjectionMatrix(camera.combined);
        Main.getInstance().getBatch().begin();
        mapController.renderMap(Main.getInstance().getBatch(), camera);
        playerController.update(v, Main.getInstance().getBatch());
        Main.getInstance().getBatch().end();

        // UI rendering (separate from game world)
        uiViewport.apply();
        uiStage.act(v);
        uiStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        uiViewport.update(width, height, true);

        // Update clock position
        clock.setPosition(
            width - clock.getWidth() - 10,
            height - clock.getHeight() - 10
        );
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
    public boolean keyDown(int i) {
        if (i >= Input.Keys.NUM_1 && i <= Input.Keys.NUM_9) {
            player.getInventory().equipItem(i - 8, player);
        } else if (i == Input.Keys.NUM_0) {
            player.getInventory().equipItem(9, player);
        } else if (i == Input.Keys.MINUS) {
            player.getInventory().equipItem(10, player);
        } else if (i == Input.Keys.EQUALS) {
            player.getInventory().equipItem(11, player);
        } else if (i == Input.Keys.I) {
            Main.getInstance().changeScreen(new Journal(player));
//            Main.getInstance().changeScreen(new SkillView(player));
        }
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Direction direction = Direction.getFacingDirection(screenX, screenY);
        if (button == Input.Buttons.RIGHT) {
        } else if (button == Input.Buttons.LEFT) {
            GameController.getInstance().interactLeftClick(player, direction);
        }
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }


}
