package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrudgerPlayerTest {

    @Test
    void testGrudgerStartsByCooperating() {
        Player grudgerPlayer = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, grudgerPlayer.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterOpponentCheatedForFirstTime() {
        Player player = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterBeingCheatedForMultipleRounds() {
        Player player = new GrudgerPlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
    }
}