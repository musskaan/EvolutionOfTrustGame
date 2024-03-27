package org.swiggy;

import java.util.*;
import java.util.stream.Collectors;

public class Tournament {

    private final List<Player> players;
    private static int rounds;
    static boolean isRunning;
    private static final int MAX_ROUNDS = 10;

    public Tournament(List<Player> players) {
        if(players == null || players.isEmpty()) {
            throw new RuntimeException("Invalid list of players, cannot be null or empty");
        }
        this.players = new ArrayList<>(players);
        isRunning = false;
        rounds = 1;
    }

    public void play() {
        if(players.size() < 5) {
            throw new RuntimeException("At least 5 players are required to start playing the tournament");
        }

        if(checkIfAllPlayersSame()) {
            throw new RuntimeException("All players are same, choose different players");
        }

        isRunning = true;
        while(isRunning) {
            if(rounds > MAX_ROUNDS) {
                isRunning = false;
                break;
            }
            System.out.println("Round " + rounds++);
            playRound();
            eliminateAndReproduce();
        }

        System.out.println("Game Over!");
    }

    public void playRound() {
        Set<Player> alreadyPlayedPlayers = new HashSet<>();

        for (Player player1 : players) {
            for (Player player2 : players) {
                if(alreadyPlayedPlayers.contains(player2) || player1 == player2) {
                    continue;
                }
                TrustGame trustGame = new TrustGame(player1, player2, 1);
                trustGame.play();
            }
            alreadyPlayedPlayers.add(player1);
        }
    }

    private void eliminateAndReproduce() {
        players.sort(Comparator.comparingInt(Player::getCoins));

        eliminate5WorstPlayers();

        if (players.isEmpty() || checkIfAllPlayersSame()) {
            isRunning = false;
        } else {
            reproduce5BestPlayers();
        }
    }

    private void eliminate5WorstPlayers() {
        players.subList(0, Math.min(5, players.size())).clear();
        for(Player player : players) {
            System.out.println("after elimination" + player);
        }
        System.out.println(players.size());
    }


    private void reproduce5BestPlayers() {
        List<Player> bestPlayers = players.subList(Math.max(0, players.size() - 5), players.size());
        players.addAll(clonePlayers(bestPlayers));
        for(Player player : players) {
            System.out.println("after reproduction" + player);
        }
        System.out.println(players.size());
    }

    private boolean checkIfAllPlayersSame() {
        Set<Class<? extends Player>> playerClasses = players.stream()
                .map(Player::getClass)
                .collect(Collectors.toSet());

        if (playerClasses.size() == 1) {
            System.out.println("Game stopped as all players are now same. Winner: " + players.getFirst().getClass().getSimpleName());
            return true;
        }

        return false;
    }

    private List<Player> clonePlayers(List<Player> playersToClone) {
        List<Player> clones = new ArrayList<>();
        for (Player player : playersToClone) {
            clones.add(player.clone());
        }
        return clones;
    }
}
