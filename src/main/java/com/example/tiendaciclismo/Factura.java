package com.example.tiendaciclismo;

import java.time.LocalDateTime;
import java.util.ArrayList;


class Factura {
    /**
     * Identificador único asignado secuencialmente.
     */
    private long numFactura;

    /**
     * Valor numérico que pertenece a Clientes
     */
    private Cliente codigoCliente;

    /**
     * Fecha en que se recibió.
     */
    private LocalDateTime fechaRecibido;

    /**
     * El estado valido o anulado. Este valor no puede ser manipulado por el usuario.
     */
    private boolean estado;

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
}
