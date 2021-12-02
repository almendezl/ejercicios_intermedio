/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Angie Mendez
 */
public class Contenedor extends JFrame{
    private final PanelGenerarPassword pnlGenerar;
    private final JLabel lblMarca;
    public Contenedor(){
     Container c = getContentPane();
     
        ImageIcon icono = new ImageIcon( "data/logo.png" );
        JLabel imagen;
        imagen = new JLabel(" ");
        imagen.setIcon( icono );
        add( imagen );
        
        c.setLayout(null);
        setBounds(400, 300, 780, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlGenerar = new PanelGenerarPassword();
        pnlGenerar.setBounds(10, 10, 500,130);
        lblMarca = new JLabel("Generator 1.0");
        lblMarca.setBounds(680,115,80,80);
        imagen.setBounds(520, 10,600,130);
        
        c.add(pnlGenerar);
        c.add(lblMarca);
        
    }

    public PanelGenerarPassword getPnlGenerar() {
        return pnlGenerar;
    }
    
}
