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
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Arrays;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;
import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.Player.ChangeSkillsFragment;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    private Dialog dialog;
    private Player player = new Player();
    private Enemy enemy = new Enemy();
    private ChangeSkillsFragment csf = new ChangeSkillsFragment();
    private AllEnemies ae = new AllEnemies();
    private AllSkills as = new AllSkills();
    private Gson gson = new Gson();
    private EnemyStatsCalc enemyStatsCalc = new EnemyStatsCalc();
    private DamageCalculation dc = new DamageCalculation();

    private String json = csf.getJson();
    private int equippedSkills[];
    private Skills[] skilllist = as.skills;

    private int current_playerhp;
    private int current_playermp;
    private int current_enemyhp;

    //Get data for enemy level and type from button
    private int enemy_level;
    private int enemy_type;

    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private TextView maxPlayerHp, currentPlayerHp, maxPlayerMp, currentPlayerMp, maxEnemyHp, currentEnemyHp, maxEnemyMp, currentEnemyMp, enemyname, enemylevel;
    private ProgressBar playerhpbar, playermpbar, enemyhpbar, enemympbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        loadEnemy();
        loadPlayerEnemyStats();
        showSkills();
        showBattleprogress();
        playerAttack();
        dialog = new Dialog(this);
    }

    private void loadEnemy() {
        Button btn_test = findViewById(R.id.testtest);

        Bundle extras = getIntent().getExtras();
        final String x = extras.getString("x");
        final String y = extras.getString("y");

        enemy_level = ae.getEnemyComposition()[Integer.parseInt(x)][Integer.parseInt(y)].getLevel();
        enemy_type = ae.getEnemyComposition()[Integer.parseInt(x)][Integer.parseInt(y)].getEnemy();

        enemyStatsCalc.statscalc(enemy_type, enemy_level);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("testtest", String.valueOf("EnemyHp: " + current_enemyhp + " EquippedSkill: " + csf.getEquippedSkills()[0] + " Skilllist: " + as.getSkills()[6].getSpellname()));
            }
        });
    }

    private void loadPlayerEnemyStats() {
        current_enemyhp = enemyStatsCalc.getStats()[4];
        current_playerhp = player.getMax_hp();
        current_playermp = player.getMax_mp();
        enemyname = findViewById(R.id.enemy_name);
        enemylevel = findViewById(R.id.enemy_level);

        maxPlayerHp = findViewById(R.id.max_playerhp);
        maxPlayerMp = findViewById(R.id.max_playermp);
        maxEnemyHp = findViewById(R.id.max_enemyhp);
        maxEnemyMp = findViewById(R.id.max_enemymp);

        currentPlayerHp = findViewById(R.id.current_playerhp);
        currentPlayerMp = findViewById(R.id.current_playermp);
        currentEnemyHp = findViewById(R.id.current_enemyhp);
        currentEnemyMp = findViewById(R.id.current_enemymp);

        playerhpbar = findViewById(R.id.player_healthBar);
        playermpbar = findViewById(R.id.player_manaBar);
        enemyhpbar = findViewById(R.id.enemy_healthBar);
        enemympbar = findViewById(R.id.enemy_manaBar);

        enemyname.setText(ae.getEnemies()[enemy_type - 1].getName());
        enemylevel.setText(String.valueOf(enemy_level));

        maxPlayerHp.setText(String.valueOf(player.getMax_hp()));
        maxPlayerMp.setText(String.valueOf(player.getMax_mp()));
        maxEnemyHp.setText(String.valueOf(enemyStatsCalc.getStats()[4]));
        maxEnemyMp.setText(String.valueOf(enemyStatsCalc.getStats()[5]));

        currentPlayerHp.setText(String.valueOf(player.getMax_hp()));
        currentPlayerMp.setText(String.valueOf(player.getMax_mp()));
        currentEnemyHp.setText(String.valueOf(current_enemyhp));
        currentEnemyMp.setText(String.valueOf(enemyStatsCalc.getStats()[5]));

        playerhpbar.setMax(player.getMax_hp());
        playermpbar.setMax(player.getMax_mp());
        enemyhpbar.setMax(enemyStatsCalc.getStats()[4]);
        enemympbar.setMax(enemyStatsCalc.getStats()[5]);

        playerhpbar.setProgress(player.getMax_hp());
        playermpbar.setProgress(player.getMax_mp());
        enemyhpbar.setProgress(enemyStatsCalc.getStats()[4]);
        enemympbar.setProgress(enemyStatsCalc.getStats()[5]);
    }

    private void showBattleprogress() {
        currentPlayerHp = findViewById(R.id.current_playerhp);
        currentPlayerMp = findViewById(R.id.current_playermp);
        currentEnemyHp = findViewById(R.id.current_enemyhp);
        currentEnemyMp = findViewById(R.id.current_enemymp);
    }

    private void showSkills() {
        btn_skill1 = findViewById(R.id.btn_skillone);
        btn_skill2 = findViewById(R.id.btn_skilltwo);
        btn_skill3 = findViewById(R.id.btn_skillthree);
        btn_skill4 = findViewById(R.id.btn_skillfour);
        btn_skill5 = findViewById(R.id.btn_skillfive);
        btn_skill6 = findViewById(R.id.btn_skillsix);

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

        //enemy.getAi().checkRule(new int[1]);
        int index = new AI(0, 0, 0, 0, 0, 0, true, new AI[0], 0, 0).checkRule(new int[][]{new int[]{current_enemyhp, current_playerhp}});

        /*
        while (true) {
            if (current_playerhp <= 0) {
                break;
            } else {

            }

            if (current_enemyhp <= 0) {
                break;
            } else {
                //int damagetoplayer = enemy.attack(new int[]{1, current_enemyhp, enemy.getMax_hp(), current_enemyhp, enemy.getMax_mp()});
            }
        }*/

        if (current_playerhp > 0 && current_enemyhp <= 0) {
            showBattleresult();
            return true;
        } else {
            showBattleresult();
            return false;
        }
    }

    private void playerAttack() {
        btn_skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(0);
            }
        });

        btn_skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(1);
            }
        });

        btn_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(2);
            }
        });

        btn_skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(3);
            }
        });

        btn_skill5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(4);
            }
        });

        btn_skill6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerattackloop(5);
            }
        });
    }

    private void playerattackloop(int equippedSkillPos) {
        for (int i = 0; i < as.getSkills().length; i++) {
            if (as.getSkills()[i].getSkillid() == equippedSkills[equippedSkillPos]) {
                if (as.getSkills()[i].getMp_cost() > current_playermp) {
                    Toast.makeText(this, "You do not have enough mana lol", Toast.LENGTH_SHORT).show();
                } else {
                    double modifier = as.getSkills()[i].getModifier();
                    int type = as.getSkills()[i].getType();
                    calculateDmg(modifier, type, enemy_type);
                    current_playermp -= as.getSkills()[i].getMp_cost();
                    current_enemyhp -= calculateDmg(modifier, type, enemy_type);
                }
                updateStats();
            }
        }
    }

    private int calculateDmg(double modifier, int type, int enemy_type) {
        if (type == 2) {
            return dc.calcPlMagDmg(modifier, enemy_type);
        }
        if (type == 1) {
            return dc.calcPlPhyDmg(modifier, enemy_type);
        }
        return dc.calcPlHybDmg(modifier, enemy_type);
    }

    private void updateStats() {
        currentEnemyHp.setText(String.valueOf(current_enemyhp));
        enemyhpbar.setProgress(current_enemyhp);

        currentPlayerMp.setText(String.valueOf(current_playermp));
        playermpbar.setProgress(current_playermp);
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
        Button btn_home = dialog.findViewById(R.id.btn_home);
        Button btn_nextstage = dialog.findViewById(R.id.btn_nextstage);
        TextView txt_currentPlayerxp = dialog.findViewById(R.id.current_playerxp_dialog);
        TextView txt_xpForNextLevel = dialog.findViewById(R.id.xpforlevelup_dialog);
        TextView battleresult = dialog.findViewById(R.id.txt_battleresult);
        ProgressBar pb_xpoptainedafterbattle = dialog.findViewById(R.id.player_xpoptainedafterbattle);

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

    public int getEnemy_level() {
        return enemy_level;
    }

    public int getEnemy_type() {
        return enemy_type;
    }
}