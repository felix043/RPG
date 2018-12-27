package ch.rpg.felix.rpg.Player;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Arrays;

import ch.rpg.felix.rpg.BattleSystem.Data.AllSkills;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;

public class ChangeSkillsFragment extends Fragment {

    private AllSkills as = new AllSkills();
    private SkillAdapter sa = new SkillAdapter();
    private Gson gson = new Gson();

    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private String json;

    private int[] equippedSkills = new int[6];
    private Skills[] skilllist = as.skills;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_skills, container, false);

        Log.d("testtest", Arrays.toString(equippedSkills));

        loadData();

        initializeBtn(view);
        showSkillsOnCreate();

        RecyclerView recyclerView = view.findViewById(R.id.skill_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(sa);

        Button button = view.findViewById(R.id.testbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("12345array", Arrays.toString(equippedSkills));
            }
        });

        return view;
    }

    private void showSkillsOnCreate() {
        Button[] buttonarray = new Button[]{btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6};

        if (equippedSkills == null) {
            for (int i = 0; i < 6; i++) {
                equippedSkills[i] = 0;
            }
        } else {
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
    }

    private void initializeBtn(View v) {

        btn_skill1 = (Button) v.findViewById(R.id.btn_skillsetone);
        btn_skill2 = (Button) v.findViewById(R.id.btn_skillsettwo);
        btn_skill3 = (Button) v.findViewById(R.id.btn_skillsetthree);
        btn_skill4 = (Button) v.findViewById(R.id.btn_skillsetfour);
        btn_skill5 = (Button) v.findViewById(R.id.btn_skillsetfive);
        btn_skill6 = (Button) v.findViewById(R.id.btn_skillsetsix);

        btn_skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(0);
            }
        });

        btn_skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(1);
            }
        });

        btn_skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(2);
            }
        });

        btn_skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(3);
            }
        });

        btn_skill5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(4);
            }
        });

        btn_skill6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSkill(5);
            }
        });
    }

    private void setSkill(int pos) {
        Button[] buttonarray = new Button[]{btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6};

        for (int j = 0; j <= skilllist.length; j++) {
            if (sa.getId() != 0) {
                if (sa.getId() == skilllist[j].getSkillid()) {
                    equippedSkills[pos] = sa.getId();
                    buttonarray[pos].setText(String.valueOf(skilllist[j].getSpellname()));
                    saveData();
                    break;
                }
            } else {
                showToast();
                break;
            }
        }
    }

    private void saveData(){
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        json = gson.toJson(equippedSkills);
        editor.putString("skill list", json);
        editor.apply();
    }

    private void loadData(){
        SharedPreferences sharedPref = this.getActivity().getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        json = sharedPref.getString("skill list", null);
        equippedSkills = gson.fromJson(json, int[].class);
    }

    private void showToast() {
        Toast.makeText(getContext(), "No skill selected", Toast.LENGTH_SHORT).show();
    }

    public int[] getEquippedSkills() {
        return equippedSkills;
    }

    public String getJson() {
        return json;
    }
}