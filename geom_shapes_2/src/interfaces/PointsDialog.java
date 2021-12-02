/**
 * 
 */
package interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import world.Circle;
import world.Quadrilateral;
import world.Triangle;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
@SuppressWarnings("serial")
public class PointsDialog extends JDialog implements ActionListener {
    // ---------------------------------------------------------------------------------------
    // Constants
    // ---------------------------------------------------------------------------------------
    /** Option command*/
    private static final String OK = "OK";
	
    /** Option command*/
    private static final String CANCEL = "CANCEL";

    /** Shape selected option*/
    private static final int CIRCLE = 1;
	
    /** Shape selected option*/
    private static final int QUAD = 2;
	
    /** Shape selected option*/
    private static final int TRIANGLE = 3;

    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** A circle */
    private Circle circle;
	
    /** A triangle */
    private Triangle triangle;
	
    /** A quadrilateral */
    private Quadrilateral quad;
	
    /** Main interface */
    private ShapesInterface shapesInterface;
	
    /** Shape selected reference */
    private int shapeSelected;
	
    // ---------------------------------------------------------------------------------------
    // Interface Attributes
    // ---------------------------------------------------------------------------------------
    /** Text field for x coordinate of point 1 */
    private JTextField txtPoint1x;

    /** Text field for y coordinate of point 1 */
    private JTextField txtPoint1y;

    /** Text field for x coordinate of point 2 */
    private JTextField txtPoint2x;

    /** Text field for y coordinate of point 2 */
    private JTextField txtPoint2y;

    /** Text field for x coordinate of point 3 */
    private JTextField txtPoint3x;

    /** Text field for y coordinate of point 3 */
    private JTextField txtPoint3y;

    /** Text field for x coordinate of point 4 */
    private JTextField txtPoint4x;

    /** Text field for y coordinate of point 4 */
    private JTextField txtPoint4y;
    
    /** Text field for radius of a circle */
    private JTextField txtRadius;

    /** Agree button */
    private JButton okButton;

    /** Cancel button */
    private JButton cancelButton;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor. Initializes the points dialog
     * @param shapesInterface Main interface of program
     */
    public PointsDialog(ShapesInterface shapesInterface) {
        this.shapesInterface = shapesInterface;
        this.shapeSelected = shapesInterface.getShapeSeleted();
        
        //Set a shape according with the selection of user
        switch(shapeSelected) {
            case CIRCLE :
                this.circle = shapesInterface.getCircle();
                setLayout(new GridLayout(6, 3));
                setTitle("Set Point and Radius");
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                add(new JLabel("Origin"));
                add(new JLabel("X Value"));
                add(new JLabel("Y Value"));

                //Origin
                add(new JLabel());
                txtPoint1x = new JTextField(Double.toString(circle.getPoint().getX()));
                add(txtPoint1x);
                txtPoint1y = new JTextField(Double.toString(circle.getPoint().getY()));
                add(txtPoint1y);

                add(new JLabel("Radius"));
                add(new JLabel("Value"));
                add(new JLabel());

                //Radius
                add(new JLabel());
                txtRadius = new JTextField(Double.toString(circle.getRadius()));
                add(txtRadius);
                add(new JLabel());

                //Space
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());

                //Buttons
                okButton = new JButton("OK");
                okButton.setActionCommand(OK);
                okButton.addActionListener(this);
                add(okButton);

                cancelButton = new JButton("CANCEL");
                cancelButton.setActionCommand(CANCEL);
                cancelButton.addActionListener(this);
                add(cancelButton);

                pack();
                break;
            case QUAD :
                this.quad = shapesInterface.getQuadrilateral();
                setLayout(new GridLayout(7, 3));
                setTitle("Set Points");
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                add(new JLabel("Point"));
                add(new JLabel("X Value"));
                add(new JLabel("Y Value"));

                //Point 1
                add(new JLabel("Point 1:"));
                txtPoint1x = new JTextField(Double.toString(quad.getPoints().get(0).getX()));
                add(txtPoint1x);
                txtPoint1y = new JTextField(Double.toString(quad.getPoints().get(0).getY()));
                add(txtPoint1y);

                //Point 2
                add(new JLabel("Point 2:"));
                txtPoint2x = new JTextField(Double.toString(quad.getPoints().get(1).getX()));
                add(txtPoint2x);
                txtPoint2y = new JTextField(Double.toString(quad.getPoints().get(1).getY()));
                add(txtPoint2y);

                //Point 3
                add(new JLabel("Point 3:"));
                txtPoint3x = new JTextField(Double.toString(quad.getPoints().get(2).getX()));
                add(txtPoint3x);
                txtPoint3y = new JTextField(Double.toString(quad.getPoints().get(2).getY()));
                add(txtPoint3y);

                //Point 4
                add(new JLabel("Point 4:"));
                txtPoint4x = new JTextField(Double.toString(quad.getPoints().get(3).getX()));
                add(txtPoint4x);
                txtPoint4y = new JTextField(Double.toString(quad.getPoints().get(3).getY()));
                add(txtPoint4y);

                //Space
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());

                //Buttons
                okButton = new JButton("OK");
                okButton.setActionCommand(OK);
                okButton.addActionListener(this);
                add(okButton);

                cancelButton = new JButton("CANCEL");
                cancelButton.setActionCommand(CANCEL);
                cancelButton.addActionListener(this);
                add(cancelButton);

                pack();
                break;
            case TRIANGLE :
                this.triangle = shapesInterface.getTriangle();
                setLayout(new GridLayout(6, 3));
                setTitle("Set Points");
                setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

