package com.example.tiendaciclismo;

import java.time.LocalDateTime;
import java.util.ArrayList;


class Factura {
    /**
     * Identificador único asignado secuencialmente.
     */
    private long numero;

    /**
     * Valor numérico que pertenece a Clientes
     */
    private long codigoCliente;

    /**
     * Fecha en que se recibió.
     */
    private LocalDateTime fechaRecibido;

    /**
     * El estado valido o anulado. Este valor no puede ser manipulado por el usuario.
     */
    private boolean anulado = false;

    /**
     * Valor antes de los impuestos
     */
    private int subtotal;

    /**
     * El 13% del de la suma de los artculos que se facture
     */
    private int impuesto;

    /**
     * El subtotal+impuestos.
     */
    private int total;

    /**
     * El detalle de la factura
     */
    private ArrayList<DetalleFactura> detalles;


    public Factura(long numero, long codigoCliente, LocalDateTime fechaRecibido, int subtotal, int impuesto, int total) {
        this.numero = numero;
        this.codigoCliente = codigoCliente;
        this.fechaRecibido = fechaRecibido;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public LocalDateTime getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(LocalDateTime fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<DetalleFactura> getDetalles() {
        return new ArrayList<>(detalles);
    }
}
