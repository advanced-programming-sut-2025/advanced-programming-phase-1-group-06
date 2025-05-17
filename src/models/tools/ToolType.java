package models.tools;

public enum ToolType {
    AXE(new Axe("axe", 0, 5)),
    PICKAXE(new Pickaxe("pickaxe", 0, 5)),
    HOE(new Hoe("hoe", 0, 5)),
    SCISSORS(new Scissors("scissors", 0, 4)),
    SCYTHE(new Scythe("scythe", 0, 2)),
    WATERING_CAN(new WateringCan("watering can", 0, 5));

    final Tool tool;

    ToolType(Tool tool){
        this.tool = tool;
    }

    public Tool getTool(){
        return tool;
    }
}
