package EncapsulationExercises.E05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
                return;
            }
        }

        System.out.println("Player " + playerName + " is not in " + name + " team.");
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).sum() / players.size();
    }
}
