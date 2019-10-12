package com.company.UF1_NF2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumsToFile1 {

    public static String SEP = ":";
    public static File guardarFile = new File("Num11001200");

    public static void main(String[] args) throws IOException {

        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardarFile, true));

        for (int x=1100; x < 1201; x++){
            outputStream.write(x + SEP);
        }
        outputStream.close();
    }
}
