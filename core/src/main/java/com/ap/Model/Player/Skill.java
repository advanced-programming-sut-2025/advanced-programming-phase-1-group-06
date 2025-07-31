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

    enum SkillType {
        FORAGING(new Skill("foraging", 0, 0, 10)),
        FISHING(new Skill("fishing", 0, 0, 5)),
        MINING(new Skill("mining", 0, 0, 10)),
        FARMING(new Skill("farming", 0, 0, 5));

        private final Skill skill;

        SkillType(Skill skill) {
            this.skill = skill;
        }

        public Skill getSkill() {
            return skill;
        }


    }
}
