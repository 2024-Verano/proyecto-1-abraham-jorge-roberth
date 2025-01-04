package com.example.tiendaciclismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;


class ControlAcceso {

    private static final String ARCHIVO_USUARIOS = "usuarios.acc";

    /**
     * Lista de usuarios.
     */
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public ControlAcceso() throws ControlAccesoException{
        try {
            this.cargarUsuarios();
        } catch (IOException e) {
            throw new ControlAccesoException("No se pudo cargar el archivo: %s".formatted(ARCHIVO_USUARIOS));
        }
    }

    /**
     * Comprueba que el usuario provisto se encuentre en la lista de usuarios y la contraseña coincida.
     * @param nombreUsuario El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @return Si el usuario existe y la contraseña es válida.
     */
    public Boolean iniciarSesion(String nombreUsuario, String contrasena) {
        Boolean usuarioValido = false; 

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                usuarioValido = true;
                break;
            }
        }

        return usuarioValido;
    }

    /**
     * Lee la lista de  usuarios desde el archivo usuarios.acc
     */
    private void cargarUsuarios() throws IOException {
        FileReader file = new FileReader(ARCHIVO_USUARIOS);
        BufferedReader in = new BufferedReader(file);

        String linea;
        while ((linea = in.readLine()) != null) {
            String[] columnas = linea.split(",");

            this.usuarios.add(new Usuario(columnas[0], columnas[1]));
        }

        in.close();
    }
}
