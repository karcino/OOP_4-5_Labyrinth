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


//    public void findeWegeVoid(Integer aktuellerKnoten, List<Integer> aktuellerWeg) {
//
//        //System.out.println(aktuellerWeg);
//        Knoten start = labyrinth.getKnotenByNummer(aktuellerKnoten);
//        aktuellerWeg.add(aktuellerKnoten);
//
//        // Iteriere durch alle Nachbarknoten
//        for (Integer nachbar : start.getNachbarknoten()) {
//            // Prüfe, ob nachbar bereits in aktuellem Weg vorhanden ist
//            if (!aktuellerWeg.contains(nachbar)) {
//                // Wenn nicht, gehe bei nachbarn weiter
//                findeWegeVoid(nachbar, aktuellerWeg);
//            }
//        }
//
//        if (aktuellerKnoten.equals(this.zielknoten) && istUnbekannterWeg(aktuellerWeg)) {
//            this.wege.add(aktuellerWeg);
//        }
//
//    }


    public void findeWegeVoid(Integer from, Integer to , List<Integer> aktuellerWeg) {

        Knoten start = labyrinth.getKnotenByNummer(from);
        aktuellerWeg.add(from);

        if (from.equals(this.zielknoten)) {
            System.out.println("s-z-Weg: " + aktuellerWeg);
            this.wege.add(aktuellerWeg);
            aktuellerWeg.remove(aktuellerWeg.size() -1);
        }else {
            Integer nachbarArray[] = new Integer[start.getNachbarknoten().size()];
            start.getNachbarknoten().toArray(nachbarArray);
            System.out.println(aktuellerWeg);

            for (int i = 0; i < nachbarArray.length; i++) {
                int nachbar = (int) nachbarArray[i];
                System.out.println("Aufruf from: " + from + " mit nachbar: " + nachbar);

                // Prüfe, ob nachbar bereits in aktuellem Weg vorhanden ist
                if (!aktuellerWeg.contains(nachbar)) {
                    // Wenn nicht, gehe bei nachbarn weiter
                    findeWegeVoid(nachbar, to, aktuellerWeg);
                }

            }
        }

    }







    public void findeAlleWege() {



        findeWegeVoid(this.startknoten, this.zielknoten, new ArrayList<>());




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