package de.uni_leipzig.oop_prakt.ss2022.team1.A4_5;
import de.uni_leipzig.oop_prakt.ss2022.team1.io.FileHandler;
import java.util.*;



public class Main {

    public static void main(String[] args) {

        int[][] arr = FileHandler.readIntArrayFromFile("labyrinth-3.graph");

        WegeFinder wegeFinder = new WegeFinder(arr, 1, 8);


        wegeFinder.findeAlleWege();
        wegeFinder.printWege();


    }
}

