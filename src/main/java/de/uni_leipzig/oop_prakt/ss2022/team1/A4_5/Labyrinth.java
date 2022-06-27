package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import

public class Labyrinth {
    private Knoten[] knoten;
    private int[][] kanten;

    public Labyrinth(int[][] kanten) {
        this.kanten = kanten;
    }

    public Knoten[] getKnoten() {
        return knoten;
    }

    public int[][] getKanten() {
        return kanten;
    }

}
