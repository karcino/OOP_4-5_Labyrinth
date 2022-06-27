package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;
public class WegeFinder {

    private Labyrinth labyrinth;
    private int Startknoten; // wird vom Filehandler als int übergeben§
    private int Zielknoten;
    private List<List<Knoten>> wege;

    public WegeFinder(int[] Kanten, int startknoten, int zielknoten) {
        Startknoten = startknoten;
        Zielknoten = zielknoten;
        //TODO Labyrinth mit Kanten[] intitialisieren
        Labyrinth labyrinth1 = new Labyrinth(Kanten);
    }

    public List<List<Knoten>> getWege() {
        return wege;
    }

    private List<Knoten> findeWeg(Knoten startKnoten, List<Knoten>) {

        //TODO Rekursion implementiern



    }
    public void findeAlleWege() {
        while () {

    }
}
