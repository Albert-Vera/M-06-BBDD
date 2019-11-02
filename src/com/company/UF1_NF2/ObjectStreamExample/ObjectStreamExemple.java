package com.company.UF1_NF2.ObjectStreamExample;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class ObjectStreamExemple {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner in = new Scanner(System.in);
        String entrada;
        do {
            System.out.println("\n   #############   Menu Persona   ###########\n");
            System.out.print("Quieres insertar una nueva persona (s/n):  ");
            entrada = in.nextLine();

            if (entrada.equals("s") || entrada.equals("S")) {
                introDades();
            }
        } while (entrada.equals("s") || entrada.equals("S"));
        mostraDades();
    }

    public static void introDades() throws IOException {

        Scanner in = new Scanner(System.in);

        Persona empleado = new Persona();

        System.out.println("Introduce datos del empleado \n");
        System.out.print(" Nombre:  ");
        empleado.setNom(in.nextLine());
        System.out.print(" Apellidos:  ");
        empleado.setApellido(in.nextLine());
        System.out.print(" Edad:       ");
        empleado.setEdad(in.nextLine());
        System.out.print(" Email:     ");
        empleado.setEmail(in.nextLine());

        escriureDades(empleado);
    }

    static void escriureDades(Persona empleado) throws IOException {

        File ficheroObject = new File("object.data");
        if (!ficheroObject.exists()) {
                    // Si el fichero no exites escribe cabecera del objeto

            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("object.data", true));
            empleado.getNom();
            empleado.getApellido();
            empleado.getEdad();
            empleado.getEmail();

            objectOutputStream.writeObject(empleado);
            objectOutputStream.close();
        }else{
                // Si el archivo ya existe no escribe cabecera del objeto
            try
            {
                // Se usa un ObjectOutputStream que no escriba una cabecera en
                // el stream.
                MiObjectOutputStream oos = new MiObjectOutputStream(
                        new FileOutputStream(ficheroObject,true));

                empleado.getNom();
                empleado.getApellido();
                empleado.getEdad();
                empleado.getEmail();
                System.out.println(" escribo archivo:  " + empleado.getNom());
                System.out.println(" escribo archivo:  " + empleado.getApellido());
                oos.writeObject(empleado);
                oos.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    static void mostraDades() throws IOException, ClassNotFoundException {

        ObjectInputStream object = null;
        List<Persona> treballadorList ;
        try {
            File lectura = new File("object.data");
            FileInputStream fis = new FileInputStream(lectura);
            object = new ObjectInputStream(fis);

            while (true) {          // LEO Y ALMACENO EN ARRAYlIST Y IMPRIMO
                treballadorList = Collections.singletonList((Persona) object.readObject());

                for ( Persona lista : treballadorList) {
                    System.out.println("Nombre:    " + lista.getNom());
                    System.out.println("Apellidos: " + lista.getApellido());
                    System.out.println("Edad:      " + lista.getEdad());
                    System.out.println("Email:     " + lista.getEmail());
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

class MiObjectOutputStream extends ObjectOutputStream {

    /** Esta clase la uso para que no escriba cabecera del objeto en el archivo.
     * Ya  que era un problema para luego leer el archivo
     * al encontrarse la cabecera de otra escritura interpretaba final de archivo**/



    /** Constructor que recibe OutputStream */
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor sin parámetros */
    protected MiObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinición del método de escribir la cabecera para que no haga nada. */
    protected void writeStreamHeader() throws IOException
    {
    }

}

class Persona implements Serializable{

    private String nom, apellido, email;
    private String edad;    // PONGO STRING PARA NO TENER QUE PONER FILTROS AL ENTRAR DATOS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        this.apellido = cognom;
        this.email = e_mail;
        this.edad = anys;
    }
}
