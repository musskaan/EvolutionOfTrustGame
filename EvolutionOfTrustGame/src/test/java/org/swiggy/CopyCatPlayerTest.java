package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyCatPlayerTest {

    @Test
    void testMakeDecisionStartsByCheating() {
        Player copyCatPlayer = new CopyCatPlayer();

        assertEquals(Decision.CHEAT, copyCatPlayer.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterOpponentCooperated() {
        CopyCatPlayer player = new CopyCatPlayer();

        player.gain();

        assertEquals(Decision.COOPERATE, player.makeDecision());
    }


    @Test
    public void testMakeDecisionAfterMultipleRounds() {
        CopyCatPlayer player = new CopyCatPlayer();

        player.gain();
        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.gain();
        assertEquals(Decision.COOPERATE, player.makeDecision());

        assertEquals(Decision.CHEAT, player.makeDecision());
    }
}