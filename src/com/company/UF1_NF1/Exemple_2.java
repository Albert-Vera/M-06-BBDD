package com.company.UF1_NF1;

import java.io.File;

public class Exemple_2 {
    public static void main(String[] args) {

        // Codi per a la creacio d'un objecte File amb un fitxer anomenat libre.xml
        System.out.println("");
        System.out.println("Creació llibre.xml");
        File llibre = new File("/home/albert/Documents/M-06/llibre.xml");
        System.out.println("Nom: " + llibre.getName());
        System.out.println("Directori pare: " + llibre.getParent());
        System.out.println("Ruta absoluta: " + llibre.getAbsolutePath());

        // Existeix ??

        System.out.println("");
        System.out.println("Ara hi ha un fitxer anomenat llibre.xml ????");
        System.out.println("Existeix aquest fitxer ? " + llibre.exists());
    }
}
