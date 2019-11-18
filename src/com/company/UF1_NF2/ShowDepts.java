package com.company.UF1_NF2;

import java.io.*;

public class ShowDepts {

    public static void main(String[] args) throws IOException {

        File aleatori = new File("Departaments.data");
        RandomAccessFile fileRandom = new RandomAccessFile(aleatori, "r");

        int codiDepart, posicion=0;
        char[] nom = new char[10];
        char aux;
        try {
            while (true){
                fileRandom.seek(posicion);
                codiDepart = fileRandom.readInt();

                if (codiDepart != 0) {  //  LEE LOS ID DEPARTAMENTOS QUE SON DIFERENTES A CERO

                    for (int i = 0; i < nom.length; i++) {
                        nom[i] = fileRandom.readChar();
                    }
                    String nomDepart = new String(nom);
                    System.out.println("Codi de departament: " + codiDepart);
                    System.out.println("Nom del departametn: " + nomDepart);
                }
                posicion = posicion + 24;
            }
        }catch (EOFException e){
            fileRandom.close();
        }

    }
}
