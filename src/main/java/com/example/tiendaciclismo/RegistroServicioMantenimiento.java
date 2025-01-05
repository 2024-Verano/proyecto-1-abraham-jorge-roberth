package com.example.tiendaciclismo;

import java.time.LocalDateTime;
import java.util.ArrayList;


class RegistroServicioMantenimiento {

    /**
     * Guarda el último código de servicio usado.
     * Cuando se almacena un registro, se incrementa en uno.
     * Al cargarse la lista de registros, el código del último registro se almacena aquí.
     */
    private static long ultimoCodigoServicio = 0;

    /**
     * Es el registro de los servicios que se han creado.
     */
    private ArrayList<ServicioMantenimiento> serviciosMantenimiento;

    /**
     * Agrega un servicio al registro de servicios 
     */
    public void agregarMantenimiento(long codigoCliente, String marcaBicicleta, int precio, LocalDateTime fechaRecibido, LocalDateTime fechaEntrega, String observaciones) {
        ServicioMantenimiento mantenimiento = new ServicioMantenimiento(ultimoCodigoServicio + 1, codigoCliente, marcaBicicleta, precio, fechaRecibido, fechaEntrega, observaciones);

        this.serviciosMantenimiento.add(mantenimiento);
    }

    /**
     * Busca el servicio por medio del código.
     */
    public ServicioMantenimiento buscarCodigo() throws Exception {
        throw new Exception("Sin implementar");
    }

    /**
     * Busca el cliente por medio del nombre de este.
     */
    public ArrayList<ServicioMantenimiento> buscarCliente() throws Exception {
        throw new Exception("Sin implementar");
    }

    /**
     * Modifica los atributos de un servicio
     */
    public void modificarServicio() throws Exception {
        throw new Exception("Sin implementar");
    }
}
