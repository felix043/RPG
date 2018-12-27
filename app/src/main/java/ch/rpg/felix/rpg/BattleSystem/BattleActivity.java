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

import java.util.concurrent.ThreadLocalRandom;

import ch.rpg.felix.rpg.BattleSystem.Data.AllEnemies;
import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.Player.ChangeSkillsFragment;
import ch.rpg.felix.rpg.R;
import ch.rpg.felix.rpg.WorldFragmentChildren.WorldData;

public class BattleActivity extends AppCompatActivity {

    private Dialog dialog;
    private Player p = new Player();
    private Enemy e = new Enemy();
    private ChangeSkillsFragment csf = new ChangeSkillsFragment();
    private AllEnemies ae = new AllEnemies();
    private AllSkills as = new AllSkills();
    private Gson gson = new Gson();
    private EnemyStatsCalc enemyStatsCalc = new EnemyStatsCalc();
    private DamageCalculation dc = new DamageCalculation();
    private WorldData wd = new WorldData();

    private int current_playerhp;
    private int current_playermp;
    private int current_enemyhp;
    private int current_enemymp;

    private int lastplayerdmg;
    private int lastenemydmg;
    private int lastplayerattacktype;
    private int lastenemyskill = 0;
    private int playerhppc = 100;
    private int enemyhppc = 100;
    private int turncount;

    private String x;
    private String y;
    private String z;

    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private TextView maxPlayerHp, currentPlayerHp, maxPlayerMp, currentPlayerMp, maxEnemyHp, currentEnemyHp, maxEnemyMp, currentEnemyMp, enemyname, enemylevel;
    private ProgressBar playerhpbar, playermpbar, enemyhpbar, enemympbar;

    //Get data for enemy level and type from button
    private int enemy_level;
    private int enemy_type;

    private String json = csf.getJson();
    private int equippedSkills[];
    private Skills[] skilllist = as.skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        loadEnemy();

