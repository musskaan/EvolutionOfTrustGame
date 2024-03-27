package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrustGameTest {

    @Test
    public void testInitializeTrustGamePlay_nullPlayer1_throwsRuntimeException() {
        Player player = mock(Player.class);

        assertThrows(RuntimeException.class, () ->  new TrustGame(null, player, 3));
    }

    @Test
    public void testInitializeTrustGamePlay_nullPlayer2_throwsRuntimeException() {
        Player player = mock(Player.class);

        assertThrows(RuntimeException.class, () ->  new TrustGame(player, null, 3));
    }

    @Test
    public void testTrustGamePlay() {
        Player player1 = spy(new AlwaysCheatPlayer());
        Player player2 = spy(new AlwaysCooperatePlayer());
        TrustGame trustGame = spy(new TrustGame(player1, player2, 3));
        TrustTransaction trustTransaction = new TrustTransaction(player1, player2);

        doNothing().when(trustTransaction).processPlayerDecisions();

        trustGame.play();

        verify(trustTransaction, times(3)).processPlayerDecisions();
    }
}