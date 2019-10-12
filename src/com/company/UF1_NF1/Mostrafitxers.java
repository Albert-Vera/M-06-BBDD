package com.company.UF1_NF1;

import java.io.File;
import java.util.Scanner;

public class Mostrafitxers {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introdueix la ruta que vols mostra: ");
        String carpeta = entrada.nextLine();

        File dir = new File(carpeta);
        String[] ficheros = dir.list();

        if (ficheros == null)
            System.out.println("No hay ficheros en el directorio especificado");
        else {
            for (int x=0;x<ficheros.length;x++)
                System.out.println(ficheros[x]);
        }
    }
}
