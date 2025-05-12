package models.Player;

public class Skill {
    private int foraging;
    private int farming;
    private int mining;
    private int fishing;
    private int foragingXP;
    private int farmingXP;
    private int miningXP;
    private int fishingXP;

    public Skill(){
        foraging = 0;
        farming = 0;
        mining = 0;
        fishing = 0;
        foragingXP = 0;
        farmingXP = 0;
        miningXP = 0;
        fishingXP = 0;
    }

    public Skill(int foraging, int farming, int mining, int fishing) {
        this.foraging = foraging;
        this.farming = farming;
        this.mining = mining;
        this.fishing = fishing;
    }

    public void increaseForaging(int amount) {
        foragingXP += 10;
        int requiredXP = (foraging * 100) + 50;
        if (foragingXP >= requiredXP){
            foraging ++;
            foragingXP -= requiredXP;
        }
    }

    public void increaseFarming(int amount) {
        farmingXP += 5;
        int requiredXP = (farming * 100) + 50;
        if (farmingXP >= requiredXP){
            farming ++;
            farmingXP -= requiredXP;
        }
    }

    public void increaseMining(int amount) {
        miningXP += 10;
        int requiredXP = (mining * 100) + 50;
        if (miningXP >= requiredXP){
            mining ++;
            miningXP -= requiredXP;
        }
    }

    public void increaseFishing(int amount) {
        fishingXP += 5;
        int requiredXP = (fishing * 100) + 50;
        if (fishingXP >= requiredXP){
            fishing ++;
            fishingXP -= requiredXP;
        }
    }

}

