package com.example.tiendaciclismo;


class Producto {
    

    private long codigoArt;
    private long codigoTipo;
    private int tamano;
    private String marca;
    private int precio;
    private int cantidad;
    private String nombre;

    public Producto(long codigoArt, long codigoTipo, int tamano, String marca, int precio, int cantidad, String nombre) throws Exception {
        setCodigoTipo(codigoTipo);
        setTamano(tamano);
        setMarca(marca);
        setPrecio(precio);
        setCantidad(cantidad);
        setNombre(nombre);
        setCodigoArticulo(codigoArt);
        
    }

    public long getCodigoArticulo() {
        return codigoArt;
    }
public void setCodigoArticulo(long codigoArt){
    this.codigoArt = codigoArt;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception {
        
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