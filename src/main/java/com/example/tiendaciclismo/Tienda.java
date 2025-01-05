/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author Roberth Rojas
 */
public class Tienda {
    private Boolean autenticado = false;

    private ControlAcceso acceso;

    public Tienda() throws ControlAccesoException {
        acceso = new ControlAcceso();
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public Boolean iniciarSesion(String nombreUsuario, String contrasena) {
        autenticado = acceso.iniciarSesion(nombreUsuario, contrasena);

        return autenticado;
    }

    public void cerrarSesion() {
        autenticado = false;
    }
}
