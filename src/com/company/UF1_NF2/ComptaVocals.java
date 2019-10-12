package com.company.UF1_NF2;

import java.io.*;

public class ComptaVocals {

    public static void main(String[] args) throws IOException {

        File lectura = new File("copyDir.txt");
        BufferedReader inputStream = new BufferedReader(new FileReader(lectura));
        File escritura = new File("vocals.csv");
        BufferedWriter outputstream = new BufferedWriter(new FileWriter(escritura));
        String line;
        boolean noLineaBlanco = false;
        outputstream.write("a,e,i,o,u \n");

        while ((line = inputStream.readLine()) != null ) {

            line = line.toLowerCase();

            char[] listaVocales = line.toCharArray();

            for ( int i = 0; i < line.length(); i++){

                switch (listaVocales[i]){

                    case 'a' :
                        System.out.print("eureka.....");
                        outputstream.write(listaVocales[i]);
                        noLineaBlanco = true;
                        break;
                    case 'e' :
                        System.out.print("eureka.....");
                        outputstream.write(listaVocales[i]);
                        noLineaBlanco = true;
                        break;
                    case 'i' :
                        System.out.print("eureka.....");
                        outputstream.write(listaVocales[i]);
                        noLineaBlanco = true;
                        break;
                    case 'o' :
                        System.out.print("eureka.....");
                        outputstream.write(listaVocales[i]);
                        noLineaBlanco = true;
                        break;
                    case 'u' :
                        System.out.print("eureka.....");
                        outputstream.write(listaVocales[i]);
                        noLineaBlanco = true;
                        break;
                    default:
                        break;
                }
            }

            if (noLineaBlanco) {
                outputstream.write("\n");
            }
            noLineaBlanco = false;
        }
        inputStream.close();
        outputstream.close();
    }
}
