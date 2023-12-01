package viergewinnt1;

import java.util.Scanner;

public class Spiel {
    // Standardgrösse des Spielfelds: 7x6
    private static final int ANZSPALTEN = 7;
    private static final int ANZZEILEN = 6;

    // Standardanzahl Steine in einer Reihe für Sieg: 4
    private static final int GEWINNZAHL = 4;
    private Spielfeld spielfeld;
    private Spieler spieler1;
    private Spieler spieler2;

    public Spiel() {
        this.spielfeld = new Spielfeld(ANZSPALTEN,ANZZEILEN,GEWINNZAHL);
        this.spieler1 = new SpielerPerson("Sepp","Rot");
        //this.spieler2 = new SpielerPerson("Hans","Blau");
        this.spieler2 = new SpielerKI("Apple","Blau");
        System.out.println("\nEs spielen " + spieler1.getName() + " (" + spieler1.getSpielsteinfarbe() + ") gegen " + spieler2.getName() + " (" + spieler2.getSpielsteinfarbe() + ").");
    }
    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        spiel.spielen();
    }

    public void spielen() {
        Spieler aktuellerSpieler = spieler1;
        int spalte;
        boolean hatGewonnen;
        spielfeld.spielfeldZeichnen(false);

        for (int i = 0; i < ANZSPALTEN * ANZZEILEN; i++) {
            spalte = aktuellerSpieler.spielen();
            hatGewonnen = spielfeld.spielsteinEinwerfen(aktuellerSpieler, spalte);
            spielfeld.spielfeldZeichnen(hatGewonnen);
            if (hatGewonnen){
                System.out.println("********** " + aktuellerSpieler.getName() + " hat mit " + aktuellerSpieler.getAnzahlSpielzuege() + " Spielzügen gewonnen. ****************");
                return;
            }
            aktuellerSpieler = (aktuellerSpieler == spieler1 ? spieler2 : spieler1);  // Konditionaloperator :)
        }
        System.out.println("********** UNENTSCHIEDEN ****************");
    }

}
