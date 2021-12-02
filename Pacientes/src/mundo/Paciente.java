/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Paciente {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para representar a un Hombre
     */
    public final static int HOMBRE = 1;
    
    /**
     * Constante para representar a una mujer
     */
    public final static int MUJER = 2;

    /**
     * Cosntante para representar una prioridad alta
     */
    public final static int P_ALTA = 1;

    /**
     * Cosntante para representar una prioridad media
     */
    public final static int P_MEDIA = 2;

    /**
     * Cosntante para representar una prioridad baja
     */
    public final static int P_BAJA = 3;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * El código del paciente
     */
    private int codigo;

    /**
     * El nombre del paciente
     */
    private String nombre;

    /**
     * Clínica a la que asiste el paciente
     */
    private String clinica;

    /**
     * La información médica del paciente
     */
    private String informacionMedica;

    /**
     * Sexo del paciente
     */
    private int sexo;

    /**
     * El siguiente paciente de la lista
     */
    private Paciente siguiente;

    /**
     * Prioridad del paciente
     */
    private int prioridad;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye un paciente
     * @param cod El código del paciente 
     * @param nom El nombre del paciente - nom!=null y nom!=""
     * @param clin La clínica del paciente - clin!=null y clin!=""
     * @param infoMed la información médica del paciente - infoMed!=null
     * @param sex El sexo del paciente. sex pertenece a { HOMBRE, MUJER }
     * @param prio La prioridad del paciente. prio pertenence a { P_ALTA, P_MEDIA, P_BAJA }
     */
    public Paciente(int cod, String nom, String clin, String infoMed, int sex, int prio) {
        codigo = cod;
        nombre = nom;
        clinica = clin;
        informacionMedica = infoMed;
        sexo = sex;
        siguiente = null;
        prioridad = prio;
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el código del paciente
     * @return El código del paciente
     */
    public int darCodigo() {
        return codigo;
    }

    /**
     * Retorna el nombre del paciente
     * @return El nombre del paciente
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Retorna la clínica asignada al paciente
     * @return La clínica asignada al paciente
     */
    public String darClinica() {
        return clinica;
    }

    /**
     * Retorna la información médica del paciente
     * @return La información médica del paciente
     */
    public String darInformacionMedica() {
        return informacionMedica;
    }

    /**
     * Retorna el sexo del paciente
     * @return El sexo del paciente
     */
    public int darSexo() {
        return sexo;
    }
    
    /**
     * Retorna la prioridad del paciente
     * @return La prioridad del paciente
     */
    public int darPrioridad() {
    	return prioridad;
    }

    /**
     * Retorna el siguiente paciente de la lista
     * @return El siguiente paciente de la lista
     */
    public Paciente darSiguiente() {
        return siguiente;
    }

    /**
     * Cambia el paciente que le sigue al actual
     * @param pac Paciente siguiente al actual
     */
    public void cambiarSiguiente(Paciente pac) {
        siguiente = pac;
    }

    /**
     * Desconecta el paciente que le sigue en la lista al paciente actual. <br>
     * <b>pre: </b> No es el último paciente de la lista <br>
     * <b>post: </b> El paciente siguiente al actual fue desconectado de la lista.
     */
    public void desconectarSiguiente() {
        siguiente = siguiente.siguiente;
    }

    /**
     * Inserta el paciente después del actual. <br>
     * <b>post: </b> Se insertó el paciente especificado después del paciente actual. <br>
     * @param pac El paciente a insertar - elPaciente!=null
     */
    public void insertarDespues(Paciente pac) {
        pac.siguiente = siguiente;
        siguiente = pac;
    }

    /**
     * Retorna una cadena con la información del paciente
     * @return [ codigo ]: nombre
     */
    public String toString() {
        return "[ " + codigo + " ]: " + nombre;
    }

    /**
     * Cambia la información médica del paciente
     * @param informacion Nueva información médica del paciente
     */
    public void cambiarInformacionMedica(String informacion) {
        informacionMedica = informacion;
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, 
     * lanza un AssertError. <br>
     * <b>inv: </b> <br>
     * codigo >= 0 nombre != null <br>
     * nombre != "" clinica != null <br>
     * clinica != "" <br>
     * informacionMedica != null <br>
     * sexo == HOMBRE o sexo == MUJER
     */
    private void verificarInvariante() {
        assert codigo >= 0 : "Código inválido";
        assert nombre != null && !nombre.equals( "" ) : "Nombre inválido";
        assert clinica != null && !clinica.equals( "" ) : "Clínica inválida";
        assert informacionMedica != null : "Información médica inválida";
        assert sexo == HOMBRE || sexo == MUJER : "Valor inválido para el "
                + "atributo sexo";
    }

}
