package com.example.tiendaciclismo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.example.tiendaciclismo.almacenamiento.XML;

class RegistroTipoProducto {

    /**
     * Lista de los tipos de producto creados.
     */
    private List<TipoProducto> listaTipos;
    private long siguienteCodigo = 1;
    private XML respaldo;

    public RegistroTipoProducto() {
        listaTipos = new ArrayList<>();
        respaldo = new XML("datos/registro_tipos_producto.xml");

        cargarRegistros();
    }

    public void agregarTipoProducto(String nombre) {

        TipoProducto tipoProducto = new TipoProducto(siguienteCodigo, nombre);
        listaTipos.add(tipoProducto);
        siguienteCodigo++; // Incrementa para el siguiente producto
    }

    public void validarEntrada(String entrada) throws Exception {
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new Exception("La entrada no puede estar vacía.");
        }
    }

    public void validarCodigo(Long codigo) throws Exception {
        if (codigo == null || codigo <= 0) {
            throw new Exception("El código debe ser un número positivo.");
        }
    }

    /**
     * Busca por nombre
     *
     * @param nombre
     * @return
     * @throws Exception
     */
    public List<TipoProducto> buscarPorNombre(String nombre) throws Exception {
        validarEntrada(nombre);
        List<TipoProducto> resultados = new ArrayList<>();

        for (TipoProducto tipo : listaTipos) {
            if (tipo.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(tipo);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el nombre especificado.");
        }

        return resultados;
    }

    /**
     *
     * @param codigo
     * @return
     * @throws Exception
     */
    public List<TipoProducto> buscarPorCodigo(Long codigo) throws Exception {
        validarCodigo(codigo);
        List<TipoProducto> resultados = new ArrayList<>();

        for (TipoProducto tipo : listaTipos) {
            if (tipo.getCodigo() == codigo) {
                resultados.add(tipo);
            }
        }

        if (resultados.isEmpty()) {
            throw new Exception("No se encontraron productos con el código especificado.");
        }

        return resultados;
    }

    /**
     * Modifica un prodcuto segun su nombre
     *
     * @param codigo
     * @param nombreActual
     * @param nuevoNombre
     * @throws Exception
     */
    public void modificarTipoProductoN(String nombreActual, String nuevoNombre) throws Exception {
        validarEntrada(nombreActual);
        validarEntrada(nuevoNombre);
        List<TipoProducto> tipos = buscarPorNombre(nombreActual);

        for (TipoProducto tipo : tipos) {
            tipo.setNombre(nuevoNombre); // Actualizar el nombre
        }
        guardarTipos(); // Guardar los cambios en el archivo XML
    }

    /**
     * Modifica por codigo
     *
     * @param codigo
     * @param nuevoNombre
     * @throws Exception
     */
    public void modificarTipoProductoC(Long codigo, String nuevoNombre) throws Exception {
        validarCodigo(codigo);
        validarEntrada(nuevoNombre);
        List<TipoProducto> tipos = buscarPorCodigo(codigo);

        for (TipoProducto tipo : tipos) {
            tipo.setNombre(nuevoNombre); // Actualizar el nombre
        }
        guardarTipos(); // Guardar los cambios en el archivo XML
    }

    public Boolean eliminarTipoProducto(Long codigo) throws Exception {
    boolean eliminado = false;

    Iterator<TipoProducto> iterator = listaTipos.iterator();
    while (iterator.hasNext()) {
        TipoProducto tipo = iterator.next();
        if (tipo.getCodigo() == codigo) {
            iterator.remove(); // Usamos el método remove() del iterador para eliminar el elemento
            eliminado = true;
            break;
        }
    }

    if (eliminado) {
        guardarTipos(); // Guardar los cambios en el archivo XML
    }

    return eliminado;
}
  public Boolean eliminarTipoProducto(String nombre) throws Exception {
    boolean eliminado = false;

    Iterator<TipoProducto> iterator = listaTipos.iterator();
    while (iterator.hasNext()) {
        TipoProducto tipo = iterator.next();
        if (tipo.getNombre().equalsIgnoreCase(nombre)) { // Usando equalsIgnoreCase para comparación de nombre
            iterator.remove(); // Usamos el método remove() del iterador para eliminar el elemento
            eliminado = true;
            break;
        }
    }

    if (eliminado) {
        guardarTipos(); // Guardar los cambios en el archivo XML
    }

    return eliminado;
}

    /**
     * Carga los tipos de producto desde un archivo.
     */
    /**
     * Método para leer tipos de productos desde un archivo XML y manipular los
     * datos internamente.
     *
     * @param filePath Ruta del archivo XML.
     */
    public void cargarTipos() {
        try {
            File xmlFile = new File("C:\\Users\\solan\\OneDrive\\Documents\\Proyecto1_POO\\proyecto-1-abraham-jorge-roberth\\tipos.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            NodeList tipoProductos = document.getElementsByTagName("tipoProducto");

            for (int i = 0; i < tipoProductos.getLength(); i++) {

                Node tipoProductoNode = tipoProductos.item(i);

                if (tipoProductoNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementoTipoProducto = (Element) tipoProductoNode;

                    long codigo = Long.parseLong(elementoTipoProducto.getElementsByTagName("codigo").item(0).getTextContent());
                    String nombre = elementoTipoProducto.getElementsByTagName("nombre").item(0).getTextContent();

                    listaTipos.add(new TipoProducto(codigo, nombre));

                    if (codigo >= siguienteCodigo) {
                        siguienteCodigo = codigo + 1; // Asegura que el siguiente código sea único
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para imprimir los tipos de productos.
     *
     * @param listaTipos Lista de objetos TipoProducto.
     */
    public void imprimirTipos() {
        for (TipoProducto tipo : listaTipos) {
            System.out.println("Código: " + tipo.getCodigo() + ", Nombre: " + tipo.getNombre());
        }
    }

    /**
     * Guarda los tipos de producto a un archivo.
     */
    public void guardarTipos() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("tipos");
            document.appendChild(rootElement);

            for (TipoProducto tipo : listaTipos) {
                Element tipoProductoElement = document.createElement("tipoProducto");

                Element codigoElement = document.createElement("codigo");
                codigoElement.appendChild(document.createTextNode(String.valueOf(tipo.getCodigo())));
                tipoProductoElement.appendChild(codigoElement);

                Element nombreElement = document.createElement("nombre");
                nombreElement.appendChild(document.createTextNode(tipo.getNombre()));
                tipoProductoElement.appendChild(nombreElement);

                rootElement.appendChild(tipoProductoElement);
            }

            // Guardar el documento en el archivo XML
            //cambiar a resources (/tipos.xml)
            FileWriter fileWriter = new FileWriter("C:\\Users\\solan\\OneDrive\\Documents\\Proyecto1_POO\\proyecto-1-abraham-jorge-roberth\\tipos.xml");

            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.print(documentToString(document));
            }

        } catch (IOException | ParserConfigurationException | DOMException e) {
        }
    }
    /**
    **
     * Devuelve una lista de TipoProducto para ser utilizada en un JComboBox.
     *
     * @return DefaultComboBoxModel<TipoProducto>
     */
    public DefaultComboBoxModel<TipoProducto> obtenerTiposComboBox() {
        DefaultComboBoxModel<TipoProducto> model = new DefaultComboBoxModel<>();

        for (TipoProducto tipo : listaTipos) {
            model.addElement(tipo);
        }

        return model;
    }

    /**
     * Método para crear y retornar un JComboBox con los tipos de producto.
     *
     * @return JComboBox<TipoProducto>
     */
    public JComboBox<TipoProducto> crearComboBoxTipos() {
        return new JComboBox<>(obtenerTiposComboBox());
    }
    private String documentToString(Document document) {
        // Transformar el documento XML en una cadena de texto
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            StringWriter writer = new StringWriter();

            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();

        } catch (TransformerException e) {

            return null;
        }
    }

    private void cargarRegistros() {
        List<Map<String,String>> registros = respaldo.leerRegistros("tipo-producto");

        for (Map<String,String> registro : registros) {
            listaTipos.add(new TipoProducto(Long.parseLong(registro.get("codigo")), registro.get("nombre")));
        }
    }
}
