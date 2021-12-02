/**
 * 
 */
package interfaces;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
@SuppressWarnings("serial")
public class ButtonsPanel extends JPanel implements ActionListener {
    // ---------------------------------------------------------------------------------------
    // Constants
    /** Option command*/
    // ---------------------------------------------------------------------------------------
    private static final String SHAPES = "SHAPES";
	
    /** Option command*/
    private static final String POINTS = "POINTS";

    /** Option command*/
    private static final String FILL_COLOR = "FILL_COLOR";

    /** Option command*/
    private static final String LINE_COLOR = "LINE_COLOR";

    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** Main interface */
    private ShapesInterface shapesInterface;

    // ---------------------------------------------------------------------------------------
    // Interface Attributes
    // ---------------------------------------------------------------------------------------
    /** Select shape button */
    private JButton selectShapeButton;
    
    /** Set points button */
    private JButton pointsButton;
    
    /** Set line color button */
    private JButton lineColorButton;
    
    /** Set fill color button */
    private JButton fillColorButton;
    
    /** Selected shape label */
    private JLabel shapeLabel;
    
    /** Selected shape area label */
    private JLabel areaLabel;
    
    /** Selected shape perimeter label */
    private JLabel perimeterLabel;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor. Initializes the button panel
     * @param shapesInterface Main interface of program
     */
    public ButtonsPanel(ShapesInterface shapesInterface) {
        this.shapesInterface = shapesInterface;
        setLayout(new GridBagLayout());
        //Settings panel
        JPanel settingsPanel = new JPanel(new GridLayout(4, 1));
        settingsPanel.setBorder(new TitledBorder("Settings"));
        
        selectShapeButton = new JButton("Select Shape");
        selectShapeButton.setActionCommand(SHAPES);
        selectShapeButton.addActionListener(this);
        settingsPanel.add(selectShapeButton);
        
        pointsButton = new JButton("Set points");
        pointsButton.setActionCommand(POINTS);
        pointsButton.addActionListener(this);
        settingsPanel.add(pointsButton);

        lineColorButton = new JButton("Set line color");
        lineColorButton.setActionCommand(LINE_COLOR);
        lineColorButton.addActionListener(this);
        settingsPanel.add(lineColorButton);

        fillColorButton = new JButton("Set fill color");
        fillColorButton.setActionCommand(FILL_COLOR);
        fillColorButton.addActionListener(this);
        settingsPanel.add(fillColorButton);

        GridBagConstraints position = new GridBagConstraints(0, 0, 1, 3, 0, 0, GridBagConstraints.CENTER,
        		GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0);
        add(settingsPanel, position);

        //Data Panel
        JPanel dataPanel = new JPanel(new GridLayout(3, 1));
        dataPanel.setBorder(new TitledBorder("Data"));
        dataPanel.setPreferredSize(new Dimension(170, 100));

        shapeLabel = new JLabel("Shape");
        shapeLabel.setFont(shapeLabel.getFont().deriveFont(Font.PLAIN));
        dataPanel.add(shapeLabel);
        
        perimeterLabel = new JLabel("Perimeter");
        perimeterLabel.setFont(perimeterLabel.getFont().deriveFont(Font.PLAIN));
        dataPanel.add(perimeterLabel);
        
        areaLabel = new JLabel("Area");
        areaLabel.setFont(areaLabel.getFont().deriveFont(Font.PLAIN));
        dataPanel.add(areaLabel);

        position = new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
        		GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0);
        add(dataPanel, position);
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Update data values
     * @param shape Shape to be showed
     * @param perimeter Perimeter of shape selected
     * @param area Area of shape selected
     */
    public void updateData(String shape, double perimeter, double area) {
    	shapeLabel.setText("Shape: " + shape);
    	perimeterLabel.setText("Perimeter: " + valueFormat(perimeter) + " px");
    	areaLabel.setText("Area: " + valueFormat(area) + " px");
    }

    /**
     * Override method to define the actions for buttons
     * @param e Event that activated the action 
     */
    public void actionPerformed(ActionEvent e) {
        if(SHAPES.equals(e.getActionCommand())) {
        	shapesInterface.setShape();
        }
        else if(POINTS.equals(e.getActionCommand())) {
            shapesInterface.setPoints();
        }
        else if(FILL_COLOR.equals(e.getActionCommand())) {
            shapesInterface.setFillColor();
        }
        else if(LINE_COLOR.equals(e.getActionCommand())) {
            shapesInterface.setLineColor();
        }
    }

    /**
     * Method for set the data format to be showed
     * @param value Value to be set
     * @return String value representation with the format defined 
     */
    private String valueFormat(double value) {
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(value);
    }

}
