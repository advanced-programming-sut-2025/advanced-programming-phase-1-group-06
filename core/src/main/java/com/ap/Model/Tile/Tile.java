package com.ap.Model.Tile;



import com.ap.Model.Item.Component;
import com.ap.Model.Item.Item;
import com.ap.Model.Overlay.OverlayObject;

import java.util.Map;

public class Tile {
    private final String atlasId;

    public Map<Class<? extends Component>, Component> components;
    private OverlayObject overlay;
    private boolean isMultiSeasonal; // yes if it changes based on the season
    private boolean isBlocked; // if yes you cannot walk on it

    public void interact(Item item) {

    }

    public Tile(String atlasId) {
        this.atlasId = atlasId;
    }

    public String getId() {
        return atlasId;
    }
}
