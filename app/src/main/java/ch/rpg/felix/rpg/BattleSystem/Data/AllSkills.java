package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.Skills;

public class AllSkills {

    //Physical skills
    Skills basic = new Skills(1000, "Basic Attack", 0.5, 1, 1, 0, 1);
    Skills punch = new Skills(1001, "Punch", 1.0, 1, 1, 2, 1);
    Skills slash = new Skills(1002, "Slash", 1.2, 1, 1, 3, 1);
    Skills stab = new Skills(1003, "Stab", 1.3, 1, 1, 4, 1);
    Skills bodycheck = new Skills(1004, "Bodycheck", 1.4, 1, 1, 4, 1);
    Skills despairedAttack = new Skills(1005, "Despaired Attack", 1.3, 1, 1, 0, 1);
    Skills hopefulAttack = new Skills(1006, "Hopeful Attack", 1.3, 1, 1, 0, 1);
    Skills scratch = new Skills(1007, "Scratch", 1.5, 1, 1, 2, 1);
    Skills oblivion = new Skills(1008, "Oblivion", 5.0, 1, 1, 20, 1);
    Skills swipe = new Skills(1009, "Swipe", 3.0, 1, 1, 20, 1);


    //Magical skills
    Skills icelance = new Skills(2000, "Icelance", 1.5, 1, 1, 5, 2);
    Skills fireball = new Skills(2001, "Fireball", 1.6, 1, 1, 10, 2);
    Skills lightning = new Skills(2002, "Lightning Strike", 1.7, 1, 1, 15, 2);
    Skills earthquake = new Skills(2003, "Earthquake", 1.7, 1, 1, 15, 2);
    Skills fireblast = new Skills(2004, "Fireblast", 1.6, 1, 1, 10, 2);
    Skills poisonfang = new Skills(2005, "Poisonous Stab ", 2.0, 1, 1, 8, 2);
    Skills painfulscream = new Skills(2006, "Painful Scream", 5.0, 1, 1, 20, 2);
    /*
    Skills mediocreHPHeal = new Skills(11, "Mediocre HP Heal", 8, 0, 3.5, 7, 4);
    Skills mediocreMPHeal = new Skills(12, "Mediocre MP Heal", 0, 8, 3.5, 7, 4);

    Skills standardHPHeal = new Skills(13, "Standard HP Heal", 12, 0, 8.5, 13, 4);
    Skills standardMPHeal = new Skills(14, "Standard MP Heal", 0, 12, 8.5, 13, 4);

    Skills greaterHPHeal = new Skills(15, "Greater HP Heal", 15, 0, 12.0, 24, 4);
    Skills greaterMPHeal = new Skills(16, "Greater MP Heal", 0, 15, 12.0, 24, 4);

    Skills masterHPHeal = new Skills(16, "Master MP Heal", 15, 0, 18.0, 42, 4);
    Skills masterMPHeal = new Skills(17, "Master MP Heal", 0, 15, 18.0, 42, 4);

    Skills divineHPHeal = new Skills(18, "Divine MP Heal", 15, 0, 30.5, 80, 4);
    Skills divineMPHeal = new Skills(19, "Divine MP Heal", 0, 15, 30.5, 80, 4);
    private Player p = new Player();
    Skills goddessTear = new Skills(20, "Goddess Tear", p.getMax_hp(), p.getMax_mp(), 1.0, 350, 4);
*/
    public Skills[] skills = new Skills[]{punch, slash, stab, bodycheck, icelance, fireball, lightning, scratch, despairedAttack, hopefulAttack, oblivion, swipe, earthquake, fireblast, painfulscream};
    Skills depression = new Skills(2006, "Depression", 7.0, 1, 1, 20, 2);
    Skills phantomsting = new Skills(2006, "Phantom Sting", 7.0, 1, 1, 20, 2);
    Skills venomspit = new Skills(2006, "Venom Spit", 7.0, 1, 1, 20, 2);


    //Supportive skills int skillid, String spellname, int hpheal, int mpheal, double modifier, int mp_cost, int type
    Skills lesserHPHeal = new Skills(9, "Minor HP Heal", 5, 0, 1.5, 4, 4);
    Skills lesserMPHeal = new Skills(10, "Minor MP Heal", 0, 5, 1.5, 4, 4);
    //Hybrid skills
    Skills lifesplitter = new Skills(1009, "Lifesplitter", 15.0, 1, 1, 50, 3);

    public Skills[] getSkills() {
        return skills;
    }
}
