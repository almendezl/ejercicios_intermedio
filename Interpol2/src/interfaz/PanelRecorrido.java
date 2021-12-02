/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelRecorrido extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Acción asociada al botón cerrar
     */
    private static final String CERRAR = "CERRAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Botón para aceptar y cerrar el diálogo que contiene el panel
     */
    private JButton btnAceptar;
    /**
     * Área de texto para el recorrido
     */
    private JTextArea txtaRecorrido;
    /**
     * Scroll para el recorrido
     */
    private JScrollPane scroll;
    /**
     * Dialogo que contiene al panel
     */
    private DialogoRecorrido padre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Método constructor por parámetros.
     * @param recorrido Lista que contiene la información a mostrar. Contiene 
     *        objetos de tipo String y no es null
     * @param dialogo Dialogo que contiene el panel
     */
    @SuppressWarnings("rawtypes")
    public PanelRecorrido(List recorrido, DialogoRecorrido dialogo) {
        padre = dialogo;
        setLayout(new BorderLayout());
        btnAceptar = new JButton("Cerrar");
        btnAceptar.setActionCommand(CERRAR);
        btnAceptar.addActionListener(this);
        setPreferredSize(new Dimension(300, 300));
        txtaRecorrido = new JTextArea();
        txtaRecorrido.setEditable(false);
        for(int i = 0; i < recorrido.size(); i++) {
            txtaRecorrido.setText( txtaRecorrido.getText() + recorrido.get(i) + 
                    "\n");
        }
        scroll = new JScrollPane(txtaRecorrido);
        scroll.setPreferredSize(new Dimension(300, 300));
        add(scroll, BorderLayout.CENTER);
        add(btnAceptar, BorderLayout.SOUTH);
    }

    // -----------------------------------------------------------------
    // Métodos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if(accion.equals(CERRAR)) {
            padre.dispose();
        }
    }

}
