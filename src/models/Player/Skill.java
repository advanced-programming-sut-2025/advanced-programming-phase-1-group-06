package models.Player;

public class Skill {


    private final String name;
    private int level;
    private int xp;
    private final int xpIncrease;

    Skill(String name, int level, int xp, int xpIncrease){
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpIncrease = xpIncrease;
    }

    public void increaseXP(){
        xp += xpIncrease;
        int xpRequired = 50 + (level * 100);
        if (xp >= xpRequired){
            level ++;
            xp -= xpRequired;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}