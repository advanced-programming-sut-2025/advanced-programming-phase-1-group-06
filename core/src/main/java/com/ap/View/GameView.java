package com.ap.View;

import com.ap.Controller.MapController;
import com.ap.Controller.PlayerController;
import com.ap.Main;
import com.ap.Model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameView implements Screen, InputProcessor {
    private final OrthographicCamera camera;
    private Viewport viewport;
    private MapController mapController;
    private PlayerController playerController;
    private Player player;
    public GameView() {
        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);
        mapController = new MapController();
        player = new Player();
        playerController = new PlayerController(player);
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = 0.2f;
        viewport.apply();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
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
    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i, i1);
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
    public boolean touchDown(int i, int i1, int i2, int i3) {
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
