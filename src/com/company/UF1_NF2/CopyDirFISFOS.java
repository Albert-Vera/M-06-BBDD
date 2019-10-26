package com.company.UF1_NF2;

import java.io.*;

public class CopyDirFISFOS {
    public static void main(String[] args) {

        File origen = new File("/home/albert/Documents/M-06/datosTxt/");
        File destino = new File("/home/albert/M-06 BBDD/masDatos");
        String[] ficheros = origen.list();
        System.out.println(origen.list());
        for (int x=0;x<ficheros.length;x++) {
            copiarDirectorios(new File(origen,ficheros[x]),new File(destino,ficheros[x]));
        }
    }

    static void copiarDirectorios(File origen,  File destino){

        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[(int)origen.length()];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
