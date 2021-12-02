/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class InsercionHijoAtributoException extends Exception {
    /**
     * Constructor
     * @param mensaje Mensaje para encapsular por un error
     */
    public InsercionHijoAtributoException(String mensaje) {
        super( "No se le puede insertar un hijo a un Atributo." );
    }

}
