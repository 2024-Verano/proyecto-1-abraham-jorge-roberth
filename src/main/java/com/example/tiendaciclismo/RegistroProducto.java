package com.example.tiendaciclismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.tiendaciclismo.almacenamiento.XML;


class RegistroProducto {
    /**
     * Lista de los productos creados.
     */
    private ArrayList<Producto> productos = new ArrayList<>();
    private static long siguienteCodigoArticulo = 1;
    private XML respaldo;

    
    public RegistroProducto() {
        respaldo = new XML("datos/registro_productos.xml");

        cargarRegistros();
    }

    /**
     * Crea un producto y lo almacena en productos.
     */
    public Producto agregarProducto(long codigoTipo, int tamano, String marca, int precio, int cantidad, String nombre) throws Exception {
        long codigoArticulo = siguienteCodigoArticulo++;
        Producto producto = new Producto(codigoArticulo, codigoTipo, tamano, marca, precio, cantidad, nombre);
        productos.add(producto);
        guardarRegistros(); // Guardar los cambios en el archivo XML
        return producto;
    }
    /**
     * Busca un producto por nombre.
     */
    public List<Producto> buscarProductoPorNombre(String nombre) throws Exception {
        validarEntrada(nombre);
        List<Producto> resultados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(producto);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        return resultados;
    }

    /**
     * Busca un producto por código.
     */
    public Producto buscarProductoPorCodigo(long codigo) throws Exception {
        validarCodigo(codigo);

        for (Producto producto : productos) {
            if (producto.getCodigoArticulo() == codigo) {
                return producto;
            }
        }

        throw new Exception("No se encontró un producto con el código especificado.");
    }

    /**
     * Modifica los atributos de un producto.
     */
    public void modificarProducto(long codigo, String atributo, Object nuevoValor) throws Exception {
        Producto producto = buscarProductoPorCodigo(codigo);

        switch (atributo.toLowerCase()) {
            case "codigotipo":
                producto.setCodigoTipo((Long) nuevoValor);
                break;
            case "tamano":
                producto.setTamano((Integer) nuevoValor);
                break;
            case "marca":
                producto.setMarca((String) nuevoValor);
                break;
            case "precio":
                producto.setPrecio((Integer) nuevoValor);
                break;
            case "cantidad":
                producto.setCantidad((Integer) nuevoValor);
                break;
            case "nombre":
                producto.setNombre((String) nuevoValor);
                break;
            default:
                throw new Exception("Atributo no válido.");
        }
        guardarRegistros();
    }

    /**
     * Elimina un producto.
     */
    public Boolean eliminarProducto() throws Exception {
        throw new Exception("Sin implementar");
    }

    private void validarEntrada(String entrada) throws Exception {
        if (entrada == null || !entrada.equals(entrada.trim())) {
            throw new Exception("La entrada no puede estar vacía.");
        }
    }

    private void validarCodigo(Long codigo) throws Exception {
        if (codigo == null || codigo <= 0) {
            throw new Exception("El código debe ser un número positivo.");
        }
    }
    /**
 * Elimina un producto por código.
 */
public boolean eliminarProductoPorCodigo(long codigo) throws Exception {
    validarCodigo(codigo);
    for (Producto producto : productos) {
        if (producto.getCodigoArticulo() == codigo) {
            productos.remove(producto);
            guardarRegistros();
            return true;
        }
    }

    throw new Exception("No se encontró un producto con el código especificado.");
}

/**
 * Elimina un producto por nombre.
 */
public boolean eliminarProductoPorNombre(String nombre) throws Exception {
    validarEntrada(nombre);

    for (Producto producto : productos) {
        if (producto.getNombre().equalsIgnoreCase(nombre)) {
            productos.remove(producto);
            guardarRegistros();
            return true;
        }
    }

    throw new Exception("No se encontraron productos con el nombre especificado.");
}
public String buscarProductoPorNombreYObtenerInfo(String nombre) throws Exception {
            validarEntrada(nombre);
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    return producto.toString();
                }
            }
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        /**
         * Busca un producto por código y devuelve su información.
         */
        public String buscarProductoPorCodigoYObtenerInfo(long codigo) throws Exception {
            validarCodigo(codigo);
            for (Producto producto : productos) {
                if (producto.getCodigoArticulo() == codigo) {
                    return producto.toString();
                }
            }
            throw new Exception("No se encontró un producto con el código especificado.");
        }

    private void cargarRegistros() {
        List<Map<String,String>> registros = respaldo.leerRegistros("tipo-producto");

        try {
            for (Map<String,String> registro : registros) {
                productos.add(new Producto(
                            Long.parseLong(registro.get("codigo-articulo")),
                            Long.parseLong(registro.get("codigo-tipo")),
                            Integer.parseInt(registro.get("tamano")),
                            registro.get("marca"),
                            Integer.parseInt(registro.get("precio")),
                            Integer.parseInt(registro.get("cantidad")),
                            registro.get("nombre")
                        ));
            }
        } catch (Exception e) {
        }
    }

    private void guardarRegistros() {
        List<Map<String,String>> registros = new ArrayList<Map<String,String>>();

        for (Producto producto : productos) {
            Map<String,String> registro = new HashMap<>();
            registro.put("codigo-articulo", String.valueOf(producto.getCodigoArticulo()));
            registro.put("codigo-tipo", String.valueOf(producto.getCodigoArticulo()));
            registro.put("tamano", String.valueOf(producto.getTamano()));
            registro.put("marca", producto.getMarca());
            registro.put("precio", String.valueOf(producto.getPrecio()));
            registro.put("cantidad", String.valueOf(producto.getCantidad()));
            registro.put("nombre", producto.getNombre());

            registros.add(registro);
        }

        try {
            respaldo.guardarRegistros("tipo-producto", registros);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
