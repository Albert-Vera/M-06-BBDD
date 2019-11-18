package com.company.UF1_NF2;





import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShowTreballadors extends Trabajador{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // MUESTRA SOLO LOS CASOS EN QUE COINCIDE CON EL MISMO NUMERO DE ID DEPARTAMENT
        // DE LOS DOS FICHEROS
        mostraDades();
    }

    static boolean leerDepart(int idDepart) throws IOException {

        boolean condicion = false;
        File aleatori = new File("Departaments.data");
        RandomAccessFile fileRandom = new RandomAccessFile(aleatori, "r");

        int codiDepart, posicion=0;
        char[] nom = new char[10];
        char aux;
        try {
            while (true){
//                fileRandom.seek(posicion);
                codiDepart = fileRandom.readInt();

                if (codiDepart != 0) {  //  LEE LOS ID DEPARTAMENTOS QUE SON DIFERENTES A CERO

                    for (int i = 0; i < nom.length; i++) {
                        nom[i] = fileRandom.readChar();
                    }
                    String nomDepart = new String(nom);

                    if (idDepart == codiDepart){
                        System.out.println("Nom del departametn: " + nomDepart);
                        condicion = true;
                    }


                }
                posicion = posicion + 24;
            }
        }catch (EOFException e){
            fileRandom.close();
        }
        return condicion;
    }





    static void mostraDades() throws IOException, ClassNotFoundException {

        boolean condicion;
        ObjectInputStream object = null;
        List<Trabajador> trabajadorList ;
        try {
            File lectura = new File("Trabajadores.data");
            FileInputStream fis = new FileInputStream(lectura);
            object = new ObjectInputStream(fis);

            while (true) {          // LEO Y ALMACENO EN ARRAYlIST Y IMPRIMO
                trabajadorList = Collections.singletonList((Trabajador) object.readObject());

                for ( Trabajador lista : trabajadorList) {

                    condicion = leerDepart(lista.getIdDepart());

                    if (condicion) {
                        System.out.println("Nombre:    " + lista.getNombre());
                    }
                    System.out.println();
                }
            }
        }catch (IOException io){
            System.out.println("   Fin de archivo");
        }finally {
            object.close();
        }
    }
}

class Trabajador implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nombre, apellidos, email;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    private int idDepart;
}

