/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Collection;
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.Document;

/**
 *
 * @author jorge
 */
public interface INodo {
    /**
     * Constante para representar el tipo Elemento.
     */
    public static final String ELEMENTO = "Elemento";
    /**
     * Constante para representar el tipo Atributo.
     */
    public static final String ATRIBUTO = "Atributo";

    /**
     * Devuelve el tipo del nodo.
     * @return El tipo de nodo
     */
    public String darTipo();
    /**
     * Devuelve el número de hijos del nodo.
     * @return El número de hijos del nodo.
     */
    public int darNumeroHijos();
    /**
     * Devuelve la colección de hijos del nodo.
     * @return La colección de hijos del nodo.
     */
    public Collection darHijos();
    /**
     * Inserta un nodo nuevo a un padre.
     * @param hijo Nuevo nodo que se va insertar.
     * @throws InsercionHijoAtributoException Está excepción se lanza en caso de querer insertar un nodo a un atributo.
     */
    public void insertarHijo(INodo hijo) throws InsercionHijoAtributoException;

    /**
     * Elimina un nodo hijo de él.
     * @param nodo Nodo hijo que se va eliminar.
     */
    public void eliminarNodo(INodo nodo);
    /**
     * Carga el elemento de un Documento.
     * @param d Documento del que se carga un elemento.
     */
    public void cargarElemento(Document d);
    /**
     * Un elemento se vuelve document.
     * @return El document representante del nodo.
     * @throws java.lang.Exception Excepcion de error
     */
    public Document toDocument() throws Exception;
    /**
     * Convierte el nodo en un default muctable tree Node.
     * @return El DefaultMutableTreeNode resultante del elemento.
     */
    public DefaultMutableTreeNode toDefaultMutableTreeNode();
    
}
