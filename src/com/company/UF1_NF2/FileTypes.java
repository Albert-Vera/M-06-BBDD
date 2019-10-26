package com.company.UF1_NF2;

import java.io.*;

public class FileTypes {
    public static void main(String[] args) throws IOException {

        String string= "Buenos dias";
        float decimal = 3.14f;
        int entero = 2001;

        try {
            FileOutputStream salidaOut = new FileOutputStream("fileTypes.bin");
            DataOutputStream salidaData = new DataOutputStream(salidaOut);

            //salidaData.writeFloat(decimal);
            salidaData.writeInt(entero);
            //salidaData.writeChars(string);

            salidaData.close();
        } catch (IOException e){
            System.out.println("Error");
        }

        try {
            File leerFile = new File("fileTypes.bin");
            BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
            String line;
            System.out.println("\n Lectura con BufferedReader:   \n");

            while ((line = inputStream.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }
            inputStream.close();
        }catch (IOException e){
            System.out.println("Error de lectura");
        }

        try {
            FileInputStream lecturaData = new FileInputStream("fileTypes.bin");
            DataInputStream datos = new DataInputStream(lecturaData);
            System.out.println("\nLectura con DataInput \n");

            System.out.println(datos.readFloat());
            System.out.println(datos.readInt());

            byte[] encoded = datos.readAllBytes();
            String text = new String(encoded, "UTF-8");
            System.out.println(text);

        }catch(EOFException e){
            //... Nos saltara este mensaje
            System.out.println("Fin del fichero");
        }catch (IOException e){
            System.out.println("Error lectura Data ");
        }
    }
}
