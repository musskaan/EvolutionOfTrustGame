package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerTest {

    @Test
    public void testMakeDecisionAlwaysCheat() {
        Player player = new AlwaysCheatPlayer();

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterOpponentCooperated() {
        Player player = new AlwaysCheatPlayer();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.addCoins(3);

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterOpponentCheated() {
        Player player = new AlwaysCheatPlayer();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.addCoins(0);

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionAfterMultipleRounds() {
        Player player = new AlwaysCheatPlayer();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.addCoins(3);

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.addCoins(0);

        assertEquals(Decision.CHEAT, player.makeDecision());
    }
}