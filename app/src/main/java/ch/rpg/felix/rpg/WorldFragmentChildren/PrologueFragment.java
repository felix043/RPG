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

public class PrologueFragment extends Fragment {

    private Intent intent = new Intent();
    private Bundle extras = new Bundle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prologue, container, false);
        battleBtn(view);
        return view;
    }

    private void switchActivity(int x, int y) {
        intent.setClass(getActivity(), BattleActivity.class);
        extras.putString("x", String.valueOf(x));
        extras.putString("y", String.valueOf(y));
        intent.putExtras(extras);
        getActivity().startActivity(intent);
    }

    private void battleBtn(View view){

        final Button btn1_1 = view.findViewById(R.id.btn_1_1);
        final Button btn1_2 = view.findViewById(R.id.btn_1_2);
        final Button btn1_3 = view.findViewById(R.id.btn_1_3);

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(0, 0);
                btn1_2.setVisibility(View.VISIBLE);
            }
        });

        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(1, 0);
                btn1_3.setVisibility(View.VISIBLE);
            }
        });

        btn1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(2, 0);
                //btn1_4.setVisibility(View.VISIBLE);       fourth stage not implemented yet
            }
        });
    }
}