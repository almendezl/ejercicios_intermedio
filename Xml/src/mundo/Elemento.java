/*
 *
 */

package mundo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Elemento implements INodo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Lista de atributos.
     */
    private Collection<Atributo> atributos;

    /**
     * Lista de elementos hijos.
     */
    private Collection<Elemento> elementosHijos;

    /**
     * Nombre del elemento.
     */
    private String nombreElemento;

    /**
     * Valor del elemento.
     */
    private String valor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor de un elemento.
     */
    public Elemento() {
        nombreElemento = "";
        valor = "";
        elementosHijos = new ArrayList<Elemento>();
        atributos = new ArrayList<Atributo>();
    }

    /**
     * Constructor de un elemento.
     * 
     * @param nNombreElemento Nombre del elemento que se está insertando.
     */
    public Elemento(String nNombreElemento) {
        valor = "";
        nombreElemento = nNombreElemento;
        elementosHijos = new ArrayList();
        atributos = new ArrayList();
    }

    /**
     * Constructor de un elemento.
     * @param nNombreElemento Nombre del elemento que se está creando.
     * @param nValor Valor del elemento que se está creando.
     */
    public Elemento(String nNombreElemento, String nValor) {
        valor = nValor;
        nombreElemento = nNombreElemento;
        elementosHijos = new ArrayList();
        atributos = new ArrayList();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Inserta un elemento dentro del elemento.
     * 
     * @param elemento Elemento que se va insertar.
     */
public void insertarElemento(Elemento elemento){
    elementosHijos.add(elemento);
}

    /**
     * Inserta un atributo del elemento.
     * 
     * @param atributo Atributo que se va insertar.
     */
public void insertarAtributo(Atributo atributo){
    atributos.add(atributo);
}

    /**
     * Método que devuelve la cadena que caracteriza el objeto.
     */
    @Override
    public String toString() {
        if(valor == null) {
            return "Elemento: " + nombreElemento;
        }
        if(valor.equals("")) {
            return "Elemento: " + nombreElemento;
        }
        else {
            return "Elemento: " + nombreElemento + " = " + valor;
        }
    }

    /**
     * Carga los elementos de un documento.
     * @param nodoInicial Es el elemento inicial que se va cargar.
     */
public void cargarElemento(Element nodoInicial){
    nombreElemento = nodoInicial.getNodeName();
    NodeList elementosHijos = nodoInicial.getChildNodes();
    for(int i=0; i< nodoInicial.getAttributes().getLength(); i++){
        Attr attribute = (Attr)nodoInicial.getAttributes().item(i);
        Atributo atributo = new Atributo(attribute.getName(), attribute.getValue());
        insertarAtributo(atributo);
    }
    for(int i = 0; i< elementosHijos.getLength();i++){
        Node nodoTemp = elementosHijos.item(i);
        if(nodoTemp.getNodeType() == Node.ELEMENT_NODE){
            Elemento elementoTemp = new Elemento();
            elementoTemp.cargarElemento((Element)nodoTemp);
            elementoTemp.asignarValor(nodoTemp.getNodeValue());
            insertarElemento(elementoTemp);
        }
    }
}

    /**
     * Carga los elementos de un documento.
     * @param documento El documento donde vienen los elementos.
     */
    @Override
public void cargarElemento(Document documento){
    Element nodoInicial = documento.getDocumentElement();
    atributos.clear();
    elementosHijos.clear();
    nombreElemento = nodoInicial.getNodeName();
    NodeList elementosHijos = nodoInicial.getChildNodes();
        for (int i = 0; i < nodoInicial.getAttributes().getLength(); i++) {
            Attr attribute = (Attr)nodoInicial.getAttributes().item(i);
            Atributo atributo = new Atributo (attribute.getName(), attribute.getValue());
            insertarAtributo(atributo);
        }
        for (int i = 0; i < elementosHijos.getLength(); i++) {
            Node nodoTemp = elementosHijos.item(i);
            if(nodoTemp.getNodeType() == Node.ELEMENT_NODE){
                Elemento elementoTemp = new Elemento ();
                elementoTemp.cargarElemento((Element)nodoTemp);
                elementoTemp.asignarValor(nodoTemp.getNodeValue());
                insertarElemento(elementoTemp);
            }
        }
}

    /**
     * Asigna el nuevo valor al valor del elemento.
     * 
     * @param nuevoValor El nuevo valor del elemento.
     */
    public void asignarValor(String nuevoValor) {
        valor = nuevoValor;
    }

    /**
     * Vuelve los elementos y atributos un Document.
     * @return Devuelve el Document que representa el elemento.
     * @throws Exception Error de conversión de documento
     */
public Document toDocument() throws Exception{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = factory.newDocumentBuilder();
    Document documento = docBuilder.newDocument();
    Element elementoRaiz = documento.createElement(this.nombreElemento);
    elementoRaiz.setTextContent(this.valor);
    for (Iterator iter = atributos.iterator(); iter.hasNext();) {
        Atributo atributo = (Atributo)iter.next();
        Attr attribute = documento.createAttribute(atributo.darNombre());
        attribute.setNodeValue(atributo.darValor());
        elementoRaiz.setAttributeNode(attribute);
    }
    for (Iterator iter = elementosHijos.iterator(); iter.hasNext();) {
        Elemento elemento = (Elemento)iter.next();
        elementoRaiz.appendChild(elemento.toElement(documento));
    }
    documento.appendChild(elementoRaiz);
    return documento;
}

    /**
     * Vuelve el elemento como un Element.
     * @param documento Documento a convertir
     * @return Devuelve el Document que representa el elemento.
     */
    public Element toElement(Document documento) {
        Element element = documento.createElement(this.nombreElemento);
        element.setTextContent(this.valor);
        for(Iterator iter = atributos.iterator(); iter.hasNext(); ) {
            Atributo atributo = (Atributo)iter.next();
            Attr attribute = documento.createAttribute(atributo.darNombre());
            attribute.setNodeValue(atributo.darValor());
            element.setAttributeNode(attribute);
        }
        for(Iterator iter = elementosHijos.iterator(); iter.hasNext(); ) {
            Elemento elemento = (Elemento)iter.next();
            element.appendChild(elemento.toElement(documento));
        }
        return element;
    }

    /**
     * Guarda el modelo en un archivo XML
     * @param xmlPath Ruta del archivo
     * @throws Exception Excepción de error
     */
    public void guardarXml(String xmlPath) throws Exception {
        try {
            Document documento = this.toDocument();
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
     * Devuelve la cadena que se escribiría en el archivo.
     * 
     * @return La cadena que se escribiría en el archivo.
     * @throws Exception En caso de no poder escribirlo como un archivo XML.
     */
    public String darXML() throws Exception {
        Document documento = this.toDocument();
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
     * Genera el Elemento raíz a partir de una cadena
     * @param xml Cadena xml.
     * @throws IOException Se lanza está excepción en caso de no poder leer el xml.
     * @throws SAXException Se lanza está excepción en caso de que halla un error 
     *         en el formato del xml.
     */
public void generarElemento(String xml) throws SAXException, IOException{
    DOMParser parser = new DOMParser();
    parser.parse(new InputSource(new StringReader(xml)));
    Document d = parser.getDocument();
    cargarElemento(d);
}

    /**
     * Devuelve el número de hijos del nodo.
     * @return El número de hijos del nodo.
     */
    @Override
public int darNumeroHijos(){
    return elementosHijos.size() + atributos.size();
}

    /**
     * Devuelve la colección de hijos del nodo.
     * @return La colección de hijos del nodo.
     */
    @Override
public Collection darHijos(){
    Collection<INodo> hijos = new ArrayList<INodo>();
    hijos.addAll(elementosHijos);
    hijos.addAll(atributos);
    return hijos;
}

    /**
     * Inserta un nodo nuevo a un padre.
     * @param hijo Nuevo nodo que se va insertar.
     * @throws InsercionHijoAtributoException Está excepción se lanza en caso de 
     *         querer insertar un nodo a un atributo.
     */
    @Override
public void insertarHijo(INodo hijo) throws InsercionHijoAtributoException{
        if (hijo.darTipo().equals(INodo.ATRIBUTO)) {
            atributos.add((Atributo)hijo);
        }
        else{
            elementosHijos.add((Elemento)hijo);
        }
}

    /**
     * Devuelve el tipo del nodo.
     * @return Tipo de nodo
     */
    @Override
public String darTipo(){
    return INodo.ELEMENTO;
}

    /**
     * Elimina un nodo hijo de él.
     * @param nodo Nodo hijo que se va eliminar.
     */
    @Override
public void eliminarNodo(INodo nodo){
    boolean exitoso = elementosHijos.remove(nodo) || atributos.remove(nodo);
    if(exitoso){
        for (Iterator iter = elementosHijos.iterator(); iter.hasNext();) {
            INodo elemento = (INodo)iter.next();
            elemento.eliminarNodo(nodo);
        }
    }
}

    /**
     * Convierte el nodo en un default muctable tree Node.
     * @return El DefaultMutableTreeNode resultante del elemento.
     */
    @Override
    public DefaultMutableTreeNode toDefaultMutableTreeNode() {
        DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(this);
        for(Iterator iter = atributos.iterator(); iter.hasNext(); ) {
            INodo atributo = ( INodo )iter.next();
            nodo.add(atributo.toDefaultMutableTreeNode());
        }
        for(Iterator iter = elementosHijos.iterator(); iter.hasNext(); ) {
            INodo elemento = (INodo)iter.next();
            nodo.add(elemento.toDefaultMutableTreeNode());
        }
        return nodo;
    }

}
