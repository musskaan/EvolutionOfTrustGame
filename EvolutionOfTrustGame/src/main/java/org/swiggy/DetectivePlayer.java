package org.swiggy;

public class DetectivePlayer extends Player {

    private boolean gainedInLastRound = true;

    private boolean isAlwaysCheater = true;

    private int currentRound = 0;

    @Override
    public Decision makeDecision() {
        Decision decision = Decision.CHEAT;
        if(currentRound == 0) {
            decision = Decision.COOPERATE;
        }
        if((currentRound == 1 || currentRound == 2) && !gainedInLastRound) {
            isAlwaysCheater = false;
        }
        if(currentRound > 1 && !isAlwaysCheater && gainedInLastRound) {
            decision = Decision.COOPERATE;
        }
        gainedInLastRound = false;
        currentRound++;
        return decision;
    }

    @Override
    public void gain() {
        super.gain();
        this.gainedInLastRound = true;
    }
}
