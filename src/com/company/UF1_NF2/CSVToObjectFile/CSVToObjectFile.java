package com.company.UF1_NF2.CSVToObjectFile;





import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVToObjectFile {

    public static void main(String[] args) throws IOException {

        List<User> userList = loadUser();
        writeUser(userList);
    }

    static List<User> loadUser() throws IOException {

        File leerFile = new File("leerUsuarios.csv");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;
        List<User> userList = new ArrayList<>();

        while((line = inputStream.readLine()) != null && !line.isEmpty()) {

            User user = new User();
            String[] values = line.split(",");
            user.setFirstname(values[0]);
            user.setLastname(values[1]);
            user.setEmail(values[2]);
            user.setPassword(values[3]);
            userList.add(user);
        }
        inputStream.close();
        return userList;
    }

    static void writeUser(List<User> userList) throws IOException {

        User user = new User();
        File ficheroObject = new File("user.bin");
        if (!ficheroObject.exists()) {
            // Si el fichero no exites escribe cabecera del objeto

            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream("user.bin", true));

            for (User users: userList) {
                System.out.println("Nombre:    " + users.getFirstname());
                System.out.println(" Lastname: " + users.getLastname());
                System.out.println("Email:     "+ users.getEmail());
                System.out.println("Password:  " + users.getPassword());
                objectOutputStream.writeObject(users);
            }
            objectOutputStream.close();
        }else{
            // Si el archivo ya existe no escribe cabecera del objeto
            try
            {
                // Se usa un ObjectOutputStream que no escriba una cabecera en
                // el stream.
                MiObjectOutputStream2 oos = new MiObjectOutputStream2(
                        new FileOutputStream(ficheroObject,true));

                for (User users: userList) {
                    System.out.println("Nombre:    " + users.getFirstname());
                    System.out.println(" Lastname: " + users.getLastname());
                    System.out.println("Email:     "+ users.getEmail());
                    System.out.println("Password:  " + users.getPassword() + "\n\n");

                    oos.writeObject(users);
                }
                oos.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}

class MiObjectOutputStream2 extends ObjectOutputStream {

    /** Esta clase la uso para que no escriba cabecera del objeto en el archivo.
     * Ya  que era un problema para luego leer el archivo
     * al encontrarse la cabecera de otra escritura interpretaba final de archivo**/



    /** Constructor que recibe OutputStream */
    public MiObjectOutputStream2(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Constructor sin parámetros */
    protected MiObjectOutputStream2() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinición del método de escribir la cabecera para que no haga nada. */
    protected void writeStreamHeader() throws IOException
    {
    }

}