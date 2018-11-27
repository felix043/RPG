package ch.rpg.felix.rpg.BattleSystem;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.Player.ChangeSkillsFragment;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    private Dialog dialog;
    private Player player;
    private Enemy enemy;
    private Gson gson = new Gson();
    private ChangeSkillsFragment csf = new ChangeSkillsFragment();
    private AllSkills as = new AllSkills();
    private int round;

    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private int equippedSkills[] = csf.getEquippedSkills();
    private Skills[] skilllist = as.skills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        showSkills();

        dialog = new Dialog(this);
    }

    private void showSkills() {

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

        if (enemy.getCurrent_hp() <= 0) {
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

    public void playerAttack() {
        Button test = (Button) findViewById(R.id.btn_skillone);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int damage;
                damage = enemy.getCurrent_hp() - 5;
            }
        });
    }

    public boolean fight(){
        while (true) {
            if (player.getCurrent_hp() <= 0) {
                break;
            } else {
                playerAttack();
            }

            if (enemy.getCurrent_hp() <= 0) {
                break;
            } else {
                int damagetoplayer = enemy.attack(new int[]{1, enemy.getCurrent_hp(), enemy.getMax_hp(), enemy.getCurrent_mp(), enemy.getMax_mp()});
            }
        }

        if (player.getCurrent_hp() > 0 && enemy.getCurrent_hp() <= 0) {
            showBattleresult();
            return true;
        } else {
            showBattleresult();
            return false;
        }
    }
}