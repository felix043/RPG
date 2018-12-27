package ch.rpg.felix.rpg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ch.rpg.felix.rpg.WorldFragmentChildren.WorldOneFragment;

public class WorldFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_world, container, false);
        chapterBtn(view);
        return view;
    }

    private void chapterBtn(View v) {
        final FragmentManager fm = getFragmentManager();
        Button prologueBtn = v.findViewById(R.id.btn_prologue);

        FloatingActionButton fab = v.findViewById(R.id.float_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new WorldBossFragment()).commit();
            }
        });

        prologueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new WorldOneFragment()).commit();

            }
        });
    }

}
