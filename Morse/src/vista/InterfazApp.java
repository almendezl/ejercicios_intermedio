/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp extends JFrame {

    private final PanelBotones pnlBotones;
    private final PanelTexto pnlTexto;
    private final PanelCodigoMorse pnlCodigoMorse;

    public InterfazApp() {
        //super(titulo);
        Container c = getContentPane();
        c.setLayout(null);
        setBounds(350, 180, 1300, 360);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnlTexto = new PanelTexto();
        pnlTexto.setBounds(10, 10, 400, 190);
        pnlBotones = new PanelBotones();
        pnlBotones.setBounds(10, 220, 400, 90);
        pnlCodigoMorse = new PanelCodigoMorse();
        pnlCodigoMorse.setBounds(420,10,860,300);
        pnlCodigoMorse.setBackground(Color.WHITE);

        c.add(pnlTexto);
        c.add(pnlBotones);
        c.add(pnlCodigoMorse);
    }

    public PanelBotones getPnlBotones() {
        return pnlBotones;
    }

 
    public PanelTexto getPnlTexto() {
        return pnlTexto;
    }

    public PanelCodigoMorse getPnlCodigoMorse() {
        return pnlCodigoMorse;
    }

}
