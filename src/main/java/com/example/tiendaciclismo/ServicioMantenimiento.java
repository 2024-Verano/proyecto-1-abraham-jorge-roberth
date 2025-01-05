package com.example.tiendaciclismo;

import java.time.LocalDateTime;


class ServicioMantenimiento {

    public enum EstadoMantenimiento {
        ABIERTO,
        CERRADO,
    }

    /**
     * Valor numérico único que incrementa en 1.
     */
    private long codigoServicio;

    /**
     * Valor numérico, proviene de clientes. 
     */
    private long codigoCliente;

    /**
     * La marca de la bicicleta.
     */
    private String marcaBicicleta;

    /**
     * El costo del mantenimiento.
     */
    private int precio;

    /**
     * Fecha en la que se recibe la bicicleta.
     */
    private LocalDateTime fechaRecibido;

    /**
     * Fecha en la que se entrega bicicleta.
     */
    private LocalDateTime fechaEntrega;

    /**
     * La condición de la bicicleta o detalles extra.
     */
    private String observaciones;

    /**
     * Indica si el servicio está Abierto o Cerrado.  Una vez cerrado, se pasará a facturación.
     */
    private EstadoMantenimiento estado;


    public ServicioMantenimiento(long codigoServicio, long codigoCliente, String marcaBicicleta, int precio, LocalDateTime fechaRecibido, LocalDateTime fechaEntrega, String observaciones) {
        this.codigoServicio = codigoServicio;
        this.codigoCliente = codigoCliente;
        this.marcaBicicleta = marcaBicicleta;
        this.precio = precio;
        this.fechaRecibido = fechaRecibido;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.estado = EstadoMantenimiento.CERRADO;
    }

    public long getCodigoServicio() {
        return codigoServicio;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public String getMarcaBicicleta() {
        return marcaBicicleta;
    }

    public void setMarcaBicicleta(String marcaBicicleta) {
        this.marcaBicicleta = marcaBicicleta;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(LocalDateTime fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadoMantenimiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoMantenimiento estado) {
        this.estado = estado;
    }
}
