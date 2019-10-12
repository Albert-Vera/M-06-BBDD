package com.company.UF1_NF2;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;

public class TreballadorsToScreen1 {

    static File guardaFile = new File("treballadors.txt");
    static String sep= ",";

    public static void main(String[] args) throws IOException {

        String nom, cognoms, casat;
        int salari;
        int i= 0;

        BufferedReader inputStream = new BufferedReader(new FileReader(guardaFile));
        String line;
        System.out.println("TREBALLADORS");

        while((line = inputStream.readLine()) != null && !line.isEmpty()){
            String[] values = line.split(sep);
            i++;
            System.out.println("Treballador " +  i);
            System.out.println();
            nom = values[0];
            cognoms = values[1];
            salari= Integer.valueOf(values[2]);
            casat = values[3];
            System.out.println(nom);
            System.out.println(cognoms);
            System.out.println(salari);
            System.out.println(casat);
            System.out.println();
        }

        inputStream.close();
    }
}
