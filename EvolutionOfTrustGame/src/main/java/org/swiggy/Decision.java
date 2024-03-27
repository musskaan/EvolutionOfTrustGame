package org.swiggy;


public enum Decision {
    COOPERATE {
        @Override
        public int[] getPayoff(Decision other) {
            return (other == COOPERATE) ? new int[]{2, 2} : new int[]{-1, 3};
        }
    },
    CHEAT {
        @Override
        public int[] getPayoff(Decision other) {
            return (other == COOPERATE) ? new int[]{3, -1} : new int[]{0, 0};
        }
    };

    public abstract int[] getPayoff(Decision other);
}

