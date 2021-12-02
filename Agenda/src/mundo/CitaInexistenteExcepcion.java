/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class CitaInexistenteExcepcion extends Exception {
    /**
     * Construye la excepción
     */
    public CitaInexistenteExcepcion( ) {
        super( "No se encontró la cita buscada" );
    }

}
