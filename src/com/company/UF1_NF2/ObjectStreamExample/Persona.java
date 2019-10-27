package com.company.UF1_NF2.ObjectStreamExample;

import java.io.IOException;
import java.util.Scanner;

public class Persona {

    private String nom, apellidos, email;
    private String edad;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Persona(){

    };
    public Persona(String nombre, String cognom, String e_mail, String  anys) {
        this.nom = nombre;
        this.apellidos = cognom;
        this.email = e_mail;
        this.edad = anys;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

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
