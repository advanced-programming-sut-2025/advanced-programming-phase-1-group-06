package com.ap.Model.Player;

public class Skill {
    private final String name;
    private final int xpIncrease;
    private int level;
    private int xp;
    private String description;

    Skill(String name, int level, int xp, int xpIncrease, String description) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpIncrease = xpIncrease;
        this.description = description;
    }

    public void increaseXP() {
        xp += xpIncrease;
        int xpRequired = 50 + (level * 100);
        if (xp >= xpRequired) {
            level++;
            xp -= xpRequired;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getXpRequired(){
        return 50 + (level * 100);
    }

    public String getDescription() {
        return description;
    }

    enum SkillType {

//        FORAGING("foraging", 0, 0, 10, "bs."),
//        FISHING("fishing", 0, 0, 5, "bs"),
//        MINING("mining", 0, 0, 10, "bs"),
//        FARMING("farming", 0, 0, 5, "bs"),


        FORAGING("foraging", 0, 0, 10, "Gained by collecting wild items, improving the ability to find valuable resources."),
        FISHING("fishing", 0, 0, 5, "Increases as you fish, improving chances of catching rare fish and using better equipment"),
        MINING("mining", 0, 0, 10, "Gained by exploring mines, improving your ability to find ores and minerals."),
        FARMING("farming", 0, 0, 5, "Increases by growing crops and raising animals, unlocking better tools and products."),
;
        private final String name;
        private int level;
        private int xp;
        private final int xpIncrease;
        private final String description;


        SkillType(String name, int level, int xp, int xpIncrease, String description) {
            this.name = name;
            this.xpIncrease = xpIncrease;
            this.level = level;
            this.xp = xp;
            this.description = description;
        }

        public Skill getSkill(){
            return new Skill(name, level, xp, xpIncrease, description);
        }
    }
}

