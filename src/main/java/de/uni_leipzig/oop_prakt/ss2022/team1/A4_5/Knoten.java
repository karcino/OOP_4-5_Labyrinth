package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

public class Knoten {
    private int nummer;
    private Knoten[] nachbarknoten;

    public Knoten(int nummer, Knoten[] nachbarknoten) {
        this.nummer = nummer;
        this.nachbarknoten = nachbarknoten;
    }

    public int getNummer() {
        return nummer;
    }

    public Knoten[] getNachbarknoten() {
        return nachbarknoten;
    }
}
