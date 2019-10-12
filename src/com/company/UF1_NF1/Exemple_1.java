package com.company.UF1_NF1;

import org.w3c.dom.ls.LSOutput;

import java.io.File;

public class Exemple_1 {
    public static void main(String[] args) {

        System.out.println("Mostra el fitxers del directori actual");
        File f = new File(".");
        String[] arxius = f.list();

        for (int i = 0; i < arxius.length; i++){
            System.out.println(arxius[i]);
        }
        System.out.println("\n ################################################## \n");

        System.out.println("Retorna un array del fitxe objecte indican fitxers de sistema");
        File[] roots = File.listRoots();

        for (File root : roots){
            System.out.println(root);
        }
    }

}
