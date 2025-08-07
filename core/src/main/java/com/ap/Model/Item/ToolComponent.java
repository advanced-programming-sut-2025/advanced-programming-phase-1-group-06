package com.ap.Model.Item;

public class ToolComponent extends Component {
    public enum ToolType {
        AXE, PICKAXE, WATERING_CAN, HOE, SCYTHE, SHEAR, MILK_PAIL, FISHING_ROD
    }

//    private ToolType toolType;

    private int successfulEnergyUse;
    private int unsuccessfulEnergyUse;
    private int capacity; // 0 for all except watering can



    public void useTool() {

    }


    // Getters
//    public ToolType getToolType() { return toolType; }

}
