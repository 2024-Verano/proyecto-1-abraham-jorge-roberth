package com.example.tiendaciclismo;

import java.time.LocalDate;
import java.util.List;

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
     * Las 7 provincias de Costa Rica.
     */
    private static final List<String> PROVINCIAS = List.of("San José", "Alajuela", "Cartago", "Heredia", "Guanacaste", "Puntarenas", "Limón");
    private String provincia;

    /**
     * Cantones dentro de la provincia seleccionada.
     */
    private String canton;

    /**
     * Distritos dentro del cantón seleccionado.
     */
    private String distrito;

    /**
     * Fecha de nacimiento y Formato de fecha correcto
     */
    private LocalDate fechaNacimiento;

    public Cliente(long codigo, String nombre, String apellidos, int numTelefono, String correo, String provincia, String canton, String distrito, LocalDate fechaNacimiento) {
        if (!PROVINCIAS.contains(provincia)) {
            throw new IllegalArgumentException("Provincia inválida: " + provincia);
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numTelefono = numTelefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        if (!PROVINCIAS.contains(provincia)) {
            throw new IllegalArgumentException("Provincia inválida: " + provincia);
        }
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
