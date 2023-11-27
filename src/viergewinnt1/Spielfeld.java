package viergewinnt1;

public class Spielfeld {
    private final int anzahlSpalten;
    private final int anzahlZeilen;
    private final int gewinnzahl;
    private Spielstein[][] spielfeld;
    private int gewinnCheckID;

    public Spielfeld(int anzahlSpalten, int anzahlZeilen, int gewinnzahl) {
        this.anzahlSpalten = anzahlSpalten;
        this.anzahlZeilen = anzahlZeilen;
        this.gewinnzahl = gewinnzahl;
        this.spielfeld = new Spielstein[anzahlSpalten][anzahlZeilen];
        this.gewinnCheckID = 0;
    }
    public void spielfeldZeichnen(boolean hatGewonnen) {
        String zeichen;
        System.out.println();
        for (int i = 1; i <= anzahlSpalten; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int y = (anzahlZeilen - 1); y >= 0; y--) {
            System.out.print("|");
            for (int x = 0; x < anzahlSpalten; x++) {
                Spielstein spielstein = spielfeld[x][y];
                if (spielstein == null) {
                    zeichen = " ";
                } else {
                    if ((hatGewonnen && spielstein.getGewinnCheckID() == gewinnCheckID)) {
                        zeichen = spielstein.getSpieler().getSpielsteinfarbe().toUpperCase().substring(0,1);
                    } else {
                        zeichen = spielstein.getSpieler().getSpielsteinfarbe().toLowerCase().substring(0,1);
                    }
                }
                System.out.print(zeichen + "|");
            }
            System.out.println();
        }
    }
    public boolean spielsteinEinwerfen(Spieler spieler, int spalte){
        // Vom Spieler eingegebene Spaltennummer um 1 reduzieren, damit sie zum Array-Index passt
        spalte --;

        // erste leere Zeile suchen
        int zeile = 0;
        while (spielfeld[spalte][zeile] != null) {
            zeile++;
        }

        // Stein an ermittelter Stelle einfügen und Anzahl Spielzüge des Spielers erhöhen
        spielfeld[spalte][zeile] = new Spielstein(spieler);
        spieler.spielzugGemacht();

        // Hat dieser Steineinwurf zum Sieg geführt?
        return hatGewonnen(spalte,zeile);
    }
    private boolean hatGewonnen(int x, int y){
        // horizontal
        gewinnCheckID++;
        if ((anzGleicheNachbarn(x,y,-1,0) + anzGleicheNachbarn(x,y,1,0)) >= gewinnzahl - 1) {return true;}
        // vertikal
        gewinnCheckID++;
        if ((anzGleicheNachbarn(x,y,0,-1) + anzGleicheNachbarn(x,y,0,1)) >= gewinnzahl - 1) {return true;}
        // diagonal unten links nach oben rechts
        gewinnCheckID++;
        if ((anzGleicheNachbarn(x,y,-1,-1) + anzGleicheNachbarn(x,y,1,1)) >= gewinnzahl - 1) {return true;}
        // diagonal oben links nach unten rechts
        gewinnCheckID++;
        if ((anzGleicheNachbarn(x,y,-1,1) + anzGleicheNachbarn(x,y,1,-1)) >= gewinnzahl - 1) {return true;}
        return false;
    }
    private int anzGleicheNachbarn(int x, int y, int xIter, int yIter){
        int anzGleiche = 0;
        while (checkZweiSteineGleich(x,y,x+xIter,y+yIter)){
            anzGleiche++;
            x+=xIter;
            y+=yIter;
        }
        return anzGleiche;
    }
    private boolean checkZweiSteineGleich(int x1, int y1, int x2, int y2){
        if (outOfBoundery(x1,anzahlSpalten) || outOfBoundery(y1,anzahlZeilen) || outOfBoundery(x2,anzahlSpalten) || outOfBoundery(y2,anzahlZeilen)){
            return false;
        }
        Spielstein stein1 = spielfeld[x1][y1];
        Spielstein stein2 = spielfeld[x2][y2];
        if (stein1 != null && stein2 != null) {
            stein1.setGewinnCheckID(gewinnCheckID);
            stein2.setGewinnCheckID(gewinnCheckID);
            return stein1.getSpieler().equals(stein2.getSpieler());
        }
        return false;
    }
    private boolean outOfBoundery(int zahl, int max){
        return (zahl < 0 || zahl >= max);
    }
}
