package EncapsulationLab.L04FirstAndReserveTeam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Barca");

        Person person = new Person("leo", "messi", 34, 1000);
        Person person1 = new Person("cris", "777", 36, 900);
        Person person2 = new Person("diego", "maradona", 88, 11000);
        Person person3 = new Person("ronaldinho", "gaucho", 45, 12000);

        team.addPlayer(person);
        team.addPlayer(person1);
        team.addPlayer(person2);
        team.addPlayer(person3);

        List<Person> fistTeam = team.getFirstTeam();

        for (Person person4 : fistTeam) {
            System.out.print(person4 + " ");
        }

        Person person6 = new Person("Frank", "Lampard", 56, 12222);

        fistTeam.add(person6); // CTE bc unmodifiable list

        System.out.println();

        List<Person> reserveTeam = team.getReserveTeam();
        for (Person person4 : reserveTeam) {
            System.out.print(person4 + " ");
        }
    }
}
