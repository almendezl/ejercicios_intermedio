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
 * @author Angie Mendez
 */
public class PanelCrearCurso extends JPanel{
    //atributos
    JLabel lblNombreCurso;
    JButton btnCrearCurso;
    JTextField txtNombreCurso;
//constructor
    public PanelCrearCurso() {
        setLayout(new FlowLayout());
        //instanciar los componente
        
        lblNombreCurso = new JLabel("Nombre del curso: ");
        btnCrearCurso = new JButton("Crear");
        txtNombreCurso = new JTextField(20);
        
        //adicionar los componentes
        add(lblNombreCurso);
        add(txtNombreCurso);
        add(btnCrearCurso);
    }
    
    
}
