package com.example.tiendaciclismo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * Clase encargada de crear las facturas y agregar detalles.
 * @author Roberth Rojas
 */
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
     * @param codigoCliente El código del cliente
     * @param fechaRecibido La fecha y hora de la facturación
     * @param subtotal El costo de los productos sin incluir impuestos
     * @param impuesto Impuestos sobre la factura. Se calcula como un 13% del subtotal.
     * @param total Costo de los productos incluyento inpuestos
     * @returns Una nueva factura
     */
    public Factura agregarFactura(long codigoCliente, LocalDateTime fechaRecibido, int subtotal, int impuesto, int total) {
        Factura factura = new Factura(ultimoNumeroFactura + 1, codigoCliente, fechaRecibido, subtotal, impuesto, total);
        facturas.add(factura);

        return factura;
    }

    /**
     * Busca una factura por numero.
     * @param numeroFactura El número de la factura a buscar
     * @return La factura con el número especificado
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
     * @param fecha La fecha a buscar
     * @return Lista de las facturas creadas en la fecha buscada
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

    /**
     * Agrega un detalle a una factura
     * @param numeroFactura El número de la factura
     * @param codigoArticulo El código del artículo a agregar
     * @param cantidad El número de unidades del artículo
     * @param precioUnidad El precio unitario del artículo
     */
    public void agregarDetalle(long numeroFactura, long codigoArticulo, int cantidad, int precioUnidad) {
        Factura factura = buscarPorNumero(numeroFactura);
        factura.agregarDetalle(codigoArticulo, cantidad, precioUnidad);
    }

    /**
     * Busca facturas por el código de cliente.
     * @param codigoCliente El código del cliente a buscar
     * @return Lista con facturas del cliente.
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
     * Marca una factura como anulada.
     * @param numeroFactura El número de la factura
     */
    public void anularFactura(long numeroFactura) {
        Factura factura = buscarPorNumero(numeroFactura);
        factura.setAnulado(true);
    }
}
