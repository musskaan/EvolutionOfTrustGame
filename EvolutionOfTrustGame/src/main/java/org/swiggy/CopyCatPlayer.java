package org.swiggy;

public class CopyCatPlayer extends Player {

    private boolean gainedLastRound = false;

    @Override
    public Decision makeDecision() {
        Decision decision = Decision.CHEAT;
        if (gainedLastRound) {
            decision = Decision.COOPERATE;
        }
        gainedLastRound = false;
        return decision;
    }

    @Override
    public void gain() {
        super.gain();
        this.gainedLastRound = true;
    }

    @Override
    public CopyCatPlayer clone() {
        return  (CopyCatPlayer) super.clone();
    }
}

///  @Override
//    public void addCoins(int amount) {
//        super.addCoins(amount);
//        this.willCooperate = didOpponentCooperate(amount);
//    }
//
//    private boolean didOpponentCooperate(int amount) {
//        return amount == 3 || amount == 2;
//    }