package ch.rpg.felix.rpg.BattleSystem;

public class Enemy extends Creature {

    private AI ai;

    public Enemy(String name, int level, int max_hp, int max_mp, int current_hp, int current_mp,
                 int atk, int mag, int def, int spr, Skills[] skillArray, AI ai) {

        super(name, level, max_hp, max_mp, current_hp, current_mp, atk, mag, def, spr, skillArray);
        this.ai = ai;

    }

    public int attack(int[] stats) {
        int skill = this.ai.checkRule(stats);
        this.setCurrent_mp(this.getCurrent_mp() - this.getSkillArray()[skill].getMp_cost());
        //FIXME calculate and return damage
        return;
    }

    public AI getAi() {
        return ai;
    }
}
