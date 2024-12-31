package com.example.tiendaciclismo;

import java.time.LocalDate;


class Cliente {
    /**
     * Identificador único asignado secuencialmente.
     */
    private long codigo;

    /**
     * Nombre del cliente
     */
    private String nombre;

    /**
     * Apellidos del cliente
     */
    private String apellidos;

    /**
     * Número de teléfono del cliente. Largo debe de ser 8 dígitos, dígitos a iniciar 2,4,6,8.
     */
    private int numTelefono;

    /**
     * Correo del cliente, este debe de tener el formato correcto. (nombre@dominio.com)
     */
    private String correo;

    /**
     * Las 7 provincias.
     */
    private String provincia;

    /**
     * A partir de la provincia seleccionada se le mostraran los cantones de esa provincia.
     */
    private String canton;

    /**
     * A partir del cantón escogido se le mostrara los distritos. 
     */
    private String distrito;

    /**
     * Fecha de nacimiento y Formato de fecha correcto
     */
    private LocalDate fechaNacimiento;
}
