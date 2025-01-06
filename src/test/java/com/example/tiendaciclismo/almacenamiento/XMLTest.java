/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.tiendaciclismo.almacenamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author universidad
 */
public class XMLTest {
	
	public XMLTest() {
	}
	
	@BeforeAll
	public static void setUpClass() {
	}
	
	@AfterAll
	public static void tearDownClass() {
	}
	
	@BeforeEach
	public void setUp() {
	}
	
	@AfterEach
	public void tearDown() {
	}

	/**
	 * Test of leerRegistros method, of class XML.
	 */
	@Test
	public void testLeerRegistros() throws Exception {
		String tag = "etiqueta-prueba";
		XML instance = new XML("recursos/archivo_prueba.xml");
		List<Map<String, String>> result = instance.leerRegistros(tag);
                assertEquals(1, result.size());

                Map<String,String> registro = result.get(0);
                assertTrue(registro.containsKey("id"));
                assertEquals("1", registro.get("id"));
                assertTrue(registro.containsKey("nombre"));
                assertEquals("prueba", registro.get("nombre"));
	}
	
        @Test
        public void testGuardarRegistros() throws Exception {
		String tag = "etiqueta-prueba";
		XML instance = new XML("datos/archivo_prueba_escritura.xml");

                ArrayList<Map<String,String>> datos = new ArrayList<Map<String,String>>();
                HashMap<String,String> registro_guardado = new HashMap<>();
                registro_guardado.put("id", "1");
                registro_guardado.put("nombre", "prueba");
                datos.add(registro_guardado);

                instance.guardarRegistros(tag, datos);

                // Carga de prueba
		List<Map<String, String>> result = instance.leerRegistros(tag);
                assertEquals(1, result.size());

                Map<String,String> registro = result.get(0);
                assertTrue(registro.containsKey("id"));
                assertEquals("1", registro.get("id"));
                assertTrue(registro.containsKey("nombre"));
                assertEquals("prueba", registro.get("nombre"));
        }
}
