
package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;


/**
 * Datentyp zum Speichern von Knoten und ihren Nachbarn.
 */
public class Knoten {
    private int nummer;
    private Set<Integer> nachbarknoten;

    public Knoten(int nummer) {
        this.nummer = nummer;
        this.nachbarknoten = new HashSet<>();
    }


    /**
     * Getter Nachbarknoten
     *
     * @return Nachbarknoten
     */
    public Set<Integer> getNachbarknoten() {
        return nachbarknoten;
    }

    /**
     * Setter Nachbarknoten
     *
     * @param nachbarknoten Nachbarknoten
     */
    public void setNachbarknoten(int nachbarknoten) {
        this.nachbarknoten.add((int) nachbarknoten);
    }

    /**
     * Getter Knotennummer
     *
     * @return Knotennummer
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * Gibt Knoten und Nachbarknoten auf der Konsole aus.
     */
    public void printKnoten() {
        System.out.println("Knotennummer: " + this.nummer + "  Nachbarknoten: " + getNachbarknoten());
    }
}