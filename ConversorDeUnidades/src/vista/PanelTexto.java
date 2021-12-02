/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
public class PanelTexto extends JPanel{
    private final JTextField txtDato;
    private final JButton btnConvertir;
    private final JButton btnBorrar;
    private final JButton btnSalir;
    private final JLabel lblValor;
    private  JLabel lblResultado;
    
    public PanelTexto(){
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Entrada y salida de datos")));
        GridLayout gl = new GridLayout(3,3);
        gl.setVgap(3);
        gl.setHgap(3);
        setLayout(gl);
        
        lblValor = new JLabel("Valor");
        txtDato = new JTextField(10);
        btnConvertir= new JButton("Convertir →");
        btnBorrar = new JButton("Borrar");
        btnSalir = new JButton("Salir");
        lblResultado = new JLabel("");
        
        add(lblValor);
        add(txtDato);
        add(btnConvertir);
        add(lblResultado);
        add(btnBorrar);
        add(btnSalir);
    }

    public JLabel getLblValor() {
        return lblValor;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public void setLblResultado(JLabel lblResultado) {
        this.lblResultado = lblResultado;
    }

    public JTextField getTxtDato() {
        return txtDato;
    }

    public JButton getBtnConvertir() {
        return btnConvertir;
    }

    public JLabel getLblResultado() {
        return lblResultado;
    }
    
}
