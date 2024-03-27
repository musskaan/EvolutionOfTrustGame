package org.swiggy;

public class TrustTransaction {
    private final Player player1;
    private final Player player2;

    public TrustTransaction(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void processPlayerDecisions() {
        Decision decisionPlayer1 = player1.makeDecision();
        Decision decisionPlayer2 = player2.makeDecision();

        if(decisionPlayer1 == Decision.COOPERATE) {
            player1.invest();
            player2.gain();
        }
        if(decisionPlayer2 == Decision.COOPERATE) {
            player2.invest();
            player1.gain();
        }
    }
}


//    private int[] transact(Decision decisionPlayer1, Decision decisionPlayer2) {
//        return decisionPlayer1.getPayoff(decisionPlayer2);
//    }