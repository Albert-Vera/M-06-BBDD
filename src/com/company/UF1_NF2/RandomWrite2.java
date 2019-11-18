package com.company.UF1_NF2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;

public class RandomWrite2 {

    public static void main(String[] args) throws IOException {
        String[] nomDepartament = {"Ventas","Personal", "Direcció", "Magatzem"};
        int codiDepartament;
        File aleatori = new File("Departaments.data");
        RandomAccessFile fileRandom = new RandomAccessFile(aleatori, "rw");

        StringBuffer buffer = null;
        int n = nomDepartament.length;

        for (int i = 0; i < n ; i++) {

            codiDepartament = (i +1) * 10;
            buffer = new StringBuffer(nomDepartament[i]);
            buffer.setLength(10);
            fileRandom.writeInt(codiDepartament);
            fileRandom.writeChars(buffer.toString());
        }
        fileRandom.close();
    }
}
