package com.example.tiendaciclismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.example.tiendaciclismo.almacenamiento.XML;

class RegistroTipoProducto {

    /**
     * Lista de los tipos de producto creados.
     */
    private List<TipoProducto> listaTipos;
    private long siguienteCodigo = 1;
    private XML respaldo;

    public RegistroTipoProducto() {
        listaTipos = new ArrayList<>();
        respaldo = new XML("datos/registro_tipos_producto.xml");

        cargarRegistros();
    }

    public void agregarTipoProducto(String nombre) {

        TipoProducto tipoProducto = new TipoProducto(siguienteCodigo, nombre);
        listaTipos.add(tipoProducto);
        siguienteCodigo++; // Incrementa para el siguiente producto

        guardarRegistros();
    }

    public void validarEntrada(String entrada) throws Exception {
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new Exception("La entrada no puede estar vacía.");
        }
    }

    public void validarCodigo(Long codigo) throws Exception {
        if (codigo == null || codigo <= 0) {
            throw new Exception("El código debe ser un número positivo.");
        }
    }

    /**
     * Busca por nombre
     *
     * @param nombre
     * @return
     * @throws Exception
     */
    public List<TipoProducto> buscarPorNombre(String nombre) throws Exception {
        validarEntrada(nombre);
        List<TipoProducto> resultados = new ArrayList<>();

        for (TipoProducto tipo : listaTipos) {
            if (tipo.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(tipo);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        return resultados;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    public List<TipoProducto> buscarPorCodigo(Long codigo) throws Exception {
        validarCodigo(codigo);
        List<TipoProducto> resultados = new ArrayList<>();

        for (TipoProducto tipo : listaTipos) {
            if (tipo.getCodigo() == codigo) {
                resultados.add(tipo);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el código especificado.");
        }

        return resultados;
    }

    /**
     * Modifica un prodcuto segun su nombre
     *
     * @param codigo
     * @param nombreActual
     * @param nuevoNombre
     * @throws Exception
     */
    public void modificarTipoProductoN(String nombreActual, String nuevoNombre) throws Exception {
        validarEntrada(nombreActual);
        validarEntrada(nuevoNombre);
        List<TipoProducto> tipos = buscarPorNombre(nombreActual);

        for (TipoProducto tipo : tipos) {
            tipo.setNombre(nuevoNombre); // Actualizar el nombre
        }
        guardarRegistros(); // Guardar los cambios en el archivo XML
    }

    /**
     * Modifica por codigo
     *
     * @param codigo
     * @param nuevoNombre
     * @throws Exception
     */
    public void modificarTipoProductoC(Long codigo, String nuevoNombre) throws Exception {
        validarCodigo(codigo);
        validarEntrada(nuevoNombre);
        List<TipoProducto> tipos = buscarPorCodigo(codigo);

        for (TipoProducto tipo : tipos) {
            tipo.setNombre(nuevoNombre); // Actualizar el nombre
        }
        guardarRegistros(); // Guardar los cambios en el archivo XML
    }

    public Boolean eliminarTipoProducto(Long codigo) throws Exception {
        boolean eliminado = false;

        Iterator<TipoProducto> iterator = listaTipos.iterator();
        while (iterator.hasNext()) {
            TipoProducto tipo = iterator.next();
            if (tipo.getCodigo() == codigo) {
                iterator.remove(); // Usamos el método remove() del iterador para eliminar el elemento
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardarRegistros(); // Guardar los cambios en el archivo XML
        }

        return eliminado;
    }
    public Boolean eliminarTipoProducto(String nombre) throws Exception {
        boolean eliminado = false;

        Iterator<TipoProducto> iterator = listaTipos.iterator();
        while (iterator.hasNext()) {
            TipoProducto tipo = iterator.next();
            if (tipo.getNombre().equalsIgnoreCase(nombre)) { // Usando equalsIgnoreCase para comparación de nombre
                iterator.remove(); // Usamos el método remove() del iterador para eliminar el elemento
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            guardarRegistros(); // Guardar los cambios en el archivo XML
        }

        return eliminado;
    }



    /**
     * Devuelve una lista de TipoProducto para ser utilizada en un JComboBox.
     *
     * @return DefaultComboBoxModel<TipoProducto>
     */
    public DefaultComboBoxModel<TipoProducto> obtenerTiposComboBox() {
        DefaultComboBoxModel<TipoProducto> model = new DefaultComboBoxModel<>();

        for (TipoProducto tipo : listaTipos) {
            model.addElement(tipo);
        }

        return model;
    }

    /**
     * Método para crear y retornar un JComboBox con los tipos de producto.
     *
     * @return JComboBox<TipoProducto>
     */
    public JComboBox<TipoProducto> crearComboBoxTipos() {
        return new JComboBox<>(obtenerTiposComboBox());
    }

    private void cargarRegistros() {
        List<Map<String,String>> registros = respaldo.leerRegistros("tipo-producto");

        for (Map<String,String> registro : registros) {
            listaTipos.add(new TipoProducto(Long.parseLong(registro.get("codigo")), registro.get("nombre")));
        }
    }

    private void guardarRegistros() {
        List<Map<String,String>> registros = new ArrayList<Map<String,String>>();

        for (TipoProducto tipo : listaTipos) {
            Map<String,String> registro = new HashMap<>();
            registro.put("codigo", String.valueOf(tipo.getCodigo()));
            registro.put("nombre", tipo.getNombre());

            registros.add(registro);
        }

        try {
            respaldo.guardarRegistros("tipo-producto", registros);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
