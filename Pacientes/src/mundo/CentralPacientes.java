/*
 *
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class CentralPacientes {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer paciente de la lista
     */
    private Paciente primero;

    /**
     * Número de pacientes en la central
     */
    private int numPacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    @SuppressWarnings("rawtypes")
    private ArrayList listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de
     * clínicas
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public CentralPacientes() {
        primero = null;
        numPacientes = 0;
        listaClinicas = new ArrayList();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return numPacientes;
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     * pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        if (primero == null) {
            primero = pac;
        } else {
            pac.cambiarSiguiente(primero);
            primero = pac;
        }
        numPacientes++;
        verificarInvariante();
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el
     * paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     * pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        if (primero == null) {
            primero = pac;
        } else {
// Busca el último paciente de la lista Paciente p = localizarUltimo();
// Adiciona el paciente después del último paciente de la lista p.insertarDespues(pac);
        }
        numPacientes++;
        verificarInvariante();
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el
     * código especificado. <br>
     * <b> pre: </b> primero!= null. <br>
     *
     * @param cod El código del paciente antes del que se va insertar el nuevo
     * paciente.
     * @param pac El paciente que se va a adicionar. <br>
     * pac!=null y no existe un paciente con código igual a pac.codigo
     * @throws NoExisteException Si el paciente antes del que se va a realizar
     * la adición no se encuentra registrado.
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        if (primero == null) {
            throw new NoExisteException(cod);
        } else if (cod == primero.darCodigo()) {
            pac.cambiarSiguiente(primero);
            primero = pac;
        } else {
            Paciente anterior = localizarAnterior(cod);
            if (anterior == null) {
                throw new NoExisteException(cod);
            }
            anterior.insertarDespues(pac);
        }
        numPacientes++;
        verificarInvariante();
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el
     * código especificado.
     *
     * @param cod El código del paciente después del que se va insertar el nuevo
     * paciente.
     * @param pac El paciente que se va a adicionar. <br>
     * pac!=null y no existe un paciente con código igual a pac.codigo
     * @throws NoExisteException Si el paciente después del que se va a realizar
     * la adición no se encuentra registrado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        Paciente anterior = localizar(cod);
        if (anterior == null) {
            throw new NoExisteException(cod);
        } else {
            anterior.insertarDespues(pac);
        }
        numPacientes++;
        verificarInvariante();
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     *
     * @param codigo El código del paciente que se va a buscar
     * @return El paciente con el código especificado. Si el paciente no existe
     * se retorna null
     */
    public Paciente localizar(int codigo) {
        Paciente actual = primero;
        while (actual != null && actual.darCodigo() != codigo) {
            actual = actual.darSiguiente();
        }
        return actual;
    }

    /**
     * Busca el paciente anterior al paciente con el código especificado
     *
     * @param cod Código del paciente del que se desea el paciente anterior
     * @return El paciente anterior al paciente con el código dado. Se retorna
     * null si el paciente con el código dado no existe o si es el primero de la
     * lista
     */
    public Paciente localizarAnterior(int cod) {
        Paciente anterior = null;
        Paciente actual = primero;
        while (actual != null && actual.darCodigo() != cod) {
            anterior = actual;
            actual = actual.darSiguiente();
        }
        return actual != null ? anterior : null;
    }

    /**
     * Retorna el último paciente de la lista
     *
     * @return El último paciente de la lista. Si la lista está vacía se retorna
     * null
     */
    public Paciente localizarUltimo() {
        Paciente actual = primero;
        if (actual != null) {
            while (actual.darSiguiente() != null) {
                actual = actual.darSiguiente();
            }
        }
        return actual;
    }

    /**
     * Elimina el paciente con el código especificado.
     *
     * @param cod El código del paciente a ser eliminado.
     * @throws NoExisteException Si el paciente con el código especificado no
     * existe y por tanto no pudo ser eliminado de la lista
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        if (primero == null) {
            throw new NoExisteException(cod);
        } else if (cod == primero.darCodigo()) {
            primero = primero.darSiguiente();
// El paciente es el primero de la lista primero = primero.darSiguiente();
        } else {
            Paciente anterior = localizarAnterior(cod);
            if (anterior == null) {
                throw new NoExisteException(cod);
            }
            anterior.desconectarSiguiente();
        }
        numPacientes--;
        verificarInvariante();
    }

// El paciente es un elemento intermedio de la lista Paciente anterior = localizarAnterior(cod); if(anterior == null)
    /**
     * Devuelve una lista con los pacientes de la central
     *
     * @return Lista de Pacientes
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ArrayList darPacientes() {
        ArrayList pacientes = new ArrayList();
        Paciente actual = primero;
        while (actual != null) {
            pacientes.add(actual);
            actual = actual.darSiguiente();
        }
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     *
     * @return La lista de clínicas manejadas por la central
     */
    @SuppressWarnings("rawtypes")
    public ArrayList darListaClinicas() {
        return listaClinicas;
    }
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un
     * AssertError. <br>
     * <b>inv: </b> <br>
     * numPacientes == longitud de la lista de pacientes <br>
     * los códigos de los pacientes son únicos en la central <br>
     * listaClinicas != null
     */
    private void verificarInvariante() {
        assert numPacientes == darLongitud() : "Número de pacientes inconsistente";
        assert !hayCodigosRepetidos() : "Los códigos no son únicos";
        assert listaClinicas != null : "La lista de clínicas no puede ser nula";
    }

    /**
     * Retorna la longitud de la lista
     *
     * @return Longitud de la lista de pacientes
     */
    private int darLongitud() {
        Paciente actual = primero;
        int longitud = 0;
        while (actual != null) {
            longitud++;
            actual = actual.darSiguiente();
        }
        return longitud;
    }

    /**
     * Indica si en la lista de pacientes hay al menos un código repetido
     *
     * @return True si hay código repetidos o false en caso contrario
     */
    private boolean hayCodigosRepetidos() {
        boolean repetidos = false;
        Paciente actual = primero;
        while (actual != null && !repetidos) {
            Paciente elPaciente = actual.darSiguiente();
            while (elPaciente != null && !repetidos) {
                if (actual.darCodigo() == elPaciente.darCodigo()) {
                    repetidos = true;
                }
                elPaciente = elPaciente.darSiguiente();
            }
            actual = actual.darSiguiente();
        }
        return repetidos;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Método para la extensión 1
     *
     * @return respuesta1
     */
    public String metodo1() {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2
     *
     * @return respuesta2
     */
    public String metodo2() {
        return "Respuesta 2";
    }

    /**
     * Método para la extensión3
     *
     * @return respuesta3
     */
    public String metodo3() {
        return "Respuesta 3";
    }

    /**
     * Método para la extensión4
     *
     * @return respuesta4
     */
    public String metodo4() {
        return "Respuesta 4";
    }

    /**
     * Método para la extensión2
     *
     * @return respuesta5
     */
    public String metodo5() {
        return "Respuesta 5";
    }

}
