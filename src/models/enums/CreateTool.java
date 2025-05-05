package models.enums;

import models.tools.Hoe;
import models.tools.Pickaxe;
import models.tools.Tool;

public enum CreateTool {
    PICKAXE(new Pickaxe()),
    HOE(new Hoe()),;

    private final Tool tool;

    CreateTool(Tool tool){
        this.tool = tool;
    }

}
