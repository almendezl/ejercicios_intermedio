/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelArbol extends JPanel {
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * La interfaz principal.
     */
    private InterfazEditorXML principal;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Árbol a visualizar
     */
    private JTree arbol;

    /**
     * Scroll Pane donde va estar el árbol.
     */
    private JScrollPane pnlArbol;

    /**
     * Modelo del árbol.
     */
    private DefaultTreeModel modeloArbol;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Constructor.
     * @param principal Instancia de la ventana principal
     */
    public PanelArbol(InterfazEditorXML principal) {
        this.principal = principal;
        this.setLayout(new BorderLayout());
        EmptyBorder eb = new EmptyBorder(5, 5, 5, 5);
        BevelBorder bb = new BevelBorder(BevelBorder.LOWERED);
        CompoundBorder cb = new CompoundBorder(eb, bb);
        this.setBorder(new CompoundBorder(cb, eb));
        // Inicialización del Scroll Pane
        pnlArbol = new JScrollPane();
        this.add(pnlArbol, BorderLayout.CENTER );
        // Inicialización del árbol
        DefaultMutableTreeNode nodoInicial = new DefaultMutableTreeNode(
                this.principal.darElementoRaiz());
        arbol = new JTree(nodoInicial);
        pnlArbol.setViewportView(arbol);
        arbol.setEditable(true);
        arbol.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        arbol.setShowsRootHandles(true);
        arbol.getModel().addTreeModelListener(new ArbolListener());
        modeloArbol = (DefaultTreeModel)arbol.getModel();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Devuelve el path del elemento seleccionado.
     * @return El path del elemento seleccionado.
     */
    public TreePath darPathSelccionado() {
        return arbol.getSelectionPath();
    }

    /**
     * Actualiza el modelo del árbol a visualizar
     * 
     * @param elemento Elemento que raiz que se va insertar en el árbol.
     */
    public void actualizar(DefaultMutableTreeNode elemento) {
        modeloArbol.setRoot(elemento);
    }

    /**
     * Se inserta un nuevo nodo en la interfaz.
     * @param padre Padre del elemento que se va insertar.
     * @param elemento Elemento que se va insertar.
     */
    public void insertarElemento(DefaultMutableTreeNode padre, 
            DefaultMutableTreeNode elemento) {
        if(padre.getChildCount() != 0) {
            modeloArbol.insertNodeInto(elemento, padre, padre.getChildCount() - 1);
        }
        else {
            modeloArbol.insertNodeInto(elemento, padre, 0);
        }
    }

    /**
     * Se inserta un nuevo nodo en la interfaz.
     * @param padre Padre del elemento que se va insertar.
     * @param atributo Atributo que se va insertar.
     */
    public void insertarAtributo(DefaultMutableTreeNode padre, 
            DefaultMutableTreeNode atributo) {
        modeloArbol.insertNodeInto(atributo, padre, padre.getChildCount() - 1);
    }

    /**
     * Método para eliminar un nodo.
     * @param elemento elemento que se va eliminar.
     */
    public void eliminarElemento(DefaultMutableTreeNode elemento) {
        if(elemento.getParent() != null) {
            modeloArbol.removeNodeFromParent(elemento);
        }
    }

    /**
     * Devuelve el elemento raiz del modelo.
     * @return El TreeNode raiz del modelo del árbol.
     */
    public DefaultMutableTreeNode darNodoRaiz() {
        return (DefaultMutableTreeNode)modeloArbol.getRoot();
    }

}
