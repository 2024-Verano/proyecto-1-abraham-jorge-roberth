/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.tiendaciclismo;

/**
 *
 * @author universidad
 */
public class TiendaCiclismo {

    private static Tienda tienda;

    public static Tienda getTienda() {
        return tienda;
    }

    public static void main(String[] args) {
        try {
            tienda = new Tienda();
        } catch (Exception e) {
            System.err.println("Fallo al inicializar, saliendo...");
        }
    }
}
