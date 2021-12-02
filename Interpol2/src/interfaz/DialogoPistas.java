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
public class DialogoPistas extends JDialog {
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel donde se muestran las pistas.
     */
    private PanelPistas panelPistas;

    /**
     * Ventana principal de la aplicación
     */
    private InterfazInterpol principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros.
     * @param interpol Interfaz principal de la aplicación. Diferente de null.
     * @param lugares Lista de los lugares donde hay una pista
     */
    @SuppressWarnings("rawtypes")
    public DialogoPistas(InterfazInterpol interpol, List lugares) {
        super(interpol, true);
        principal = interpol;
        setTitle("Lugares");
        panelPistas = new PanelPistas(this, lugares);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        add(panelPistas);
        pack();
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Llama a la ventana principal para que muestre una pista de un lugar.
     * @param nombreLugar Nombre del lugar donde se quiere mostrar la pista. 
     *        Diferente de null.
     */
    public void mostrarPista(String nombreLugar) {
        principal.mostrarPista(nombreLugar);
    }

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar() {
        setLocationRelativeTo(null);
    }

}
