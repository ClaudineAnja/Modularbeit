package viergewinnt1;

import java.util.Scanner;

public class SpielerKI extends Spieler {
    public SpielerKI(String nickname, String spielsteinfarbe) {
        super(nickname, spielsteinfarbe);
    }
    public int spielen() {
        int spalte = (int)(Math.random() * 7)+1;
        System.out.println("\n" + getName() + " ist am Zug -> Spalte " + spalte);
        return spalte;
    }
}
