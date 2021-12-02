/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mundo.Convertidor;
import vista.InterfazApp;

/**
 *
 * @author Angie Mendez
 */
public class Controlador implements ActionListener {

    private final InterfazApp interfaz;
    private final Convertidor convertidor;

    public Controlador(InterfazApp interfaz, Convertidor convertidor) {
        this.interfaz = interfaz;
        this.convertidor = convertidor;
        //a cada boton le asigno el action listener 
        this.interfaz.getPnlBotones().getBtnLetras().addActionListener(this);
        this.interfaz.getPnlBotones().getBtnMorse().addActionListener(this);
        this.interfaz.getPnlBotones().getBtnBorrar().addActionListener(this);
        this.interfaz.getPnlBotones().getBtnSalir().addActionListener(this);
        
        this.convertidor.llenarTabla();
        
        for (int i = 0; i < this.convertidor.getArrayTabla().length; i++) {
            for (int j = 0; j < this.convertidor.getArrayTabla()[i].length; j++) {
                this.interfaz.getPnlCodigoMorse().add(new JLabel(this.convertidor.getArrayTabla()[i][j]));
            }
        }

    }

    public void iniciar() {
        interfaz.setTitle("Codigo Morse ↔ Alfabeto Español");
        interfaz.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == interfaz.getPnlBotones().getBtnMorse()) {
            convertidor.setTexto(interfaz.getPnlTexto().getTxtLetras().getText());
            interfaz.getPnlTexto().getTxtMorse().setText(convertidor.convertirMorse());
        }
        if (e.getSource() == interfaz.getPnlBotones().getBtnLetras()) {
            convertidor.setTexto(interfaz.getPnlTexto().getTxtMorse().getText());
            interfaz.getPnlTexto().getTxtLetras().setText(convertidor.convertirTexto());
        }
        if (e.getSource() == interfaz.getPnlBotones().getBtnSalir()) {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?");
            if (resultado == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        }
        if (e.getSource() == interfaz.getPnlBotones().getBtnBorrar()) {
            convertidor.setTexto("");
            interfaz.getPnlTexto().getTxtMorse().setText("");
            interfaz.getPnlTexto().getTxtLetras().setText("");
        }
    }

}
