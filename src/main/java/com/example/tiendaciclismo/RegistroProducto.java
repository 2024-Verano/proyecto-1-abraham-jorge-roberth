package com.example.tiendaciclismo;

import java.util.ArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.w3c.dom.DOMException;

class RegistroProducto {
    /**
     * Lista de los productos creados.
     */
    private ArrayList<Producto> productos = new ArrayList<>();
private static long siguienteCodigoArticulo = 1;

    /**
     * Crea un producto y lo almacena en productos.
     */
    public Producto agregarProducto(long codigoTipo, int tamano, String marca, int precio, int cantidad, String nombre) throws Exception {
        long codigoArticulo = siguienteCodigoArticulo++;
        Producto producto = new Producto(codigoArticulo, codigoTipo, tamano, marca, precio, cantidad, nombre);
        productos.add(producto);
        guardarProductos(); // Guardar los cambios en el archivo XML
        return producto;
    }
    /**
     * Busca un producto por nombre.
     */
    public List<Producto> buscarProductoPorNombre(String nombre) throws Exception {
        validarEntrada(nombre);
        List<Producto> resultados = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(producto);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        return resultados;
    }

    /**
     * Busca un producto por código.
     */
    public Producto buscarProductoPorCodigo(long codigo) throws Exception {
        validarCodigo(codigo);

        for (Producto producto : productos) {
            if (producto.getCodigoArticulo() == codigo) {
                return producto;
            }
        }

        throw new Exception("No se encontró un producto con el código especificado.");
    }

    /**
     * Modifica los atributos de un producto.
     */
    public void modificarProducto(long codigo, String atributo, Object nuevoValor) throws Exception {
        Producto producto = buscarProductoPorCodigo(codigo);

        switch (atributo.toLowerCase()) {
            case "codigotipo":
                producto.setCodigoTipo((Long) nuevoValor);
                break;
            case "tamano":
                producto.setTamano((Integer) nuevoValor);
                break;
            case "marca":
                producto.setMarca((String) nuevoValor);
                break;
            case "precio":
                producto.setPrecio((Integer) nuevoValor);
                break;
            case "cantidad":
                producto.setCantidad((Integer) nuevoValor);
                break;
            case "nombre":
                producto.setNombre((String) nuevoValor);
                break;
            default:
                throw new Exception("Atributo no válido.");
        }
        guardarProductos();
    }

    /**
     * Elimina un producto.
     */
    public Boolean eliminarProducto() throws Exception {
        throw new Exception("Sin implementar");
    }

