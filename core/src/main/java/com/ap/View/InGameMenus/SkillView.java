package com.ap.View.InGameMenus;

import com.ap.Main;
import com.ap.Model.Player.Player;
import com.ap.Model.Player.Skill;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.LinkedHashMap;
import java.util.Map;

public class SkillView implements Screen, InputProcessor {

    private static final float XP_BAR_WIDTH = 500;
    private static final float XP_BAR_HEIGHT = 20f;

    private Player player;
    private Stage stage;
    private Window window;
    private Skin skin;
    private LinkedHashMap <Skill, Label> labels;
    private Table table;

    public SkillView(Player player){
        skin = Main.getInstance().getSkin();
        this.player = player;
        window = new Window("Skill" , skin);
        labels = new LinkedHashMap<>();
        table = new Table(skin);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());

        InputMultiplexer multiplexer = new InputMultiplexer(this, stage);
        multiplexer.addProcessor(this); // Add Journal as an InputProcessor for keyboard input
        multiplexer.addProcessor(stage); // Add Stage for UI input (buttons)
        Gdx.input.setInputProcessor(multiplexer);

        table.center();
        for (int i = 0; i < 4; i ++){
            Skill skill = player.getSkills().get(i);
            Label label = new Label(skill.getName() + ": " + skill.getXp() + " | " + skill.getXpRequired(), skin);

            label.addListener(new TextTooltip(skill.getDescription(), skin));
            labels.put(skill, label);
//            table.debug();
            Texture texture = new Texture(Gdx.files.internal("skills/" + skill.getName()+".png"));

            Image image = new Image(texture);
            table.add(image).size(image.getWidth() / 2, image.getHeight()/2).padBottom(50).padRight(50);
            table.add(labels.get(skill)).padRight(600).padBottom(50);
            table.add(new Label(String.format("level : %d", skill.getLevel()), skin)).padBottom(50);
            table.row();
        }

        window.setSize(1600, 1000);
        window.setPosition(160, 80);
//        window.debug();
//        table.debug();
        window.center();
        window.add(table);
        Journal.addButtonsToStage(window, stage, Journal.getImageButtons(), "skill");
    }

    @Override
    public void render(float delta) {
        Main.getInstance().getBatch().begin();
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
        stage.draw();
        stage.act(delta);
        for (Map.Entry<Skill, Label> entry : labels.entrySet()){
            Skill skill = entry.getKey();
            Label label = entry.getValue();
            drawProgressBar(skill, Gdx.graphics.getWidth()/2 - (XP_BAR_WIDTH/2) + 100, label.getY() + 390);
        }
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

    public void drawProgressBar(Skill skill, float XP_BAR_X, float XP_BAR_Y) {
        int currentXp = skill.getXp();
        int requiredXp = skill.getXpRequired();

        // Calculate progress percentage
        float progress = Math.min(1f, (float)currentXp / requiredXp);

        // Get the shape renderer from the player controller
        ShapeRenderer shapeRenderer = new ShapeRenderer();

        // Begin shape rendering
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw background (empty bar)
        shapeRenderer.setColor(0.3f, 0.3f, 0.3f, 1);
        shapeRenderer.rect(XP_BAR_X, XP_BAR_Y, XP_BAR_WIDTH, XP_BAR_HEIGHT);

        // Draw progress (filled portion)
        shapeRenderer.setColor(0.4f, 0.8f, 0.4f, 1);  // Green color for XP
        shapeRenderer.rect(XP_BAR_X, XP_BAR_Y, XP_BAR_WIDTH * progress, XP_BAR_HEIGHT);

        shapeRenderer.end();

        // Add border
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0.8f, 0.8f, 0.8f, 1);
        shapeRenderer.rect(XP_BAR_X, XP_BAR_Y, XP_BAR_WIDTH, XP_BAR_HEIGHT);
        shapeRenderer.end();

        shapeRenderer.dispose();
    }
}

