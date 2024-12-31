/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author universidad
 */
public class ControlAccesoException extends Exception {

	/**
	 * Creates a new instance of <code>ArchivoNoCargadoException</code>
	 * without detail message.
	 */
	public ControlAccesoException() {
	}

	/**
	 * Constructs an instance of <code>ArchivoNoCargadoException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ControlAccesoException(String msg) {
		super(msg);
	}
}
