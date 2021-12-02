/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelPrevisualizacionXML extends JPanel {
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * La interfaz principal.
     */
    private InterfazEditorXML principal;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Árbol a visualizar
     */
    private JTextArea txaPrevisualizacionXML;

    /**
     * Scroll Pane donde va estar el árbol.
     */
    private JScrollPane spnPrevisualizacionXML;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Constructor.
     * @param principal Instancia de la ventana principal
     */
    public PanelPrevisualizacionXML(InterfazEditorXML principal) {
        this.principal = principal;
        this.setLayout(new BorderLayout());
        EmptyBorder eb = new EmptyBorder(5, 5, 5, 5);
        BevelBorder bb = new BevelBorder(BevelBorder.LOWERED);
        CompoundBorder cb = new CompoundBorder(eb, bb);
        this.setBorder(new CompoundBorder(cb, eb));
        // Inicialización del Scroll Pane
        spnPrevisualizacionXML = new JScrollPane();
        this.add(spnPrevisualizacionXML, BorderLayout.CENTER);
        // Inicialización del árbol
        txaPrevisualizacionXML = new JTextArea();
        spnPrevisualizacionXML.setViewportView(txaPrevisualizacionXML);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Actualiza la cadena que está en el área de texto.
     */
    public void actualizar() {
        try {
            if(principal.darElementoRaiz() == null) {
                txaPrevisualizacionXML.setText("");
            }
            else {
                txaPrevisualizacionXML.setText(principal.darCadenaXML());
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage( ), 
                    "Respuesta", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Devuelve el texto escrito en el área de texto.
     * @return El texto que está en el área de texto.
     */
    public String darTexto() {
        return txaPrevisualizacionXML.getText();
    }

}
