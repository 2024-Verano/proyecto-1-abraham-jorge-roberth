/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.example.tiendaciclismo.almacenamiento;

/**
 *
 * @author universidad
 */
public class ErrorCargaException extends Exception {

	/**
	 * Creates a new instance of <code>ErrorCargaException</code> without
	 * detail message.
	 */
	public ErrorCargaException() {
	}

	/**
	 * Constructs an instance of <code>ErrorCargaException</code> with the
	 * specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public ErrorCargaException(String msg) {
		super(msg);
	}
}
