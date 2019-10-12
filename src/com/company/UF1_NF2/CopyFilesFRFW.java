package com.company.UF1_NF2;

import java.io.*;

public class CopyFilesFRFW {
    public static void main(String[] args) throws IOException {

        File guardaFile = new File("alphabetacopy.txt");
        File leerFile = new File("alphabeta.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));
        String line;

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {
            outputStream.write(line + "\n");
        }
        inputStream.close();
        outputStream.close();
    }
}
