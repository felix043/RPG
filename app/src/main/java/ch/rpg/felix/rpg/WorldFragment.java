package ch.rpg.felix.rpg;

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

import ch.rpg.felix.rpg.WorldFragmentChildren.PrologueFragment;

public class WorldFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_world, container, false);
        chapterBtn(view);
        return view;
    }

    private void chapterBtn(View view){
        final FragmentManager fm = getFragmentManager();
        final Button prologueBtn = (Button) view.findViewById(R.id.btn_prologue);
        prologueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.addToBackStack(null).replace(R.id.fragment_container, new PrologueFragment()).commit();

            }
        });
    }
}
