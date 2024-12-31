package com.example.tiendaciclismo;


class DetalleFactura {
    /**
     * Código del artículo, este ya existe.
     */
    private long codigoArticulo;

    /**
     * Numero de factura perteneciente a encabezado
     */
    private long numeroDeFactura;

    /**
     * Cantidad de articulos.
     */
    private int cantidad;

    /**
     * El precio de cada unidad.
     */
    private int precioUnidad;

    /**
     * El total del detalle.
     */
    private int total;
}
