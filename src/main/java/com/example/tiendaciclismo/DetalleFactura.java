package com.example.tiendaciclismo;


class DetalleFactura {
    /**
     * Código del artículo, este ya existe.
     */
    private long codigoArticulo;

    /**
     * Numero de factura perteneciente a encabezado
     */
    private long numeroFactura;

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



    public DetalleFactura(long codigoArticulo, long numeroFactura, int cantidad, int precioUnidad, int total) {
        this.codigoArticulo = codigoArticulo;
        this.numeroFactura = numeroFactura;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.total = total;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(long codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
