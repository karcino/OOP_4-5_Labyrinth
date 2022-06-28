
package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;


public class Knoten {
    private int nummer;
    private Set<Integer> nachbarknoten;
    private boolean visited;

    public Knoten(int nummer) {
        this.nummer = nummer;
        this.nachbarknoten = new HashSet<>();
        this.visited = false;
    }


    public Set<Integer> getNachbarknoten() {
        return nachbarknoten;
    }

    public void setNachbarknoten(int nachbarknoten) {
        this.nachbarknoten.add((int) nachbarknoten);
    }

    public void setVisited() {
        this.visited = true;
    }

    public int getNummer() {
        return nummer;
    }

    public void printKnoten(){
        System.out.println("Knotennummer: " + this.nummer + "  Nachbarknoten: " + getNachbarknoten());
    }
}


