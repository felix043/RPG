package ch.rpg.felix.rpg.Player;

public class LevelAlgorithm {

    private int currentPlayerlevel;
    private int expObtained;
    private int expForNextLv;
    private int expTransfer;

    public LevelAlgorithm() {
        expObtained = 1;
        currentPlayerlevel = 1;
    }

    public int expNeededForNextLv() {
        while (expTransfer >= 0) {
            if (currentPlayerlevel <= 200) {
                expForNextLv = (int) Math.pow(currentPlayerlevel * currentPlayerlevel * 3.5, 1.001) + 10;
                expObtained += expTransfer;
                expTransfer = expTransfer - expObtained;
            } else if (currentPlayerlevel > 200 && currentPlayerlevel < 250) {
                expForNextLv = (int) Math.pow(currentPlayerlevel * currentPlayerlevel * 5, 1.003);
                expObtained += expTransfer;
                expTransfer = expTransfer - expObtained;
            }

            if (expForNextLv < expObtained) {
                currentPlayerlevel++;
                expTransfer = expObtained - expForNextLv;
                expObtained = 0;
            }
        }
        return currentPlayerlevel;
    }

    public int getExpForNextLv() {
        return expForNextLv;
    }

    public int getExpObtained() {
        return expObtained;
    }
}
