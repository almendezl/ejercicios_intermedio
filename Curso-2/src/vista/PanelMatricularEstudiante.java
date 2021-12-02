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
 * @author SG701-21
 */
public class PanelMatricularEstudiante extends JPanel{
        //Atributos
    JLabel lblId, lblNombre, lblEdad, lblNotas, lblCorte1,lblCorte2,lblCorte3;
    JTextField txtId, txtNombre, txtEdad, txtCorte1, txtCorte2, txtCorte3;
    JButton btnMatricularEstudiante;
    
    //Constructor
    public PanelMatricularEstudiante(){
        GridLayout gl = new GridLayout(7,2);
        gl.setVgap(5);
        gl.setHgap(10);
        
        setLayout(gl);
        
        //Instanaciar Componentes
        lblId = new JLabel ("Número de Id:");
        lblNombre =  new JLabel ("Nombre:");
        lblEdad = new JLabel ("Edad");
        lblNotas = new JLabel ("Notas");
        lblCorte1 = new JLabel ("Corte1");
        lblCorte2 = new JLabel ("Corte2");
        lblCorte3 = new JLabel ("Corte3");
        
        
        txtId = new JTextField (10);
        txtNombre = new JTextField (20);
        txtEdad = new JTextField (2);
        txtCorte1 = new JTextField (4);
        txtCorte2 = new JTextField (4);
        txtCorte3 = new JTextField (4);
    
        btnMatricularEstudiante = new JButton ("Matricular Estudiante");
        
        //Adicionar componentes
        add(lblId);
        add(txtId);
        add(lblNombre);
        add(txtNombre);
        add(lblEdad);
        add(txtEdad);
        //add(lblNotas);
        add(lblCorte1);        
        add(txtCorte1);
        add(lblCorte2);        
        add(txtCorte2);
        add(lblCorte3);        
        add(txtCorte3);
        add(btnMatricularEstudiante);
    }
}
