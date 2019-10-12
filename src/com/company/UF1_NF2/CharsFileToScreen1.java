package com.company.UF1_NF2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class CharsFileToScreen1 {

    static File leerFile = new File("alphabeta.txt");

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {
            System.out.print(line + " ");
        }
        inputStream.close();
    }
}
