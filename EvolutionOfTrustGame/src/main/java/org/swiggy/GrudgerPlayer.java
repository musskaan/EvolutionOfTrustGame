package org.swiggy;

public class GrudgerPlayer extends Player{
    private boolean gainedInLastRound = true;

    @Override
    public Decision makeDecision() {
        Decision decision = Decision.CHEAT;
        if(gainedInLastRound )
            decision = Decision.COOPERATE;
        gainedInLastRound = false;
        return decision;
    }

    @Override
    public void gain() {
        super.gain();
        this.gainedInLastRound = true;
    }
}

//    @Override
//    public void addCoins(int amount) {
//        super.addCoins(amount);
//        if (didOpponentCheat(amount)) {
//            retaliate = true;
//        }
//    }
//
//    private boolean didOpponentCheat(int amount) {
//        return amount == -1 || amount == 0;
//    }
