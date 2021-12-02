/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Angie Mendez
 */
public class PanelTiempo extends JPanel {

    private final JRadioButton rbtSegundos;
    private final JRadioButton rbtMinutos;
    private final JRadioButton rbtHoras;
    private final JRadioButton rbtDias;
    private final JRadioButton rbtMeses;
    private final JRadioButton rbtAnios;

    public PanelTiempo() {
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Unidad")));
        GridLayout gl = new GridLayout(3, 2);

        rbtSegundos = new JRadioButton("Segundos");
        rbtMinutos = new JRadioButton("Minutos");
        rbtHoras = new JRadioButton("Horas");
        rbtDias = new JRadioButton("Dias");
        rbtMeses = new JRadioButton("Meses");
        rbtAnios = new JRadioButton("Años");

        add(rbtSegundos);
        add(rbtMinutos);
        add(rbtHoras);
        add(rbtDias);
        add(rbtMeses);
        add(rbtAnios);
    }

    public JRadioButton getRbtSegundos() {
        return rbtSegundos;
    }

    public JRadioButton getRbtMinutos() {
        return rbtMinutos;
    }

    public JRadioButton getRbtHoras() {
        return rbtHoras;
    }

    public JRadioButton getRbtDias() {
        return rbtDias;
    }

    public JRadioButton getRbtMeses() {
        return rbtMeses;
    }

    public JRadioButton getRbtAnios() {
        return rbtAnios;
    }

}
