package com.company.UF1_NF2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreballadorsToFile1 {

    public static File guardaFile = new File("treballadors.txt");
    private String nom, cognoms, casat;
    private int salari;
    private String sep= ",";

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));
        String op="y";

        while ( op.equals("y")) {

            TreballadorsToFile1 treballadorsToFile1 = new TreballadorsToFile1();

            System.out.println("Introduce nombre: " );
            treballadorsToFile1.nom= in.nextLine();
            System.out.println("Apellidos: ");
            treballadorsToFile1.cognoms = in.nextLine();
            System.out.println("Salario: ");
            treballadorsToFile1.salari = in.nextInt(); in.nextLine();
            System.out.println("Casat Si/No: ");
            treballadorsToFile1.casat = in.nextLine();
            System.out.println();
            System.out.println("Quieres introducir otro empleado: (y/n) ");
            op = in.nextLine();

            outputStream.write(treballadorsToFile1.nom + treballadorsToFile1.sep + treballadorsToFile1.cognoms + treballadorsToFile1.sep + treballadorsToFile1.salari + treballadorsToFile1.sep + treballadorsToFile1.casat + "\n");
        }

        outputStream.close();


    }
}
