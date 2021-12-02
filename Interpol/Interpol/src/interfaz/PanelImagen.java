/*
 *
 */

package interfaz;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelImagen extends JPanel {
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Método constructor por defecto. Coloca la imagen del encabezado de la aplicación.
     */
    public PanelImagen() {
        JLabel imagen = new JLabel();
        ImageIcon icono = new ImageIcon("data/imagenes/titulo.png");
        // La agrega a la etiqueta
        imagen = new JLabel("");
        imagen.setIcon(icono);
        add(imagen);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.BLACK));
    }

}
