/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class NoExisteException extends Exception {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor de la excepción con el código del paciente
     * @param codigo Código del paciente que no está registrado en la central
     */
    public NoExisteException(int codigo) {
        super("El paciente con código " + codigo + " no está registrado");
    }

}
