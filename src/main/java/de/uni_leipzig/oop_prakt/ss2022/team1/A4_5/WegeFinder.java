package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;

public class WegeFinder {

    private Labyrinth labyrinth;
    private Integer startknoten;
    private Integer zielknoten;
    private List<List<Integer>> wege;

    public WegeFinder(int[] kanten, int startknoten, int zielknoten) {
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;

<<<<<<< Updated upstream
        // Labyrinth labyrinth1 = new Labyrinth(kanten);
=======
        //Labyrinth wird initialisiert
        this.labyrinth = new Labyrinth(kanten);
        this.wege = new ArrayList<List<Integer>>();
//        for (Knoten k : this.labyrinth.getKnoten()) {
//            k.printKnoten();
//        }

>>>>>>> Stashed changes
    }

    public List<List<Integer>> getWege() {
        return wege;
    }

    public List<Integer> findeWeg(Integer startknoten, List<Integer> aktuellerWeg) {
        Knoten start = labyrinth.getKnotenByNummer(startknoten);


        if (!startknoten.equals(this.zielknoten) && istUnbekannterWeg(aktuellerWeg)) {
            for (Integer nachbar : start.getNachbarknoten()) {
                if (!aktuellerWeg.contains(nachbar) && istUnbekannterWeg(aktuellerWeg)) {
                    aktuellerWeg.add(nachbar);
                    aktuellerWeg = findeWeg(nachbar, aktuellerWeg);
                }
            }
        }

        return aktuellerWeg;

    }

    public void findeAlleWege() {



        List<Integer> weg = findeWeg(this.startknoten, new ArrayList<>());
        wege.add(weg);
        List<Integer> weg1 = findeWeg(this.startknoten, new ArrayList<>());
        wege.add(weg1);
        List<Integer> weg2 = findeWeg(this.startknoten, new ArrayList<>());
        wege.add(weg2);
        List<Integer> weg3 = findeWeg(this.startknoten, new ArrayList<>());
        wege.add(weg3);


    }

    private boolean istUnbekannterWeg(List<Integer> aktuellerWeg) {
        for (List<Integer> alterWeg : wege) {
            if (alterWeg.equals(aktuellerWeg)) {
                return false;
            }
        }
            return true;

    }
    public void printWege() {
        for (List<Integer> weg : wege) {
            System.out.println(weg);

        }
    }

    public void printLabyrinth() {
        System.out.println(this.labyrinth.getKnoten());
    }
}
