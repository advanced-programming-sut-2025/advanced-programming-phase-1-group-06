package com.ap.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP_LEFT(-1, 1),
    UP_RIGHT(1, 1),
    DOWN_LEFT(-1, -1),
    DOWN_RIGHT(1, -1);

    public final int x, y;

    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Direction getFacingDirection(float mouseX, float mouseY) {

        float screenCenterX = Gdx.graphics.getWidth() / 2f;
        float screenCenterY = Gdx.graphics.getHeight() / 2f;

        float deltaX = mouseX - screenCenterX;
        float deltaY = screenCenterY - mouseY;
        Vector2 directionVector = new Vector2(deltaX, deltaY);
        float angle = directionVector.angleDeg();

        if (angle >= 337.5f || angle < 22.5f) return Direction.RIGHT;
        else if (angle >= 22.5f && angle < 67.5f) return Direction.UP_RIGHT;
        else if (angle >= 67.5f && angle < 112.5f) return Direction.UP;
        else if (angle >= 112.5f && angle < 157.5f) return Direction.UP_LEFT;
        else if (angle >= 157.5f && angle < 202.5f) return Direction.LEFT;
        else if (angle >= 202.5f && angle < 247.5f) return Direction.DOWN_LEFT;
        else if (angle >= 247.5f && angle < 292.5f) return Direction.DOWN;
        else return Direction.DOWN_RIGHT;

    }
}


