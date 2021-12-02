/*
 *
 */

package mundo;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Documento {
    private INodo elementoRaiz;

    public Documento() {
        elementoRaiz = new Elemento("Documento");
    }

    /**
     * Devuelve el elemento raíz del árbol.
     * @return El elemento raíz del arbol.
     */
    public INodo darElementoRaiz() {
        return elementoRaiz;
    }

    /**
     * Asigna el elementos raiz.
     * @param nombre Nombre del elemento raiz.
     */
    public void asignarElementoRaiz(String nombre) {
        if(nombre == null) {
            elementoRaiz = null;
        }
        else {
            elementoRaiz = new Elemento(nombre);
        }
    }

    /**
     * Asigna el elementos raiz.
     * @param nombre Nombre del elemento raiz.
     * @param valor Valor de elemento raiz.
     */
    public void asignarElementoRaiz(String nombre, String valor) {
        elementoRaiz = new Elemento(nombre, valor);
    }

    /**
     * Crea un elemento con el nombre dado.
     * @param nombreElemento Nombre del elemento que se va crear.
     * @return El Elemento que se creo.
     */
    public INodo crearElemento(String nombreElemento) {
        return new Elemento(nombreElemento);
    }

    /**
     * Inserta un nuevo elemento a un nodo.
     * @param padre Padre nodo al que se le va insertar el hijo.
     * @param nuevoElemento Nuevo nodo que se va insertar.
     * @throws InsercionHijoAtributoException Se lanza está excepción en caso que 
     *         no se pueda insertar el elemento.
     */
    public void insertarNodo(INodo padre, INodo nuevoElemento) 
            throws InsercionHijoAtributoException {
        padre.insertarHijo(nuevoElemento);
    }

    /**
     * Crea un elemento con el nombre y el valor dado.
     * @param nombreElemento Nombre del elemento que se va crear.
     * @param valorElemento Valor del elemento que se va crear.
     * @return El Elemento que se creo.
     */
    public INodo crearElemento(String nombreElemento, String valorElemento) {
        return new Elemento(nombreElemento, valorElemento);
    }

    /**
     * Crea un atributo con el nombre y el valor dado.
     * @param nombreElemento Nombre del atributo que se va crear.
     * @param valorElemento Valor del atributo que se va crear.
     * @return El Atributo que se creo.
     */
    public INodo crearAtributo(String nombreElemento, String valorElemento) {
        return new Atributo(nombreElemento, valorElemento);
    }

    /**
     * Elimina un nodo del nodo raiz.
     * @param nodo Nodo a eliminar
     */
    public void eliminarNodo(INodo nodo) {
        elementoRaiz.eliminarNodo(nodo);
    }

    /**
     * Carga un archivo XML en un elemento.
     * @param xmlPath Ruta del archivo.
     * @throws Exception Excepción de error
     */
    public void cargarXml(String xmlPath) throws Exception {
        StringBuffer lectura = new StringBuffer();
        try {
            FileReader fr = new FileReader(xmlPath);
            BufferedReader in = new BufferedReader(fr);
            String str;
            while((str = in.readLine()) != null) {
                lectura.append(str);
            }
            in.close();
            fr.close();
        }
        catch(IOException e) {
            throw new Exception("Error al leer el archivo del disco", e);
        }
        // Saca el XML completo y lo parsea utilizando DOM
        String xml = lectura.toString();
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(new StringReader(xml)));
        Document d = parser.getDocument();
        if(elementoRaiz == null) {
            elementoRaiz = new Elemento();
        }
        elementoRaiz.cargarElemento(d);
    }

    /**
     * Guarda un archivo en formato XML
     * @param xmlPath Ruta para guardar el archivo
     * @throws Exception Excepción de error
     */
    public void guardarXml(String xmlPath) throws Exception {
        try {
            Document documento = elementoRaiz.toDocument();
            // Saca el XML completo a un String
            StringWriter stringWriter = new StringWriter();
            OutputFormat format = new OutputFormat(documento);
            format.setLineSeparator("\n");
            format.setIndenting(true);
            format.setEncoding("ISO-8859-1");
            XMLSerializer serial = new XMLSerializer(stringWriter, format);
            serial.serialize(documento);
            String xml = stringWriter.toString();
            // Guarda el XML en el archivo especificado
            FileOutputStream fos = new FileOutputStream(xmlPath);
            fos.write(xml.getBytes());
            fos.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception("Error al guardar en XML", e);
        }

    }

    /**
     * Permite ver el contenido de un archivo XML
     * @return Contenido del archivo XML
     * @throws Exception Excepción de error
     */
    public String darXML() throws Exception {
        Document documento = elementoRaiz.toDocument();
        // Saca el XML completo a un String
        StringWriter stringWriter = new StringWriter();
        OutputFormat format = new OutputFormat(documento);
        format.setLineSeparator("\n");
        format.setIndenting(true);
        format.setEncoding("ISO-8859-1");
        XMLSerializer serial = new XMLSerializer(stringWriter, format);
        serial.serialize(documento);
        return stringWriter.toString();
    }

    /**
     * Generar un nuevo elemento del archivo
     * @param cadenaXML Cadena XML
     * @throws SAXException Error de conversión XML
     * @throws IOException Error de lectura de archivo
     */
    public void generarElemento(String cadenaXML) throws SAXException, IOException {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(new StringReader(cadenaXML)));
        Document d = parser.getDocument();
        elementoRaiz.cargarElemento(d);
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Método para la extensión 1
     * @return respuesta1
     */
    public String metodo1() {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2() {
        return "Respuesta 2";
    }

}
