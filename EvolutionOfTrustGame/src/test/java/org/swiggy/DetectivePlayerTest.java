package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectivePlayerTest {

    @Test
    void testDetectivePlayerFirstCooperateSecondCheat() {
        Player detectivePlayer = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, detectivePlayer.makeDecision());
        assertEquals(Decision.CHEAT, detectivePlayer.makeDecision());
    }

    @Test
    public void testMakeDecisionMultipleRoundsWithCheatPlayer_willAlwaysCheat() {
        Player player = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionMultipleRoundsWithCooperatePlayer_willAlwaysCheat() {
        Player player = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionMultipleRoundsWithCopyKitten_willAlwaysCheat() {
        Player player = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionMultipleRoundsWithGrudger_willAlwaysCheat() {
        Player player = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.CHEAT, player.makeDecision());
        assertEquals(Decision.CHEAT, player.makeDecision());
    }

    @Test
    public void testMakeDecisionMultipleRoundsWithCopyCat_willMimicAfterRound2() {
        Player player = new DetectivePlayer();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());

        player.gain();

        assertEquals(Decision.COOPERATE, player.makeDecision());

        player.invest();

        assertEquals(Decision.CHEAT, player.makeDecision());
    }
}