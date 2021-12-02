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
public class Contenedor extends JFrame {
    private final PanelTexto pnlTexto;
    private final PanelSeleccion1 pnlSel;
    private final PanelTiempo pnlTiempo;

    public Contenedor() {
        Container c = getContentPane();
        c.setLayout(null);
        setBounds(500, 300, 630, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlTexto = new PanelTexto();
        pnlTexto.setBounds(10,10,360,110);
        pnlSel = new PanelSeleccion1();
        pnlSel.setBounds(380,10,230,110);
        pnlTiempo = new PanelTiempo();
        pnlTiempo.setBounds(10,130,600,80);
        c.add(pnlTexto);
        c.add(pnlSel);
        c.add(pnlTiempo);
    }
}
