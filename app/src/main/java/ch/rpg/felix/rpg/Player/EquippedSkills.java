package ch.rpg.felix.rpg.Player;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import ch.rpg.felix.rpg.R;

public class EquippedSkills extends AppCompatActivity {

    Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;

    public void Btn_Skills() {
        btn_skill1 = (Button) findViewById(R.id.btn_skillone);
        btn_skill2 = (Button) findViewById(R.id.btn_skilltwo);
        btn_skill3 = (Button) findViewById(R.id.btn_skillthree);
        btn_skill4 = (Button) findViewById(R.id.btn_skillfour);
        btn_skill5 = (Button) findViewById(R.id.btn_skillfive);
        btn_skill6 = (Button) findViewById(R.id.btn_skillsix);
    }
}
