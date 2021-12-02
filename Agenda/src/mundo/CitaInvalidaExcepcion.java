/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class CitaInvalidaExcepcion extends Exception {
    /**
     * Construye la excepción
     * @param hora La hora de la cita que tiene un problema
     * @param duracion La duración de la cita que tiene un problema
     */
    public CitaInvalidaExcepcion( int hora, int duracion ) {
        super("No se puede agregar una cita a las " + hora + " de " + duracion + 
                " minutos");
    }

}
