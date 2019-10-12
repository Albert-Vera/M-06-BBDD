package com.company.UF1_NF1;

import java.io.File;

public class CreaDir {
    public static void main(String[] args) {

        File directorio = new File("/home/albert/Documents/M-06/directorio");


        if(directorio.exists()){
            System.out.println("El directorio ya existe");
        }else{
            directorio.mkdir();
            System.out.println("El directorio no existe");
            System.out.println("Se ha creado el directorio:  " + String.format(directorio.getName()));
        }

    }
}
