package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;
import java.util.*;

public class WegeFinder {

    private Labyrinth labyrinth;
    private int startknoten; // wird vom Filehandler als int übergeben§
    private int zielknoten;
    private List<List<Knoten>> wege;

    public WegeFinder(int[][] kanten, int startknoten, int zielknoten) {
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;
        //TODO Labyrinth mit Kanten[] intitialisieren

        this.labyrinth = new Labyrinth(kanten);
    }

    public List<List<Knoten>> getWege() {
        return wege;
    }

    private List<Knoten> findeWeg(List<Knoten> aktuellerWeg) {
        return findeWeg(null);

    }

    public void findeAlleWege() {

    }
}
