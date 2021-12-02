/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Angie Mendez
 */
public class PanelMatricularEstudiante extends JPanel {
    private final JPanel pnlDatos;
    private final JPanel pnlNotas;
    JLabel lblId;
    JLabel lblNombre;
    JLabel lblEdad;
    JLabel lblNotasC;
    JLabel lblNotai;
    JLabel lblNotaii;
    JLabel lblNotaiii;
    JLabel lblNotaF;
    JTextField txtId;
    JTextField txtNombre;
    JTextField txtEdad;
    JTextField txtNotai;
    JTextField txtNotaii;
    JTextField txtNotaiii;
    JTextField txtNotaF;
    JButton btnMatricular;
    

    public PanelMatricularEstudiante() {

        lblId = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblEdad = new JLabel("Edad:");
        lblNotasC = new JLabel("Notas por corte:");
        lblNotai = new JLabel("I");
        lblNotaii = new JLabel("II");
        lblNotaiii = new JLabel("III");
        lblNotaF = new JLabel("NF");
        txtId = new JTextField(7);
        txtNombre  = new JTextField(20);
        txtEdad = new JTextField(2);
        txtNotai = new JTextField(3);
        txtNotaii = new JTextField(3);
        txtNotaiii = new JTextField(3);
        txtNotaF = new JTextField(3);
        btnMatricular = new JButton("Matricular");
        
        pnlDatos = new JPanel();
        pnlDatos.setLayout(new GridLayout(5,2,5,5));
        pnlDatos.add(lblId);
        pnlDatos.add(txtId);
        pnlDatos.add(lblNombre);
        pnlDatos.add(txtNombre);
        pnlDatos.add(lblEdad);
        pnlDatos.add(txtEdad);
        pnlDatos.add(lblNotasC);
        
        pnlNotas = new JPanel();
        pnlNotas.setLayout(new FlowLayout());
        pnlNotas.add(lblNotai);
        pnlNotas.add(txtNotai);
        pnlNotas.add(lblNotaii);
        pnlNotas.add(txtNotaii);
        pnlNotas.add(lblNotaiii);
        pnlNotas.add(txtNotaiii);
        pnlNotas.add(lblNotaF);
        pnlNotas.add(txtNotaF);
        
        pnlDatos.add(pnlNotas);
        pnlDatos.add(btnMatricular);
    }

    public JPanel getPnlDatos() {
        return pnlDatos;
    }

}
