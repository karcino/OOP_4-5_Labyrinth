package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;
import de.uni_leipzig.oop_prakt.ss2022.team1.io.FileHandler;
import java.util.*;


/**
 * Ausgangspunkt für das Programm mit der main-Methode
 */
public class Main {

    /**
     * ließt eine Labyrinth-datei ein und findet alle kreisfreien Wege zw. 2 Punkten
     *
     * @param args Argumente der Kommandozeile
     */
    public static void main(String[] args) {

        int[][] arr = FileHandler.readIntArrayFromFile("labyrinth-2.graph");

        WegeFinder wegeFinder = new WegeFinder(arr, 72, 70);
        //wegeFinder.printLabyrinth();
        //wegeFinder.printWege();

        System.out.println("------------------");
        System.out.println("Es gibt " + wegeFinder.getAnzahlWege() + " kreisfreie Wege zwischen den Knoten " + wegeFinder.getStartknoten() + " und " +wegeFinder.getZielknoten());


    }
}

