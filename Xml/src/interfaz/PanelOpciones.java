/*
 *
 */

package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelOpciones extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que va identificar la acción cargar.
     */
    private static final String CARGAR = "Cargar";

    /**
     * Constante que va identificar la acción guardar.
     */
    private static final String GUARDAR = "Guardar";

    /**
     * Constante que va identificar la acción Insertar un elemento.
     */
    private static final String NUEVO_ELEMENTO = "Nuevo Elemento";

    /**
     * Constante que va identificar la acción Insertar un atributo.
     */
    private static final String NUEVO_ATRIBUTO = "Nuevo Atributo";

    /**
     * Constante que va identificar la acción eliminar.
     */
    private static final String ELIMINAR = "Eliminar";

    /**
     * Constante que va identificar la acción eliminar.
     */
    private static final String GENERAR_ARBOL = "Generar Arbol";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazEditorXML principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el botón para cargar una colección de un xml
     */
    private JButton botonCargar;

    /**
     * Es el botón para salvar una colección en un xml
     */
    private JButton botonGuardar;

    /**
     * Botón para crear un nuevo nodo.
     */
    private JButton botonNuevoElemento;

    /**
     * Botón para crear un nuevo atributo.
     */
    private JButton botonNuevoAtributo;

    /**
     * Botón para eliminar un nodo.
     */
    private JButton botonEliminarNodo;

    /**
     * Botón para tomar un texto y generar un árbol.
     */
    private JButton botonGenerarArbol;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes
     * @param ip Es una referencia a la clase principal de la interfaz
     */
    public PanelOpciones(InterfazEditorXML ip) {
        principal = ip;
        setBorder(new TitledBorder(""));
        botonCargar = new JButton(CARGAR);
        botonCargar.setActionCommand( CARGAR );
        botonCargar.addActionListener( this );
        add( botonCargar );
        botonGuardar = new JButton( GUARDAR );
        botonGuardar.setActionCommand( GUARDAR );
        botonGuardar.addActionListener( this );
        add( botonGuardar );
        botonNuevoElemento = new JButton( NUEVO_ELEMENTO );
        botonNuevoElemento.setActionCommand( NUEVO_ELEMENTO );
        botonNuevoElemento.addActionListener( this );
        add( botonNuevoElemento );
        botonNuevoAtributo = new JButton( NUEVO_ATRIBUTO );
        botonNuevoAtributo.setActionCommand( NUEVO_ATRIBUTO );
        botonNuevoAtributo.addActionListener( this );
        add( botonNuevoAtributo );
        botonEliminarNodo = new JButton( ELIMINAR );
        botonEliminarNodo.setActionCommand( ELIMINAR );
        botonEliminarNodo.addActionListener( this );
        add( botonEliminarNodo );
        botonGenerarArbol = new JButton( GENERAR_ARBOL );
        botonGenerarArbol.setActionCommand( GENERAR_ARBOL );
        botonGenerarArbol.addActionListener( this );
        add( botonGenerarArbol );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Es el método que se llama cuando se hace click sobre un botón
     * @param evento Es el evento del click sobre un botón- evento!=null
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();
        if(CARGAR.equals(comando)) {
            principal.cargarArbol();
        }
        if(GUARDAR.equals(comando)) {
            principal.guardar();
        }
        if(NUEVO_ELEMENTO.equals(comando)) {
            if(principal.darPathSeleccionado() == null) {
                (new DialogoNuevoElemento(principal)).setVisible(true);
            }
            else {
                if(principal.darPathSeleccionado().getLastPathComponent().
                        toString().startsWith("Elemento")) {
                    (new DialogoNuevoElemento(principal)).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(principal, "No se puede insertar "
                            + "un elemento a un atributo", "Error", 
                            JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        if(NUEVO_ATRIBUTO.equals(comando)) {
            if(principal.darPathSeleccionado() == null) {
                JOptionPane.showMessageDialog(principal, "Debe seleccionar un "
                        + "elemento para insertar un Elemento", "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(principal.darPathSeleccionado().getLastPathComponent().
                        toString().startsWith("Elemento")) {
                    (new DialogoNuevoAtributo(principal)).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(principal, "No se puede insertar "
                            + "un elemento a un atributo", "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(ELIMINAR.equals(comando)) {
            principal.eliminarElemento();
        }
        if(GENERAR_ARBOL.equals(comando)) {
            principal.cargarElementoAreaTexto();
        }
    }

}
