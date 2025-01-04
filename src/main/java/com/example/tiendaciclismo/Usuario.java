package com.example.tiendaciclismo;

import java.util.Objects;

/**
 * Clase para el almacenamiento de los usuarios en memoria.
 * @author Roberth Rojas
 */
class Usuario {
    /**
     * El nombre del usuario
     */
    private final String nombreUsuario;

    /**
     * La contrasena del usuario
     */
    private final String contrasena;


    /**
     * @param nombreUsuario El nombre del usuario.
     * @param contrasena La contraseña con la cual el usuario iniciará sesión.
     */
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * @return El nombre del usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.nombreUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nombreUsuario, other.nombreUsuario);
    }
}
