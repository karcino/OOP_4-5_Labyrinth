package de.uni_leipzig.oop_prakt.ss2022.team1.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse FileHandler ist zuständig für das Einlesen und Schreiben von Textdateien.
 *
 * @author Wahrenburg, David
 */
public final class FileHandler {
    /**
     * Liest von Dateiname und gibt String zurück.
     *
     * @author Wahrenburg, David
     */
    public static String readFromFile(String filename) {
        StringBuilder tempStr = new StringBuilder();

        try(FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();

            while (line != null) {
                tempStr.append(line);
                tempStr.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = tempStr.toString();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return tempStr.toString();
    }

    public static int[] readIntArrayFromFile(String filename) {
        StringBuilder tempStr = new StringBuilder();

        List<Integer> intList = new ArrayList<Integer>();



        try(FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr)){
            String line = br.readLine();

            while (line != null) {
                String[] strs = line.trim().split("\\s+");
                for (String str : strs){
                    intList.add(Integer.parseInt(str));
                }
                line = br.readLine();
            }
            String everything = tempStr.toString();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        int[] intArray = new int[intList.size()];
        for(int i = 0; i < intList.size(); i++) intArray[i] = intList.get(i);


        return intArray;
    }




    /**
     * Schreibt den String in die Datei.
     *
     * @author Wahrenburg, David
     */
    public static void writeFile(String filename, String filetext) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(filetext);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return;
        }

    }
}
