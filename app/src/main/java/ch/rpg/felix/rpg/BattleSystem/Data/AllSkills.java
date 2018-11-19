package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.Skills;

public class AllSkills {

    Skills basic = new Skills(1, "Basic Attack", 0.5, 1, 1, 0, 1);
    Skills punch = new Skills(2, "Punch", 1, 1, 1, 2, 1);
    Skills slash = new Skills(3, "Slash", 1.2, 1, 1, 3, 1);
    Skills stab = new Skills(4, "Stab", 1.3, 1, 1, 4, 1);
    Skills bodycheck = new Skills(5, "Bodycheck", 1.4, 1, 1, 4, 1);

    Skills icelance = new Skills(6, "Icelance", 1.5, 1, 1, 5, 2);
    Skills fireball = new Skills(7, "Fireball", 1.6, 1, 1, 10, 2);
    Skills lightning = new Skills(8, "Lightning Strike", 1.7, 1, 1, 15, 2);

    public Skills[] skills = new Skills[]{punch, slash, stab, bodycheck, icelance, fireball, lightning};

    public Skills[] getSkills() {
        return skills;
    }
}
