/*
 *
 */

package mundo;

import java.text.DecimalFormat;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Cita {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * La hora a la que está programada la cita. <br>
     * La hora se representa con un entero que incluye la hora y los minutos 
     * iniciales de la cita. <br>
     * Ej: 830 es 8:30 am, 1405 es 2:05 pm
     */
    private int hora;

    /**
     * La duración en minutos de la cita
     */
    private int duracion;

    /**
     * La descripción de la cita
     */
    private String descripcion;

    /**
     * Indica la prioridad de la cita
     */
    private int prioridad;

    /**
     * Es una referencia a la siguiente cita del día
     */
    private Cita siguienteCita;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye una nueva cita a una hora específica
     * @param descripcionC La descripción de la cita - descripcionC!=null
     * @param horaC La hora a la que se programó la cita
     * @param duracionC Es la duración (en minutos) que tendrá la cita
     * @param prioridadC Es la prioridad de la cita - prioridadC pertenece a {1,3,5,7,9}
     */
    public Cita( String descripcionC, int horaC, int duracionC, int prioridadC ) {
        hora = horaC;
        descripcion = descripcionC;
        duracion = duracionC;
        prioridad = prioridadC;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cambia la cita siguiente por sig
     * @param sig Es la cita que ahora será la siguiente
     */
    public void cambiarSiguiente( Cita sig ) {
        siguienteCita = sig;
    }

    /**
     * Desconecta la cita que le sigue en la lista a la cita actual. <br>
     * <b>pre: </b> No es la última cita de la lista <br>
     * <b>post: </b> La cita siguiente a la actual fue desconectada de la lista.
     */
    public void desconectarSiguiente( ) {
        siguienteCita = siguienteCita.siguienteCita;
    }

    /**
     * Retorna la cita siguiente del día
     * @return Se retornó la cita siguiente del día
     */
    public Cita darSiguiente( ) {
        return siguienteCita;
    }

    /**
     * Retorna la hora de la cita
     * @return Se retornó la hora de la cita
     */
    public int darHora( ) {
        return hora;
    }

    /**
     * Retorna la duración de la cita
     * @return Se retornó la duración
     */
    public int darDuracion( ) {
        return duracion;
    }

    /**
     * Retorna la descripción de la cita
     * @return Se retornó la descripción
     */
    public String darDescripcion( ) {
        return descripcion;
    }

    /**
     * Retorna la prioridad de la cita
     * @return Se retornó la prioridad
     */
    public int darPrioridad( ) {
        return prioridad;
    }

    /**
     * Este método sirve para calcular la hora a la cual va a terminar la cita
     * @return Se retornó la hora a la que termina la cita
     */
    public int calcularHoraFin( ) {
        int horaFin = hora;
        int tempDuracion = duracion;
        while( tempDuracion >= 60 ) {
            horaFin += 100;
            tempDuracion -= 60;
        }
        int temp = ( horaFin % 100 ) + tempDuracion;
        if( temp >= 60 ) {
            horaFin += 100;
            horaFin += ( temp - 60 );
        }
        else {
            horaFin += tempDuracion;
        }
        return horaFin;
    }

    /**
     * Inserta la cita después de la actual. <br>
     * <b>post: </b> Se insertó la cita especificada después de la cita actual. <br>
     * @param cita La cita a insertar - cita!=null
     */
    public void insertarDespues( Cita cita ) {
        cita.siguienteCita = siguienteCita;
        siguienteCita = cita;
    }

    /**
     * Retorna una cadena que representa una cita
     * @return Se retornó la cadena que presenta la cita
     */
    @Override
    public String toString( ) {
        DecimalFormat df = new DecimalFormat( "00" );
        int horaFin = calcularHoraFin( );
        String strHora = df.format( hora / 100 ) + ":" + df.format( hora % 100 );
        String strHoraFin = df.format(horaFin / 100) + ":" + df.format(horaFin % 100);
        String strDescripcion = ( descripcion.length( ) > 40 ) ? 
                descripcion.substring( 0, 40 ) + "..." : descripcion;
        String cadena = strHora + " - " + strHoraFin + ": " + strDescripcion;
        return cadena;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> Dia.PRIMERA_HORA <= hora <= Dia.ULTIMA_HORA y 0 <= hora % 100 < 60<br>
     * Dia.PRIMERA_HORA <= hora + duracion <= Dia.ULTIMA_HORA y 0 <= hora % 100 < 60<br>
     * duracion >= 0<br>
     * descripcion != null<br>
     * prioridad pertence a {1,3,5,7,9}<br>
     */
    private void verificarInvariante( ) {
        assert ( descripcion != null ) : "La descripción de una cita no debe ser null";
        assert ( prioridad == 1 || prioridad == 3 || prioridad == 5 || prioridad == 7 
                || prioridad == 9 ) : "La prioridad debe pertenecer a {1,3,5,7,9}";
        assert ( Dia.PRIMERA_HORA <= hora && hora <= Dia.ULTIMA_HORA ) : 
                "La hora debe estar entre la PRIMERA_HORA y la ULTIMA_HORA";
        assert ( duracion >= 0 ) : "La duración debe ser un número positivo";
        assert ( verificarInvarianteDuracionCita( ) ) : "La cita llega más allá "
                + "de la ULTIMA_HORA";
    }

    /**
     * Verifica que la cita no termine después de la ULTIMA_HORA
     * @return Se retornó true si la cita tiene hora de inicio y duración válidas
     */
    private boolean verificarInvarianteDuracionCita( ) {
        int horaCita = hora;
        int duracionTemp = duracion;
        while( duracionTemp / 60 > 0 ) {
            horaCita += 60;
            duracionTemp /= 60;
        }
        boolean citaOk = horaCita + duracionTemp < Dia.ULTIMA_HORA;
        return citaOk;
    }

}
