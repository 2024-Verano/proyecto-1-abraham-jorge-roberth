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
}
