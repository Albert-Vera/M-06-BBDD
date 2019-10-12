package com.company.UF1_NF2;

import java.io.*;
import java.util.Scanner;

public class CopyDirFRFW {
    public static void main(String[] args) throws IOException {



        File guardaFile = new File("copyDir.txt");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));


        String line;

        File dir = new File("/home/albert/Documents/M-06/datosTxt");
        String[] ficheros = dir.list();



        if (ficheros == null)
            System.out.println("No hay ficheros en el directorio especificado");
        else {

            for (int x = 0; x < ficheros.length; x++) {

                BufferedReader inputStream = new BufferedReader(new FileReader(ficheros[x]));

                if (x == 0) {
                    System.out.println("\n ################     Fichero a leer: " + ficheros[x] + "  ##########################\n");
                    outputStream.write("Nombre fichero: " + ficheros[x] + "\n");
                }else{
                    System.out.println("\n ################     Fichero a leer: " + ficheros[x] + "  ##########################\n");
                    outputStream.write("\n Nombre fichero: " + ficheros[x] + "\n");
                }
                while((line = inputStream.readLine()) != null && !line.isEmpty()) {
                    System.out.println(line + " ");
                    outputStream.write(line + "\n");
                }
                inputStream.close();
            }
        }
        outputStream.close();
    }
}