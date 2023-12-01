package viergewinnt1;

import java.util.Scanner;

public class SpielerPerson extends Spieler {
    public SpielerPerson(String nickname, String spielsteinfarbe) {
        super(nickname, spielsteinfarbe);
    }
    public int spielen() {
        Scanner eingabe = new Scanner(System.in);
        System.out.print("\n" + getName() + " (" + getSpielsteinfarbe() + ") ist am Zug. Welche Spalte? ");
        return eingabe.nextInt();
    }
}
