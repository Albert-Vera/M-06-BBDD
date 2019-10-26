package com.company.UF1_NF2.ObjectStreamExample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Treballador extends Persona{
    public static void introDades() throws IOException {

        Scanner in = new Scanner(System.in);

        Treballador empleado = new Treballador();

        System.out.println("Introduce datos del empleado \n");
        System.out.print(" Nombre:  ");
        empleado.setNom(in.nextLine());
        System.out.print(" Apellidos:  ");
        empleado.setApellidos(in.nextLine());
        System.out.print(" Edad:       ");
        empleado.setEdad(in.nextLine());
        System.out.print(" Email:     ");
        empleado.setEmail(in.nextLine());

        escriureDades( empleado);

    }

    static void escriureDades(Treballador empleado) throws IOException {

        BufferedWriter outputStream = new BufferedWriter(new FileWriter("Treballadors.txt", true));

            outputStream.write(empleado.getNom() + ", " + empleado.getApellidos()+ ", " + empleado.getEdad() + ", " + empleado.getEmail() + "\n");

        outputStream.close();
    }
    static void mostraDades() throws IOException {
        List<Treballador> personasList = new ArrayList<>();
        File leerFile = new File("Treballadors.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;

        while ((line = inputStream.readLine()) != null && !line.isEmpty()) {
            String[] values = line.split(",");

            Treballador empleado = new Treballador();
            empleado.setNom(values[0]);
            empleado.setApellidos(values[1]);
            empleado.setEdad(values[2]);
            empleado.setEmail(values[3]);

            personasList.add(empleado);
        }
        inputStream.close();

        for (Persona listado : personasList){
            System.out.println(listado.getNom() + listado.getApellidos() + listado.getEdad() + listado.getEmail());
        }
    }
}

