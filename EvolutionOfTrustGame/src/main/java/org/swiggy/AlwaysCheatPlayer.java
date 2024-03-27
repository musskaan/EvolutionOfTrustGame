package org.swiggy;

public class AlwaysCheatPlayer extends Player {
    @Override
    public Decision makeDecision() {
        return Decision.CHEAT;
    }

    @Override
    public AlwaysCheatPlayer clone() {
        return  (AlwaysCheatPlayer) super.clone();
    }
}
