package com.ap.Model.Enum;

import com.ap.Model.GameAssetManager;
import com.badlogic.gdx.graphics.Texture;

public enum AssetAddresses {
    LOGO("menu_assets/Logo.png", Texture.class),
    BACKGROUND("menu_assets/background.png", Texture.class);
    ;
    private final String address;
    private final Class<?> clazz;

    AssetAddresses(String address, Class<?> clazz){
        this.address = address;
        this.clazz = clazz;
    }

    public void load(){
        GameAssetManager.getInstance().load(address, clazz);
    }

    public <T> T get(){
        if (GameAssetManager.getInstance().isLoaded(address))
            return (T) GameAssetManager.getInstance().get(address, clazz);
        throw new RuntimeException("asset at address " + address + " not loaded");
    }
}
