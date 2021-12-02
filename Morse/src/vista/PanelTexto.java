/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
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
public class PanelTexto extends JPanel {
    private final JLabel lblLetras;
    private final JLabel lblMorse;
    private JTextField txtLetras;
    private JTextField txtMorse; 
    
    public PanelTexto(){
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Entrada y salida de datos" ) ) );
        GridLayout gl = new GridLayout(5,2);
        gl.setVgap(5);
        gl.setHgap(10);
        setLayout(gl);
        
        lblLetras = new JLabel("Letras:");
        lblMorse = new JLabel("Codigo Morse:");
        txtLetras = new JTextField (50);
       txtMorse = new JTextField (200);

        add(lblLetras);
        add(txtLetras);
        add(lblMorse);
        add(txtMorse);
    }

    public JTextField getTxtLetras() {
        return txtLetras;
    }

    public void setTxtLetras(JTextField txtLetras) {
        this.txtLetras = txtLetras;
    }

    public JTextField getTxtMorse() {
        return txtMorse;
    }

    public void setTxtMorse(JTextField txtMorse) {
        this.txtMorse = txtMorse;
    }

}
