/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import mundo.Interpol;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class DialogoMostrarArbol extends JDialog {
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Panel que contiene el dialogo 
     */
    private PanelArbol panelArbol;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros. Inicializa y coloca los componentes gráficos.
     * @param interfaz Ventana principal de la aplicación. Diferente de null.
     * @param nInterpol Instancia del mundo. Diferente de null
     */
    public DialogoMostrarArbol(InterfazInterpol interfaz, Interpol nInterpol) {
        super(interfaz, true);
        setTitle("Árbol Respuesta");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(685, 400));
        panelArbol = new PanelArbol(nInterpol);
        panelArbol.actualizarImagen();
        add(new JScrollPane(panelArbol), BorderLayout.CENTER);
        add(new PanelBotones(this, interfaz), BorderLayout.SOUTH);
        pack();
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
