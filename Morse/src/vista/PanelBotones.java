/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Angie Mendez
 */
public class PanelBotones extends JPanel {

    private final JButton btnLetras;
    private final JButton btnMorse;
    private final JButton btnSalir;
    private final JButton btnBorrar;

    public PanelBotones() {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("  Convertir ")));
        setLayout(new FlowLayout());

        btnLetras = new JButton("Morse → Letras");
        btnMorse = new JButton("Letras → Morse");
        btnSalir = new JButton(" Salir ");
        btnBorrar = new JButton("Borrar");
        
        add(btnLetras);
        add(btnMorse);
        add(btnBorrar);
        add(btnSalir);

    }

    public JButton getBtnLetras() {
        return btnLetras;
    }

    public JButton getBtnMorse() {
        return btnMorse;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

}
