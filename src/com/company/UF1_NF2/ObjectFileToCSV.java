package com.company.UF1_NF2;



import com.company.UF1_NF2.CSVToObjectFile.User;

import java.io.*;
import java.util.Collections;
import java.util.List;

import static javax.naming.Name.serialVersionUID;

public class ObjectFileToCSV {

    public static void main(String[] args) throws IOException {

        loadUsers();

    }

    static void loadUsers() throws IOException {

        ObjectInputStream object = null;
        List<User> userList ;
        try {
            File lectura = new File("user.bin");
            FileInputStream fis = new FileInputStream(lectura);
            object = new ObjectInputStream(fis);
            //User user = new User();

            while (true) {          // LEO Y ALMACENO EN ARRAYlIST Y IMPRIMO
                userList = Collections.singletonList((User) object.readObject());

                for ( User lista : userList) {
                    System.out.println("Nombre:    " + lista.getFirstname());
                    System.out.println("Apellidos: " + lista.getLastname());
                    System.out.println("Edad:      " + lista.getEmail());
                    System.out.println("Email:     " + lista.getPassword());
                    System.out.println();
                }
            }
        }catch (IOException | ClassNotFoundException io){
            System.out.println("   Fin de archivo");
        }finally {
            object.close();
        }
    }
}
