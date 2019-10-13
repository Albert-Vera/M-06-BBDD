package com.company.UF1_NF2;

import java.io.*;

public class CopyFilesBin {
    public static void main(String[] args) {

        File origen = new File("snake.png");
        File destino = new File("snakeCopia.png");

        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

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
