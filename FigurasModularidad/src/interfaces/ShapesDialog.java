/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Angie Mendez
 */
public class ShapesDialog extends JDialog implements ActionListener{
    private static final String OK = "OK";
    private static final String CANCEL = "CANCEL";
    private static final String CIRCLE_A = "1";
    private static final String QUAD_A = "2";
    private static final String TRIANGLE_A = "3";
    private static final int CIRCLE = 1;
    private static final int QUAD = 2;
    private static final int TRIANGLE = 3;
    
    private ShapesInterface shapesInterface;
    private int shapeSelected;
    
    private JRadioButton circleButton;
    private JRadioButton quadButton;
    private JRadioButton triangleButton;
    private ButtonGroup buttonGroup;
    private JButton okButton;
    private JButton cancelButton;
    
    public ShapesDialog(ShapesInterface shapesInterface){
        this.shapesInterface = shapesInterface;
        this.shapeSelected = shapesInterface.getShapeSeleted();
        setLayout(new GridLayout(5,3));
        setTitle("Select a shape");
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
        //radioButtons
        add(new JLabel());
        circleButton = new JRadioButton("Circle", false);
        circleButton.setActionCommand(CIRCLE_A);
        add(circleButton);
        
        add(new JLabel());
        quadButton = new JRadioButton("Quad", false);
        quadButton.setActionCommand(QUAD_A);
        add(quadButton);
        
        add(new JLabel());
        triangleButton = new JRadioButton("Triangle", false);
        triangleButton.setActionCommand(TRIANGLE_A);
        add(triangleButton);
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(circleButton);
        buttonGroup.add(quadButton);
        buttonGroup.add(triangleButton);
        
        switch(shapeSelected){
            case CIRCLE:
                buttonGroup.setSelected(circleButton.getModel(), true);
                break;
            case QUAD:
                buttonGroup.setSelected(quadButton.getModel(), true);
                break;
            case TRIANGLE:
                buttonGroup.setSelected(triangleButton.getModel(), true);
                break;
        }
        
        okButton = new JButton ("OK");
        okButton.setActionCommand(OK);
        okButton.addActionListener(this);
        add(okButton);
        
        cancelButton = new JButton("CANCEL");
        cancelButton.setActionCommand(CANCEL);
        cancelButton.addActionListener(this);
        add(cancelButton);
        pack();
    }
    public void actionPerformed(ActionEvent e){
        try{
            if(OK.equals(e.getActionCommand())){
                shapesInterface.setShapeSelected(Integer.valueOf(buttonGroup.getSelection()
                .getActionCommand()).intValue());
                shapesInterface.setEnabled(true);
                shapesInterface.repaint(Integer.valueOf(buttonGroup.getSelection()
                .getActionCommand()).intValue());
                setVisible(false);
            }
            else{
                shapesInterface.setEnabled(true);
                shapesInterface.repaint();
                setVisible(false);
            }
        }
        catch(NumberFormatException e2){
            JOptionPane.showMessageDialog(this, "You must enter a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
