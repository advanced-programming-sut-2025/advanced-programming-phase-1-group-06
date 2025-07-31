package com.ap.Model;


import com.ap.Model.Item.Item;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private static final float PLAYER_WIDTH = 8f;
    private static final float PLAYER_HEIGHT = 8f; //fix these later
    private static double maxEnergy = 200.0;
    public Vector2 position = new Vector2(10, 10);

    public Item getHeldItem() {
        return null;
    }

    public float getSpeed() {
        return 80f;
    }

    public Vector2 getTruePosition() {
        return new Vector2(PLAYER_WIDTH, PLAYER_HEIGHT).add(position);
    }
}
