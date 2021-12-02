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

/**
 *
 * @author SG702-21
 */
public class PanelAsignarDocente extends JPanel {
    //Atributos
    JLabel lblCedula, lblNombre, lblEdad, lblDedicacion;
    JTextField txtCedula, txtNombre, txtEdad, txtDedicacion;
    JButton btnAsignarDocente;
    
    //Constructor
    public PanelAsignarDocente(){
        GridLayout gl = new GridLayout(5,2);
        gl.setVgap(5);
        gl.setHgap(10);
        
        setLayout(gl);
        
        //Instanaciar Componentes
        lblCedula = new JLabel ("Número de cédula:");
        lblNombre =  new JLabel ("Nombre:");
        lblEdad = new JLabel ("Edad");
        lblDedicacion = new JLabel ("Dedicación");
        
        
        txtCedula = new JTextField (10);
        txtNombre = new JTextField (20);
        txtEdad = new JTextField (2);
        txtDedicacion = new JTextField (2);
    
        btnAsignarDocente = new JButton ("Asignar Docente");
        
        //Adicionar componentes
        add(lblCedula);
        add(txtCedula);
        add(lblNombre);
        add(txtNombre);
        add(lblEdad);
        add(txtEdad);
        add(lblDedicacion);
        add(txtDedicacion);
        add(btnAsignarDocente);
    }
    
    
}
