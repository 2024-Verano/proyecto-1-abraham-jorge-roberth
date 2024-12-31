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
    private ArrayList<Usuario> usuarios;

    /**
     * Comprueba que el usuario provisto se encuentre en la lista de usuarios y la contraseña coincida.
     */
    public Boolean iniciarSesion() throws Exception {
        throw new Exception("Sin implementar");
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
