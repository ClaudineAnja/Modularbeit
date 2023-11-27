package viergewinnt1;

public class Spielstein {
    private final Spieler spieler;
    private int gewinnCheckID;
    public Spielstein(Spieler spieler) {
        this.spieler = spieler;
        this.gewinnCheckID = 0;
    }
    public Spieler getSpieler() {
        return spieler;
    }

    public int getGewinnCheckID() {
        return gewinnCheckID;
    }

    public void setGewinnCheckID(int gewinnCheckID) {
        this.gewinnCheckID = gewinnCheckID;
    }
}
