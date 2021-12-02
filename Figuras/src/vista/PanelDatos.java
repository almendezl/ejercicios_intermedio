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
public class PanelDatos extends JPanel {
//ingreso de datos

    private JTextField txtLado;
    private JTextField txtBase1;
    private JTextField txtBase2;
    private JTextField txtAltura;
    private JTextField txtRadio1;
    private JTextField txtRadio2;
    private JTextField txtRadio3;
    private JTextField txtProfundidad;
    private JLabel lblLado;
    private JLabel lblBase1;
    private JLabel lblBase2;
    private JLabel lblAltura;
    private JLabel lblRadio1;
    private JLabel lblRadio2;
    private JLabel lblRadio3;
    private JLabel lblProfundidad;

    //salida de datos
    private JButton btnResultado;
    private JLabel lblResultado;
    private final JButton btnSalir;
    private final JButton btnBorrar;

    public PanelDatos() {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Entrada y salida de datos")));
        GridLayout gl = new GridLayout(10, 2);
        gl.setVgap(3);
        gl.setHgap(5);
        setLayout(gl);
        
        //ingreso de datos
        txtLado = new JTextField();
        txtLado.setEditable(false);
        txtBase1 = new JTextField();
        txtBase1.setEditable(false);
        txtBase2 = new JTextField();
        txtBase2.setEditable(false);
        txtAltura = new JTextField();
        txtAltura.setEditable(false);
        txtRadio1 = new JTextField();
        txtRadio1.setEditable(false);
        txtRadio2 = new JTextField();
        txtRadio2.setEditable(false);
        txtRadio3 = new JTextField();
        txtRadio3.setEditable(false);
        txtProfundidad = new JTextField();
        txtProfundidad.setEditable(false);
        
        lblLado = new JLabel("Lado →");
        lblLado.setEnabled(false);
        lblBase1 = new JLabel("Base →");
        lblBase1.setEnabled(false);
        lblBase2 = new JLabel("Base 2 →");
        lblBase2.setEnabled(false);
        lblAltura = new JLabel("Altura →");
        lblAltura.setEnabled(false);
        lblRadio1 = new JLabel("Radio →");
        lblRadio1.setEnabled(false);
        lblRadio2 = new JLabel("Radio 2 →");
        lblRadio2.setEnabled(false);
        lblRadio3 = new JLabel("Radio 3 →");
        lblRadio3.setEnabled(false);
        lblProfundidad = new JLabel("Profundidad →");
        lblProfundidad.setEnabled(false);

        //salida de datos
        btnResultado = new JButton("Resultado →");
        lblResultado = new JLabel();
        btnSalir = new JButton("Salir");
        btnBorrar = new JButton("Borrar");
        // lblResultado.setVisible(false);

        add(lblLado);
        add(txtLado);
        add(lblBase1);
        add(txtBase1);
        add(lblBase2);
        add(txtBase2);
        add(lblAltura);
        add(txtAltura);
        add(lblRadio1);
        add(txtRadio1);
        add(lblRadio2);
        add(txtRadio2);
        add(lblRadio3);
        add(txtRadio3);
        add(lblProfundidad);
        add(txtProfundidad);

        add(btnResultado);
        add(lblResultado);
        add(btnBorrar);
        add(btnSalir);
    }

    public JTextField getTxtLado() {
        return txtLado;
    }

    public void setTxtLado(JTextField txtLado) {
        this.txtLado = txtLado;
    }

    public JTextField getTxtBase1() {
        return txtBase1;
    }

    public void setTxtBase1(JTextField txtBase1) {
        this.txtBase1 = txtBase1;
    }

    public JTextField getTxtBase2() {
        return txtBase2;
    }

    public void setTxtBase2(JTextField txtBase2) {
        this.txtBase2 = txtBase2;
    }

    public JTextField getTxtAltura() {
        return txtAltura;
    }

    public void setTxtAltura(JTextField txtAltura) {
        this.txtAltura = txtAltura;
    }

    public JTextField getTxtRadio1() {
        return txtRadio1;
    }

    public void setTxtRadio1(JTextField txtRadio1) {
        this.txtRadio1 = txtRadio1;
    }

    public JTextField getTxtRadio2() {
        return txtRadio2;
    }

    public void setTxtRadio2(JTextField txtRadio2) {
        this.txtRadio2 = txtRadio2;
    }

    public JTextField getTxtRadio3() {
        return txtRadio3;
    }

    public void setTxtRadio3(JTextField txtRadio3) {
        this.txtRadio3 = txtRadio3;
    }

    public JTextField getTxtProfundidad() {
        return txtProfundidad;
    }

    public void setTxtProfundidad(JTextField txtProfundidad) {
        this.txtProfundidad = txtProfundidad;
    }

    public JLabel getLblLado() {
        return lblLado;
    }

    public void setLblLado(JLabel lblLado) {
        this.lblLado = lblLado;
    }

    public JLabel getLblBase1() {
        return lblBase1;
    }

    public void setLblBase1(JLabel lblBase1) {
        this.lblBase1 = lblBase1;
    }

    public JLabel getLblBase2() {
        return lblBase2;
    }

    public void setLblBase2(JLabel lblBase2) {
        this.lblBase2 = lblBase2;
    }

    public JLabel getLblAltura() {
        return lblAltura;
    }

    public void setLblAltura(JLabel lblAltura) {
        this.lblAltura = lblAltura;
    }

    public JLabel getLblRadio1() {
        return lblRadio1;
    }

    public void setLblRadio1(JLabel lblRadio1) {
        this.lblRadio1 = lblRadio1;
    }

    public JLabel getLblRadio2() {
        return lblRadio2;
    }

    public void setLblRadio2(JLabel lblRadio2) {
        this.lblRadio2 = lblRadio2;
    }

    public JLabel getLblRadio3() {
        return lblRadio3;
    }

    public void setLblRadio3(JLabel lblRadio3) {
        this.lblRadio3 = lblRadio3;
    }

    public JLabel getLblProfundidad() {
        return lblProfundidad;
    }

    public void setLblProfundidad(JLabel lblProfundidad) {
        this.lblProfundidad = lblProfundidad;
    }

    public JButton getBtnResultado() {
        return btnResultado;
    }

    public void setBtnResultado(JButton btnResultado) {
        this.btnResultado = btnResultado;
    }

    public JLabel getLblResultado() {
        return lblResultado;
    }

    public void setLblResultado(JLabel lblResultado) {
        this.lblResultado = lblResultado;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

}
