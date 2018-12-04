package ch.rpg.felix.rpg.BattleSystem;

public class AI {

    private int selector1;
    private int selector2;
    private int value1;
    private int value2;
    private double multiplier1;
    private double multiplier2;
    private boolean isEnd;      //check if s tree finished
    private AI[] sub_ai;
    private int operations;     //0: ==, 1: <, 2: >, 3: <=, 4: >=, 5: !=, 6: % == 0, 7: % != 0
    private int skill_index;

    public AI(int selector1, int value1, double multiplier1, int selector2, int value2, double multiplier2, boolean isEnd, AI[] sub_ai, int operations, int skill_index) {
        this.selector1 = selector1;
        this.selector2 = selector2;
        this.value1 = value1;
        this.value2 = value2;
        this.multiplier1 = multiplier1;
        this.multiplier2 = multiplier2;
        this.isEnd = isEnd;
        this.sub_ai = sub_ai;
        this.operations = operations;
        this.skill_index = skill_index;
    }

    private int nextRule(int[][] stats) {
        if (this.isEnd) {
            return this.skill_index;
        }
        int return_index = -1;
        for (int i = 0; i < this.sub_ai.length; i++) {
            return_index = this.sub_ai[i].checkRule(stats);
            if (return_index != -1) {
                break;
            }
        }
        return return_index;
    }

    public int checkRule(int[][] stats) {
        if (this.operations == 0) {
            if (this.multiplier1 * stats[this.selector1][this.value1] == this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 1) {
            if (this.multiplier1 * stats[this.selector1][this.value1] < this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 2) {
            if (this.multiplier1 * stats[this.selector1][this.value1] > this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 3) {
            if (this.multiplier1 * stats[this.selector1][this.value1] <= this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 4) {
            if (this.multiplier1 * stats[this.selector1][this.value1] >= this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 5) {
            if (this.multiplier1 * stats[this.selector1][this.value1] != this.multiplier2 * stats[this.selector2][this.value2]) {
                return nextRule(stats);
            }
        } else if (this.operations == 6) {
            if (this.multiplier1 * stats[this.selector1][this.value1] % this.multiplier2 * stats[this.selector2][this.value2] == 0) {
                return nextRule(stats);
            }
        } else if (this.operations == 7) {
            if (this.multiplier1 * stats[this.selector1][this.value1] % this.multiplier2 * stats[this.selector2][this.value2] != 0) {
                return nextRule(stats);
            }
        }
        return -1;
    }
}