    /**
     * Carga los productos desde un archivo.
     */
    public void cargarProductos() throws Exception {
    try {
        File xmlFile = new File("C:\\Users\\solan\\OneDrive\\Documents\\Proyecto1_POO\\proyecto-1-abraham-jorge-roberth\\productos.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);

        NodeList productoNodes = document.getElementsByTagName("producto");

        for (int i = 0; i < productoNodes.getLength(); i++) {
            Node productoNode = productoNodes.item(i);

            if (productoNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elementoProducto = (Element) productoNode;

                long codigoArticulo = elementoProducto.getElementsByTagName("codigoArticulo").item(0) != null ? Long.parseLong(elementoProducto.getElementsByTagName("codigoArticulo").item(0).getTextContent()) : 0;
                long codigoTipo = elementoProducto.getElementsByTagName("codigoTipo").item(0) != null ? Long.parseLong(elementoProducto.getElementsByTagName("codigoTipo").item(0).getTextContent()) : 0;
                int tamano = elementoProducto.getElementsByTagName("tamano").item(0) != null ? Integer.parseInt(elementoProducto.getElementsByTagName("tamano").item(0).getTextContent()) : 0;
                String marca = elementoProducto.getElementsByTagName("marca").item(0) != null ? elementoProducto.getElementsByTagName("marca").item(0).getTextContent() : "";
                int precio = elementoProducto.getElementsByTagName("precio").item(0) != null ? Integer.parseInt(elementoProducto.getElementsByTagName("precio").item(0).getTextContent()) : 0;
                int cantidad = elementoProducto.getElementsByTagName("cantidad").item(0) != null ? Integer.parseInt(elementoProducto.getElementsByTagName("cantidad").item(0).getTextContent()) : 0;
                String nombre = elementoProducto.getElementsByTagName("nombre").item(0) != null ? elementoProducto.getElementsByTagName("nombre").item(0).getTextContent() : "";

                Producto producto = new Producto(codigoArticulo, codigoTipo, tamano, marca, precio, cantidad, nombre);
                productos.add(producto);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception("Error al cargar los productos desde el archivo.");
    }
}

    /**
     * Guarda los productos a un archivo.
     */
    private void guardarProductos() throws Exception {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("productos");
            document.appendChild(rootElement);

            for (Producto producto : productos) {
                Element productoElement = document.createElement("producto");

                Element codigoArticuloElement = document.createElement("codigoArticulo");
                codigoArticuloElement.appendChild(document.createTextNode(String.valueOf(producto.getCodigoArticulo())));
                productoElement.appendChild(codigoArticuloElement);

                Element codigoTipoElement = document.createElement("codigoTipo");
                codigoTipoElement.appendChild(document.createTextNode(String.valueOf(producto.getCodigoTipo())));
                productoElement.appendChild(codigoTipoElement);

                Element tamanoElement = document.createElement("tamano");
                tamanoElement.appendChild(document.createTextNode(String.valueOf(producto.getTamano())));
                productoElement.appendChild(tamanoElement);

                Element marcaElement = document.createElement("marca");
                marcaElement.appendChild(document.createTextNode(String.valueOf(producto.getMarca())));
                productoElement.appendChild(marcaElement);

                Element precioElement = document.createElement("precio");
                precioElement.appendChild(document.createTextNode(String.valueOf(producto.getPrecio())));
                productoElement.appendChild(precioElement);

                Element cantidadElement = document.createElement("cantidad");
                cantidadElement.appendChild(document.createTextNode(String.valueOf(producto.getCantidad())));
                productoElement.appendChild(cantidadElement);

                Element nombreElement = document.createElement("nombre");
                nombreElement.appendChild(document.createTextNode(producto.getNombre()));
                productoElement.appendChild(nombreElement);

                rootElement.appendChild(productoElement);
            }

            // Guardar el documento en el archivo XML
            FileWriter fileWriter = new FileWriter("C:\\Users\\solan\\OneDrive\\Documents\\Proyecto1_POO\\proyecto-1-abraham-jorge-roberth\\productos.xml");

            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.print(documentToString(document));
            }

        } catch (IOException | ParserConfigurationException | DOMException e) {
            e.printStackTrace();
            throw new Exception("Error al guardar los productos en el archivo.");
        }
    }

    private String documentToString(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();

        } catch (TransformerException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void validarEntrada(String entrada) throws Exception {
        if (entrada == null || !entrada.equals(entrada.trim())) {
            throw new Exception("La entrada no puede estar vacía.");
        }
    }

    private void validarCodigo(Long codigo) throws Exception {
        if (codigo == null || codigo <= 0) {
            throw new Exception("El código debe ser un número positivo.");
        }
    }
    /**
 * Elimina un producto por código.
 */
public boolean eliminarProductoPorCodigo(long codigo) throws Exception {
    validarCodigo(codigo);
    cargarProductos();
    for (Producto producto : productos) {
        if (producto.getCodigoArticulo() == codigo) {
            productos.remove(producto);
            guardarProductos();
            return true;
        }
    }

    throw new Exception("No se encontró un producto con el código especificado.");
}

/**
 * Elimina un producto por nombre.
 */
public boolean eliminarProductoPorNombre(String nombre) throws Exception {
    validarEntrada(nombre);

    for (Producto producto : productos) {
        if (producto.getNombre().equalsIgnoreCase(nombre)) {
            productos.remove(producto);
            guardarProductos();
            return true;
        }
    }

    throw new Exception("No se encontraron productos con el nombre especificado.");
}
public String buscarProductoPorNombreYObtenerInfo(String nombre) throws Exception {
            validarEntrada(nombre);
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    return producto.toString();
                }
            }
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        /**
         * Busca un producto por código y devuelve su información.
         */
        public String buscarProductoPorCodigoYObtenerInfo(long codigo) throws Exception {
            validarCodigo(codigo);
            for (Producto producto : productos) {
                if (producto.getCodigoArticulo() == codigo) {
                    return producto.toString();
                }
            }
            throw new Exception("No se encontró un producto con el código especificado.");
        }
}