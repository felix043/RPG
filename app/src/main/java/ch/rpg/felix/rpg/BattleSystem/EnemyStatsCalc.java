package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;

public class EnemyStatsCalc {

    private AllEnemies ae = new AllEnemies();
    private Enemy test = new Enemy();

    private int[] stats = new int[6];

    public EnemyStatsCalc() {

    }

    protected void statscalc(int enemy, int level) {
        for (int i = 0; i < ae.getEnemies().length; i++) {
            if (ae.getEnemies()[i].getEnemyId() == enemy) {
                test = ae.getEnemies()[i];
                break;
            }
        }

        stats[0] = test.getAtk() * level;
        stats[1] = test.getDef() * level;
        stats[2] = test.getMag() * level;
        stats[3] = test.getSpr() * level;
        stats[4] = test.getMax_hp() * level;
        stats[5] = test.getMax_mp() * level;
    }

    public int[] getStats() {
        return stats;
    }
}
