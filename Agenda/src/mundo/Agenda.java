/*
 *
 */
package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Agenda {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es el primer día que aparece en la agenda
     */
    private Dia primerDia;

    /**
     * Es el archivo del cual se carga la información de las citas
     */
    private String archivoAgenda;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye una nueva agenda y carga los datos del archivo indicado
     *
     * @param archivo El archivo que contiene los datos de la agenda
     * @throws IOException Se lanza esta excepción si hay problemas leyendo del
     * archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si hay errores
     * en el formato del archivo cargado
     * @throws CitaInvalidaExcepcion Se lanza esta excepción si se intenta
     * construir una cita inválida
     */
    public Agenda(String archivo) throws IOException, FormatoInvalidoExcepcion,
            CitaInvalidaExcepcion {
        cargarDatos(archivo);
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Carga la información de la agenda a partir de un archivo
     *
     * @param archivo El nombre del archivo del cual se van a cargar los datos
     * @throws IOException Se lanza esta excepción si hay problemas leyendo del
     * archivo
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si hay errores
     * en el formato del archivo cargado
     * @throws CitaInvalidaExcepcion Se lanza esta excepción si se intenta
     * construir una cita inválida
     */
    @SuppressWarnings("resource")
    private void cargarDatos(String archivo) throws IOException,
            FormatoInvalidoExcepcion, CitaInvalidaExcepcion {
        archivoAgenda = archivo;
        BufferedReader br = new BufferedReader(new FileReader(archivoAgenda));
        br.readLine(); // BEGIN:VCALENDAR
        br.readLine(); // VERSION:2.0
        br.readLine(); // PRODID:-//hacksw/handcal//NONSGML v1.0//EN
        String linea = br.readLine();
        while (linea != null && !"END:VCALENDAR".equals(linea)) {
            if (!"BEGIN:VEVENT".equals(linea)) {
                throw new FormatoInvalidoExcepcion(linea);
            }
            String inicio = br.readLine();
            String fin = br.readLine();
            String descripcion = br.readLine();
            String strPrioridad = br.readLine();
            br.readLine(); // END:VEVENT
            construirCita(inicio, fin, descripcion, strPrioridad);
            verificarInvariante();
            linea = br.readLine();
        }
        br.close();
    }

    /**
     * Guarda los datos de la agenda en el archivo que se usó para cargar la
     * información de la agenda
     *
     * @throws IOException Si hay problemas al tratar de guardar la información
     * de la agenda
     */
    public void guardarAgenda() throws IOException {
        PrintWriter out = new PrintWriter(archivoAgenda);
        out.println("BEGIN:VCALENDAR");
        out.println("VERSION:2.0");
        out.println("PRODID:-//hacksw/handcal//NONSGML v1.0//EN");
        Dia diaTemp = primerDia;
        while (diaTemp != null) {
            diaTemp.guardarDia(out);
            diaTemp = diaTemp.darSiguiente();
        }
        out.println("END:VCALENDAR");
        out.close();
    }

    /**
     * Construye una nueva cita a partir de los parámetros leídos del archivo
     *
     * @param inicio La línea del archivo que indica el inicio de la cita
     * @param strDuracion La línea del archivo que indica el fin de la cita
     * @param descripcion La línea del archivo que contiene la descripción de la
     * cita
     * @param strPrioridad La línea del archivo que contiene la prioridad de la
     * cita
     * @throws FormatoInvalidoExcepcion Se lanza esta excepción si hay errores
     * en el formato del archivo cargado
     * @throws CitaInvalidaExcepcion Se lanza esta excepción si se intenta
     * construir una cita inválida
     */
    private void construirCita(String inicio, String strDuracion, String descripcion, String strPrioridad)
            throws FormatoInvalidoExcepcion, CitaInvalidaExcepcion {
        if (!inicio.startsWith("DTSTART:")) {
            throw new FormatoInvalidoExcepcion(inicio);
        }
        if (!inicio.startsWith("DURATION:")) {
            throw new FormatoInvalidoExcepcion(strDuracion);
        }
        if (!inicio.startsWith("SUMMARY:")) {
            throw new FormatoInvalidoExcepcion(descripcion);
        }
        if (!inicio.startsWith("PRIORITY:")) {
            throw new FormatoInvalidoExcepcion(strPrioridad);
        }
        inicio = inicio.substring(8);
        String strFechaInicio = inicio.substring(0, 8);
        String strHoraInicio = inicio.substring(9, 15);
        strDuracion = strDuracion.substring(10);
        strDuracion = strDuracion.substring(0, (strDuracion.indexOf("M")));
        descripcion = descripcion.substring(8);
        strPrioridad = strPrioridad.substring(9);
        try {
            Date fechaInicio = convertirFecha(strFechaInicio);
            int horaInicio = convertirHora(strHoraInicio);
            int duracion = Integer.parseInt(strDuracion);
            int prioridad = Integer.parseInt(strPrioridad);
            descripcion = descripcion.replace("*", "\n");
            agregarCita(fechaInicio, descripcion, horaInicio, duracion, prioridad);
        } catch (ParseException e) {
            throw new FormatoInvalidoExcepcion(strFechaInicio + "/" + strDuracion + "/" + strHoraInicio + "/" + "/" + strPrioridad);
        }
    }

    /**
     * Convierte una cadena en una fecha (Date) y retorna el objeto recién
     * construido
     *
     * @param strFecha Es la cadena que contiene la fecha
     * @return Se retornó un objeto de tipo fecha construido a partir de la
     * cadena
     * @throws ParseException Si hay problemas al convertir la fecha al formato
     * especificado
     */
    private Date convertirFecha(String strFecha) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.parse(strFecha);
    }

    /**
     * Convierte una cadena en una fecha (Date) y retorna el objeto recién
     * construido
     *
     * @param strFecha Es la cadena que contiene la fecha
     * @return Se retornó un objeto de tipo fecha construido a partir de la
     * cadena
     * @throws ParseException Si hay problemas al convertir la fecha al formato
     * especificado
     */
    private String convertirFecha(Date fecha) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MMMM.dd");
        return df.format(fecha);
    }

    /**
     * Convierte una cadena en una hora (int) y retorna el valor
     *
     * @param strHora La cadena que contiene la hora - strHora!=null
     * @return Se retornó el entero que representa a la hora
     * @throws NumberFormatException Se lanza esta excepción si el formato era
     * incorrecto
     */
    private int convertirHora(String strHora) throws NumberFormatException {
        int hora = Integer.parseInt(strHora.substring(0, 4));
        return hora;
    }

    /**
     * Agrega una nueva cita. <br>
     * <b>post:</b>Se agregó una nueva cita en el día correspondiente. Si el día
     * no existía entonces se creó ese día. <br>
     *
     * @param fechaC Es la fecha en la que se va a crear la cita
     * @param descripcionC La descripción de la cita
     * @param horaC La hora a la que se programó la cita
     * @param duracionC Es la duración (en minutos) que tendrá la cita
     * @param prioridadC Es la prioridad de la cita
     * @throws CitaInvalidaExcepcion Se lanza esta excepción si esta cita no se
     * puede poner en este día porque se cruza con otra cita
     */
    public void agregarCita(Date fechaC, String descripcionC, int horaC, int duracionC, int prioridadC) throws CitaInvalidaExcepcion {
        if (horaC < Dia.PRIMERA_HORA || horaC > Dia.ULTIMA_HORA) {
            throw new CitaInvalidaExcepcion(horaC, duracionC);
        }
        Cita nuevaCita = new Cita(descripcionC, horaC, duracionC, prioridadC);
        int horaFin = nuevaCita.calcularHoraFin();
        if (horaFin > Dia.ULTIMA_HORA) {
            throw new CitaInvalidaExcepcion(horaC, duracionC);
        }
        Dia diaCita = buscarDia(fechaC);
        if (diaCita == null) {
            diaCita = crearDia(fechaC);
        }
        diaCita.agregarCita(nuevaCita);
        verificarInvariante();
    }

    /**
     * Elimina una cita, si el día del cual elimino la cita queda sin citas,
     * este se debe eliminar de la agenda <br>
     *
     * @param d Día del cual se va a eliminar la cita
     * @param hora Hora de la cita a eliminar
     * @throws CitaInexistenteExcepcion Si no se encuentra la cita a eliminar
     */
    public void eliminarCita(Dia d, int hora) throws CitaInexistenteExcepcion {
        d.eliminarCita(hora);
        if (d.darCitas().size() == 0) {
            eliminarDiaSinCitas(d);
        }
        verificarInvariante();
    }

    /**
     * Busca el día dada la fecha. Si no encuentra el día retorna null.<br>
     * Del objeto Date que llega como parámetro solamente se usa la parte de la
     * fecha para hacer las comparaciones (se ignora la hora).
     *
     * @param fecha La fecha del día buscado
     * @return Se retornó el día de la fecha indicada o null si el día no existe
     */
    public Dia buscarDia(Date fecha) {
        Dia diaABuscar = new Dia(fecha);
        Dia diaBuscado = null;
        Dia diaActual = null;
// Búsqueda secuencial hasta que se llegue a la fecha buscada o se supere
        for (diaActual = primerDia; diaActual != null && diaActual.compararPorFecha(diaABuscar) < 0; diaActual = diaActual.darSiguiente());
// Se verifica si se encontró el día buscado
        if (diaActual != null && diaActual.compararPorFecha(diaABuscar) == 0) {
            diaBuscado = diaActual;
        }
        return diaBuscado;
    }

    /**
     * Busca el día con la menor cantidad de citas. Si hay más de uno retorna el
     * último encontrado.
     *
     * @return Se retorna el día con menor cantidad de citas
     */
    public Dia buscarDiaMenorCantCitas() {
        Dia diaBuscado = null;
        Dia diaActual = null;
        int menorCantCitas = primerDia.contarCitas();
        for (diaActual = primerDia; diaActual != null; diaActual = diaActual.darSiguiente()) {
            if (diaActual.contarCitas() <= menorCantCitas) {
                diaBuscado = diaActual;
                menorCantCitas = diaActual.contarCitas();
            }
        }
        return diaBuscado;
    }

    /**
     * Crea un nuevo Día en la agenda con la fecha indicada y lo deja en su
     * lugar dentro de la lista<br>
     * <b>pre:</b>En la agenda no hay ya un día con la fecha indicada<br>
     * <b>post:</b>Se agregó el Día a la agenda y la lista de días siguió
     * ordenada por fecha
     *
     * @param fecha La fecha que tendrá el día - fecha!=null
     * @return Se retornó el objeto Día que fue creado
     */
    public Dia crearDia(Date fecha) {
        Dia nuevoDia = new Dia(fecha);
        if (primerDia == null) {
            primerDia = nuevoDia;
        } else if (primerDia.compararPorFecha(nuevoDia) > 0) {
            primerDia.insertarAntes(nuevoDia);
            primerDia = nuevoDia;
        } else {
            Dia diaAnterior = primerDia;
            Dia diaActual = primerDia.darSiguiente();
            while (diaActual != null && diaActual.compararPorFecha(nuevoDia) < 0) {
                diaAnterior = diaActual;
                diaActual = diaActual.darSiguiente();
            }
            diaAnterior.insertarDespues(nuevoDia);
        }
        return nuevoDia;
    }

    /**
     * Retorna el primer día de la agenda
     *
     * @return primer día de la agenda
     */
    public Dia darPrimerDia() {
        return primerDia;
    }

    /**
     * Elimina el día con un numero dado de citas por parámetro de la agenda
     *
     * @param cantCitas Cantidad de citas minimas a considerar
     */
    private int eliminarDiaConMenosDeNCitas(int cantCitas) {
        int diasEliminados = 0;
        Dia diaActual = null;
        for (diaActual = primerDia; diaActual != null; diaActual = diaActual.darSiguiente()) {
            if (diaActual.contarCitas() < cantCitas) {
                Dia anterior = diaActual.darAnterior();
                Dia siguiente = diaActual.darSiguiente();
                if (diaActual.equals(primerDia) && siguiente != null) {
                    siguiente.cambiarAnterior(null);
                    primerDia = siguiente;
                } else if (diaActual.equals(primerDia) && siguiente == null) {
                    primerDia = null;
                } else if (siguiente != null) {
                    anterior.cambiarSiguiente(siguiente);
                    siguiente.cambiarAnterior(anterior);
                } else {
                    anterior.cambiarSiguiente(siguiente);
                }
                diasEliminados++;
            }
        }
        return diasEliminados;

    }

    /**
     * Elimina el día dado por parámetro de la agenda
     *
     * @param dia Día a eliminar
     */
    private void eliminarDiaSinCitas(Dia dia) {
        Dia diaActual = null;
        boolean terminar = false;
        for (diaActual = primerDia; diaActual != null && !terminar; diaActual
                = diaActual.darSiguiente()) {
            if (diaActual.equals(dia)) {
                Dia anterior = diaActual.darAnterior();
                Dia siguiente = diaActual.darSiguiente();
                if (diaActual.equals(primerDia) && siguiente != null) {
                    siguiente.cambiarAnterior(null);
                    primerDia = siguiente;
                } else if (diaActual.equals(primerDia) && siguiente == null) {
                    primerDia = null;
                } else if (siguiente != null) {
                    anterior.cambiarSiguiente(siguiente);
                    siguiente.cambiarAnterior(anterior);
                } else {
                    anterior.cambiarSiguiente(siguiente);
                }
                terminar = true;
            }
        }
    }
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv: </b> <br>
     * Los días están organizados por su fecha <br>
     * La lista de días está bien enlazada <br>
     */
    private void verificarInvariante() {
        assert (verificarOrdenDias()) : "Los días no están organizados";
        assert (verificarEstructuraLista()) : "La lista no está bien construida";
        assert (verificarDiasConCitas()) : "Existen días sin citas";
    }

    /**
     * Verifica que la lista esté bien construida
     *
     * @return Se retornó true si la lista está bien construida o false en caso
     * contrario.
     */
    private boolean verificarEstructuraLista() {
        boolean bienConstruida = true;
        if (primerDia != null) {
            if (primerDia.darAnterior() != null) {
                bienConstruida = false;
            } else {
                Dia diaAnterior = primerDia;
                Dia diaActual = diaAnterior.darSiguiente();
                while (diaActual != null && bienConstruida) {
                    if (diaActual.darAnterior() != diaAnterior) {
                        bienConstruida = false;
                    } else {
                        diaAnterior = diaActual;
                        diaActual = diaAnterior.darSiguiente();
                    }
                }
            }
        }
        return bienConstruida;
    }

    /**
     * Verifica que los días estén organizados
     *
     * @return Se retornó true si los días están bien organizados o false en
     * caso contrario
     */
    private boolean verificarOrdenDias() {
        boolean bienOrganizados = true;
        if (primerDia != null) {
            Dia diaAnterior = primerDia;
            Dia diaActual = diaAnterior.darSiguiente();
            while (diaActual != null && bienOrganizados) {
                if (diaAnterior.compararPorFecha(diaActual) >= 0) {
                    bienOrganizados = false;
                } else {
                    diaAnterior = diaActual;
                    diaActual = diaAnterior.darSiguiente();
                }
            }
        }
        return bienOrganizados;
    }

    /**
     * Verifica que todos los días existentes tengan por lo menos una cita <br>
     *
     * @return Se retornó true si todos los días tienen al menos una cita o
     * false en caso contrario
     */
    private boolean verificarDiasConCitas() {
        Dia diaActual = null;
        for (diaActual = primerDia; diaActual != null; diaActual
                = diaActual.darSiguiente()) {
            if (diaActual.darCitas().size() == 0) {
                return false;
            }
        }
        return true;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Es el punto de extensión 1
     *
     * @return respuesta 1
     */
    public String metodo1() {
        try {
            return "El día con menor cantidad de citas es " + convertirFecha(
                    buscarDiaMenorCantCitas().darFecha()) + ". La cantidad de "
                    + "citas ese día es " + buscarDiaMenorCantCitas().contarCitas();
        } catch (ParseException pe) {
            return "Error en la fecha. " + pe.getMessage();
        }
    }

    /**
     * Es el punto de extensión 2
     *
     * @param nCitas Numero limite de citas para eliminar un día
     * @return respuesta 2
     */
    public String metodo2(int nCitas) {
        return "El total de días eliminados es " + eliminarDiaConMenosDeNCitas(nCitas);
    }

}
