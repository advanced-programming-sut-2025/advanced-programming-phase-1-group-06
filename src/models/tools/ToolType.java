package models.tools;

public enum ToolType {
    AXE(new Axe("axe", 1, 5)),
    PICKAXE(new Pickaxe("pickaxe", 1, 5)),
    HOE(new Hoe("shovel", 1, 5)),
    SCISSORS(new Scissors("scissors", 1, 4)),
    SCYTHE(new Scythe("scythe", 1, 2)),
    WATERING_CAN(new WateringCan("watering can", 1, 5));

    Tool tool;

    ToolType(Tool tool){
        this.tool = tool;
    }

    public Tool getTool(){
        return tool;
    }
}
