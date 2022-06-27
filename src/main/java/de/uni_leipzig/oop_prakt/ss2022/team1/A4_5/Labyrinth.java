package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import de.uni_leipzig.oop_prakt.ss2022.team1.io.FileHandler;

import java.util.HashSet;
import java.util.Set;

public class Labyrinth {
    private Knoten[] knoten;
    private int[][] kanten;

    public Labyrinth(int[][] kanten) {
        this.kanten = kanten;
        // Finde alle einzelknoten ohne Duplikate
        Set<Knoten> tempSet = new HashSet<Knoten>();
        for (int[] kante: kanten) {
            for(int knoten : kante){
                tempSet.add(new Knoten(knoten));
            }
        }
        this.knoten = new Knoten[tempSet.size()];
        for (int i = 0; i < kanten.length; i++) {

        }


    }

    public Knoten[] getKnoten() {
        return knoten;
    }

    public int[][] getKanten() {
        return kanten;
    }

}
