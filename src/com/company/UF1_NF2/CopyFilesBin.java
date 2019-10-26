package com.company.UF1_NF2;

import java.io.*;

public class CopyFilesBin {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream origen = new FileInputStream("snake.png");
        FileOutputStream destino = new FileOutputStream("snakeCopia.png");

        try {
            InputStream in = new DataInputStream(origen);
            OutputStream out = new DataOutputStream(destino);

            byte[] buf = new byte[1024];
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
