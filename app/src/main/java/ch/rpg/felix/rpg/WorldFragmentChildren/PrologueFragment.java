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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prologue, container, false);
        battleBtn(view);
        return view;
    }

    private void battleBtn(View view){
        final Button btn1_1 = (Button) view.findViewById(R.id.btn_1_1);
        final Button btn1_2 = (Button) view.findViewById(R.id.btn_1_2);
        final Button btn1_3 = (Button) view.findViewById(R.id.btn_1_3);

        btn1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BattleActivity.class);
                getActivity().startActivity(intent);
                btn1_2.setVisibility(View.VISIBLE);
            }
        });

        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1_3.setVisibility(View.VISIBLE);
            }
        });
    }
}
