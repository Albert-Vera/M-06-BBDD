package com.company.UF1_NF3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

class FicheroToXML {




    public static void main(String argv[]) throws IOException, ParserConfigurationException, TransformerException {

        List<Alumne> alumnes = loadAlumne();
        Result result = new StreamResult(new java.io.File("ToXMLalumnes" + ".xml")); //nombre del archivo
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Alumnes", null);
        document.setXmlVersion("1.0");

        for (Alumne alumneList : alumnes) {
            try {

                document = generate(alumneList, document);
            } catch (Exception e) {
            }
        }
        //Generate XML
        Source source = new DOMSource(document);
        //Indicamos donde lo queremos almacenar

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        System.out.println("\n\n   ......... Generado fichero ToXMLalumnes.xml");
    }


    public static Document generate( Alumne alumneList, Document document) throws Exception {

        //Main Node
        Element raiz = document.getDocumentElement();

        //Item Node
        Element itemNode = document.createElement("ALUMNE");
        //Key Node
        Element node = document.createElement("DNI");
        Text nodeValue = document.createTextNode(alumneList.getDni());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("NOM");
        nodeValue = document.createTextNode(alumneList.getNom());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("COGNOM1");
        nodeValue = document.createTextNode(alumneList.getCognom1());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("COGNOM2");
        nodeValue = document.createTextNode(alumneList.getCognom2());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("EDAD");
        nodeValue = document.createTextNode(Integer.toString(alumneList.getEdad()));
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("CIUTAT");
        nodeValue = document.createTextNode(alumneList.getCiutat());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
        //Value Node
        node = document.createElement("ASIGNATURES");
        nodeValue = document.createTextNode(alumneList.getAsignatures());
        node.appendChild(nodeValue);
        itemNode.appendChild(node);
       // append keyNode and valueNode to itemNode
        itemNode.appendChild(node);
        //itemNode.appendChild(valueNode);
        //append itemNode to raiz
        raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"

        return document;
    }


    static List<Alumne> loadAlumne() throws IOException {

        File leerFile = new File("/home/albert/IdeaProjects/M-06_BBDD/src/Alumnes.data");
        BufferedReader inputStream = new BufferedReader(new FileReader(leerFile));
        String line;
        List<Alumne> alumneList = new ArrayList<>();

        while ((line = inputStream.readLine()) != null && !line.isEmpty()) {

            Alumne alumne = new Alumne();
            String[] values = line.split(",");
            alumne.setDni(values[0]);
            alumne.setNom(values[1]);
            alumne.setCognom1(values[2]);
            alumne.setCognom2(values[3]);
            alumne.setEdad(Integer.valueOf(values[4]));
            alumne.setCiutat(values[5]);
            alumne.setAsignatures(values[6]);
            alumneList.add(alumne);
        }
        inputStream.close();
        return alumneList;
    }
}
class Alumne {
    private String dni, nom, cognom1, cognom2, ciutat, asignatures;
    private int edad;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public String getAsignatures() {
        return asignatures;
    }

    public void setAsignatures(String asignatures) {
        this.asignatures = asignatures;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}