/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Angie Mendez
 */
public class Contenedor extends JFrame{
 private PanelFiguras pnlFiguras;
 private PanelDatos pnlDatos;
 private PanelSeleccion pnlSeleccion;
 
    public Contenedor(){
        Container c = getContentPane();
        c.setLayout(null);
        setBounds(300, 300, 720, 430);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlFiguras = new PanelFiguras();
        pnlFiguras.setBounds(110, 10,590,130);
        pnlDatos = new PanelDatos ();
        pnlDatos.setBounds(10,150,380,230 );
        pnlSeleccion = new PanelSeleccion();
        pnlSeleccion.setBounds(10,10,90,130);
        
        c.add(pnlFiguras);
        c.add(pnlDatos);
        c.add(pnlSeleccion);
    }

    public PanelDatos getPnlDatos() {
        return pnlDatos;
    }

    public PanelSeleccion getPnlSeleccion() {
        return pnlSeleccion;
    }
    

    public PanelFiguras getPnlFiguras() {
        return pnlFiguras;
    }

    public void setPnlFiguras(PanelFiguras pnlFiguras) {
        this.pnlFiguras = pnlFiguras;
    }
    
}
