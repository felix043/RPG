package ch.rpg.felix.rpg.Skills;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ch.rpg.felix.rpg.R;

public class SkilltreeFragment extends Fragment {

    Button btn_offense, btn_defense, btn_utility, btn_passive;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skilltree, container, false);
        swapFragment(view);
        return view;
    }

    private void swapFragment(View v) {
        btn_offense = (Button) v.findViewById(R.id.btn_offenseskill);
        btn_defense = (Button) v.findViewById(R.id.btn_defenseskill);
        btn_utility = (Button) v.findViewById(R.id.btn_utilityskill);
        btn_passive = (Button) v.findViewById(R.id.btn_passiveskill);

        final FragmentManager fm = getFragmentManager();

        btn_offense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new OffenseFragment()).commit();
            }
        });

        btn_defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new DefenseFragment()).commit();
            }
        });

        btn_utility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new UtilityFragment()).commit();
            }
        });

        btn_passive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new PassiveFragment()).commit();
            }
        });
    }
}
