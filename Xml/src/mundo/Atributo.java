/*
 *
 */

package mundo;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.tree.DefaultMutableTreeNode;
import org.w3c.dom.Document;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Atributo implements INodo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Nombre del atributo.
     */
    private String nombre;

    /**
     * Valor del atributo.
     */
    private String valor;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor de la clase atributo.
     * 
     * @param nNombre Nombre de la clase.
     */
    public Atributo(String nNombre) {
        nombre = nNombre;
        valor = "";
    }

    /**
     * Constructor de la clase atributo.
     * @param nNombre Nombre del atributo.
     * @param nValor Valor del atributo.
     */
    public Atributo(String nNombre, String nValor) {
        nombre = nNombre;
        valor = nValor;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Método que convierte el atributo en una cadena.
     */
    @Override
    public String toString() {
        return "Atributo: " + nombre + " = " + valor;
    }

    /**
     * Cambia el valor del atributo.
     * @param nuevoValor El nuevo valor por el que va ser reemplazado.
     */
    public void cambiarValor(String nuevoValor) {
        valor = nuevoValor;
    }

    /**
     * Devuelve el nombre del atributo.
     * @return Devuelve el nombre del atributo.
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Devuelve el valor del atributo.
     * @return El valor del tributo.
     */
    public String darValor() {
        return valor;
    }

    /**
     * Devuelve el número de hijos del nodo.
     * @return El número de hijos del nodo.
     */
    @Override
    public int darNumeroHijos() {
        return 0;
    }

    /**
     * Devuelve la colección de hijos del nodo.
     * @return La colección de hijos del nodo.
     */
    @Override
    public Collection darHijos() {
        return new ArrayList();
    }

    /**
     * Inserta un nodo nuevo a un padre.
     * @param hijo Nuevo nodo que se va insertar.
     * @throws InsercionHijoAtributoException Está excepción se lanza en caso de querer insertar un nodo a un atributo.
     */
    @Override
    public void insertarHijo(INodo hijo) throws InsercionHijoAtributoException {
        throw new InsercionHijoAtributoException("No se puede insertar un hijo a "
                + "un atributo");
    }

    /**
     * Devuelve el tipo del nodo.
     * @return Tipo de nodo
     */
    @Override
    public String darTipo() {
        return INodo.ATRIBUTO;
    }

    @Override
    public void eliminarNodo(INodo nodo) { }

    @Override
    public void cargarElemento(Document d) { }

    @Override
    public Document toDocument() {
        return null;
    }

    /**
     * Convierte el nodo en un default muctable tree Node.
     * @return El DefaultMutableTreeNode resultante del elemento.
     */
    @Override
    public DefaultMutableTreeNode toDefaultMutableTreeNode() {
        return new DefaultMutableTreeNode(this);
    }

}
