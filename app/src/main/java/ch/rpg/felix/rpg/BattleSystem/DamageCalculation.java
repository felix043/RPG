package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;

public class DamageCalculation {

    private Player player = new Player();
    private Enemy enemy = new Enemy();
    private AllEnemies as = new AllEnemies();

    private int damage;

    protected int calcPlMagDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) (Math.pow(player.getMag(), 2) / as.getEnemies()[i].getSpr() * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcPlPhyDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) (Math.pow(player.getAtk(), 2) / as.getEnemies()[i].getDef() * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcPlHybDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) ((Math.pow(player.getAtk(), 2) / as.getEnemies()[i].getDef() * modifier + Math.pow(player.getMag(), 2) / as.getEnemies()[i].getSpr() * modifier) / 2);
                break;
            }
        }
        return damage;
    }

    protected int calcEnMagDmg(double modifier, int enemytype) {
        damage = (int) ((Math.pow(enemy.getMag(), 2) / player.getSpr()) * modifier);
        return damage;
    }

    protected int calcEnPhyDmg(double modifier, int enemytype) {
        damage = (int) ((Math.pow(enemy.getAtk(), 2) / player.getDef()) * modifier);
        return damage;
    }

    protected int calcEnHybDmg(double modifier, int enemytype) {
        damage = (int) (((Math.pow(player.getMag(), 2) / enemy.getSpr()) * modifier + (Math.pow(player.getAtk(), 2) / enemy.getDef()) * modifier) / 2);
        return damage;
    }
}
