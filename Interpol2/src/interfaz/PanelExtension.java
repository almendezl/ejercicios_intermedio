/*
 *
 */

package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelExtension extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";
    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";
    /**
     * Comando para iniciar el juego
     */
    private static final String INICIAR_JUEGO = "INICIAR_JUEGO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación
     */
    private InterfazInterpol principal;

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    /**
     * Botón para iniciar el juego
     */
    private JButton btnIniciar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension(InterfazInterpol ventana) {
        principal = ventana;
        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridLayout(1, 3));
        // Botón iniciar juego
        btnIniciar = new JButton("Seleccionar Juego");
        btnIniciar.setActionCommand(INICIAR_JUEGO);
        btnIniciar.addActionListener(this);
        add(btnIniciar);
        // Botón opción 1
        btnOpcion1 = new JButton("Opción 1");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);
        // Botón opción 2
        btnOpcion2 = new JButton("Opción 2");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(OPCION_1.equals(e.getActionCommand())) {
            principal.reqFuncOpcion1();
        }
        else if(OPCION_2.equals(e.getActionCommand())) {
            principal.reqFuncOpcion2();
        }
        else if(e.getActionCommand().equals(INICIAR_JUEGO)) {
            principal.iniciarJuego();
        }
    }

}
