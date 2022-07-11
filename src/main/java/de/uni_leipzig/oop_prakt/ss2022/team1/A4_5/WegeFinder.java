package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;

/**
 * Instanz findet alle Wege von start nach zielknoten in einem Labyrinth.
 */
public class WegeFinder {

    private Labyrinth labyrinth;
    private Integer startknoten;
    private Integer zielknoten;
    private List<Stack> wege;

    /**
     * Konstruktor Wegefinder
     *
     * @param kanten Kanten des Labyrinth-Graph's
     * @param startknoten Startknoten
     * @param zielknoten Zielknoten
     */
    public WegeFinder(int[][] kanten, int startknoten, int zielknoten) {
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;


        //Labyrinth wird initialisiert
        this.labyrinth = new Labyrinth(kanten);
        this.wege = new ArrayList<Stack>();


        Stack startstack = new Stack();
        startstack.push(this.startknoten);
        findeWege(this.startknoten, this.zielknoten,startstack);
    }

    /**
     * @param start Startknotennummer
     * @param ziel Zielknotennummer
     * @param aktuellerWeg temporärer Stack zum speichern der durchlaufenen Knoten
     */
    private void findeWege(Integer start, Integer ziel , Stack<Integer> aktuellerWeg) {

        // Get Knotenelement mit startnummer
        Knoten startKnoten = labyrinth.getKnotenByNummer(start);

        // Iteriere durch alle Nachbarknoten des Startknotens
        for (Integer nachbar : startKnoten.getNachbarknoten()) {

            // Wenn der nachbarknoten == zielknoten ist
            if (nachbar.equals(ziel)) {

                // Aktueller Weg in temporären Stack kopieren (neue Instanz nötig, da sonst nur Pass-by-Reference)
                Stack<Integer> temp = new Stack<>();
                for (Integer node : aktuellerWeg) {
                    temp.push(node);
                }
                // Zielknoten hinzufügen und erfolgreichen Weg abspeichern
                temp.push(nachbar);
                this.wege.add(temp);
            }

            // Wenn der nachbar noch nicht im Weg vorhanden ist
            if (!aktuellerWeg.contains(nachbar)) {

                // Nachbarn zum Weg hinzufühen
                aktuellerWeg.push(nachbar);
                // Recursiver Aufruf mit Nachbarknoten als Start und aktuellem Weg
                findeWege(nachbar, ziel, aktuellerWeg);
                // Letztes Element von Stack nehmen,
                // damit nächster Nachbar in der For-Schleife den gleichen aktuellen Weg vorfindet
                aktuellerWeg.pop();
            }
        }
    }

    /**
     * Getter Startknoten
     *
     * @return Startknotennummer
     */
    public Integer getStartknoten() {
        return startknoten;
    }

    /**
     * Getter Zielknoten
     *
     * @return Zielknotennummer
     */
    public Integer getZielknoten() {
        return zielknoten;
    }

    /*public List<Stack> getWege() {
        return wege;
    }*/

    /**
     * Gibt Anzahl aller möglichen Wege zurück.
     * @return Anzahl der Wege
     */
    public int getAnzahlWege(){
        return this.wege.size();
    }

    /**
     * Gibt alle möglichen Wege auf der Konsole aus.
     */
    public void printWege() {
        System.out.println("Alle wege: ");
        for (Stack weg : this.wege) {
            System.out.println(weg);
        }
    }

    /**
     * Gibt alle Knoten und dessen Nachbarknoten auf der Konsole aus.
     */
    public void printLabyrinth(){
        for (Knoten k : this.labyrinth.getKnoten()) {
            k.printKnoten();
        }
    }
}