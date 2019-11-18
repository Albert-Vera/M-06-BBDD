package com.company.UF1_NF3;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
/**
 *
 * @author decodigo
 */
public class LeerXML {
    public static void main(String args[]) {
        try {
            File archivo = new File("/home/albert/IdeaProjects/M-06_BBDD/src/AlumneXML.txt");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz:" + document.getDocumentElement().getNodeName());
            NodeList listaAlumnes = document.getElementsByTagName("Alumne");
            for (int temp = 0; temp < listaAlumnes.getLength(); temp++) {
                Node nodo = listaAlumnes.item(temp);
                System.out.println("Elemento:" + nodo.getNodeName());
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    System.out.println("Dni: " + element.getAttribute("dni"));
                    System.out.println("Nom: " + element.getElementsByTagName("nom").item(0).getTextContent());
                    System.out.println("Cognom 1: " + element.getElementsByTagName("cognom1").item(0).getTextContent());
                    System.out.println("Cognom 2: " + element.getElementsByTagName("cognom2").item(0).getTextContent());
                    System.out.println("Edad: " + element.getElementsByTagName("edad").item(0).getTextContent());
                    System.out.println("Ciutat: " + element.getElementsByTagName("ciutat").item(0).getTextContent());
                    System.out.println("Asignature: " + element.getElementsByTagName("asignatures").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

