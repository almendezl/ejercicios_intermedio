/*
 *
 */

package mundo;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class Sospechoso {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * La ruta de la imagen del sospechoso
     */
    private String rutaImagen;

    /**
     * Indica si es el ladrón o no.
     */
    private boolean esLadron;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros. Los atributos se inicializan con lo parámetros. rutaImagen = ruta, esSospechoso = nEsSospechoso
     * @param ruta La ruta de la imagen del sospechoso
     * @param nEsLadron Indica si es el ladrón o no.
     */
    public Sospechoso(String ruta, boolean nEsLadron) {
        rutaImagen = ruta;
        esLadron = nEsLadron;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna la ruta de la imagen del sospechoso.
     * @return Diferente de null.
     */
    public String darRutaImagen() {
        return rutaImagen;
    }

    /**
     * Retorna si el sospechoso es el ladrón o no
     * @return True en caso de que sea el ladrón, false de lo contrario.
     */
    public boolean esLadron() {
        return esLadron;
    }

}
