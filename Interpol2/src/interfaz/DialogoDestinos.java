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
public class DialogoDestinos extends JDialog {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Panel que contiene la información de los destinos
     */
    private PanelDestinos panelDestinos;
    /**
     * Ventana principal de la aplicación
     */
    private InterfazInterpol principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros. Inicializa y coloca los componentes gráficos.
     * @param interpol Ventana principal de la aplicación. Diferente de null.
     * @param destinos Lista de los posibles destinos para avanzar. Diferente de null
     */
    @SuppressWarnings("rawtypes")
    public DialogoDestinos(InterfazInterpol interpol, List destinos) {
        super(interpol, true);
        setTitle("Posibles Destinos");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        principal = interpol;
        panelDestinos = new PanelDestinos(this, destinos);
        add(panelDestinos);
        pack();
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cambiar la ciudad seleccionada en la aplicación.
     * @param nombreCiudad Nombre de la ciudad. Diferente de null.
     */
    public void cambiarCiudad(String nombreCiudad) {
        principal.viajar(nombreCiudad);
    }

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar() {
        setLocationRelativeTo(null);
    }

}
