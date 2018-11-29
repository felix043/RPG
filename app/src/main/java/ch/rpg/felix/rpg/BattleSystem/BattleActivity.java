package ch.rpg.felix.rpg.BattleSystem;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;
import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.Player.ChangeSkillsFragment;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    private Dialog dialog;
    private Player player;
    private Enemy enemy;
    private ChangeSkillsFragment csf = new ChangeSkillsFragment();
    private AllEnemies ae = new AllEnemies();
    private AllSkills as = new AllSkills();

    private Gson gson = new Gson();

    private String json = csf.getJson();
    private int equippedSkills[] = csf.getEquippedSkills();
    private Skills[] skilllist = as.skills;
    private int current_playerhp;
    private int current_enemyhp;

    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private TextView currentPlayerHp, currentPlayerMp, currentEnemyHp, currentEnemyMp, maxPlayerHp, maxPlayerMp, maxEnemyHp, maxEnemyMp;
    private ProgressBar playerhpbar, playermpbar, enemyhpbar, enemympbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        loadEnemy();
        //loadPlayerEnemyStats();
        showSkills();
        showBattleprogress();
        dialog = new Dialog(this);
    }

    private void loadEnemy() {
        Button testtest = (Button) findViewById(R.id.testtest);

        Bundle extras = getIntent().getExtras();
        final String x = extras.getString("x");
        final String y = extras.getString("y");

    }

    private void loadPlayerEnemyStats() {
        maxPlayerHp = (TextView) findViewById(R.id.max_playerhp);
        maxPlayerMp = (TextView) findViewById(R.id.max_playermp);
        maxEnemyHp = (TextView) findViewById(R.id.max_enemyhp);
        maxEnemyMp = (TextView) findViewById(R.id.max_enemymp);

        currentPlayerHp = (TextView) findViewById(R.id.current_playerhp);
        currentPlayerMp = (TextView) findViewById(R.id.current_playermp);
        currentEnemyHp = (TextView) findViewById(R.id.current_enemyhp);
        currentEnemyMp = (TextView) findViewById(R.id.current_enemymp);

        playerhpbar = (ProgressBar) findViewById(R.id.player_healthBar);
        playermpbar = (ProgressBar) findViewById(R.id.player_manaBar);
        enemyhpbar = (ProgressBar) findViewById(R.id.enemy_healthBar);
        enemympbar = (ProgressBar) findViewById(R.id.enemy_manaBar);

        maxPlayerHp.setText(String.valueOf(player.getMax_hp()));
        maxPlayerMp.setText(String.valueOf(player.getMax_mp()));
        maxEnemyHp.setText(String.valueOf(enemy.getMax_hp()));
        maxEnemyMp.setText(String.valueOf(enemy.getMax_mp()));

        currentPlayerHp.setText(String.valueOf(player.getMax_hp()));
        currentPlayerMp.setText(String.valueOf(player.getMax_mp()));
        currentEnemyHp.setText(String.valueOf(enemy.getMax_hp()));
        currentEnemyMp.setText(String.valueOf(enemy.getMax_mp()));

        playerhpbar.setMax(player.getMax_hp());
        playermpbar.setMax(player.getMax_mp());
        enemyhpbar.setMax(enemy.getMax_hp());
        enemympbar.setMax(enemy.getMax_mp());

        playerhpbar.setProgress(player.getMax_hp());
        playermpbar.setProgress(player.getMax_mp());
        enemyhpbar.setProgress(enemy.getMax_hp());
        enemympbar.setProgress(enemy.getMax_mp());
    }

    private void showBattleprogress() {
        currentPlayerHp = (TextView) findViewById(R.id.current_playerhp);
        currentPlayerMp = (TextView) findViewById(R.id.current_playermp);
        currentEnemyHp = (TextView) findViewById(R.id.current_enemyhp);
        currentEnemyMp = (TextView) findViewById(R.id.current_enemymp);
    }

    private void showSkills() {
        btn_skill1 = (Button) findViewById(R.id.btn_skillone);
        btn_skill2 = (Button) findViewById(R.id.btn_skilltwo);
        btn_skill3 = (Button) findViewById(R.id.btn_skillthree);
        btn_skill4 = (Button) findViewById(R.id.btn_skillfour);
        btn_skill5 = (Button) findViewById(R.id.btn_skillfive);
        btn_skill6 = (Button) findViewById(R.id.btn_skillsix);

        Button[] buttonarray = new Button[]{btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6};
        loadData();
        for (int i = 0; i < equippedSkills.length; i++) {
            if (equippedSkills[i] != 0) {
                Log.d("12345oncreate", Arrays.toString(equippedSkills));
                buttonarray[i].setText(String.valueOf(skilllist[equippedSkills[i] - 2].getSpellname()));
            }
        }
    }

    private void loadData() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        json = sharedPref.getString("skill list", null);
        equippedSkills = gson.fromJson(json, int[].class);
    }

    public boolean fight() {
        loadPlayerEnemyStats();

        current_playerhp = player.getMax_hp();
        current_enemyhp = enemy.getMax_hp();

        while (true) {
            if (current_playerhp <= 0) {
                break;
            } else {
                playerAttack();
            }

            if (current_enemyhp <= 0) {
                break;
            } else {
                //int damagetoplayer = enemy.attack(new int[]{1, current_enemyhp, enemy.getMax_hp(), current_enemyhp, enemy.getMax_mp()});
            }
        }

        if (current_playerhp > 0 && current_enemyhp <= 0) {
            showBattleresult();
            return true;
        } else {
            showBattleresult();
            return false;
        }
    }

    public void playerAttack() {
        Button test = (Button) findViewById(R.id.btn_skillone);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int damage;
                damage = current_enemyhp - 5;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

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

        xpForNextLevel = player.getExpForNextLv();
        currentXpObtained = player.getExpObtained();
        txt_currentPlayerxp.setText(String.valueOf(currentXpObtained));
        txt_xpForNextLevel.setText(String.valueOf(xpForNextLevel));
        pb_xpoptainedafterbattle.setMax(xpForNextLevel);
        pb_xpoptainedafterbattle.setProgress(currentXpObtained);

        if (current_enemyhp <= 0) {
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
}