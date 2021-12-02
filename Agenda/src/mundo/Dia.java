/*
 *
 */

package mundo;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Dia {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es la hora más temprana a la que se van a aceptar citas
     */
    public static final int PRIMERA_HORA = 800;

    /**
     * Es la hora más tarde a la que se van a aceptar citas
     */
    public static final int ULTIMA_HORA = 1859;

    /**
     * Es la fecha a la que corresponde este día
     */
    private Date fecha;

    /**
     * Es la primera cita del día
     */
    private Cita primeraCita;

    /**
     * Es una referencia al día siguiente
     */
    private Dia siguiente;

    /**
     * Es una referencia al día anterior
     */
    private Dia anterior;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea un nuevo día sin citas
     * @param fechaDia La fecha del día creado - fechaDia!=null
     */
    public Dia( Date fechaDia ) {
        fecha = fechaDia;
        primeraCita = null;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Guarda las citas del día en el archivo
     * @param out El stream donde se debe guardar la información
     */
    public void guardarDia(PrintWriter out) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Cita citaTemp = primeraCita;
        while(citaTemp != null) {
            String strFecha = sdf.format(fecha);
            out.println("BEGIN:VEVENT");
            out.print("DTSTART:" + strFecha + "T");
            if(citaTemp.darHora() < 1000)
                out.print("0");
            out.println(citaTemp.darHora() + "00Z");
            out.println("DURATION:" + "P" + citaTemp.darDuracion() + "M");
            out.println("SUMMARY:" + citaTemp.darDescripcion().replaceAll("\n", "*"));
            out.println("PRIORITY:" + citaTemp.darPrioridad());
            out.println("END:VEVENT");
            citaTemp = citaTemp.darSiguiente();
        }
    }

    /**
     * Este método sirve para saber si una hora está libre para una cita de una 
     * determinada duración
     * @param hora La hora a la que debería empezar la cita Dia.
     * @param duracion La duración en minutos de la cita
     * @return Se retornó true si hay espacio para acomodar una cita de la 
     *         duración indicada en la hora indicada
     */
    public boolean estaHoraLibre( int hora, int duracion ) {
        boolean estaLibre = false;
        // No hay citas en el día
        if( primeraCita == null )
            estaLibre = true;
        // La primera cita no se cruza con el horario buscado
        else if( primeraCita.darHora( ) > calcularHoraFin( hora, duracion ) )
            estaLibre = true;
        else {
            Cita citaTemp = primeraCita;
            Cita citaTemp2 = citaTemp.darSiguiente( );
            boolean termine = false;
            while( !termine ) {
                // citaTemp2 es anterior al horario buscado
                if( citaTemp2 != null && citaTemp2.darHora( ) < hora ) {
                    citaTemp = citaTemp2;
                    citaTemp2 = citaTemp.darSiguiente( );
                }
                // citaTemp2 es posterior al horario buscado: hay que verificar si el horario buscado está libre
                // entre citaTemp y citaTemp2
                else if( citaTemp2 != null && citaTemp2.darHora( ) > hora ) {
                    if(calcularHoraFin(citaTemp.darHora(), citaTemp.darDuracion()) < 
                            hora && calcularHoraFin(hora, duracion) < 
                            citaTemp2.darHora()) {
                        estaLibre = true;
                    }
                    else {
                        estaLibre = false;
                    }
                    termine = true;
                }
                // Si la hora es igual a la de citaTemp2, la hora se encuentra ocupada
                else if( citaTemp2 != null && citaTemp2.darHora( ) == hora ) {
                    estaLibre = false;
                    termine = true;
                }
                // citaTemp es la última cita: hay que verificar si no se cruza 
                // con el horario buscado
                else if( citaTemp2 == null ) {
                    if(calcularHoraFin(citaTemp.darHora(), citaTemp.darDuracion()) < hora) {
                        estaLibre = true;
                    }
                    else {
                        estaLibre = false;
                    }
                    termine = true;
                }
            }
        }
        return estaLibre;
    }

    /**
     * Este método sirve para calcular la hora a la cual va a terminar la cita
     * @param hora La hora a la que inicia la cita
     * @param duracion La duración de la cita
     * @return Se retornó la hora a la que termina la cita
     */
    public int calcularHoraFin( int hora, int duracion ) {
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
     * Agrega una nueva cita en la posición que le corresponde según la hora
     * @param nuevaCita La nueva cita que se va a agregar
     * @throws CitaInvalidaExcepcion Se lanza esta excepción si esta cita no 
     *         se puede poner en este día porque se cruza con otra cita
     */

public void agregarCita( Cita nuevaCita) throws CitaInvalidaExcepcion{
    int hora = nuevaCita.darHora();
    int duracion = nuevaCita.darDuracion();
    if(!estaHoraLibre(hora, duracion))
        throw new CitaInvalidaExcepcion(hora, duracion);
    if(primeraCita == null){
        primeraCita = nuevaCita;
    }
    else if(primeraCita.darHora()>0){
        nuevaCita.cambiarSiguiente(primeraCita);
        primeraCita = nuevaCita;
    }
    else{
        Cita citaAnterior = primeraCita;
        Cita citaActual = citaAnterior.darSiguiente();
        while( citaActual != null && citaActual.darHora() < hora){
            citaAnterior = citaActual;
            citaActual = citaAnterior.darSiguiente();
        }
        citaAnterior.insertarDespues(nuevaCita);
    }
    verificarInvariante();
}
    /**
     * Elimina una cita del día dada su hora <br>
     * <b>post: </b>Se eliminó la cita que estaba programada para la hora indicada
     * @param horaCita La hora de la cita que se va a eliminar
     * @throws CitaInexistenteExcepcion Se lanza esta excepción si no se encontró la cita que se iba a eliminar
     */
public void eliminarCita(int horaCita) throws CitaInexistenteExcepcion{
    if(primeraCita == null){
        throw new CitaInexistenteExcepcion();
    }
    else if(primeraCita.darHora() == horaCita){
        primeraCita = primeraCita.darSiguiente();
    }
    else{
        Cita anterior = localizarAnterior(horaCita);
        if(anterior == null)
            throw new CitaInexistenteExcepcion();
        anterior.desconectarSiguiente();
    }
    verificarInvariante();
}

    /**
     * Busca la cita anterior a la cita con la hora especificada
     * @param hora La hora de la cita de la que se desea la cita anterior
     * @return Se retornó la cita anterior a la cita de la hora dada o null si no existe una cita con la hora especificada o si es la primero de la lista
     */
private Cita localizarAnterior(int hora){
    Cita anterior = null;
    Cita actual = primeraCita;
    while(actual != null && actual.darHora() != hora){
        anterior = actual;
        actual = actual.darSiguiente();
    }
    return actual != null ?anterior:null;
}

    /**
     * Retorna una lista con las citas del día
     * @return Se retornó la lista de citas
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ArrayList darCitas( ) {
        ArrayList citas = new ArrayList( );
        Cita citaTemp = primeraCita;
        while( citaTemp != null ) {
            citas.add( citaTemp );
            citaTemp = citaTemp.darSiguiente( );
        }
        return citas;
    }

    /**
     * Cuenta el número de citas que hay en el día
     * @return Se retornó el número de citas
     */
    public int contarCitas( ) {
        int numeroCitas = 0;
        Cita citaTemp = primeraCita;
        while( citaTemp != null ) {
            numeroCitas++;
            citaTemp = citaTemp.darSiguiente( );
        }
        return numeroCitas;
    }

    /**
     * Retorna la fecha a la que corresponde este día
     * @return Se retorno la fecha a la que corresponde el día
     */
    public Date darFecha( ) {
        return fecha;
    }

    /**
     * Compara dos días usando sus fechas
     * @param d2 El día con el que se está comparando - d2 != null
     * @return Retorna 0 si las fechas de los días son iguales <br>
     *         Retorna un número mayor a 0 si d2 corresponde a un día anterior. <br>
     *         Retorna un número menor a 0 en caso contrario.
     */
    public int compararPorFecha( Dia d2 ) {
        int resultado = 0;
        // Eliminar la parte de la hora de los objetos Date que llegan como parámetro
        SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy" );
        String strFecha1 = sdf.format( fecha );
        String strFecha2 = sdf.format( d2.fecha );
        // Si las dos cadenas son iguales se sabe ya que las fechas representan el mismo día
        if( strFecha1.equals( strFecha2 ) ) {
            resultado = 0;
        }
        // Si las cadenas no son iguales entonces se usa el método compareTo de la clase Date
        else {
            try {
                Date fechaTemp1 = sdf.parse( strFecha1 );
                Date fechaTemp2 = sdf.parse( strFecha2 );
                resultado = fechaTemp1.compareTo( fechaTemp2 );
            }
            catch( ParseException e ) { }
        }
        return resultado;
    }

    /**
     * Cambia el día siguiente por sig
     * @param sig Es el día que ahora será el siguiente
     */
    public void cambiarSiguiente( Dia sig ) {
        siguiente = sig;
    }

    /**
     * Retorna el siguiente día
     * @return Se retornó el día siguiente
     */
    public Dia darSiguiente( ) {
        return siguiente;
    }

    /**
     * Cambia el día anterior por ant
     * @param ant Es el día que ahora será el anterior
     */
    public void cambiarAnterior( Dia ant ) {
        anterior = ant;
    }

    /**
     * Retorna el día anterior
     * @return Se retornó el día anterior
     */
    public Dia darAnterior( ) {
        return anterior;
    }

    /**
     * Inserta el día después del actual. <br>
     * <b>post: </b> Se insertó el día especificado después del día actual. <br>
     * @param dia El dia a insertar - dia!=null
     */
    public void insertarDespues( Dia dia ) {
        dia.siguiente = siguiente;
        if( siguiente != null )
            siguiente.anterior = dia;
        dia.anterior = this;
        siguiente = dia;
        verificarInvariante( );
    }

    /**
     * Inserta el día antes del actual. <br>
     * <b>post: </b> Se insertó el día especificado después del día actual. <br>
     * @param dia El dia a insertar - dia!=null
     */
    public void insertarAntes( Dia dia ) {
        if( anterior != null )
            anterior.siguiente = dia;
        dia.anterior = anterior;
        dia.siguiente = this;
        anterior = dia;
        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv: </b> <br>
     * Las citas están organizadas por hora<br>
     * No hay citas que se crucen<br>
     */
    private void verificarInvariante( ) {
        assert ( verificarOrdenCitas( ) ) : "Las citas no están bien organizadas";
        assert ( verificarCrucesCitas( ) ) : "Las citas no están bien separadas";
    }

    /**
     * Este método sirve para verificar que las citas no se crucen
     * @return Se retornó true si no hay citas que se crucen o false en caso contrario
     */
    private boolean verificarCrucesCitas( ) {
        boolean bienOrganizadas = true;
        if( primeraCita != null ) {
            Cita citaTemp = primeraCita;
            Cita citaTemp2 = citaTemp.darSiguiente( );
            while( citaTemp2 != null && bienOrganizadas ) {
                if( hayCruce( citaTemp, citaTemp2 ) ) {
                    bienOrganizadas = false;
                }
                else {
                    citaTemp = citaTemp2;
                    citaTemp2 = citaTemp.darSiguiente( );
                }
            }
        }
        return bienOrganizadas;
    }

    /**
     * Este método sirve para saber si hay cruce entre un par de citas
     * @param c1 Es la primera cita - c1.darHora() < c2.darHora()
     * @param c2 Es la segunda cita - c1.darHora() < c2.darHora()
     * @return Se retornó true si las dos citas se cruzan o false en caso contrario
     */
    private boolean hayCruce( Cita c1, Cita c2 ) {
        boolean hayCruce = false;
        int horaFinCita1 = c1.darHora( );
        int duracion1 = c1.darDuracion( );
        while( duracion1 / 60 > 0 ) {
            horaFinCita1 += 60;
            duracion1 /= 60;
        }
        hayCruce = horaFinCita1 + duracion1 > c2.darHora( );
        return hayCruce;
    }

    /**
     * Verifica que las citas estén organizadas por hora
     * @return Se retornó true si las citas están bien organizadas o false en caso contrario
     */
    private boolean verificarOrdenCitas( ) {
        boolean bienOrganizadas = true;
        if( primeraCita != null ) {
            Cita citaTemp = primeraCita;
            Cita citaTemp2 = citaTemp.darSiguiente( );
            while( citaTemp2 != null && bienOrganizadas ) {
                if( citaTemp.darHora( ) >= citaTemp2.darHora( ) ) {
                    bienOrganizadas = false;
                }
                else {
                    citaTemp = citaTemp2;
                    citaTemp2 = citaTemp.darSiguiente( );
                }
            }
        }
        return bienOrganizadas;
    }

}
