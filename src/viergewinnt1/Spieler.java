package viergewinnt1;

import java.util.Scanner;

public abstract class Spieler {
    private final String nickname;
    private final String spielsteinfarbe;
    private int anzahlSpielzuege;

    public Spieler(String nickname,  String spielsteinfarbe) {
        this.nickname = nickname;
        this.spielsteinfarbe = spielsteinfarbe;
        this.anzahlSpielzuege = 0;
        System.out.println("Spieler "+ nickname + " (Spielsteinfarbe " + spielsteinfarbe + ") erfasst.");
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
    public abstract int spielen();
}
