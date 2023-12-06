package com;

import java.util.*;

public class Leaderboard {

    private List<Player> players;

    public Leaderboard() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        for (Player p : players) {
            if (p.getUsername().equals(player.getUsername())) {
                if (player.getScore() > p.getScore()) {
                    p.setScore(player.getScore());
                    players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
                }
                return;
            }
        }
        players.add(player);
        players.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
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
