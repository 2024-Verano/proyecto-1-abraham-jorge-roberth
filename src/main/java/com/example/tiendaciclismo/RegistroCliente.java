/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tiendaciclismo;

/**
 *
 * @author jorge
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDate;

import com.example.tiendaciclismo.almacenamiento.XML;


public class RegistroCliente {
    private List<Cliente> clientes;

    private XML respaldo;

    public RegistroCliente() {
        clientes = new ArrayList<>();
        respaldo = new XML("datos/registro_clientes.xml");

        cargarRegistros();
    }

    public void agregarCliente(Cliente nuevoCliente) throws Exception {
        if (nuevoCliente.getNombre().isEmpty() || nuevoCliente.getApellidos().isEmpty() || nuevoCliente.getTelefono() .isEmpty() || nuevoCliente.getCorreo().isEmpty() || nuevoCliente.getProvincia().isEmpty() || nuevoCliente.getCanton().isEmpty() || nuevoCliente.getDistrito().isEmpty() || nuevoCliente.getFechaNacimiento() == null) {
            throw new Exception("Todos los campos son obligatorios.");
        }
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == nuevoCliente.getCodigo()) {
                throw new Exception("Ya existe un cliente con el código proporcionado.");
            }
        }
        clientes.add(nuevoCliente);

        guardarRegistros();
    }

    public void modificarCliente(long codigo, String nuevoNombre, String nuevosApellidos, String nuevoTelefono, String nuevoCorreo, String nuevaProvincia, String nuevoCanton, String nuevoDistrito, LocalDate nuevaFechaNacimiento) throws Exception {
        Cliente cliente = buscarPorCodigo(codigo);
        cliente.setNombre(nuevoNombre);
        cliente.setApellidos(nuevosApellidos);
        cliente.setTelefono(nuevoTelefono);
        cliente.setCorreo(nuevoCorreo);
        cliente.setProvincia(nuevaProvincia);
        cliente.setCanton(nuevoCanton);
        cliente.setDistrito(nuevoDistrito);
        cliente.setFechaNacimiento(nuevaFechaNacimiento);

        guardarRegistros();
    }

    public void eliminarCliente(long codigo) throws Exception {
        Cliente cliente = buscarPorCodigo(codigo);
        // Verificar si el cliente tiene facturas asociadas (simulación)
        if (verificarFacturas(cliente)) {
            throw new Exception("No se puede eliminar el cliente con código " + codigo + ", tiene facturas asociadas.");
        }
        clientes.remove(cliente);

        guardarRegistros();
    }

    public Cliente buscarPorCodigo(long codigo) throws Exception {
        return clientes.stream()
                .filter(cliente -> cliente.getCodigo() == codigo)
                .findFirst()
                .orElseThrow(() -> new Exception("Cliente con código " + codigo + " no encontrado."));
    }

    public Cliente buscarPorNombre(String nombre) throws Exception {
        return clientes.stream()
                .filter(cliente -> cliente.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new Exception("Cliente con nombre " + nombre + " no encontrado."));
    }

    public Cliente buscarPorApellidos(String apellidos) throws Exception {
        return clientes.stream()
                .filter(cliente -> cliente.getApellidos().equalsIgnoreCase(apellidos))
                .findFirst()
                .orElseThrow(() -> new Exception("Cliente con apellidos " + apellidos + " no encontrado."));
    }

    private boolean verificarFacturas(Cliente cliente) {
        // Simulación de verificación de facturas. Reemplazar con lógica real
        return false;
    }

    private void cargarRegistros() {
        List<Map<String,String>> registros = respaldo.leerRegistros("cliente");

        for (Map<String,String> registro : registros) {
            clientes.add(new Cliente(
                        Long.parseLong(registro.get("codigo")),
                        registro.get("nombre"),
                        registro.get("apellidos"),
                        registro.get("numTelefono"),
                        registro.get("correo"),
                        registro.get("provincia"),
                        registro.get("canton"),
                        registro.get("distrito"),
                        LocalDate.parse(registro.get("fecha-nacimiento"))
                        ));
        }
    }

    private void guardarRegistros() {
        List<Map<String,String>> registros = new ArrayList<Map<String,String>>();

        for (Cliente cliente : clientes) {
            Map<String,String> registro = new HashMap<>();
            registro.put("codigo", String.valueOf(cliente.getCodigo()));
            registro.put("nombre", cliente.getNombre());
            registro.put("apellidos", cliente.getApellidos());
            registro.put("numTelefono", cliente.getTelefono());
            registro.put("correo", cliente.getCorreo());
            registro.put("provincia", cliente.getProvincia());
            registro.put("canton", cliente.getCanton());
            registro.put("distrito", cliente.getDistrito());
            registro.put("fecha-nacimiento", cliente.getFechaNacimiento().toString());
        }

        try {
            respaldo.guardarRegistros("cliente", registros);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
