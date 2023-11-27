package viergewinnt1;

import java.util.Scanner;

public class Spieler {
    private final String nickname;
    private final String spielsteinfarbe;
    private int anzahlSpielzuege;

    public Spieler(String bezeichnung,  String spielsteinfarbe) {
        System.out.println("Erfassung von "+ bezeichnung + " (Spielsteinfarbe " + spielsteinfarbe + ")");
        this.nickname = spielerDetailsErfassen("Nickname");
        this.spielsteinfarbe = spielsteinfarbe;
        this.anzahlSpielzuege = 0;
    }
    private String spielerDetailsErfassen(String detail) {
        Scanner eingabe = new Scanner(System.in);
        System.out.print(detail + ": ");
        return eingabe.next();
    }
    public int spielen(){
        Scanner eingabe = new Scanner(System.in);
        System.out.print(getName() + " (" + getSpielsteinfarbe() + ") ist am Zug. Welche Spalte? ");
        return eingabe.nextInt();
    }
    public String getName() {
        return nickname;
    }
    public String getSpielsteinfarbe() {
        return spielsteinfarbe;
    }
    public int getAnzahlSpielzuege() { return anzahlSpielzuege; }
    public void spielzugGemacht(){
        anzahlSpielzuege++;
    }
    @Override
    public String toString() {
        return (getName() + ", Steinfarbe " + getSpielsteinfarbe() + ", Anzahl Züge: " + anzahlSpielzuege);
    }
}
