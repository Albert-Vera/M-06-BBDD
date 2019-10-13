package com.company.UF1_NF2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecordsTextToCSV {

    String nom, cognom;
    int edad;
    String SEP = ",";

    public static void main(String[] args) throws IOException {

        mostraPerPantalla();
        escriuSortidaCSV();

    }

    private static void mostraPerPantalla() throws IOException {

        List<RecordsTextToCSV22>agendaList = llegeixFitxer();
        System.out.println();
        System.out.println("     Nombre" + "          Cognom " + "        Edad " );
        System.out.println();

        for(RecordsTextToCSV22 recordsTextToCSV : agendaList){
            System.out.println("    " + recordsTextToCSV.nom + "            " + recordsTextToCSV.cognom + "          " + recordsTextToCSV.edad );
        }
        System.out.println();
    }

    private static List<RecordsTextToCSV22> llegeixFitxer() throws IOException {

        File lectura = new File("agenda.txt");

        BufferedReader inputStream = new BufferedReader(new FileReader(lectura));
        BufferedReader detectarFinal = new BufferedReader(new FileReader(lectura));
        List<RecordsTextToCSV22> agenda = new ArrayList<>();
        String line, line22;

        while ((line22 = detectarFinal.readLine()) != null && !line22.isEmpty()) {

            String[] values = new String[2];
            int valorInt= 0;

            for (int a = 0; a < 4; a++) {
                line = inputStream.readLine();
                detectarFinal.readLine();

                if (a != 3) {

                    if (a == 2) {valorInt = Integer.parseInt(line);}
                    else {values[a] = line;}
                }
            }

            RecordsTextToCSV22 recordsTextToCSV = new RecordsTextToCSV22();
            recordsTextToCSV.nom = values[0];
            recordsTextToCSV.cognom = values[1];
            recordsTextToCSV.edad = valorInt;
            agenda.add(recordsTextToCSV);
        }
        inputStream.close();
        detectarFinal.close();
        return agenda;
    }

    private static void escriuSortidaCSV() throws IOException {
        File guardaFile = new File("agenda.csv");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(guardaFile, true));
        List<RecordsTextToCSV22> agendaLista = llegeixFitxer();
        outputStream.write("     Nombre" + "          Cognom " + "        Edad \n \n" );

        for(RecordsTextToCSV22 recordsTextToCSV : agendaLista){
            outputStream.write("    " + recordsTextToCSV.nom + "            " + recordsTextToCSV.cognom + "          " + recordsTextToCSV.edad + "\n");
        }
        outputStream.close();
    }
}
