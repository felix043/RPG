package ch.rpg.felix.rpg.BattleSystem;

public class Enemy extends Creature {

    private AI ai;
    private Skills skills;

    private int enemyId;

    public Enemy(int enemyId, String name, int level, int max_hp, int max_mp, int current_hp, int current_mp,
                 int atk, int mag, int def, int spr, Skills[] skillArray, AI ai) {

        super(name, level, max_hp, max_mp, atk, mag, def, spr, skillArray);
        this.ai = ai;
        this.enemyId = enemyId;
    }

    public Enemy(int enemy, int level) {
        super(enemy, level);
    }

    public Enemy() {

    }

    /*
    public int attack(int[] stats) {
        int damage;
        int skill = this.ai.checkRule(stats);
        this.setCurrent_mp(this.getCurrent_mp() - this.getSkillArray()[skill].getMp_cost());
        if (skills.getType() == 2) {
            damage = dc.calculateEnemyHybridDamage();
        } else if (skills.getType() == 1) {
            damage = dc.calculateEnemyPhysicalDamage();
        } else {
            damage = dc.calculateEnemyMagicDamage();
        }

        return damage;
    }*/

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public int getEnemyId() {
        return enemyId;
    }
}
