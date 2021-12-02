/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Angie Mendez
 */
public class PanelSeleccion extends JPanel {
    private JRadioButton rbtVolumen;
    private JRadioButton rbtArea;
   
    
    public PanelSeleccion(){
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Seleccion")));
        GridLayout gl = new GridLayout(2,2);
        gl.setVgap(3);
        gl.setHgap(5);
        setLayout(gl);
        
        rbtVolumen = new JRadioButton("Volumen");
        rbtArea = new JRadioButton ("Area");
        
        add(rbtVolumen);
        add(rbtArea);
    }

    public JRadioButton getRbtVolumen() {
        return rbtVolumen;
    }

    public JRadioButton getRbtArea() {
        return rbtArea;
    }
    
}
