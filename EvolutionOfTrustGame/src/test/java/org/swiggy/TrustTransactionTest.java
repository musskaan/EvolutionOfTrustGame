package org.swiggy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrustTransactionTest {

    @Test
    void testProcessGameDecisionsCooperateVsCheat() {
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer).invest();
        verify(alwaysCheatPlayer).gain();
    }

    @Test
    void testProcessGameDecisionsCooperateVsCooperate() {
        Player alwaysCooperatePlayer1 = spy(new AlwaysCooperatePlayer());
        Player alwaysCooperatePlayer2 = spy(new AlwaysCooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer1, alwaysCooperatePlayer2);

        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer1).gain();
        verify(alwaysCooperatePlayer2).gain();
    }

    @Test
    void testProcessGameDecisionsCooperateVsCopyCat() {
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, copyCatPlayer);

        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer).invest();
        verify(copyCatPlayer).gain();
    }

    @Test
    void testProcessGameDecisionsCooperateVsCopyKitten() {
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer).invest();
        verify(alwaysCooperatePlayer).gain();
        verify(copyKittenPlayer).invest();
        verify(copyKittenPlayer).gain();
    }

    @Test
    void testProcessGameDecisionsCooperateVsDetective() {
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        Player detectivePlayer = spy(new DetectivePlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, detectivePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer, times(3)).invest();
        verify(alwaysCooperatePlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsCooperateVsGrudger() {
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        Player grudgerPlayer = spy(new GrudgerPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCooperatePlayer, grudgerPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCooperatePlayer, times(4)).invest();
        verify(alwaysCooperatePlayer, times(4)).gain();
        verify(grudgerPlayer, times(4)).invest();
        verify(grudgerPlayer, times(4)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsCheat() {
        Player alwaysCheatPlayer1 = spy(new AlwaysCheatPlayer());
        Player alwaysCheatPlayer2 = spy(new AlwaysCheatPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer1, alwaysCheatPlayer2);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer1, times(0)).invest();
        verify(alwaysCheatPlayer1, times(0)).gain();
        verify(alwaysCheatPlayer2, times(0)).invest();
        verify(alwaysCheatPlayer2, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsCooperate() {
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(3)).gain();
        verify(alwaysCooperatePlayer, times(3)).invest();
        verify(alwaysCooperatePlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsCopyCat() {
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(0)).gain();
        verify(copyCatPlayer, times(0)).invest();
        verify(copyCatPlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsCopyKitten() {
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
        verify(copyKittenPlayer, times(1)).invest();
        verify(copyKittenPlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsGrudger() {
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        Player grudgerPlayer = spy(new GrudgerPlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
        verify(grudgerPlayer, times(1)).invest();
        verify(grudgerPlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCheatVsDetective() {
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        Player detectivePlayer = spy(new DetectivePlayer());
        TrustTransaction transaction = new TrustTransaction(alwaysCheatPlayer, detectivePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCheat() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer, times(0)).invest();
        verify(copyCatPlayer, times(0)).gain();
        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCooperate() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer, times(2)).invest();
        verify(copyCatPlayer, times(3)).gain();
        verify(alwaysCooperatePlayer, times(3)).invest();
        verify(alwaysCooperatePlayer, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCopyCat() {
        Player copyCatPlayer1 = spy(new CopyCatPlayer());
        Player copyCatPlayer2 = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer1, copyCatPlayer2);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer1, times(0)).invest();
        verify(copyCatPlayer1, times(0)).gain();
        verify(copyCatPlayer2, times(0)).invest();
        verify(copyCatPlayer2, times(0)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsCopyKitten() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(2)).gain();
        verify(copyKittenPlayer, times(2)).invest();
        verify(copyKittenPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsGrudger() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player grudgerPlayer = spy(new GrudgerPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(1)).gain();
        verify(grudgerPlayer, times(1)).invest();
        verify(grudgerPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyCatVsDetective() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player detectivePlayer = spy(new DetectivePlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, detectivePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyCatPlayer, times(2)).invest();
        verify(copyCatPlayer, times(2)).gain();
        verify(detectivePlayer, times(2)).invest();
        verify(detectivePlayer, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCheat() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer, times(1)).invest();
        verify(copyKittenPlayer, times(0)).gain();
        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCooperate() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer, times(3)).invest();
        verify(copyKittenPlayer, times(3)).gain();
        verify(alwaysCooperatePlayer, times(3)).invest();
        verify(alwaysCooperatePlayer, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCopyCat() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer, times(1)).invest();
        verify(copyKittenPlayer, times(1)).gain();
        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsCopyKitten() {
        Player copyKittenPlayer1 = spy(new CopyKittenPlayer());
        Player copyKittenPlayer2 = spy(new CopyKittenPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer1, copyKittenPlayer2);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer1, times(2)).invest();
        verify(copyKittenPlayer1, times(2)).gain();
        verify(copyKittenPlayer2, times(2)).invest();
        verify(copyKittenPlayer2, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsGrudger() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player grudgerPlayer = spy(new GrudgerPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, grudgerPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer, times(2)).invest();
        verify(copyKittenPlayer, times(2)).gain();
        verify(grudgerPlayer, times(2)).invest();
        verify(grudgerPlayer, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsCopyKittenVsDetective() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player detectivePlayer = spy(new DetectivePlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, detectivePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(copyKittenPlayer, times(2)).invest();
        verify(copyKittenPlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCheat() {
        Player grudgerPlayer = spy(new GrudgerPlayer());
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer, times(1)).invest();
        verify(grudgerPlayer, times(0)).gain();
        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCooprate() {
        Player grudgerPlayer = spy(new GrudgerPlayer());
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer, times(3)).invest();
        verify(grudgerPlayer, times(3)).gain();
        verify(alwaysCooperatePlayer, times(3)).invest();
        verify(alwaysCooperatePlayer, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCopyCat() {
        Player grudgerPlayer = spy(new GrudgerPlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, copyCatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer, times(1)).invest();
        verify(grudgerPlayer, times(1)).gain();
        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsCopyKitten() {
        Player grudgerPlayer = spy(new GrudgerPlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer, times(3)).invest();
        verify(grudgerPlayer, times(3)).gain();
        verify(copyKittenPlayer, times(3)).invest();
        verify(copyKittenPlayer, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsGrudger() {
        Player grudgerPlayer1 = spy(new GrudgerPlayer());
        Player grudgerPlayer2 = spy(new GrudgerPlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer1, grudgerPlayer2);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer1, times(3)).invest();
        verify(grudgerPlayer1, times(3)).gain();
        verify(grudgerPlayer2, times(3)).invest();
        verify(grudgerPlayer2, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsGrudgerVsDetectiver() {
        Player grudgerPlayer = spy(new GrudgerPlayer());
        Player detectivePlayer = spy(new DetectivePlayer());

        TrustTransaction transaction = new TrustTransaction(grudgerPlayer, detectivePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(grudgerPlayer, times(2)).invest();
        verify(grudgerPlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(2)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsCheat() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player alwaysCheatPlayer = spy(new AlwaysCheatPlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer, alwaysCheatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(0)).gain();
        verify(alwaysCheatPlayer, times(0)).invest();
        verify(alwaysCheatPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsCooperate() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player alwaysCooperatePlayer = spy(new AlwaysCooperatePlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer, alwaysCooperatePlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(5)).gain();
        verify(alwaysCooperatePlayer, times(5)).invest();
        verify(alwaysCooperatePlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsCopyCat() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer, copyCatPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer, times(3)).invest();
        verify(detectivePlayer, times(  2)).gain();
        verify(copyCatPlayer, times(2)).invest();
        verify(copyCatPlayer, times(3)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsCopyKitten() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer, copyKittenPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(2)).gain();
        verify(copyKittenPlayer, times(2)).invest();
        verify(copyKittenPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsGrudger() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player grudgerPlayer = spy(new GrudgerPlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer, grudgerPlayer);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer, times(1)).invest();
        verify(detectivePlayer, times(2)).gain();
        verify(grudgerPlayer, times(2)).invest();
        verify(grudgerPlayer, times(1)).gain();
    }

    @Test
    void testProcessGameDecisionsDetectiveVsDetective() {
        Player detectivePlayer1 = spy(new DetectivePlayer());
        Player detectivePlayer2 = spy(new DetectivePlayer());

        TrustTransaction transaction = new TrustTransaction(detectivePlayer1, detectivePlayer2);

        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();
        transaction.processPlayerDecisions();

        verify(detectivePlayer1, times(1)).invest();
        verify(detectivePlayer1, times(1)).gain();
        verify(detectivePlayer2, times(1)).invest();
        verify(detectivePlayer2, times(1)).gain();
    }
}