package com.example.tiendaciclismo;

import java.util.Objects;


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
     * Verifica que la contraseña ingresada coincida con la del usuario.
     */
    public Boolean verificarContrasena() throws Exception {
        throw new Exception("Sin implementar");
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
