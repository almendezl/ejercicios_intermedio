/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class DialogoRecorrido extends JDialog {
    // -----------------------------------------------------------------
    // Constructores
    /**
    // -----------------------------------------------------------------
     * Constructor por parámetros de la clase.
     * @param padre Dialogo sobre el cual el dialogo recorrido se va a mostrar
     * @param recorrido Lista que contiene los elementos organizados de acuerdo al recorrido solicitado. Diferente de null
     * @param titulo Titulo que tendrá la ventana. Diferente de null
     */
    @SuppressWarnings("rawtypes")
    public DialogoRecorrido(DialogoMostrarArbol padre, List recorrido, String titulo) {
        super(padre, true);
        setLayout(new BorderLayout());
        setTitle(titulo);
        setSize(new Dimension(300, 350));
        PanelRecorrido panelRecorrido = new PanelRecorrido(recorrido, this);
        add(panelRecorrido, BorderLayout.CENTER);
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar() {
        setLocationRelativeTo(null);
    }

}
