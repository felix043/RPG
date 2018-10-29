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

import ch.rpg.felix.rpg.BattleSystem.BattleActivity;
import ch.rpg.felix.rpg.R;

public class ChangeSkillsFragment extends Fragment {

    BattleActivity ba = new BattleActivity();
    private Button btn_skill1, btn_skill2, btn_skill3, btn_skill4, btn_skill5, btn_skill6;
    private int skillarray[][] = new int[6][2]; //[row][colums]

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_skills, container, false);
        btn_Skills(view);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.skill_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final SkillAdapter adapter = new SkillAdapter();
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void btn_Skills(View v) {

        for (int i = 0; i < skillarray.length; i++) {
            skillarray[i][0] = i;
        }

        btn_skill1 = (Button) v.findViewById(R.id.btn_skillsetone);
        btn_skill2 = (Button) v.findViewById(R.id.btn_skillsettwo);
        btn_skill3 = (Button) v.findViewById(R.id.btn_skillsetthree);
        btn_skill4 = (Button) v.findViewById(R.id.btn_skillsetfour);
        btn_skill5 = (Button) v.findViewById(R.id.btn_skillsetfive);
        btn_skill6 = (Button) v.findViewById(R.id.btn_skillsetsix);
    }
}
