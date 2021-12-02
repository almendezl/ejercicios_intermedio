/*
 *
 */

package interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelBotones extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Acción asociada al botón recorrido inorden
     */
    private static final String INORDEN = "INORDEN";

    /**
     * Acción asociada al botón recorrido preorden
     */
    private static final String PREORDEN = "PREORDEN";

    /**
     * Acción asociada al botón recorrido postorden
     */
    private static final String POSTORDEN = "POSTORDEN";

    /**
     * Acción asociada al botón de obtener altura
     */
    private static final String ALTURA = "ALTURA";

    /**
     * Acción asociada al botón de obtener peso
     */
    private static final String PESO = "PESO";

    /**
     * Acción asociada al botón cerrar
     */
    private static final String CERRAR = "CERRAR";

    // -----------------------------------------------------------------
    // Atributos 
    // -----------------------------------------------------------------
    /**
     * Botón para cerrar el dialogo padre
     */
    private JButton btnCerrar;
    /**
     * Botón para mostrar el recorrido en inorden del árbol respuesta
     */
    private JButton btnInorden;
    /**
     * Botón para mostrar el recorrido en preorden del árbol respuesta
     */
    private JButton btnPreorden;
    /**
     * Botón para mostrar el recorrido en postorden del árbol respuesta
     */
    private JButton btnPostorden;
    /**
     * Botón para mostrar la altura del árbol respuesta
     */
    private JButton btnAltura;
    /**
     * Botón para mostrar el peso del árbol respuesta
     */
    private JButton btnPeso;
    /**
     * Dialogo que contiene al panel
     */
    private DialogoMostrarArbol dialogo;

    /**
     * Instancia de la interfaz principal
     */
    private InterfazInterpol principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros de la clase.
     * @param arbol Dialogo que contiene el panel
     * @param padre Instancia de la interfaz principal
     */
    public PanelBotones(DialogoMostrarArbol arbol, InterfazInterpol padre) {
        dialogo = arbol;
        principal = padre;
        btnInorden = new JButton("Inorden");
        btnInorden.setActionCommand(INORDEN);
        btnInorden.addActionListener(this);
        btnInorden.setPreferredSize(new Dimension(100, 25));
        add(btnInorden);
        btnPreorden = new JButton("Preorden");
        btnPreorden.setActionCommand(PREORDEN);
        btnPreorden.addActionListener(this);
        btnPreorden.setPreferredSize(new Dimension(100, 25));
        add(btnPreorden);
        btnPostorden = new JButton("Postorden");
        btnPostorden.setActionCommand(POSTORDEN);
        btnPostorden.addActionListener(this);
        btnPostorden.setPreferredSize(new Dimension(100, 25));
        add(btnPostorden);
        btnAltura = new JButton("Altura");
        btnAltura.setActionCommand(ALTURA);
        btnAltura.addActionListener(this);
        btnAltura.setPreferredSize(new Dimension(100, 25));
        add(btnAltura);
        btnPeso = new JButton("Peso");
        btnPeso.setActionCommand(PESO);
        btnPeso.addActionListener(this);
        btnPeso.setPreferredSize(new Dimension(100, 25));
        add(btnPeso);
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setActionCommand(CERRAR);
        btnCerrar.addActionListener(this);
        btnCerrar.setPreferredSize(new Dimension(100, 25));
        add(btnCerrar);
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
        String comando = e.getActionCommand();
        if( comando.equals(CERRAR)) {
            dialogo.dispose();
        }
        else if(comando.equals(INORDEN)) {
            principal.mostrarRecorridoInorden(dialogo);
        }
        else if(comando.equals(PREORDEN)) {
            principal.mostrarRecorridoPreorden(dialogo);
        }
        else if(comando.equals(POSTORDEN)) {
            principal.mostrarRecorridoPostorden(dialogo);
        }
        else if(comando.equals( ALTURA)) {
            principal.mostrarAltura(dialogo);
        }
        else if(comando.equals(PESO)) {
            principal.mostrarPeso(dialogo);
        }
    }

}
