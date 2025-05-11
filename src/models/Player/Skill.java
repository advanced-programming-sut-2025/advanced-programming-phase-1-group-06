package models.Player;

public class Skill {
    private int foraging;

    private int farming;
    private int mining;
    private int fishing;

    public Skill(){
        foraging = 0;
        farming = 0;
        mining = 0;
        fishing = 0;
    }

    public Skill(int foraging, int farming, int mining, int fishing) {
        this.foraging = foraging;
        this.farming = farming;
        this.mining = mining;
        this.fishing = fishing;
    }

    public void increaseForaging(int amount) {
    }

    public void increaseFarming(int amount) {
    }

    public void increaseMining(int amount) {
    }

    public void increaseFishing(int amount) {
    }

}