        loadPlayerEnemyStats();
        showSkills();
        showBattleprogress();
        playerSkillBtn();
        dialog = new Dialog(this);
    }


    private void loadEnemy() {
        Bundle extras = getIntent().getExtras();
        x = extras.getString("x");
        y = extras.getString("y");
        z = extras.getString("z");

        e = ae.getEnemies()[enemyStatsCalc.getEnemynr()];

        enemy_level = ae.getEnemyComposition()[Integer.parseInt(x)][Integer.parseInt(y)][Integer.parseInt(z)].getLevel();
        enemy_type = ae.getEnemyComposition()[Integer.parseInt(x)][Integer.parseInt(y)][Integer.parseInt(z)].getEnemy();

        enemyStatsCalc.statscalc(enemy_type, enemy_level);
    }

    private void loadPlayerEnemyStats() {
        current_enemyhp = enemyStatsCalc.getStats()[4];
        current_enemymp = enemyStatsCalc.getStats()[5];
        current_playerhp = p.getMax_hp();
        current_playermp = p.getMax_mp();
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

        for (int i = 0; i < ae.getEnemies().length; i++) {
            if (ae.getEnemies()[i].getEnemyId() == enemy_type) {
                enemyname.setText(ae.getEnemies()[i].getName());
            }
        }

        enemylevel.setText(String.valueOf(enemy_level));

        maxPlayerHp.setText(String.valueOf(p.getMax_hp()));
        maxPlayerMp.setText(String.valueOf(p.getMax_mp()));
        maxEnemyHp.setText(String.valueOf(enemyStatsCalc.getStats()[4]));
        maxEnemyMp.setText(String.valueOf(enemyStatsCalc.getStats()[5]));

        currentPlayerHp.setText(String.valueOf(p.getMax_hp()));
        currentPlayerMp.setText(String.valueOf(p.getMax_mp()));
        currentEnemyHp.setText(String.valueOf(current_enemyhp));
        currentEnemyMp.setText(String.valueOf(enemyStatsCalc.getStats()[5]));

        playerhpbar.setMax(p.getMax_hp());
        playermpbar.setMax(p.getMax_mp());
        enemyhpbar.setMax(enemyStatsCalc.getStats()[4]);
        enemympbar.setMax(enemyStatsCalc.getStats()[5]);

        playerhpbar.setProgress(p.getMax_hp());
        playermpbar.setProgress(p.getMax_mp());
        enemyhpbar.setProgress(enemyStatsCalc.getStats()[4]);
        enemympbar.setProgress(enemyStatsCalc.getStats()[5]);
    }

    private void showBattleprogress() {
        currentPlayerHp = findViewById(R.id.current_playerhp);
        currentPlayerMp = findViewById(R.id.current_playermp);
        currentEnemyHp = findViewById(R.id.current_enemyhp);
        currentEnemyMp = findViewById(R.id.current_enemymp);
    }

    private void loadData() {
        SharedPreferences sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        json = sharedPref.getString("skill list", null);
        equippedSkills = gson.fromJson(json, int[].class);
    }

    protected void showSkills() {
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
                for (int j = 0; j < skilllist.length; j++) {
                    if (equippedSkills[i] == as.getSkills()[j].getSkillid()) {
                        buttonarray[i].setText(String.valueOf(skilllist[j].getSpellname()));
                    }
                }
            }
        }
    }

    protected void updateStats() {
        currentEnemyHp.setText(String.valueOf(current_enemyhp));
        enemyhpbar.setProgress(current_enemyhp);

        currentEnemyMp.setText(String.valueOf(current_enemymp));
        enemympbar.setProgress(current_enemymp);

        currentPlayerHp.setText(String.valueOf(current_playerhp));
        playerhpbar.setProgress(current_playerhp);

        currentPlayerMp.setText(String.valueOf(current_playermp));
        playermpbar.setProgress(current_playermp);
    }

    private void playerSkillBtn() {
        showSkills();
        btn_skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(0);
            }
        });

        btn_skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(1);
            }
        });

        btn_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(2);
            }
        });

        btn_skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(3);
            }
        });

        btn_skill5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(4);
            }
        });

        btn_skill6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerAttack(5);
            }
        });
    }

    private void enemyAttack() {
        final int enemy = e.getAi().checkRule(new int[][]{new int[]{1, current_playerhp, p.getMax_hp(), current_playermp, p.getMax_mp(), p.getAtk(), p.getMag(), p.getDef(), p.getSpr(),
                current_enemyhp, enemyStatsCalc.getStats()[4], current_enemymp, enemyStatsCalc.getStats()[5], enemyStatsCalc.getStats()[0], enemyStatsCalc.getStats()[1], enemyStatsCalc.getStats()[2], enemyStatsCalc.getStats()[3],
                lastplayerdmg, lastenemydmg, 0, 0, lastplayerattacktype, lastenemyskill, playerhppc, enemyhppc, turncount, generateRandomNr()},
                new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}});

        if (e.getSkillArray()[enemy].getType() == 3) {
            lastenemydmg = dc.calcEnHybDmg(e.getSkillArray()[enemy].getModifier(), enemy_type);
            current_playerhp -= lastenemydmg;
        } else if (e.getSkillArray()[enemy].getType() == 1) {
            lastenemydmg = dc.calcEnPhyDmg(e.getSkillArray()[enemy].getModifier(), enemy_type);
            current_playerhp -= lastenemydmg;
        } else {
            lastenemydmg = dc.calcEnMagDmg(e.getSkillArray()[enemy].getModifier(), enemy_type);
            current_playerhp -= lastenemydmg;
        }

        Button btn_test = findViewById(R.id.testtest);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("testtest", String.valueOf(enemy));
            }
        });
        lastenemyskill = e.getSkillArray()[enemy].getSkillid();
        playerhppc = (current_playerhp / p.getMax_hp()) * 100;
        current_enemymp -= e.getSkillArray()[enemy].getMp_cost();
        updateStats();

        if (isPlayerAlive()) {

        } else {
            showBattleresult();
        }
    }

    private void playerAttack(int equippedSkillPos) {
        for (int i = 0; i < as.getSkills().length; i++) {
            if (as.getSkills()[i].getSkillid() == equippedSkills[equippedSkillPos]) {
                if (as.getSkills()[i].getMp_cost() > current_playermp) {
                    Toast.makeText(this, "You do not have enough mana lol", Toast.LENGTH_SHORT).show();
                } else {
                    double modifier = as.getSkills()[i].getModifier();
                    int type = as.getSkills()[i].getType();

                    calculatePDmg(modifier, type, enemy_type);
                    current_playermp -= as.getSkills()[i].getMp_cost();
                    current_enemyhp -= calculatePDmg(modifier, type, enemy_type);
                    enemyhppc = (current_enemyhp / e.getMax_hp()) * 100;

                    updateStats();
                    if (isEnemyAlive()) {
                        enemyAttack();
                    } else {
                        showBattleresult();
                    }
                }
            }
        }
    }

    private int calculatePDmg(double modifier, int type, int enemy_type) {
        if (type == 2) {
            lastplayerattacktype = 2;
            lastplayerdmg = dc.calcPlMagDmg(modifier, enemy_type);
            return lastplayerdmg;
        }
        if (type == 1) {
            lastplayerattacktype = 1;
            lastplayerdmg = dc.calcPlPhyDmg(modifier, enemy_type);
            return lastplayerdmg;
        }
        lastplayerattacktype = 3;
        lastplayerdmg = dc.calcPlHybDmg(modifier, enemy_type);
        return lastplayerdmg;
    }

    private boolean isEnemyAlive() {
        boolean isEnemyalive = true;
        if (current_enemyhp <= 0) {
            isEnemyalive = false;
        }
        return isEnemyalive;
    }

    private boolean isPlayerAlive() {
        boolean isPlayeralive = true;
        if (current_playerhp <= 0) {
            isPlayeralive = false;
        }
        return isPlayeralive;
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

        xpForNextLevel = p.getExpForNextLv();
        currentXpObtained = p.getExpObtained();
        txt_currentPlayerxp.setText(String.valueOf(currentXpObtained));
        txt_xpForNextLevel.setText(String.valueOf(xpForNextLevel));
        pb_xpoptainedafterbattle.setMax(xpForNextLevel);
        pb_xpoptainedafterbattle.setProgress(currentXpObtained);

        if (current_enemyhp <= 0) {
            battleresult.setText("You won!");
            saveData();
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

    private void saveData() {

    }

    private int generateRandomNr() {
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }

    public int getEnemy_level() {
        return enemy_level;
    }

    public int getEnemy_type() {
        return enemy_type;
    }
}