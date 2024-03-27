package org.swiggy;

public abstract class Player implements Cloneable {
    private int coins;

    public Player() {
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }

    public void displayCoins() {
        System.out.println("Player coins: " + coins);
    }

    public abstract Decision makeDecision();

    public void invest() {
        addCoins(-1);
    }

    public void gain() {
        addCoins(3);
    }

    @Override
    public Player clone() {
        try {
            return (Player) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported for Player", e);
        }
    }
}
