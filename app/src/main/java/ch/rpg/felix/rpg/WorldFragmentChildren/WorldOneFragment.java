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

import ch.rpg.felix.rpg.BattleSystem.BattleActivity;
import ch.rpg.felix.rpg.R;

public class WorldOneFragment extends Fragment {

    private Intent intent = new Intent();
    private Bundle extras = new Bundle();

    private WorldData wd = new WorldData();

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    //private boolean bool1 = false, bool2 = false, bool3 = false, bool4 = false, bool5 = false, bool6 = false, bool7 = false, bool8 = false, bool9 = false, bool10 = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prologue, container, false);
        battleBtn(view);
        return view;
    }

    private void switchActivity(int x, int y, int z) {
        intent.setClass(getActivity(), BattleActivity.class);
        extras.putString("x", String.valueOf(x));
        extras.putString("y", String.valueOf(y));
        extras.putString("z", String.valueOf(z));
        intent.putExtras(extras);
        getActivity().startActivity(intent);
    }

    private void battleBtn(View v) {
        final Button b1 = v.findViewById(R.id.btn_1_1);
        final Button b2 = v.findViewById(R.id.btn_1_2);
        final Button b3 = v.findViewById(R.id.btn_1_3);
        final Button b4 = v.findViewById(R.id.btn_1_4);
        final Button b5 = v.findViewById(R.id.btn_1_5);
        final Button b6 = v.findViewById(R.id.btn_1_6);
        final Button b7 = v.findViewById(R.id.btn_1_7);
        final Button b8 = v.findViewById(R.id.btn_1_8);
        final Button b9 = v.findViewById(R.id.btn_1_9);
        final Button b10 = v.findViewById(R.id.btn_1_10);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 0, 0);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 1, 0);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 2, 0);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 3, 0);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 4, 0);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 5, 0);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 6, 0);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 7, 0);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 8, 0);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 10, 0);
            }
        });
    }
}