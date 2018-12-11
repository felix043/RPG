package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;

public class EnemyStatsCalc {

    private AllEnemies ae = new AllEnemies();
    private Enemy e = new Enemy();
    private int enemynr;

    private int[] stats = new int[6];

    public EnemyStatsCalc() {

    }

    protected void statscalc(int enemy, int level) {
        for (int i = 0; i < ae.getEnemies().length; i++) {
            if (ae.getEnemies()[i].getEnemyId() == enemy) {
                e = ae.getEnemies()[i];
                enemynr = i;
                break;
            }
        }

        stats[0] = e.getAtk() * level;
        stats[1] = e.getDef() * level;
        stats[2] = e.getMag() * level;
        stats[3] = e.getSpr() * level;
        stats[4] = e.getMax_hp() * level;
        stats[5] = e.getMax_mp() * level;
    }

    public int[] getStats() {
        return stats;
    }

    public int getEnemynr() {
        return enemynr;
    }
}
