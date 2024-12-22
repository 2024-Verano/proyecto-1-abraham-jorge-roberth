package com.example.tiendaciclismo;


class Producto {
    /**
     * Identificador único asignado secuencialmente.
     */
    private long codigoArticulo;

    /**
     * El valor de una instancia de TipoProducto que representa el tipo de producto.
     */
    private long codigoTipo;

    /**
     * Tamaño de la bicicleta. Se asigna 0 (cero) si el producto no es una bicicleta.
     */
    private int tamano;

    private int marca;

    /**
     * El costo del producto
     */
    private int precio;

    /**
     * La cantidad de unidades disponibles del producto.
     */
    private int cantidad;
}
