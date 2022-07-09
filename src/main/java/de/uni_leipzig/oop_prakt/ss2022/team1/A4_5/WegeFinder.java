package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;

import java.util.*;

public class WegeFinder {

    private Labyrinth labyrinth;
    private Integer startknoten;
    private Integer zielknoten;
    private List<List<Integer>> wege;

    public WegeFinder(int[][] kanten, int startknoten, int zielknoten) {
        this.startknoten = startknoten;
        this.zielknoten = zielknoten;


        //Labyrinth wird initialisiert
        this.labyrinth = new Labyrinth(kanten);
        this.wege = new ArrayList<List<Integer>>();
        
//        for (Knoten k : this.labyrinth.getKnoten()) {
//            k.printKnoten();
//        }

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


    public void findeWegeVoid(Integer startknoten, List<Integer> aktuellerWeg) {

        //System.out.println(aktuellerWeg);
        Knoten start = labyrinth.getKnotenByNummer(startknoten);
        aktuellerWeg.add(startknoten);


        for (Integer nachbar : start.getNachbarknoten()) {
            if (!aktuellerWeg.contains(nachbar)) {
                findeWegeVoid(nachbar, aktuellerWeg);
            }
        }

        if (startknoten.equals(this.zielknoten) && istUnbekannterWeg(aktuellerWeg)) {
            this.wege.add(aktuellerWeg);
        }

    }



    public void findeAlleWege() {



        findeWegeVoid(this.startknoten, new ArrayList<>());
        findeWegeVoid(this.startknoten, new ArrayList<>());
        findeWegeVoid(this.startknoten, new ArrayList<>());



        //List<Integer> weg = findeWeg(this.startknoten, new ArrayList<>());
        //wege.add(weg);


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