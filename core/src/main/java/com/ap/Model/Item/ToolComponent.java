package com.ap.Model.Item;

import com.ap.Model.Component;

public class ToolComponent extends Component {
    public enum ToolType {
        AXE, PICKAXE, WATERING_CAN, HOE, SWORD
    }

    private ToolType toolType;
    private int power;

    public ToolComponent(ToolType toolType, int power) {
        this.toolType = toolType;
        this.power = power;
    }

    public void useTool() {

    }


    // Getters
    public ToolType getToolType() { return toolType; }

    public int getPower() { return power; }
}
