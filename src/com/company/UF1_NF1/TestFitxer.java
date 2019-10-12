package com.company.UF1_NF1;

import java.io.File;
import java.text.SimpleDateFormat;


public class TestFitxer {
    public static void main(String[] args) {

        File dir = new File("/home/albert/Documents/M-06/Exercicis-M06.odt");


        if (!dir.exists())
            System.out.println("El archivo especificado No EXISTE");
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println(" Nom complert: " + String.format("%s (%s) - %d - %s" ,

                    dir.getName(),
                    dir.isDirectory() ? "Carpeta" : "Archivo",
                    dir.length(),
                    sdf.format(dir.lastModified())


            ));
            System.out.println("Ruta: " + String.format(dir.getAbsolutePath()));

        }
    }
}
