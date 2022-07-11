
package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;
import de.uni_leipzig.oop_prakt.ss2022.team1.io.FileHandler;

/**
 * Implementiert das Labyrinth
 * @author Fiedler, Paul
 */
public class Labyrinth {
    private Set<Knoten> knoten;
    private int[][] kanten;

    /**
     * Konstruktor Labyrinth
     *
     * @param kanten Kanten des Labyrinths
     */
    public Labyrinth(int[][] kanten) {
        this.kanten = kanten;

        // Finde alle einzelknoten ohne Duplikate (deshalb Integer Set)
        Set<Integer> tempSet = new HashSet<>();
        for (int[] kante : kanten) {
            for (int knoten : kante) {
                tempSet.add(knoten);
            }
        }
        // Erstelle für jeden Einzelknoten ein Knotenelement und füge es dem Knoten-Set hinzu
        this.knoten = new HashSet<>();
        for (Integer k : tempSet) {
            this.knoten.add(new Knoten(k));
        }

        // Füge jedem Knoten die Nachbarknoten als Integer hinzu. Diese können dann mittels "getKnotenByNummer" abgerufen werden.
        for (Knoten k : this.knoten) {
            for (int[] kante : kanten) {
                if (k.getNummer() == kante[0]) {
                    k.setNachbarknoten(kante[1]);
                }
                if (k.getNummer() == kante[1]) {
                    k.setNachbarknoten(kante[0]);
                }
            }

        }
    }

    /**
     * Getter des Attributes knoten
     *
     * @return Gibt ein Set von Knoten zurück
     */
    public Set<Knoten> getKnoten() {
        return knoten;
    }

    /**
     * @param i Knotennummer
     * @return Knotenobjekt mit der nummer i
     */
    public Knoten getKnotenByNummer(int i) {
        return knoten.stream()
                .filter(x -> x.getNummer() == i)
                .findFirst()
                .get();
    }

    /**
     * Getter des Attributes Kanten
     *
     * @return kanten Knaten des Labyrinths
     */
    public int[][] getKanten() {
        return kanten;
    }

    /**
     * Gibt alle Knoten in der Konsole
     */
    public void printAlleKnoten(){
        for (Knoten k : this.knoten) {
            System.out.print(k.getNummer());
            System.out.print(" ");
        }
    }

}

