package com.company.UF1_NF2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class probafiltre {



    public static void main(String[] args) throws IOException {

        // aquí creas los filtros



        //Una vez creados los filtros, sólo debes asignárselos al cuadro de diálogo
//        JFileChooser jf = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT: ", "txt");
//        jf.setFilter(filter);

        File guardaFile = new File("copyDir.txt");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));


        String line;

        File dir = new File("/home/albert/Documents/M-06/datosTxt");
        String[] ficheros = dir.list();



        if (ficheros == null)
            System.out.println("No hay ficheros en el directorio especificado");
        else {

            for (int x = 0; x < ficheros.length; x++) {
                System.out.println("jk");

                    BufferedReader inputStream = new BufferedReader(new FileReader(ficheros[x]));
                    System.out.println("\n ################     Fichero a leer: " + ficheros[x] + "  ##########################\n");
                    outputStream.write("\n Nombre fichero: " + ficheros[x] + "\n");

                    while ((line = inputStream.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line + " ");
                        outputStream.write(line + "\n");
                    }
                    inputStream.close();

            }
        }
        outputStream.close();
    }
}