                add(new JLabel("Point"));
                add(new JLabel("X Value"));
                add(new JLabel("Y Value"));

                //Point 1
                add(new JLabel("Point 1:"));
                txtPoint1x = new JTextField(Double.toString(triangle.getPoints().get(0).getX()));
                add(txtPoint1x);
                txtPoint1y = new JTextField(Double.toString(triangle.getPoints().get(0).getY()));
                add(txtPoint1y);

                //Point 2
                add(new JLabel("Point 2:"));
                txtPoint2x = new JTextField(Double.toString(triangle.getPoints().get(1).getX()));
                add(txtPoint2x);
                txtPoint2y = new JTextField(Double.toString(triangle.getPoints().get(1).getY()));
                add(txtPoint2y);

                //Point 3
                add(new JLabel("Point 3:"));
                txtPoint3x = new JTextField(Double.toString(triangle.getPoints().get(2).getX()));
                add(txtPoint3x);
                txtPoint3y = new JTextField(Double.toString(triangle.getPoints().get(2).getY()));
                add(txtPoint3y);

                //Space
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());
                add(new JLabel());

                //Buttons
                okButton = new JButton("OK");
                okButton.setActionCommand(OK);
                okButton.addActionListener(this);
                add(okButton);

                cancelButton = new JButton("CANCEL");
                cancelButton.setActionCommand(CANCEL);
                cancelButton.addActionListener(this);
                add(cancelButton);

                pack();
                break;
        }
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Override method to define the actions for buttons
     * @param e Event that activated the action 
     */
    public void actionPerformed(ActionEvent e) {
        try {
            //Actions defined for specific shape
            switch (shapeSelected) {
                case CIRCLE :
                    if(OK.equals(e.getActionCommand())) {
                        //read values
                        double p1x = Double.parseDouble(txtPoint1x.getText());
                        double p1y = Double.parseDouble(txtPoint1y.getText());
                        double radius = Double.parseDouble(txtRadius.getText());

                        //validation
                        if(radius <= 0) {
                                JOptionPane.showMessageDialog(this, "Radius must be greater than zero", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                                //set Values
                                circle.getPoint().setX(p1x);
                                circle.getPoint().setY(p1y);
                                circle.setRadius(radius);
                            shapesInterface.setEnabled(true);
                            shapesInterface.repaint();
                            setVisible(false);
                        }
                    }
                    else {
                        shapesInterface.setEnabled(true);
                        shapesInterface.repaint();
                        setVisible(false);
                    }
                break;
                case QUAD :
                    if(OK.equals(e.getActionCommand())) {
                        //read values
                        double p1x = Double.parseDouble(txtPoint1x.getText());
                        double p1y = Double.parseDouble(txtPoint1y.getText());
                        double p2x = Double.parseDouble(txtPoint2x.getText());
                        double p2y = Double.parseDouble(txtPoint2y.getText());
                        double p3x = Double.parseDouble(txtPoint3x.getText());
                        double p3y = Double.parseDouble(txtPoint3y.getText());
                        double p4x = Double.parseDouble(txtPoint4x.getText());
                        double p4y = Double.parseDouble(txtPoint4y.getText());

                        //validation
                        if(shapesInterface.collinear(p1x, p1y, p2x, p2y, p3x, p3y, p4x, p4y)){
                            JOptionPane.showMessageDialog(this, "Points can't be colineal", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            //set Points
                            quad.getPoints().get(0).setX(p1x);
                            quad.getPoints().get(0).setY(p1y);
                            quad.getPoints().get(1).setX(p2x);
                            quad.getPoints().get(1).setY(p2y);
                            quad.getPoints().get(2).setX(p3x);
                            quad.getPoints().get(2).setY(p3y);
                            quad.getPoints().get(3).setX(p4x);
                            quad.getPoints().get(3).setY(p4y);
                            shapesInterface.setEnabled(true);
                            shapesInterface.repaint();
                            setVisible(false);
                        }
                    }
                    else {
                        shapesInterface.setEnabled(true);
                        shapesInterface.repaint();
                        setVisible(false);
                    }
                break;
                case TRIANGLE :
                    if(OK.equals(e.getActionCommand())) {
                        //read values
                        double p1x = Double.parseDouble(txtPoint1x.getText());
                        double p1y = Double.parseDouble(txtPoint1y.getText());
                        double p2x = Double.parseDouble(txtPoint2x.getText());
                        double p2y = Double.parseDouble(txtPoint2y.getText());
                        double p3x = Double.parseDouble(txtPoint3x.getText());
                        double p3y = Double.parseDouble(txtPoint3y.getText());

                        //validation
                        if(shapesInterface.collinear(p1x, p1y, p2x, p2y, p3x, p3y)){
                            JOptionPane.showMessageDialog(this, "Points can't be colineal", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            //set Points
                            triangle.getPoints().get(0).setX(p1x);
                            triangle.getPoints().get(0).setY(p1y);
                            triangle.getPoints().get(1).setX(p2x);
                            triangle.getPoints().get(1).setY(p2y);
                            triangle.getPoints().get(2).setX(p3x);
                            triangle.getPoints().get(2).setY(p3y);
                            shapesInterface.setEnabled(true);
                            shapesInterface.repaint();
                            setVisible(false);
                        }
                    }
                    else {
                        shapesInterface.setEnabled(true);
                        shapesInterface.repaint();
                        setVisible(false);
                    }
                break;
            }
        }
        catch(NumberFormatException e2) {
            JOptionPane.showMessageDialog(this, "You must enter a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
