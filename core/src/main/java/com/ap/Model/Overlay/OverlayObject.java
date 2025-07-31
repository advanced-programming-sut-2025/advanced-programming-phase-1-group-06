package com.ap.Model.Overlay;



import com.ap.Model.Component;
import com.ap.Model.Item.Item;

import java.util.Map;


public class OverlayObject {
    private Map<Class<? extends Component>, Component> components;
    private String texturePath;
    public void interact(Item item) {

    }
}
