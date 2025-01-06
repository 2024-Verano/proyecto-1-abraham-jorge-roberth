/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo.almacenamiento;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Roberth Rojas
 */
public class XML {

    private File archivo;

    public XML(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    public List<Map<String, String>> leerRegistros(String tag) throws ErrorCargaException {
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
            throw new ErrorCargaException(archivo.getName());
        }

        return registros;
    }
}
