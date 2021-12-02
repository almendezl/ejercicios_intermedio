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
public class PanelSeleccion1 extends JPanel{
    
    private final JRadioButton rbtLongitud;
    private final JRadioButton rbtMasa;
    private final JRadioButton rbtTiempo;
    private final JRadioButton rbtTemperatura;
    
    public PanelSeleccion1(){
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Seleccion de unidad a convertir")));
        GridLayout gl = new GridLayout(2,2);
        gl.setVgap(3);
        gl.setHgap(3);
        setLayout(gl);
        
        rbtLongitud = new JRadioButton("Longitud");
        rbtMasa = new JRadioButton("Masa");
        rbtTiempo = new JRadioButton("Tiempo");
        rbtTemperatura = new JRadioButton("Temperatura");
        
        add(rbtLongitud);
        add(rbtMasa);
        add(rbtTiempo);
        add(rbtTemperatura);
    }

    public JRadioButton getRbtLongitud() {
        return rbtLongitud;
    }

    public JRadioButton getRbtMasa() {
        return rbtMasa;
    }

    public JRadioButton getRbtTiempo() {
        return rbtTiempo;
    }

    public JRadioButton getRbtTemperatura() {
        return rbtTemperatura;
    }
    
}
