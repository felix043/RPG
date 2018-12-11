package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;

public class DamageCalculation {

    private Player p = new Player();
    private AllEnemies as = new AllEnemies();

    private int damage;

    protected int calcPlMagDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) (Math.pow(p.getMag(), 2) / as.getEnemies()[i].getSpr() * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcPlPhyDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) (Math.pow(p.getAtk(), 2) / as.getEnemies()[i].getDef() * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcPlHybDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) ((Math.pow(p.getAtk(), 2) / as.getEnemies()[i].getDef() * modifier + Math.pow(p.getMag(), 2) / as.getEnemies()[i].getSpr() * modifier) / 2);
                break;
            }
        }
        return damage;
    }

    protected int calcEnMagDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) ((Math.pow(as.getEnemies()[i].getMag(), 2) / p.getSpr()) * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcEnPhyDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) ((Math.pow(as.getEnemies()[i].getAtk(), 2) / p.getDef()) * modifier);
                break;
            }
        }
        return damage;
    }

    protected int calcEnHybDmg(double modifier, int enemytype) {
        for (int i = 0; i < as.getEnemies().length; i++) {
            if (as.getEnemies()[i].getEnemyId() == enemytype) {
                damage = (int) ((Math.pow(as.getEnemies()[i].getAtk(), 2) / p.getDef() * modifier + Math.pow(as.getEnemies()[i].getMag(), 2) / p.getSpr() * modifier) / 2);
                break;
            }
        }
        return damage;
    }
}