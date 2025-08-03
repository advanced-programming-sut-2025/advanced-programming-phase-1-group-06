package com.ap.Controller;

import com.ap.Model.Player.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Gdx.input;

public class PlayerController {
    private Animation<TextureRegion> front = new Animation<>(0.3f, new TextureAtlas("Player/front.atlas").getRegions());
    private Animation<TextureRegion> back = new Animation<>(0.3f, new TextureAtlas("Player/back.atlas").getRegions());
    private Animation<TextureRegion> left = new Animation<>(0.3f, new TextureAtlas("Player/left.atlas").getRegions());
    private Animation<TextureRegion> right = new Animation<>(0.3f, new TextureAtlas("Player/right.atlas").getRegions());
    private Player player;
    private boolean isWalking = false;

    private TextureRegion currentFrame = front.getKeyFrame(0, true);
    private Animation<TextureRegion> currentAnimation = front;
    private float stateTime = 0;
    private Vector2 direction = new Vector2(0, 0);

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update(float delta, SpriteBatch batch) {
        if (isWalking) {
            stateTime += delta;
            currentFrame = currentAnimation.getKeyFrame(stateTime, true);
        }
        else {
            currentFrame = currentAnimation.getKeyFrame(0.7f, true);
        }
        batch.draw(currentFrame, player.position.x, player.position.y);
        System.out.println(player.position.x + " " + player.position.y);
    }

    public void handleInput() {
        float delta = Gdx.graphics.getDeltaTime();
        Vector2 movement = new Vector2(0 , 0);
        if (input.isKeyPressed(Input.Keys.A)) {
            movement.x -= 1;
        }
        if (input.isKeyPressed(Input.Keys.D)) {
            movement.x += 1;
        }
        if (input.isKeyPressed(Input.Keys.W)) {
            movement.y += 1;
        }
        if (input.isKeyPressed(Input.Keys.S)) {
            movement.y -= 1;
        }

        if (movement.len2() > 0) {
            isWalking = true;
            if (!movement.idt(direction)) {
                currentAnimation = getAnimation(movement);
                direction = movement;
            }
            movement.nor();
            player.position.x += movement.x * player.getSpeed()* delta;
            player.position.y += movement.y * player.getSpeed() * delta;
        }
        else {
            isWalking = false;
        }
    }

    private Animation<TextureRegion> getAnimation(Vector2 direction) {
        Animation<TextureRegion> animation = null;
        if (direction.y > 0) {
            animation = back;
        }
        else if (direction.y < 0) {
            animation = front;
        }
        if (direction.x > 0) {
            animation = right;
        }
        else if (direction.x < 0) {
            animation = left;
        }
        return animation;
    }
}
