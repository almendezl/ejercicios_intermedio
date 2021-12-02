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
 * @author Angie Mendez
 */
public class PanelAsignarDocente extends JPanel {
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblEdad;
    JLabel lblDedicacion;
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtEdad;
    JTextField txtDedicacion;
    JButton btnAsignar;
    
    public PanelAsignarDocente(){
       GridLayout gl = new GridLayout(5,2);
        gl.setVgap(5);
        gl.setHgap(10);
        
        setLayout(gl);
        //instanciar componentes
        
        lblCedula = new JLabel("Numero de cedula:");
        lblNombre = new JLabel("Nombre:");
        lblEdad = new JLabel("Edad:");
        lblDedicacion = new JLabel("Dedicacion:");
        
        txtCedula = new JTextField(10);
        txtNombre = new JTextField(20);
        txtEdad = new JTextField(2);
        txtDedicacion = new JTextField(2);
        
        btnAsignar = new JButton("Asignar");
        
        //adicionarlos
        add(lblCedula);
        add(txtCedula);
        add(lblNombre);
        add(txtNombre);
        add(lblEdad);
        add(txtEdad);
        add(lblDedicacion);
        add(txtDedicacion);
        add(btnAsignar);
     
        
 
    }
    
}
