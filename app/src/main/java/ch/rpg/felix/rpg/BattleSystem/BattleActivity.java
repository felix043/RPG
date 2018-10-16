package ch.rpg.felix.rpg.BattleSystem;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;
import ch.rpg.felix.rpg.Player.Player;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    //TODO Rewrite class at a later point for more flexibility (e.g different skills)

    Dialog dialog;
    Player player = new Player();
    Enemies enemies = new Enemies();
    Skills skills = new Skills();

    private int current_enemyHp;
    private int current_playerHp;

    private void showBattleresult() {
        dialog.setContentView(R.layout.popup_battleresult);
        Button btn_home = (Button) dialog.findViewById(R.id.btn_home);
        Button btn_nextstage = (Button) dialog.findViewById(R.id.btn_nextstage);
        TextView battleresult = (TextView) dialog.findViewById(R.id.txt_battleresult);

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
            enemies.Rat();
            getEnemyStats();
        } else if (stage1 == 12) {
            enemies.Goblin();
            getEnemyStats();
        } else if (stage1 == 13) {
            enemies.Ogre();
            getEnemyStats();
        }
    }

    private void playerAttack() {
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);
        ProgressBar enemy_hpbar = (ProgressBar) findViewById(R.id.enemy_healthBar);

        current_enemyHp = enemy_hpbar.getProgress();
        current_enemyHp = current_enemyHp - skills.getDamage();
        enemy_hpbar.setProgress(current_enemyHp);
        enemyHp.setText(current_enemyHp + " / " + String.valueOf(enemies.getEnemy_hp()));
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

        skills.slash();
        btnSkill1.setText(skills.getName());
        skills.punch();
        btnSkill2.setText(skills.getName());
    }

    private void BtnSkill() {
        final Button btnSkill1 = (Button) findViewById(R.id.btn_skillone);
        final Button btnSkill2 = (Button) findViewById(R.id.btn_skilltwo);

        btnSkill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skills.slash();
                playerAttack();
                enemyAttack();
                endBattle();
            }
        });

        btnSkill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack();
                skills.punch();
                enemyAttack();
                endBattle();
            }
        });
    }

    private void endBattle() {
        TextView playerHp = (TextView) findViewById(R.id.player_maxHp);
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);

        if (current_enemyHp <= 0) {
            current_enemyHp = 0;
            enemyHp.setText(current_enemyHp + " / " + String.valueOf(enemies.getEnemy_hp()));
            showBattleresult();
        } else if (current_playerHp <= 0) {
            current_playerHp = 0;
            playerHp.setText(current_playerHp + " / " + String.valueOf(player.getPlayer_max_hp()));
            showBattleresult();
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