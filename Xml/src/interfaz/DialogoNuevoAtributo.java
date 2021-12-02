/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import mundo.InsercionHijoAtributoException;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class DialogoNuevoAtributo extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante "Aceptar".
     */
    public static final String ACEPTAR = "Aceptar";

    /**
     * Constante "Cancelar".
     */
    public static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Interfaz principal.
     */
    private InterfazEditorXML principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Label "Nombre nodo:"
     */
    private JLabel labelNombreAtributo;

    /**
     * Cuadro de texto donde se va tomar el nombre del atributo.
     */
    private JTextField textoNombreAtributo;

    /**
     * Label "Nombre atributo:"
     */
    private JLabel labelValorAtributo;

    /**
     * Cuadro de texto donde se va tomar el valor del atributo.
     */
    private JTextField textoValorAtributo;

    /**
     * Botón Aceptar.
     */
    private JButton botonAceptar;

    /**
     * Botón Cancelar;
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del diálogo donde se va a crear el nodo.
     * @param nPrincipal Instancia de la ventana principal
     */
    public DialogoNuevoAtributo(InterfazEditorXML nPrincipal) {
        principal = nPrincipal;
        // Construcción del nodo principal.
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(3, 2));
        labelNombreAtributo = new JLabel("Nombre del Atributo");
        panel.add(labelNombreAtributo);
        textoNombreAtributo = new JTextField();
        panel.add(textoNombreAtributo);
        labelValorAtributo = new JLabel("Valor del Atributo");
        panel.add(labelValorAtributo);
        textoValorAtributo = new JTextField();
        panel.add(textoValorAtributo);
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setActionCommand(ACEPTAR);
        botonAceptar.addActionListener(this);
        panel.add(botonAceptar);
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setActionCommand(CANCELAR);
        botonCancelar.addActionListener(this);
        panel.add(botonCancelar);
        setTitle("Nuevo Atributo");
        setLocationRelativeTo(principal);
        pack();
    }

    /**
     * Método que maneja las acciones del diálogo.
     * @param e El objeto donde están las características del evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(ACEPTAR)) {
            if(textoNombreAtributo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Por favor inserte el nombre "
                        + "del elemento", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    principal.insertarAtributo(textoNombreAtributo.getText(), 
                            textoValorAtributo.getText());
                }
                catch(InsercionHijoAtributoException e1) {
                    JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
                setVisible(false);
            }
        }
        if(e.getActionCommand().equals(CANCELAR)) {
            setVisible(false);
        }
    }

}
