package com.company.UF1_NF2;

import java.io.*;

public class CSVToScreen {

    private static String SEP=",";
    private static String nom, cognom, usuari, password, email;

    public static void main(String[] args) throws IOException {

        llegirCSV();
    }

    private static void llegirCSV() throws IOException {

        File leerFile = new File("agenda_ex_13.csv");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;
        int contador= 0;

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {


            String[] values = line.split(SEP);
            CSVToScreen.nom = values[0];
            CSVToScreen.cognom = values[1];
            CSVToScreen.usuari = values[2];
            CSVToScreen.password = values[3];
            CSVToScreen.email = values[4];

            if (!values[0].equals("Firstname")){
                contador++;
                System.out.println("\n Persona:  " + contador + "\n");
                System.out.println(" Firstname: " + CSVToScreen.nom);
                System.out.println(" Lastname:  " + CSVToScreen.cognom);
                System.out.println(" User:      " + CSVToScreen.usuari);
                System.out.println(" Password:  " + CSVToScreen.password);
                System.out.println(" Email:     " + CSVToScreen.email + "\n");


            }
        }
        inputStream.close();
    }
}
