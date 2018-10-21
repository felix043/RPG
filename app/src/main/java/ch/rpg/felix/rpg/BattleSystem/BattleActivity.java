package ch.rpg.felix.rpg.BattleSystem;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    Dialog dialog;
    Player player;
    Enemy enemy;
    Skills skills;
    LevelAlgorithm la = new LevelAlgorithm();
    DamageCalculation dc = new DamageCalculation();
    private int round;

    Skills basic = new Skills("Basic Attack", 0.5, 1, 1, 0, 1);
    Skills punch = new Skills("Punch", 1, 1, 1, 2, 1);
    Skills slash = new Skills("Slash", 1.2, 1, 1, 3, 1);
    Skills stab = new Skills("Stab", 1.3, 1, 1, 4, 1);
    Skills bodycheck = new Skills("Bodycheck", 1.4, 1, 1, 4, 1);

    Skills icelance = new Skills("Icelance", 1.5, 1, 1, 5, 2);
    Skills fireball = new Skills("Fireball", 1.6, 1, 1, 10, 2);
    Skills lightning = new Skills("Lightning Strike", 1.7, 1, 1, 15, 2);

    //Stats: [1, enemyhealth, maxenemyhealth, enemy_atk, enemy_mag, enemy_def, enemy_spr, round]
    AI more50hp = new AI(1, 2, 1, 0.5, true, new AI[0], 2, 0);
    AI more75hp = new AI(1, 2, 1, 0.75, true, new AI[0], 2, 1);
    AI goblinAI = new AI(0, 0, 0, 0, false, new AI[]{more75hp, more50hp}, 0, -1);

    Enemy goblin = new Enemy("Goblin", 1, 10, 5, 10, 5, 2, 1, 3, 1, new Skills[]{basic, punch, bodycheck}, goblinAI);

    private void showBattleresult() {
        int xpForNextLevel;
        int currentXpObtained;

        dialog.setContentView(R.layout.dialog_battleresult);
        Button btn_home = (Button) dialog.findViewById(R.id.btn_home);
        Button btn_nextstage = (Button) dialog.findViewById(R.id.btn_nextstage);
        TextView txt_currentPlayerxp = (TextView) dialog.findViewById(R.id.current_playerxp_dialog);
        TextView txt_xpForNextLevel = (TextView) dialog.findViewById(R.id.xpforlevelup_dialog);
        TextView battleresult = (TextView) dialog.findViewById(R.id.txt_battleresult);
        ProgressBar pb_xpoptainedafterbattle = (ProgressBar) dialog.findViewById(R.id.player_xpoptainedafterbattle);

        xpForNextLevel = la.getExpForNextLv();
        currentXpObtained = la.getExpObtained();
        txt_currentPlayerxp.setText(String.valueOf(currentXpObtained));
        txt_xpForNextLevel.setText(String.valueOf(xpForNextLevel));
        pb_xpoptainedafterbattle.setMax(xpForNextLevel);
        pb_xpoptainedafterbattle.setProgress(currentXpObtained);

        if (current_enemyHp == 0) {
            battleresult.setText("You won!");
        } else {
            battleresult.setText("You lost!");
        }

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onBackPressed();
            }
        });
        btn_nextstage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void getEnemyStats() {
        ProgressBar enemy_hpbar = (ProgressBar) findViewById(R.id.enemy_healthBar);
        TextView enemyName = (TextView) findViewById(R.id.enemy_name);
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);

        enemyName.setText(enemies.getEnemy_name());
        current_enemyHp = enemies.getEnemy_hp();
        enemyHp.setText(current_enemyHp + " / " + String.valueOf(enemies.getEnemy_hp()));
        enemy_hpbar.setMax(enemies.getEnemy_hp());
        enemy_hpbar.setProgress(enemies.getEnemy_hp());
    }

    private void showPlayer() {
        ProgressBar player_hpbar = (ProgressBar) findViewById(R.id.player_healthBar);
        TextView playerHp = (TextView) findViewById(R.id.player_maxHp);

        player_hpbar.setMax(player.getPlayer_max_hp());
        player_hpbar.setProgress(player.getPlayer_max_hp());
        current_playerHp = player.getPlayer_max_hp();
        playerHp.setText(current_playerHp + " / " + String.valueOf(player.getPlayer_max_hp()));
    }

    private void showEnemy() {
        int stage1 = Integer.parseInt(getIntent().getStringExtra("stage"));
        if (stage1 == 11) {
            enemy.Rat();
            getEnemyStats();
        } else if (stage1 == 12) {
            enemy.Goblin();
            getEnemyStats();
        } else if (stage1 == 13) {
            enemy.Ogre();
            getEnemyStats();
        }
    }

    private void playerAttack() {
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);
        ProgressBar enemy_hpbar = (ProgressBar) findViewById(R.id.enemy_healthBar);

        current_enemyHp = enemy_hpbar.getProgress();
        current_enemyHp = current_enemyHp - skills.getDamage();
        enemy_hpbar.setProgress(current_enemyHp);
        enemyHp.setText(current_enemyHp + " / " + String.valueOf(enemy.getEnemy_current_hp()));
    }

    private void enemyAttack() {
        TextView playerHp = (TextView) findViewById(R.id.player_maxHp);
        ProgressBar player_hpbar = (ProgressBar) findViewById(R.id.player_healthBar);

        current_playerHp = player_hpbar.getProgress();
        current_playerHp = current_playerHp - 2;
        player_hpbar.setProgress(current_playerHp);
        playerHp.setText(current_playerHp + " / " + String.valueOf(player.getPlayer_max_hp()));
    }

    private void setSkillnames() {
        final Button btnSkill1 = (Button) findViewById(R.id.btn_skillone);
        final Button btnSkill2 = (Button) findViewById(R.id.btn_skilltwo);

        skills.useFireball();
        btnSkill1.setText(skills.getSpellname());
        skills.useSlash();
        btnSkill2.setText(skills.getSpellname());
    }

    private void BtnSkill() {
        final Button btnSkill1 = (Button) findViewById(R.id.btn_skillone);
        final Button btnSkill2 = (Button) findViewById(R.id.btn_skilltwo);

        btnSkill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skills.usePunch();
                playerAttack();
                enemyAttack();
                endBattle();
            }
        });

        btnSkill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack();
                skills.useFireball();
                enemyAttack();
                endBattle();
            }
        });
    }

    public boolean fight(){
        while (player.getPlayer_current_hp() > 0 && enemy.getEnemy_current_hp() > 0) {
            if (player.getPlayer_current_hp() <= 0) {
                break;
            } else {
                playerAttack();
            }

            if (enemy.getEnemy_current_hp() <= 0) {
                break;
            } else {
                int damagetoplayer = goblin.attack(new int[]{1, goblin.getCurrent_hp(), goblin.getMax_hp()});
            }
        }

        if (player.getPlayer_current_hp() > 0 && enemy.getEnemy_current_hp() <= 0) {
            showBattleresult();
            return true;
        } else {
            showBattleresult();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        dialog = new Dialog(this);
        showEnemy();
        showPlayer();
        setSkillnames();
        BtnSkill();
    }
}