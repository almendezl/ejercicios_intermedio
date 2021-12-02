/**
 * 
 */
package interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener {
    // ---------------------------------------------------------------------------------------
    // Constants
    // ---------------------------------------------------------------------------------------
    /** Option command 1 */
    private static final String OPTION_1 = "OPTION_1";
    
    /** Option command 2 */
    private static final String OPTION_2 = "OPTION_2";

    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** Main interface */
    private ShapesInterface shapesInterface;

    // ---------------------------------------------------------------------------------------
    // Interface Attributes
    // ---------------------------------------------------------------------------------------
    /** Option 1 button*/
    private JButton optionButton1;

    /** Option 2 button*/
    private JButton optionButton2;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor. Initializes the options panel
     * @param shapesInterface Main interface of program
     */
    public OptionsPanel(ShapesInterface shapesInterface) {
        this.shapesInterface = shapesInterface;

        setBorder(new TitledBorder("Options"));
        setLayout(new GridLayout(1, 2));

        //Button option 1
        optionButton1 = new JButton("Option 1");
        optionButton1.setActionCommand(OPTION_1);
        optionButton1.addActionListener(this);
        add(optionButton1);

        //Button option 2
        optionButton2 = new JButton("Option 2");
        optionButton2.setActionCommand(OPTION_2);
        optionButton2.addActionListener(this);
        add(optionButton2);
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Override method to define the actions for buttons
     * @param e Event that activated the action 
     */
    public void actionPerformed(ActionEvent e) {
        if(OPTION_1.equals(e.getActionCommand())) {
            shapesInterface.reqFuncOption1();
        }
        else if(OPTION_2.equals(e.getActionCommand())) {
            shapesInterface.reqFuncOption2();
        }
    }

}
