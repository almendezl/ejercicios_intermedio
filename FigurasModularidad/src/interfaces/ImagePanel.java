/**
 * 
 */
package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
    // ---------------------------------------------------------------------------------------
    // Interface Attributes
    // ---------------------------------------------------------------------------------------
    /** Title image */
	private JLabel image;
	
    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor. Initializes the image panel
     */
    public ImagePanel() {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        ImageIcon icono = new ImageIcon("data/titulo.png");
        image = new JLabel("");
        image.setIcon(icono);
        add(image);
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
    }

}
