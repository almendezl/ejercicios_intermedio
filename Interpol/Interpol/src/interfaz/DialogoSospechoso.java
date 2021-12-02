/*
 *
 */

package interfaz;

import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class DialogoSospechoso extends JDialog {
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel con la selección de los sospechosos
     */
    private PanelSospechosos panelSospechoso;
    /**
     * Ventana principal de la aplicación
     */
    private InterfazInterpol principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros. Pasa los parámetros al panel de sospechosos.
     * @param interpol Instancia de la ventana principal de la aplicación
     * @param sospechosos Lista de los sospechosos del crimen
     */
    @SuppressWarnings("rawtypes")
    public DialogoSospechoso(InterfazInterpol interpol, List sospechosos) {
        super(interpol, true);
        principal = interpol;
        setTitle("Expedir Orden de Captura");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        panelSospechoso = new PanelSospechosos(this, sospechosos);
        add(panelSospechoso);
        pack();
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Genera la orden de captura dado un sospechoso
     * @param i Posición del sospechoso. Entero mayor a cero.
     */
    public void generarOrdenCaptura(int i) {
        principal.generarOrdenCaptura(i);
    }

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar() {
        setLocationRelativeTo(null);
    }

}
