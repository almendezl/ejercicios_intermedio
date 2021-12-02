/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class YaExisteException extends Exception {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor de la excepción con el código del paciente
     * @param codigo Código del paciente que ya está registrado en la central
     */
    public YaExisteException(int codigo) {
        super("El paciente con código " + codigo + " ya está registrado");
    }

}
