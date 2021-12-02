/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class FormatoInvalidoExcepcion extends Exception {
    /**
     * Construye la excepción
     * @param linea La línea que no cumple el formato especificado
     */
    public FormatoInvalidoExcepcion( String linea ) {
        super( "Error en el formato del archivo en la línea: \n" + linea );
    }

}
