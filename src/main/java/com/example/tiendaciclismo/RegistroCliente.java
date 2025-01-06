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
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public class RegistroCliente {
    private List<Cliente> clientes;

    public RegistroCliente() {
        clientes = new ArrayList<>();
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
    }

    public void eliminarCliente(long codigo) throws Exception {
        Cliente cliente = buscarPorCodigo(codigo);
        // Verificar si el cliente tiene facturas asociadas (simulación)
        if (verificarFacturas(cliente)) {
            throw new Exception("No se puede eliminar el cliente con código " + codigo + ", tiene facturas asociadas.");
        }
        clientes.remove(cliente);
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
}