package ch.rpg.felix.rpg;

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

public class WorldBossFragment extends Fragment {

    private Intent intent = new Intent();
    private Bundle extras = new Bundle();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worldbosses, container, false);
        battlebtn(view);
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

    private void battlebtn(View v) {
        final Button phantomspider = v.findViewById(R.id.btn_boss_phantomspider);
        final Button mumie = v.findViewById(R.id.btn_boss_mumie);

        phantomspider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(1, 0, 0);
            }
        });

        mumie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivity(1, 1, 0);
            }
        });
    }
}
