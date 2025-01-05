package com.example.tiendaciclismo;


class Producto {
    private static long siguienteCodigoArticulo = 1;

    private long codigoArticulo;
    private long codigoTipo;
    private int tamano;
    private int marca;
    private int precio;
    private int cantidad;
    private String nombre;

    public Producto(long codigoTipo, int tamano, int marca, int precio, int cantidad, String nombre) throws Exception {
        setCodigoTipo(codigoTipo);
        setTamano(tamano);
        setMarca(marca);
        setPrecio(precio);
        setCantidad(cantidad);
        setNombre(nombre);
        this.codigoArticulo = siguienteCodigoArticulo++;
    }

    public long getCodigoArticulo() {
        return codigoArticulo;
    }

    public long getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(long codigoTipo) throws Exception {
        if (codigoTipo <= 0) {
            throw new Exception("El código de tipo debe ser un número positivo.");
        }
        this.codigoTipo = codigoTipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) throws Exception {
        if (tamano < 0) {
            throw new Exception("El tamaño no puede ser negativo.");
        }
        this.tamano = tamano;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) throws Exception {
        if (marca <= 0) {
            throw new Exception("La marca debe ser un número positivo.");
        }
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
        if (precio < 0) {
            throw new Exception("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) throws Exception {
        if (cantidad < 0) {
            throw new Exception("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }
}