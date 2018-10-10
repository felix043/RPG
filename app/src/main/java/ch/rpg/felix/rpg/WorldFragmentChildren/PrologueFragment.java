package ch.rpg.felix.rpg.WorldFragmentChildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ch.rpg.felix.rpg.BattleSystem.BattleActivity;
import ch.rpg.felix.rpg.BattleSystem.Enemies;
import ch.rpg.felix.rpg.R;

public class PrologueFragment extends Fragment {

    private int stage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prologue, container, false);
        battleBtn(view);
        return view;
    }

    private void getIntoBattleactivity() {
        Intent i = new Intent();
        i.setClass(getActivity(), BattleActivity.class);
        i.putExtra("stage", String.valueOf(stage));
        getActivity().startActivity(i);
    }

    private void battleBtn(View view){

        final Button btn1_1 = (Button) view.findViewById(R.id.btn_1_1);
        final Button btn1_2 = (Button) view.findViewById(R.id.btn_1_2);
        final Button btn1_3 = (Button) view.findViewById(R.id.btn_1_3);

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage = 11;
                getIntoBattleactivity();
                btn1_2.setVisibility(View.VISIBLE);
            }
        });

        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage = 12;
                getIntoBattleactivity();
                btn1_3.setVisibility(View.VISIBLE);
            }
        });

        btn1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stage = 13;
                getIntoBattleactivity();
                //btn1_4.setVisibility(View.VISIBLE);       fourth stage not implemented yet
            }
        });
    }
}