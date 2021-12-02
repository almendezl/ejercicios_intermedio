/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Angie Mendez
 */
public class PanelGenerarPassword extends JPanel{
    private final JLabel lblLetras;
    private final JLabel lblNumeros;
    private final JLabel lblLongitud;
    private JLabel lblLong;
    private  JTextField txtPassword;
    private final JTextField txtLetras;
    private final JTextField txtNumeros;
    private final JButton btnGenerar;
    private final JButton btnBorrar;
    private final JButton btnSalir;
    
    public PanelGenerarPassword(){
          /**
         * SE AGREGA BORDE, TITULO Y ESTILO AL PANEL
         */
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("")));
        GridLayout gl = new GridLayout(5,2);
        gl.setVgap(2);
        gl.setHgap(5);
        setLayout(gl);
        
        int font = Font.ROMAN_BASELINE;
        lblLetras = new JLabel(" Cantidad de Letras →");
        lblLetras.setFont(new Font("Serif",font, 16));
        lblNumeros = new JLabel(" Cantidad de Numeros →");
        lblNumeros.setFont(new Font("Serif",font, 16));
        lblLongitud = new JLabel(" Longitud →");
        lblLongitud.setFont(new Font("Serif",font, 16));
        txtPassword = new JTextField("");
        txtPassword.setFont(new Font("Serif",font, 16));
        lblLong = new JLabel("");
        lblLong.setFont(new Font("Serif",font, 16));
        txtLetras = new JTextField(3);
        txtLetras.setFont(new Font("Serif",font, 16));
        txtNumeros = new JTextField(3);
        txtNumeros.setFont(new Font("Serif",font, 16));
        btnGenerar = new JButton("Generar →");
        btnGenerar.setFont(new Font("Serif",font, 16));
        btnBorrar = new JButton("Borrar");
        btnBorrar.setFont(new Font("Serif",font, 16));
        btnBorrar.setBackground(Color.getHSBColor(100, 30,60));
        btnSalir = new JButton ("Salir");
        btnSalir.setBackground(Color.getHSBColor(100, 30,60));
        btnSalir.setFont(new Font("Serif",font, 16));
        
        add(lblLetras);
        add(txtLetras);
        add(lblNumeros);
        add(txtNumeros);
        add(lblLongitud);
        add(lblLong);
        add(btnGenerar);
        add(txtPassword);
        add(btnBorrar);
        add(btnSalir);
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        this.txtPassword = txtPassword;
    }

    public JLabel getLblLetras() {
        return lblLetras;
    }

    public JLabel getLblNumeros() {
        return lblNumeros;
    }

    public JLabel getLblLongitud() {
        return lblLongitud;
    }

    public JTextField getTxtLetras() {
        return txtLetras;
    }

    public JTextField getTxtNumeros() {
        return txtNumeros;
    }

    public JLabel getLblLong() {
        return lblLong;
    }

    public void setLblLong(JLabel lblLong) {
        this.lblLong = lblLong;
    }

    public JButton getBtnGenerar() {
        return btnGenerar;
    }
    
}
