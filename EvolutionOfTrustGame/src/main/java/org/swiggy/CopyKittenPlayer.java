package org.swiggy;

public class CopyKittenPlayer extends Player{
    private boolean gainedLastRound = false;

    @Override
    public Decision makeDecision() {
        if (!gainedLastRound) {
            gainedLastRound = true;
            return Decision.COOPERATE;
        }
        return Decision.CHEAT;
    }

    @Override
    public void gain() {
        super.gain();
        this.gainedLastRound = false;
    }

    @Override
    public CopyKittenPlayer clone() {
        return (CopyKittenPlayer) super.clone();
    }
}


//    @Override
//    public void addCoins(int amount) {
//        super.addCoins(amount);
//        this.willCheat = didOpponentCheat(amount);
//    }
//
//    private boolean didOpponentCheat(int amount) {
//        return amount == -1 || amount == 0;
//    }