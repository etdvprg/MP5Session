package com;

import java.util.*;

public class Leaderboard {

    private List<Player> players;

    public Leaderboard() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        // Check if the player already exists in the leaderboard
        for (Player p : players) {
            if (p.getUsername().equals(player.getUsername())) {
                // If the new score is higher than the existing one, update the score
                if (player.getScore() > p.getScore()) {
                    p.setScore(player.getScore());
                    // Sort the players by score in descending order after updating the score
                    players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
                }
                // If the new score is lower than the existing one, do nothing
                return;
            }
        }
        // If the player doesn't exist in the leaderboard, add them
        players.add(player);
        // Sort the players by score in descending order
        players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        // If the leaderboard size is more than 20, remove the player with the lowest score
        if (players.size() > 20) {
            players.remove(players.size() - 1);
        }
    }

    public List<Player> getLeaderboardPlayers() {
        return new ArrayList<>(players);
    }
    
    public void deletePlayer(String username) {
        players.removeIf(p -> p.getUsername().equals(username));
    }
   
}
