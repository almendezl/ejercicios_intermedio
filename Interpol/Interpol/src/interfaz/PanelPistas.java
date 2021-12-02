/*
 *
 */

package interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelPistas extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que identifica que el usuario acepto y quiere ver la pista
     */
    private static final String ACEPTAR = "ACEPTAR";

    /**
     * Constante que identifica que el usuario cancelo
     */
    private static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * ComboBox para las pistas que puede ver
     */
    @SuppressWarnings("rawtypes")
    private JComboBox combo;
    /**
     * Botón para visualizar una pista
     */
    private JButton btnAceptar;
    /**
     * Botón para cancelar la visualización de una pista
     */
    private JButton btnCancelar;
    /**
     * Dialogo que contiene al panel
     */
    private DialogoPistas padre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel. Inicializa y coloca los componentes gráficos.
     * @param pistas Dialogo que contiene este panel. Diferente de null.
     * @param lugares Lugares donde se pueden ver las pistas. Diferente de null.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public PanelPistas(DialogoPistas pistas, List lugares) {
        padre = pistas;
        setLayout(new GridBagLayout());
        combo = new JComboBox(lugares.toArray());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint.insets = new Insets(5, 5, 5, 5);
        add(combo, constraint);
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(5, 5, 5, 5);
        add(btnAceptar, constraint);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);
        constraint = new GridBagConstraints();
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(5, 5, 5, 5);
        add(btnCancelar, constraint);
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
        if( comando.equals(ACEPTAR)) {
            padre.mostrarPista((String)combo.getSelectedItem());
            padre.dispose();
        }
        else if(comando.equals(CANCELAR)) {
            padre.dispose();
        }
    }

}
