package com.ap.Model.Overlay;

import com.ap.Model.ArtisanRecipe;
import com.ap.Model.Item.Component;
import com.ap.Model.Item.Item;

import java.util.List;
import java.util.Map;

public class ArtisanDeviceComponent extends Component {
    private final Map<ArtisanRecipe, Integer> recipes; //integer is time to craft in hours
    // some recipes are ready the next morning so we mark them with negative hours
    private final boolean selfSustained = false; //only for bee house
    private List<Item> placedItems;
    private final String preparingItemId = null;
    private final boolean isActive = false;
    private final long remainingTime = 0;
    private final boolean isPlaced = false; // in inventory or on ground
    private String animationAtlasPath;

    public ArtisanDeviceComponent(Map<ArtisanRecipe, Integer> recipes) {
        this.recipes = recipes;
    }
}
