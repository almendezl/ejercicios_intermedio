/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp extends JFrame {
    private Container contenedor;
    
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;
    private JLabel lblNumero1;
    private JLabel lblNumero2;
    private JLabel lblResultado;
    public JButton btnSumar;
    
    
    public InterfazApp(String titulo){
        //caracteristicas del contenedor
        super(titulo);
        setLayout(new FlowLayout());
        contenedor = getContentPane();
        setSize(150,220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instanciar los componentes
        txtNumero1 = new JTextField("",10);
        txtNumero2 = new JTextField("",10);
        txtResultado = new JTextField("",10);
        lblNumero1 = new JLabel("Primer operando: ");
        lblNumero2 = new JLabel("Segundo operando:");
        lblResultado = new JLabel("Resultado");
        btnSumar = new JButton("Sumar");
        
        //agregar
        contenedor.add(lblNumero1);
        contenedor.add(txtNumero1);
        
        contenedor.add(lblNumero2);
        contenedor.add(txtNumero2);
        
        contenedor.add(lblResultado);
        contenedor.add(txtResultado);
        
        contenedor.add(btnSumar);
        
        //integrar el controlador
        setVisible(true);
    }

    public String getNumero1(){
        return txtNumero1.getText();
    }
    
    public String getNumero2(){
        return txtNumero2.getText();
    }
    
    public void setResultado(String resultado){
        txtResultado.setText(resultado);
    }
    
}
