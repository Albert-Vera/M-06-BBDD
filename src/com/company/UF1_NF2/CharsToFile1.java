package com.company.UF1_NF2;

import java.io.*;

public class CharsToFile1 {



    public static File guardaFile = new File("alphabeta.txt");
    static String abc = "abcdefghijklmnopqrstuxyz";

    public static void main(String[] args) throws IOException {

        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));
        BufferedReader inputStream = new BufferedReader(new FileReader(guardaFile));
        String line = inputStream.readLine();

        if( line == null ){


                for (int x = 0; x < 24; x++) {
                    outputStream.write(abc.charAt(x) + "\n");
                }
        }
        outputStream.close();
        inputStream.close();
    }
}

