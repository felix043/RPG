package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.AI;

public class AllConditions {

    //Stats: [1, enemyhealth, maxenemyhealth, enemy_atk, enemy_mag, enemy_def, enemy_spr, round]
    //AI more50hp = new AI(1, 2, 1, 0.5, true, new AI[0], 2, 0);
    //AI more75hp = new AI(1, 2, 1, 0.75, true, new AI[0], 2, 1);

    AI doPunch = new AI(0, 3, 1, 1, 0, 1, true, new AI[0], 3, 2);
    AI doStab = new AI(0, 3, 1, 1, 1, 1, true, new AI[0], 3, 3);
    AI doSlash = new AI(0, 3, 1, 1, 2, 1, true, new AI[0], 3, 4);
    AI doHeal = new AI(0, 3, 1, 1, 3, 1, true, new AI[0], 3, 5);
    AI doBoostAttack = new AI(0, 3, 1, 1, 5, 1, true, new AI[0], 3, 7);
    AI doFireball = new AI(0, 3, 1, 1, 6, 1, true, new AI[0], 3, 8);
    AI doEarthquake = new AI(0, 3, 1, 1, 7, 1, true, new AI[0], 3, 9);
    AI doLightning = new AI(0, 3, 1, 1, 8, 1, true, new AI[0], 3, 10);

    AI failPunchB = new AI(0, 3, 1, 1, 0, 1, true, new AI[0], 2, 1);
    AI failStabM = new AI(0, 3, 1, 1, 1, 1, true, new AI[0], 2, 6);
    AI failSlashM = new AI(0, 3, 1, 1, 2, 1, true, new AI[0], 2, 6);
    AI failHeal0 = new AI(0, 3, 1, 1, 3, 1, true, new AI[0], 2, 0);
    AI failHealM = new AI(0, 3, 1, 1, 3, 1, true, new AI[0], 2, 6);
    AI failBoostAttack0 = new AI(0, 3, 1, 1, 5, 1, true, new AI[0], 2, 0);
    AI failFireballB = new AI(0, 3, 1, 1, 6, 1, true, new AI[0], 2, 1);
    AI failFireball0 = new AI(0, 3, 1, 1, 6, 1, true, new AI[0], 2, 0);
    AI failEarthquake0 = new AI(0, 3, 1, 1, 7, 1, true, new AI[0], 2, 0);
    AI failLightningB = new AI(0, 3, 1, 1, 8, 1, true, new AI[0], 2, 1);
    AI failLightningM = new AI(0, 3, 1, 1, 8, 1, true, new AI[0], 2, 6);

    AI playerMoreHp = new AI(0, 1, 1, 0, 9, 1, true, new AI[0], 2, 11);
    AI playerLessHp = new AI(0, 1, 1, 0, 9, 1, true, new AI[0], 1, 12);

    AI pAttackMagic = new AI(0, 21, 1, 1, 0, 2, false, new AI[]{doFireball, failFireballB}, 0, -1);
    AI pAttackNotMagic = new AI(0, 21, 1, 1, 0, 2, false, new AI[]{doPunch, failPunchB}, 5, -1);
    AI randomMore95 = new AI(0, 23, 1, 0, 0, 95, true, new AI[0], 4, 1);
    AI randomLess95 = new AI(0, 23, 1, 0, 0, 95, false, new AI[]{doHeal, failHeal0}, 1, -1);
    AI randomMore90a = new AI(0, 23, 1, 0, 0, 90, false, new AI[]{randomMore95, randomLess95}, 4, -1);
    AI randomLess90a = new AI(0, 23, 1, 0, 0, 90, false, new AI[]{doEarthquake, failEarthquake0}, 1, -1);
    AI randomMore90b = new AI(0, 23, 1, 0, 0, 90, true, new AI[0], 4, 0);
    AI randomLess90b = new AI(0, 23, 1, 0, 0, 90, false, new AI[]{doHeal, failHealM}, 1, -1);
    AI randomMore80 = new AI(0, 23, 1, 0, 0, 80, false, new AI[]{randomMore90a, randomLess90a}, 4, -1);
    AI randomLess80 = new AI(0, 23, 1, 0, 0, 80, false, new AI[]{doBoostAttack, failBoostAttack0}, 1, -1);
    AI randomMore70 = new AI(0, 23, 1, 0, 0, 70, false, new AI[]{randomMore90b, randomLess90b}, 4, -1);
    AI randomLess70 = new AI(0, 23, 1, 0, 0, 70, false, new AI[]{doLightning, failLightningM}, 1, -1);
    AI randomMore50a = new AI(0, 23, 1, 0, 0, 50, false, new AI[]{randomMore70, randomLess70}, 4, -1);
    AI randomLess50a = new AI(0, 23, 1, 0, 0, 50, false, new AI[]{doSlash, failSlashM}, 1, -1);
    AI randomMore50b = new AI(0, 23, 1, 0, 0, 50, false, new AI[]{randomMore80, randomLess80}, 4, -1);
    AI randomLess50b = new AI(0, 23, 1, 0, 0, 50, false, new AI[]{doFireball, failFireball0}, 1, -1);
    AI randomMore30 = new AI(0, 23, 1, 0, 0, 30, false, new AI[]{randomMore50a, randomLess50a}, 4, -1);
    AI randomLess30 = new AI(0, 23, 1, 0, 0, 30, false, new AI[]{doStab, failStabM}, 1, -1);

    AI turn4 = new AI(0, 22, 1, 1, 0, 4, false, new AI[]{doLightning, failLightningB}, 6, -1);
    AI turnNot4 = new AI(0, 22, 1, 1, 0, 4, false, new AI[]{randomMore30, randomLess30}, 7, -1);
    AI eHpMore10pc = new AI(0, 9, 1, 0, 9, 0.1, false, new AI[]{randomMore50b, randomLess50b}, 4, -1);
    AI eHpLess10pc = new AI(0, 9, 1, 0, 9, 0.1, false, new AI[]{playerMoreHp, playerLessHp}, 1, -1);
    AI eHpMore50pc = new AI(0, 9, 1, 0, 9, 0.5, false, new AI[]{turn4, turnNot4}, 4, -1);
    AI eHpLess50pc = new AI(0, 9, 1, 0, 9, 0.5, false, new AI[]{eHpMore10pc, eHpLess10pc}, 1, -1);
    AI eHpMore70pc = new AI(0, 9, 1, 0, 9, 0.7, false, new AI[]{pAttackMagic, pAttackNotMagic}, 4, -1);
    AI eHpLess70pc = new AI(0, 9, 1, 0, 9, 0.7, false, new AI[]{eHpMore50pc, eHpLess50pc}, 1, -1);
}
