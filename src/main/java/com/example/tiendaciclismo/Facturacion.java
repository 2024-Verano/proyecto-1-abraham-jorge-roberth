package com.example.tiendaciclismo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


class Facturacion {

    /**
     * Guarda el último código de servicio usado.
     * Cuando se almacena un registro, se incrementa en uno.
     * Al cargarse la lista de registros, el código del último registro se almacena aquí.
     */
    private static long ultimoNumeroFactura = 0;

    /**
     * Lista de facturas.
     */
    private ArrayList<Factura> facturas;

    /**
     * Crea una factura
     */
    public Factura agregarFactura(long codigoCliente, LocalDateTime fechaRecibido, int subtotal, int impuesto, int total) {
        Factura factura = new Factura(ultimoNumeroFactura + 1, codigoCliente, fechaRecibido, subtotal, impuesto, total);
        facturas.add(factura);

        return factura;
    }

    /**
     * Busca una factura por numero.
     */
    public Factura buscarPorNumero(long numeroFactura) {
        Factura resultado = null;
        for (Factura factura : facturas) {
            if (factura.getNumero() == numeroFactura) {
                resultado = factura;
                break;
            }
        }

        return resultado;
    }

    /**
     * Busca facturas por fecha.
     */
    public ArrayList<Factura> buscarPorFecha(LocalDate fecha) {
        ArrayList<Factura> resultados = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getFechaRecibido().toLocalDate().equals(fecha)) {
                resultados.add(factura);
            }
        }

        return resultados;
    }

    public void agregarDetalle(long numeroFactura, long codigoArticulo, int cantidad, int precioUnidad) {
        Factura factura = buscarPorNumero(numeroFactura);
        factura.agregarDetalle(codigoArticulo, cantidad, precioUnidad);
    }

    /**
     * Busca facturas por el código de cliente.
     */
    public ArrayList<Factura> buscarPorCliente(long codigoCliente) {
        ArrayList<Factura> resultados = new ArrayList<>();

        for (Factura factura : facturas) {
            if (factura.getNumero() == codigoCliente) {
                resultados.add(factura);
            }
        }

        return resultados;
    }

    /**
     * Anula una factura.
     */
    public void anularFactura(long numeroFactura) {
        Factura factura = buscarPorNumero(numeroFactura);
        factura.setAnulado(true);
    }
}
