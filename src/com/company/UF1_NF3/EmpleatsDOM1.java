package com.company.UF1_NF3;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.company.UF1_NF2.CSVToObjectFile.User;
import org.w3c.dom.*;



class EmpleatsDOM1 implements Serializable {

    private static final long serialVersionUID = 1L;
    User user = new User();
    String nombre, apellido, edad, pass;

    public static void main(String argv[]) throws IOException, ParserConfigurationException, TransformerException {


        Result result = new StreamResult(new File("ToXMLEmpleats" + ".xml")); //nombre del archivo
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "EMPLEATS", null);
        document.setXmlVersion("1.0");

        //          METODO LOAD... LO METI AQUI
        ObjectInputStream object = null;
        List<User> userList = new ArrayList<>();
        try {
            File lectura = new File("user.bin");
            FileInputStream fis = new FileInputStream(lectura);
            object = new ObjectInputStream(fis);


            while (true) {          // LEO Y ALMACENO EN ARRAYlIST Y IMPRIMO
                userList = Collections.singletonList((User) object.readObject());


                try {

                    document = generate(userList, document);
                } catch (Exception e) {
                }

            }
        } catch (IOException | ClassNotFoundException io) {
            System.out.println("   Fin de archivo");
        } finally {
            object.close();
        }

        //Generate XML
        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        System.out.println("\n\n   ......... Generado fichero ToXMLalumnes.xml");
    }


    public static Document generate(List<User> empleats, Document document) throws Exception {

        //Main Node
        Element raiz = document.getDocumentElement();

        //Item Node
        Element itemNode = document.createElement("EMPLEAT");
        //Key Node
        Element node = document.createElement("NOMBRE");
        Text nodeValue = document.createTextNode(empleats.get(0).getFirstname());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("APELLIDOS");
        nodeValue = document.createTextNode(empleats.get(0).getLastname());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("EMAIL");
        nodeValue = document.createTextNode(empleats.get(0).getEmail());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("PASSWORD");
        nodeValue = document.createTextNode(empleats.get(0).getPassword());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);

        // append keyNode and valueNode to itemNode
        itemNode.appendChild(node);
        //itemNode.appendChild(valueNode);
        //append itemNode to raiz
        raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"

        return document;
    }

}