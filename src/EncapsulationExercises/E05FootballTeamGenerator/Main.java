package EncapsulationExercises.E05FootballTeamGenerator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> teams = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");

            if (tokens.length == 2) {
                String teamName = tokens[1];

                if (tokens[0].equals("Team")) {
                    try {
                        Team team = new Team(teamName);
                        teams.put(teamName, team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }

                } else if (tokens[0].equals("Rating")) {

                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team" + teamName + "does not exist.");
                    } else {
                        System.out.println(teamName + " - " + Math.round(teams.get(teamName).getRating()));
                    }

                }

            } else if (tokens.length == 8) {
                String teamName = tokens[1];
                String playerName = tokens[2];
                int endurance = Integer.parseInt(tokens[3]);
                int sprint = Integer.parseInt(tokens[4]);
                int dribble = Integer.parseInt(tokens[5]);
                int passing = Integer.parseInt(tokens[6]);
                int shooting = Integer.parseInt(tokens[7]);

                try {
                    Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);

                    if (!teams.containsKey(teamName)) {
                        System.out.println("Team" + teamName + "does not exist.");
                    } else {
                        teams.get(teamName).addPlayer(player);
                    }
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }


            } else if (tokens.length == 3) {
                String teamName = tokens[1];
                String playerName = tokens[2];

                teams.get(teamName).removePlayer(playerName);
            }

            input = scanner.nextLine();
        }


    }
}
