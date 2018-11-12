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
                if (sa.getId() != 0) {
                    skillarray[1][0] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill1.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });

        btn_skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sa.getId() != 0) {
                    skillarray[1][1] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill2.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });

        btn_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sa.getId() != 0) {
                    skillarray[1][2] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill3.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });

        btn_skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sa.getId() != 0) {
                    skillarray[1][3] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill4.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });

        btn_skill5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sa.getId() != 0) {
                    skillarray[1][4] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill5.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });

        btn_skill6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sa.getId() != 0) {
                    skillarray[1][5] = sa.getId();
                    for (int i = 0; i <= skilllist.length; i++) {
                        if (sa.getId() == skilllist[i].getSkillid()) {
                            btn_skill6.setText(String.valueOf(skilllist[i].getSpellname()));
                            break;
                        }
                    }
                } else {
                    showToast();
                }
            }
        });
    }

    protected void showToast() {
        Toast.makeText(getContext(), "No skill selected", Toast.LENGTH_SHORT).show();
    }

    public int[][] getSkillarray() {
        return skillarray;
    }
}
