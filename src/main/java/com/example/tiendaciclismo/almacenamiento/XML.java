/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo.almacenamiento;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * La clase XML simplifica la carga y guardado de datos en archivos XML.
 * El nodo raíz es {@code <tienda-ciclismo>}. Los nodos de almacenamiento se especifican al cargar o guardar los datos.
 * Los atributos se registran como atributos xml.
 * @author Roberth Rojas
 */
public class XML {

    private File archivo;

    /**
     * Inicializa la clase con un archivo que se usa para lectura y escritura.
     * @param nombreArchivo Ruta del archivo a usar
     */
    public XML(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }


    /**
     * Lee los registros que usan la etiqueta tag.
     * @param tag El nombre de las etiquetas a cargar.
     * @return Una lista de mapas con los atributos de los registros.
     */
    public List<Map<String, String>> leerRegistros(String tag) {
        ArrayList<Map<String, String>> registros = new ArrayList<Map<String, String>>();

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(archivo);

            NodeList nodos = document.getElementsByTagName(tag);
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                NamedNodeMap atributos = nodo.getAttributes();

                HashMap<String,String> registro = new HashMap<>();
                for (int j = 0; j < atributos.getLength(); j++) {
                    Node atributo = atributos.item(j);
                    String nombre = atributo.getNodeName();
                    String valor = atributo.getNodeValue();

                    registro.put(nombre, valor);
                }

                registros.add(registro);
            }
        } catch (Exception e) {
            // No hacer nada. Si el archivo no existe, retornar una lista de registros vacía
        }

        return registros;
    }

    /**
     * Guarda los registros en el archivo especificado.
     * @param tag El nombre de las etiquetas a cargar.
     * @param registros Los datos que serán guardados.
     */
    public void guardarRegistros(String tag, List<Map<String,String>> registros) throws ErrorCargaException {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); 
            Document document = builder.newDocument();

            Element root = document.createElement("tienda-ciclismo");
            document.appendChild(root);

            for (Map<String,String> registro : registros) {
                Element elemento = document.createElement(tag);

                for (String nombre : registro.keySet()) {
                    elemento.setAttribute(nombre, registro.get(nombre));
                }

                root.appendChild(elemento);
            }

            FileWriter fileWriter = new FileWriter(archivo);

            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                StringWriter writer = new StringWriter();

                transformer.transform(new DOMSource(document), new StreamResult(writer));
                printWriter.print(writer.toString());
            }

        } catch (Exception e) {
            throw new ErrorCargaException(archivo.getName());
        }


    }
}
