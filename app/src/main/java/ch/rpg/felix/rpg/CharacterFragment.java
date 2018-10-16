package ch.rpg.felix.rpg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import ch.rpg.felix.rpg.Item.EquipmentActivity;

public class CharacterFragment extends Fragment {

    private Intent i;
    private int equipID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        selectEquip(view);
        return view;
    }


    private void changeActivity() {
        i = new Intent();
        i.setClass(getActivity(), EquipmentActivity.class);
        i.putExtra("equipID", String.valueOf(equipID));
        getActivity().startActivity(i);
    }

    private void selectEquip(View view) {
        final ImageButton btn_mainweapon = (ImageButton) view.findViewById(R.id.mainhandslot);
        final ImageButton btn_subweapon = (ImageButton) view.findViewById(R.id.subhandslot);
        final ImageButton btn_helmet = (ImageButton) view.findViewById(R.id.helmetslot);
        final ImageButton btn_gauntlet = (ImageButton) view.findViewById(R.id.gauntletslot);
        final ImageButton btn_armor = (ImageButton) view.findViewById(R.id.armorslot);
        final ImageButton btn_boots = (ImageButton) view.findViewById(R.id.bootsslot);

        btn_mainweapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 1;
                changeActivity();
            }
        });

        btn_subweapon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 2;
                changeActivity();
            }
        });

        btn_helmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 3;
                changeActivity();
            }
        });

        btn_gauntlet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 4;
                changeActivity();
            }
        });

        btn_armor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 5;
                changeActivity();
            }
        });

        btn_boots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equipID = 6;
                changeActivity();
            }
        });
    }
}
