package org.swiggy;

public class AlwaysCooperatePlayer extends Player{
    @Override
    public Decision makeDecision() {
        return Decision.COOPERATE;
    }

    @Override
    public AlwaysCooperatePlayer clone() {
        return (AlwaysCooperatePlayer) super.clone();
    }
}
