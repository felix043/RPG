package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.AI;

public class AllConditions {

    //Stats: [1, enemyhealth, maxenemyhealth, enemy_atk, enemy_mag, enemy_def, enemy_spr, round]
    AI more50hp = new AI(1, 2, 1, 0.5, true, new AI[0], 2, 0);
    AI more75hp = new AI(1, 2, 1, 0.75, true, new AI[0], 2, 1);

}
