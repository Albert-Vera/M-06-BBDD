package com.company.UF1_NF2.ObjectStreamExample;

import java.io.IOException;
import java.util.Scanner;

public class Persona {

    private String nom, apellidos, email;
    private int edad;

    public String getNom() {
        return nom;
    }

    public void setNom() {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos() {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona(){

    };
    public Persona(String nombre, String cognom, String e_mail, int anys) {
        this.nom = nombre;
        this.apellidos = cognom;
        this.email = e_mail;
        this.edad = anys;
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String entrada;
        do {
            System.out.println("\n   #############   Menu Persona   ###########\n");
            System.out.print("Quieres insertar una nueva persona (s/n):  ");
            entrada = in.nextLine();

            if (entrada.equals("s") || entrada.equals("S")) {
                Treballador.introDades();
            }
        }while (entrada.equals("s") || entrada.equals("S"));
        Treballador.mostraDades();
    }
}
