package com.ap.Model.Item;

public class BombComponent {
    private static final int explosionDelay = 3; //seconds
    private final int explosionRadius;

    public BombComponent(int explosionRadius) {
        this.explosionRadius = explosionRadius;
    }

    public int getExplosionRadius() {
        return explosionRadius;
    }
}
