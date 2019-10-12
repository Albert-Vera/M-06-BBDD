package com.company.UF1_NF2;

import java.io.*;

public class CopyArrayToFile {

    public static void main(String[] args) throws IOException {


        File guardaFile = new File("copyArray.txt");
        String paraules[] = {"casa", "mesa", "reloj", "silla", "coche", "lapiz", "color"};
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));
        BufferedReader inputStream = new BufferedReader(new FileReader(guardaFile));
        String line = inputStream.readLine();

        if( line == null ) {

            for (String x : paraules) {
                outputStream.write(x + "\n");
            }
        }
        inputStream.close();
        outputStream.close();
        imprimir();
    }

    static void imprimir() throws IOException {
        File guardFile = new File("copyArray.txt");
        BufferedReader inputStream2 = new BufferedReader(new FileReader(guardFile));
        String line2;

        while ((line2 = inputStream2.readLine()) != null && !line2.isEmpty()) {
            System.out.println(line2 + " ");
        }
        inputStream2.close();
    }
}
