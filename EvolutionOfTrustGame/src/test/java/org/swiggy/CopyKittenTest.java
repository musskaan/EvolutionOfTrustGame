package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyKittenTest {

    @Test
    void testCopyKittenPlayerStartsByCooperating() {
        Player copyKittenPlayer = new CopyKittenPlayer();

        assertEquals(Decision.COOPERATE, copyKittenPlayer.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterOpponentCheated() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterMultipleRounds() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());

        assertEquals(Decision.COOPERATE, player.makeDecision());
    }
}

