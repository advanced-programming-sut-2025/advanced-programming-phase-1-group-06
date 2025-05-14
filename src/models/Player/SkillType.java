package models.Player;

public enum SkillType {
    FORAGING(new Skill("foraging", 0, 0, 10)),
    FISHING(new Skill("fishing", 0, 0, 5)),
    MINING(new Skill("mining", 0, 0, 10)),
    FARMING(new Skill("farming", 0, 0, 5)),

    ;

    private final Skill skill;

    SkillType(Skill skill){
        this.skill = skill;
    }

    public Skill getSkill(){
        return skill;
    }



}
