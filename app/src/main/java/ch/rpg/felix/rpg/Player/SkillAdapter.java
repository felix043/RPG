package ch.rpg.felix.rpg.Player;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ch.rpg.felix.rpg.BattleSystem.BattleActivity;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;

import static android.content.ContentValues.TAG;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillHolder> {

    private BattleActivity ba = new BattleActivity();
    private int id;
    private Skills[] skilllist = ba.skills;

    @NonNull
    @Override
    public SkillAdapter.SkillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_skills, parent, false);
        return new SkillAdapter.SkillHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.SkillHolder holder, final int position) {
        final Skills skills = skilllist[position];

        holder.skillname.setText(skills.getSpellname());
        holder.skilldescription.setText(String.valueOf("Mod: " + skills.getModifier() + " Mp cost: " + skills.getMp_cost()));
        holder.skillequipbutton.setText(String.valueOf(skills.getSkillid()));

        holder.skillequipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = skilllist[position].getSkillid();
                id = getId();
                Log.d(TAG, String.valueOf("id isch: " + id + "          position isch: " + position));
            }
        });

    }

    public int getId() {
        Log.d(TAG, String.valueOf("id isch: " + id));
        return id;
    }

    @Override
    public int getItemCount() {
        return skilllist.length;
    }

    public class SkillHolder extends RecyclerView.ViewHolder {

        private TextView skillname;
        private TextView skilldescription;
        private Button skillequipbutton;

        public SkillHolder(View itemView) {
            super(itemView);

            skillname = itemView.findViewById(R.id.txt_skillname);
            skilldescription = itemView.findViewById(R.id.txt_skilldetails);
            skillequipbutton = itemView.findViewById(R.id.btn_skillequip);
        }
    }
}