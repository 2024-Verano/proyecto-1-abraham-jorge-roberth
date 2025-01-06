/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author jorge
 */

import java.time.LocalDate;
import java.util.List;

public class Cliente {
    private static long contador = 0; // Contador estático para generar códigos únicos

    private long codigo;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String correo;
    private String provincia;
    private String canton;
    private String distrito;
    private LocalDate fechaNacimiento;

    public Cliente(long codigo, String nombre, String apellidos, int telefono, String correo, String provincia, String canton, String distrito, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y setters
    public long getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre.trim(); }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos.trim(); }
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getCanton() { return canton; }
    public void setCanton(String canton) { this.canton = canton; }
    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}


