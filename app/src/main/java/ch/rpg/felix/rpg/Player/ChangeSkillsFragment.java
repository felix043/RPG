package ch.rpg.felix.rpg.Player;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;

public class ChangeSkillsFragment extends Fragment {

    protected int skillarray[][] = new int[2][6]; //[row][colums]
    private AllSkills as = new AllSkills();
    private SkillAdapter sa = new SkillAdapter();

    private Button btn_skill1;

    private Button btn_skill2;
    private Button btn_skill3;
    private Button btn_skill4;
    private Button btn_skill5;
    private Button btn_skill6;

    private Skills[] skilllist = as.skills;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_skills, container, false);
        btn_Skills(view);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.skill_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(sa);

        return view;
    }

    public void btn_Skills(View v) {
        for (int i = 0; i < skillarray.length; i++) {
            skillarray[i][0] = i;
            skillarray[i][1] = 0;
        }

        btn_skill1 = (Button) v.findViewById(R.id.btn_skillsetone);
        btn_skill2 = (Button) v.findViewById(R.id.btn_skillsettwo);
        btn_skill3 = (Button) v.findViewById(R.id.btn_skillsetthree);
        btn_skill4 = (Button) v.findViewById(R.id.btn_skillsetfour);
        btn_skill5 = (Button) v.findViewById(R.id.btn_skillsetfive);
        btn_skill6 = (Button) v.findViewById(R.id.btn_skillsetsix);

        btn_skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(0, 0);
            }
        });

        btn_skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(1, 1);
            }
        });

        btn_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(2, 2);
            }
        });

        btn_skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(3, 3);
            }
        });

        btn_skill5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(4, 4);
            }
        });

        btn_skill6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(5, 5);
            }
        });
    }

    private void setSkill(int bpos, int apos) {
        Button[] buttonarray = new Button[]{btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6};

        for (int j = 0; j <= skilllist.length; j++) {
            if (sa.getId() != 0) {
                if (sa.getId() == skilllist[j].getSkillid()) {
                    skillarray[1][apos] = sa.getId();
                    buttonarray[bpos].setText(String.valueOf(skilllist[j].getSpellname()));
                    break;
                }
            } else {
                showToast();
                break;
            }
        }
    }

    private void showToast() {
        Toast.makeText(getContext(), "No skill selected", Toast.LENGTH_SHORT).show();
    }

    public int[][] getSkillarray() {
        return skillarray;
    }
}