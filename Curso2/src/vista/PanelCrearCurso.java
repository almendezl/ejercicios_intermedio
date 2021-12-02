/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author SG702-21
 */
public class PanelCrearCurso extends JPanel{
    //Atributos
    JLabel lblNombre;
    JTextField txtNombre;
    JButton btnCrearCurso;
    
    //Constructor
    public PanelCrearCurso(){
        setLayout(new FlowLayout());
        
        //Instanciar componentes
        lblNombre = new JLabel("Nombre del Curso:");
        txtNombre = new JTextField(30);
        btnCrearCurso = new JButton("Crear");
        
        //Adicionar componentes
        add(lblNombre);
        add(txtNombre);
        add(btnCrearCurso);
    }
}
