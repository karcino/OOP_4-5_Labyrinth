package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

<<<<<<< Updated upstream
=======
import java.util.*;

>>>>>>> Stashed changes
public class Labyrinth {
    private Set<Knoten> knoten;
    private int[][] kanten;

    public Labyrinth(int[][] kanten) {
        this.kanten = kanten;
<<<<<<< Updated upstream
=======

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

>>>>>>> Stashed changes
    }

    public Set<Knoten> getKnoten() {
        return knoten;
    }

    public Knoten getKnotenByNummer(int i) {
        return knoten.stream()
                .filter(x -> x.getNummer() == i)
                .findFirst()
                .get();
    }

    public int[][] getKanten() {
        return kanten;
    }

    public void printAlleKnoten(){
        for (Knoten k : this.knoten) {
            System.out.print(k.getNummer());
            System.out.print(" ");
        }
    }

}
