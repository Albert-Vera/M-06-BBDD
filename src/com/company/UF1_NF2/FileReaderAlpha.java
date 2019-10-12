package com.company.UF1_NF2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderAlpha {

    public static void main(String[] args) throws IOException {

        File leerFile = new File("alphabeta.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {
            System.out.print(line.toUpperCase() + " ");
        }
        inputStream.close();
    }
}
