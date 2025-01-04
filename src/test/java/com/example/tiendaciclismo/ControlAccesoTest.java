/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.tiendaciclismo;

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
public class ControlAccesoTest {
	
	public ControlAccesoTest() {
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
	 * Test of iniciarSesion method, of class ControlAcceso.
	 */
	@Test
	public void cuando_UsuarioExisteYContrasenaEsValida_entonces_RetornaTrue() throws Exception {
		ControlAcceso instance = new ControlAcceso();
		Boolean expResult = true;
		Boolean result = instance.iniciarSesion("usuario", "contrasena");
		assertEquals(expResult, result);
	}
	
        @Test
        public void cuando_UsuarioNoExiste_entonces_RetornaFalse() throws Exception {
		ControlAcceso instance = new ControlAcceso();
		Boolean expResult = false;
		Boolean result = instance.iniciarSesion("inexistente", "contrasena");
		assertEquals(expResult, result);
        }
	
        @Test
        public void cuando_ContrasenaEsIncorrecta_entonces_RetornaFalse() throws Exception {
		ControlAcceso instance = new ControlAcceso();
		Boolean expResult = false;
		Boolean result = instance.iniciarSesion("usuario", "contrasena_incorrecta");
		assertEquals(expResult, result);
        }
}
