/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import mundo.Documento;
import mundo.INodo;
import mundo.InsercionHijoAtributoException;
import org.xml.sax.SAXException;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class InterfazEditorXML extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Clase principal del mundo.
     */
    private Documento documento;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Panel con las extensiones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel donde va estar el árbol.
     */
    private PanelArbol panelArbol;

    /**
     * Panel donde se va ver la previsualización del archivo.
     */
    private PanelPrevisualizacionXML panelPrevisualizador;

    /**
     * Panel donde va ir la imágen de cupi2XML.
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Descripción <br>
     * <b>post: </b> Descripción
     */
    public InterfazEditorXML() {
        // Crea la clase principal
        documento = new Documento();
        // Construye la forma
        getContentPane().setLayout(new BorderLayout());
        panelImagen = new PanelImagen();
        this.add(panelImagen, BorderLayout.NORTH);
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(2, 1));
        this.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelArbol = new PanelArbol(this);
        panelCentral.add(panelArbol);
        panelPrevisualizador = new PanelPrevisualizacionXML(this);
        panelCentral.add(panelPrevisualizador);
        setSize(650, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Editor XML - Principal");
        // Creación de los paneles aquí
        panelOpciones = new PanelOpciones(this);
        getContentPane().add(panelOpciones, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Inserta un elemento dentro del elemento.
     * @param nombreElemento Nombre del elemento que se va insertar.
     * @throws InsercionHijoAtributoException Error al ingresar nodo
     */
    public void insertarElemento(String nombreElemento) throws 
            InsercionHijoAtributoException {
        INodo nuevoElemento = documento.crearElemento(nombreElemento);
        DefaultMutableTreeNode elementoSeleccionado = null;
        TreePath rutaArbol = panelArbol.darPathSelccionado();
        boolean seleccionAtributo = false;
        if(rutaArbol == null) {
            elementoSeleccionado = panelArbol.darNodoRaiz();
        }
        else {
            try {
                elementoSeleccionado = (DefaultMutableTreeNode)rutaArbol.
                        getLastPathComponent();
            }
            catch(Exception e) {
                e.printStackTrace();
                seleccionAtributo = true;
            }
        }
        if(!seleccionAtributo) {
            if(elementoSeleccionado == null) {
                documento.asignarElementoRaiz(nombreElemento);
                panelArbol.actualizar(documento.darElementoRaiz().
                        toDefaultMutableTreeNode());
                panelPrevisualizador.actualizar();
            }
            else if(elementoSeleccionado.getUserObject() == null) {
                documento.asignarElementoRaiz(nombreElemento);
                panelArbol.actualizar(documento.darElementoRaiz().
                        toDefaultMutableTreeNode());
                panelPrevisualizador.actualizar();
            }
            else {
                INodo nodo = (INodo)elementoSeleccionado.getUserObject();
                nodo.insertarHijo(nuevoElemento);
                panelArbol.insertarElemento(elementoSeleccionado, 
                        new DefaultMutableTreeNode(nuevoElemento));
                panelPrevisualizador.actualizar();
            }
        }
    }

    /**
     * Inserta un elemento dentro del elemento.
     * @param nombreElemento Nombre del elemento que se va insertar.
     * @param valorElemento Valor del elemento que se va insertar.
     * @throws InsercionHijoAtributoException Error al ingresar un nodo
     */
    public void insertarElemento(String nombreElemento, String valorElemento) 
            throws InsercionHijoAtributoException {
        INodo nuevoElemento = documento.crearElemento(nombreElemento, valorElemento);
        DefaultMutableTreeNode elementoSeleccionado = null;
        TreePath rutaArbol = panelArbol.darPathSelccionado();
        boolean seleccionAtributo = false;
        if(rutaArbol == null) {
            elementoSeleccionado = panelArbol.darNodoRaiz();
        }
        else {
            try {
                elementoSeleccionado = (DefaultMutableTreeNode)rutaArbol.
                        getLastPathComponent();
            }
            catch(Exception e) {
                e.printStackTrace();
                seleccionAtributo = true;
            }
        }
        if(!seleccionAtributo) {
            if(elementoSeleccionado == null) {
                documento.asignarElementoRaiz(nombreElemento, valorElemento);
                panelArbol.actualizar(documento.darElementoRaiz().
                        toDefaultMutableTreeNode());
                panelPrevisualizador.actualizar();
            }
            else if(elementoSeleccionado.getUserObject() == null) {
                documento.asignarElementoRaiz(nombreElemento, valorElemento);
                panelArbol.actualizar( documento.darElementoRaiz().
                        toDefaultMutableTreeNode());
                panelPrevisualizador.actualizar();
            }
            else {
                INodo nodo = (INodo)elementoSeleccionado.getUserObject();
                nodo.insertarHijo(nuevoElemento);
                panelArbol.insertarElemento(elementoSeleccionado, 
                        new DefaultMutableTreeNode(nuevoElemento));
                panelPrevisualizador.actualizar();
            }
        }
    }

    /**
     * Inserta un atributo dentro del elemento.
     * @param nombreAtributo Nombre del atributo que se va insertar.
     * @param valorAtributo Valor del atributo que se va insertar.
     * @throws InsercionHijoAtributoException Se lanza está excepción cuando se 
     *         va insertar un atributo dentro de otro atributo.
     */
    public void insertarAtributo(String nombreAtributo, String valorAtributo) 
            throws InsercionHijoAtributoException {
        INodo nuevoElemento = documento.crearAtributo(nombreAtributo, valorAtributo);
        DefaultMutableTreeNode elementoSeleccionado = null;
        TreePath rutaArbol = panelArbol.darPathSelccionado();
        boolean seleccionAtributo = false;
        if(rutaArbol == null) {
            elementoSeleccionado = panelArbol.darNodoRaiz();
        }
        else {
            try {
                elementoSeleccionado = (DefaultMutableTreeNode)rutaArbol.
                        getLastPathComponent();
            }
            catch(Exception e) {
                e.printStackTrace();
                seleccionAtributo = true;
            }
        }
        if(!seleccionAtributo) {
            if(elementoSeleccionado.getUserObject() == null) {
                JOptionPane.showMessageDialog(this, "No se puede tener un atributo "
                        + "como nodo inicial de un elemento", "Respuesta", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else if(elementoSeleccionado.getUserObject() == null) {
                JOptionPane.showMessageDialog( this, "No se puede tener un atributo "
                        + "como nodo inicial de un elemento", "Respuesta", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                INodo nodo = (INodo)elementoSeleccionado.getUserObject();
                nodo.insertarHijo(nuevoElemento);
                panelArbol.insertarElemento(elementoSeleccionado, 
                        new DefaultMutableTreeNode(nuevoElemento));
                panelPrevisualizador.actualizar();
            }
        }
    }

    /**
     * Elimina el elemento seleccionado.
     */
    public void eliminarElemento() {
        TreePath rutaArbol = panelArbol.darPathSelccionado();
        try {
            if(rutaArbol == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el nodo que "
                        + "quiere eliminar", "Respuesta", JOptionPane.ERROR_MESSAGE);
            }
            else {
                DefaultMutableTreeNode nodoEliminar = (DefaultMutableTreeNode)
                        rutaArbol.getLastPathComponent();
                if(rutaArbol.getParentPath( ) == null) {
                    documento.asignarElementoRaiz(null);
                    if(documento.darElementoRaiz() != null) {
                        panelArbol.actualizar(documento.darElementoRaiz().
                                toDefaultMutableTreeNode());
                    }
                    else {
                        panelArbol.actualizar(null);
                    }
                }
                else {
                    panelArbol.eliminarElemento(nodoEliminar);
                    DefaultMutableTreeNode padre = (DefaultMutableTreeNode)
                            rutaArbol.getParentPath().getLastPathComponent();
                    documento.eliminarNodo((INodo)padre.getUserObject());
                }
                panelPrevisualizador.actualizar();
            }
        }
        catch(ClassCastException e) {
            JOptionPane.showMessageDialog(this, "No se puede eliminar ese elemento", 
                    "Respuesta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Devuelve el elemento raíz del árbol.
     * @return El elemento raíz del arbol.
     */
    public INodo darElementoRaiz() {
        return documento.darElementoRaiz();
    }

    /**
     * Abre la ventana para escoger el archivo y lo carga.
     */
    public void cargarArbol() {
        try {
            // Seleccionar el archivo
            JFileChooser fc = new JFileChooser("./data/");
            fc.setDialogTitle("Seleccionar XML a desplegar");
            int resultado = fc.showOpenDialog(this);
            if(resultado == JFileChooser.APPROVE_OPTION) {
                File seleccionado = fc.getSelectedFile();
                // Se crea el modelo
                documento.cargarXml(seleccionado.getAbsolutePath());
                panelArbol.actualizar(documento.darElementoRaiz().
                        toDefaultMutableTreeNode());
                panelPrevisualizador.actualizar();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error", "Error al cargar el archivo " + 
                    e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Salva el modelo desplegado en un archivo Xml
     */
    public void guardar() {
        try {
            if(documento.darElementoRaiz() != null) {
                JFileChooser fc = new JFileChooser("./data/");
                fc.setDialogTitle("Guardar como... ");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setMultiSelectionEnabled(false);
                boolean termine = false;
                int resultado = fc.showSaveDialog(this);
                while(!termine) {
                    if(resultado == JFileChooser.APPROVE_OPTION) {
                        File archivo = fc.getSelectedFile();
                        int respuesta = JOptionPane.YES_OPTION;
                        // Si el archivo ya existe hay que pedir confirmación
                        // para sobreescribirlo
                        if(archivo.exists()) {
                            respuesta = JOptionPane.showConfirmDialog(this, 
                                    "Desea sobreescribir el archivo seleccionado?", 
                                    "Sobreescribir", JOptionPane.YES_NO_OPTION, 
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        // Si la respuesta fue positiva (o si no fue necesario
                        // hacer la
                        // pregunta) se graba el archivo
                        if(respuesta == JOptionPane.YES_OPTION) {
                            try {
                                documento.guardarXml(archivo.getPath());
                                termine = true;
                            }
                            catch(IOException e) {
                                JOptionPane.showMessageDialog(this, "Hubo problemas "
                                        + "guardando el archivo:\n" + e.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            resultado = fc.showSaveDialog(this);
                        }
                    }
                    else {
                        termine = true;
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(this, "No hay información para guardar ", 
                        "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Devuelve el Nodo que está seleccionado.
     * @return El nodo que está seleccionado.
     */
    public TreePath darPathSeleccionado() {
        return panelArbol.darPathSelccionado();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1() {
        String resultado = documento.metodo1();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2() {
        String resultado = documento.metodo2();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Devuelve la cadena que representa el archivo XML que se escribiría.
     * @return La cadena XML que se escribiría en el archivo.
     * @throws Exception Se lanza está excepción en caso que no se pueda pasar a un String.
     */
    public String darCadenaXML() throws Exception {
        return documento.darXML();
    }

    /**
     * Carga el elemento que está descrito en el xml.
     */
    public void cargarElementoAreaTexto() {
        try {
            String cadenaXML = panelPrevisualizador.darTexto();
            documento.generarElemento(cadenaXML);
            panelArbol.actualizar(documento.darElementoRaiz().
                    toDefaultMutableTreeNode());
            panelPrevisualizador.actualizar();
        }
        catch(SAXException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de xml", 
                    "Respuesta", JOptionPane.ERROR_MESSAGE);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la codificación", 
                    "Respuesta", JOptionPane.ERROR_MESSAGE);
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Conjunto de argumentos vacio para ejecutar aplicación
     */
    public static void main(String[] args) {
        InterfazEditorXML ventana = new InterfazEditorXML();
        ventana.setVisible(true);
    }

}
