package com.ap.Model.Player;

public class Skill {
    private final String name;
    private final int xpIncrease;
    private int level;
    private int xp;

    Skill(String name, int level, int xp, int xpIncrease) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpIncrease = xpIncrease;
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

    enum SkillType {

        FORAGING("foraging", 0, 0, 10),
        FISHING("fishing", 0, 0, 5),
        MINING("mining", 0, 0, 10),
        FARMING("farming", 0, 0, 5);

        private final String name;
        private int level;
        private int xp;
        private final int xpIncrease;

        SkillType(String name, int level, int xp, int xpIncrease) {
            this.name = name;
            this.xpIncrease = xpIncrease;
            this.level = level;
            this.xp = xp;
        }

        public Skill getSkill(){
            return new Skill(name, level, xp, xpIncrease);
        }
    }
}

