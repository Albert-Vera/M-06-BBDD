//package com.company.UF1_NF2.CSVToObjectFile;
//
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//                // SOLO LA VERSIÓN INTELLIJ IDEA ULTIMATE SOPORTA CSVREADER ,LA COMMUNITY NO LA SOPORTA
//
//public class CSVToObjectFile {
//    public static void main(String[] args) throws IOException {
//
//        User user = new User();
//        List<User> userList = new ArrayList<>();
//        userList= loadUser();
//    }
//
//    static List<User> loadUser() throws IOException {
//
//        List<User> users = new ArrayList<>();
//
//
//        ObjectInputStream object = null;
//        try {
//            File lectura = new File("leerUsuarios.dat");
//            FileInputStream fis = new FileInputStream(lectura);
//            object = new ObjectInputStream(fis);
//
//            while (true) {
//                users = (User) object.readObject();
//
//
//                //deserializedList= (ArrayList<TestObject>) in.readObject();
//            }
//        }catch (IOException | ClassNotFoundException io){
//            System.out.println("   Fin de archivo");
//        }finally {
//            object.close();
//        }
//
//        return users;
//
////        BufferedReader inputStream = new BufferedReader(new FileReader("leerUsuarios.csv"));
////        String line;
////
////        while((line = inputStream.readLine()) != null && !line.isEmpty()){
////            String[] values = line.split(",");
////
////            User user = new User();
////            user.setFirstname(values[0]);
////            user.setLastname(values[1]);
////            user.setEmail(values[2]);
////            user.setPassword(values[3]);
////            users.add(user);
////            System.out.println(user.getFirstname());
////        }
////        inputStream.close();
//
//
//
////        try {
////
////            // Create an object of filereader
////            // class with CSV file as a parameter.
////            FileReader filereader = new FileReader("leerUsuarios.csv");
////
////            // create csvReader object passing
////            // file reader as a parameter
////            CSVReader csvReader = new CSVReader(filereader);
////            String[] nextRecord;
////
////            // we are going to read data line by line
////            while ((nextRecord = csvReader.readNext()) != null) {
////                for (String cell : nextRecord) {
////                    System.out.print(cell + "\t");
////                }
////                System.out.println();
////            }
////        }
////        catch (Exception e) {
////            e.printStackTrace();
////        }
//
//    }
//}
