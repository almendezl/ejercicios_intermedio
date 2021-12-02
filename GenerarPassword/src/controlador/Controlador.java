/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mundo.GenerarPassword;
import vista.Contenedor;

/**
 *
 * @author Angie Mendez
 */
public class Controlador implements ActionListener {

    private final Contenedor interfaz;
    private GenerarPassword generarPass;

    public Controlador() {
        interfaz = new Contenedor();
        /**
         * AGREGAR ACTIONLISTENER AL BOTON GENERAR
         */
        interfaz.getPnlGenerar().getBtnGenerar().addActionListener(this);
        interfaz.getPnlGenerar().getBtnBorrar().addActionListener(this);
        interfaz.getPnlGenerar().getBtnSalir().addActionListener(this);
    }

    public void iniciar() {
        interfaz.setTitle("Calculadora");
        interfaz.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == interfaz.getPnlGenerar().getBtnGenerar()) {
                /**
                 * ENVIA LOS DATOS A LA CLASE GENERAR PASSWORD
                 */
                generarPass = new GenerarPassword(interfaz.getPnlGenerar().getTxtNumeros().getText(), interfaz.getPnlGenerar().getTxtLetras().getText());
                /**
                 * MUESTRA LA LONGITUD
                 */
                interfaz.getPnlGenerar().getLblLong().setText(String.valueOf(generarPass.getLongitud()));

                /**
                 * TRAE EL PASSWORD GENERADO Y LO MUESTRA
                 */
                interfaz.getPnlGenerar().getTxtPassword().setText(generarPass.generarPassword());

            }
            if (e.getSource() == interfaz.getPnlGenerar().getBtnBorrar()) {
                interfaz.getPnlGenerar().getTxtLetras().setText("");
                interfaz.getPnlGenerar().getTxtNumeros().setText("");
                interfaz.getPnlGenerar().getLblLong().setText("");
                interfaz.getPnlGenerar().getTxtPassword().setText("");
            }
            if (e.getSource() == interfaz.getPnlGenerar().getBtnSalir()) {
                int resultado = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?");
                if (resultado == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "Datos invalidos, intente nuevamente!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
