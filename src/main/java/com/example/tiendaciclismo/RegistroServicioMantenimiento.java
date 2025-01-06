package com.example.tiendaciclismo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tiendaciclismo.almacenamiento.XML;


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

    private XML respaldo;


    public RegistroServicioMantenimiento() {
        serviciosMantenimiento = new ArrayList<>();
        respaldo = new XML("datos/servicios_mantenimiento.xml");

        cargarRegistros();
    }

    /**
     * Agrega un servicio al registro de servicios 
     */
    public void agregarMantenimiento(long codigoCliente, String marcaBicicleta, int precio, LocalDateTime fechaRecibido, LocalDateTime fechaEntrega, String observaciones) {
        ServicioMantenimiento mantenimiento = new ServicioMantenimiento(ultimoCodigoServicio + 1, codigoCliente, marcaBicicleta, precio, fechaRecibido, fechaEntrega, observaciones);

        this.serviciosMantenimiento.add(mantenimiento);

        guardarRegistros();
    }

    /**
     * Busca el servicio por medio del código.
     */
    public ServicioMantenimiento buscarPorCodigo(long codigoServicioMantenimiento) {
        ServicioMantenimiento resultado = null;
        for (ServicioMantenimiento servicioMantenimiento : serviciosMantenimiento) {
            if (servicioMantenimiento.getCodigoServicio() == codigoServicioMantenimiento) {
                resultado = servicioMantenimiento;
                break;
            }
        }

        return resultado;
    }

    /**
     * Busca el cliente por medio del nombre de este.
     */
    public ArrayList<ServicioMantenimiento> buscarPorCliente(long codigoCliente) {
        ArrayList<ServicioMantenimiento> resultados = new ArrayList<>();

        for (ServicioMantenimiento servicioMantenimiento : serviciosMantenimiento) {
            if (servicioMantenimiento.getCodigoCliente() == codigoCliente) {
                resultados.add(servicioMantenimiento);
            }
        }

        return resultados;
    }

    /**
     * Modifica los atributos de un servicio
     */
    public void modificarServicio(long codigoServicio, String marcaBicicleta, int precio, LocalDateTime fechaRecibido, LocalDateTime fechaEntrega, String observaciones, boolean cerrado) {
        ServicioMantenimiento resultado = buscarPorCodigo(codigoServicio);

        resultado.setMarcaBicicleta(marcaBicicleta);
        resultado.setPrecio(precio);
        resultado.setFechaRecibido(fechaRecibido);
        resultado.setFechaEntrega(fechaEntrega);
        resultado.setObservaciones(marcaBicicleta);
        resultado.setEstado(cerrado? ServicioMantenimiento.Estado.CERRADO: ServicioMantenimiento.Estado.ABIERTO);

        guardarRegistros();
    }

    public boolean borrarServicio(ServicioMantenimiento servicioMantenimiento) {
        boolean borrado = serviciosMantenimiento.remove(servicioMantenimiento);
        guardarRegistros();

        return borrado;
    }

    private void cargarRegistros() {
        List<Map<String,String>> registros = respaldo.leerRegistros("cliente");

        for (Map<String,String> registro : registros) {
            ServicioMantenimiento mantenimiento = new ServicioMantenimiento(
                        Long.parseLong(registro.get("codigo-servicio")),
                        Long.parseLong(registro.get("codigo-cliente")),
                        registro.get("marca-bicicleta"),
                        Integer.parseInt(registro.get("precio")),
                        LocalDateTime.parse(registro.get("fecha-recibido")),
                        LocalDateTime.parse(registro.get("fecha-entrega")),
                        registro.get("observaciones")
                        );
            mantenimiento.setEstado(ServicioMantenimiento.Estado.valueOf(registro.get("estado")));

            serviciosMantenimiento.add(mantenimiento);
        }
    }

    private void guardarRegistros() {
        List<Map<String,String>> registros = new ArrayList<Map<String,String>>();

        for (ServicioMantenimiento mantenimiento : serviciosMantenimiento) {
            Map<String,String> registro = new HashMap<>();
            registro.put("codigo-servicio", String.valueOf(mantenimiento.getCodigoServicio()));
            registro.put("codigo-cliente", String.valueOf(mantenimiento.getCodigoCliente()));
            registro.put("marca-bicicleta", mantenimiento.getMarcaBicicleta());
            registro.put("precio", String.valueOf(mantenimiento.getPrecio()));
            registro.put("fecha-recibido", mantenimiento.getFechaRecibido().toString());
            registro.put("fecha-entrega", mantenimiento.getFechaEntrega().toString());
            registro.put("observaciones", mantenimiento.getObservaciones());
            registro.put("estado", mantenimiento.getEstado().name());

            registros.add(registro);
        }

        try {
            respaldo.guardarRegistros("mantenimiento", registros);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
