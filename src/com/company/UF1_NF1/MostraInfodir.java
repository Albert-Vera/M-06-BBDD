package com.company.UF1_NF1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MostraInfodir {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introdueix la ruta que vols mostra: ");
        String carpet = entrada.nextLine();

        File carpeta = new File(carpet);
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Lect.  Escrit. Ejec. Usuario Longitud   Fecha              Nombre");
            System.out.println();
            for (int i=0; i< archivos.length; i++) {
                File archivo = archivos[i];
                System.out.println(String.format("%s-%s-%s - %s -  %d -  %s -  %s",
                        archivo.canRead(),
                        archivo.canWrite(),
                        archivo.canExecute(),
                        archivo.isDirectory() ? "Carpeta" : "Archivo",
                        archivo.length(),
                        sdf.format(archivo.lastModified()),
                        archivo.getName()
                ));
            }
        }
    }
}
