/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelImagen extends JPanel {
    // -------------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Etiqueta donde va ir la imagen
     */
    private JLabel labelImagen;

    // -------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
    /**
     * Constructor del panel donde va estar la imagen.
     */
    public PanelImagen() {
        this.setLayout(new BorderLayout());
        labelImagen = new JLabel();
        labelImagen.setVerticalAlignment(JLabel.CENTER);
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        labelImagen.setIcon(new ImageIcon("data/imagenes/EditorXML.png"));
        this.add(labelImagen, BorderLayout.CENTER);
    }

}
