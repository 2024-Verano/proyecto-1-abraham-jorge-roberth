package com.example.tiendaciclismo;
/*
*@autor: abraham
*/

public class TipoProducto {
    /**
     * Identificador único asignado secuencialmente
     */
    private long codigo;

    /**
     * Nombre del tipo de producto
     */
    private String nombre;

    /**
     * Constructor vacío, utilizado por posibles necesidades de inicialización
     */
    public TipoProducto() {
    }

    /**
     * Constructor con solo el código
     * 
     * @param codigo Identificador único del tipo de producto
     */
    public TipoProducto(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Constructor con ambos, código y nombre
     * 
     * @param codigo Identificador único del tipo de producto
     * @param nombre Nombre del tipo de producto
     */
    public TipoProducto(long codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Getters y setters

    public long getCodigo() {
        return codigo;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}