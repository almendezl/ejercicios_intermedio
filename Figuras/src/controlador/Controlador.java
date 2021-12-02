/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import mundo.Area;
import mundo.Volumen;
import vista.Contenedor;

/**
 *
 * @author Angie Mendez
 */
public class Controlador implements ActionListener {

    private final Contenedor interfaz;
    private final Area area;
    private final Volumen vol;
    private final ButtonGroup opcionFiguras;
    private final ButtonGroup opcionSeleccion;

    public Controlador() {
        interfaz = new Contenedor();
        area = new Area();
        vol = new Volumen();
        opcionFiguras = new ButtonGroup();
        opcionSeleccion = new ButtonGroup();
        
        opcionSeleccion.add(interfaz.getPnlSeleccion().getRbtArea());
        opcionSeleccion.add(interfaz.getPnlSeleccion().getRbtVolumen());

        opcionFiguras.add(interfaz.getPnlFiguras().getRbtCuadrado());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtRectangulo());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtParalelogramo());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtTrapecio());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtCirculo());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtTriangulo());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtElipse());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtCubo());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtEsfera());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtCilindro());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtCono());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtElipsoide());
        opcionFiguras.add(interfaz.getPnlFiguras().getRbtPrismaRect());

        //agregar action listener
        interfaz.getPnlFiguras().getRbtCuadrado().addActionListener(this);
        interfaz.getPnlFiguras().getRbtRectangulo().addActionListener(this);
        interfaz.getPnlFiguras().getRbtParalelogramo().addActionListener(this);
        interfaz.getPnlFiguras().getRbtTrapecio().addActionListener(this);
        interfaz.getPnlFiguras().getRbtCirculo().addActionListener(this);
        interfaz.getPnlFiguras().getRbtTriangulo().addActionListener(this);
        interfaz.getPnlFiguras().getRbtElipse().addActionListener(this);
        interfaz.getPnlFiguras().getRbtCubo().addActionListener(this);
        interfaz.getPnlFiguras().getRbtEsfera().addActionListener(this);
        interfaz.getPnlFiguras().getRbtCilindro().addActionListener(this);
        interfaz.getPnlFiguras().getRbtCono().addActionListener(this);
        interfaz.getPnlFiguras().getRbtElipsoide().addActionListener(this);
        interfaz.getPnlFiguras().getRbtPrismaRect().addActionListener(this);

        interfaz.getPnlSeleccion().getRbtVolumen().addActionListener(this);
        interfaz.getPnlSeleccion().getRbtArea().addActionListener(this);

        interfaz.getPnlDatos().getBtnResultado().addActionListener(this);
        interfaz.getPnlDatos().getBtnBorrar().addActionListener(this);
        interfaz.getPnlDatos().getBtnSalir().addActionListener(this);
    }

    public Area getArea() {
        return area;
    }

    public Volumen getVol() {
        return vol;
    }

    public ButtonGroup getOpcionFiguras() {
        return opcionFiguras;
    }

    public void iniciar() {
        interfaz.setTitle("Areas y Volumenes");
        interfaz.setVisible(true);
    }

    public Contenedor getInterfaz() {
        return interfaz;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == interfaz.getPnlSeleccion().getRbtArea()){
            interfaz.getPnlFiguras().getRbtCuadrado().setEnabled(true);
            interfaz.getPnlFiguras().getRbtRectangulo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtParalelogramo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtTrapecio().setEnabled(true);
            interfaz.getPnlFiguras().getRbtCirculo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtTriangulo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtElipse().setEnabled(true);
            interfaz.getPnlFiguras().getRbtCubo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtEsfera().setEnabled(true);
            interfaz.getPnlFiguras().getRbtCilindro().setEnabled(false);
            interfaz.getPnlFiguras().getRbtCono().setEnabled(false);
            interfaz.getPnlFiguras().getRbtElipsoide().setEnabled(false);
            interfaz.getPnlFiguras().getRbtPrismaRect().setEnabled(false);
            
        }
        if(e.getSource() == interfaz.getPnlSeleccion().getRbtVolumen()){
            interfaz.getPnlFiguras().getRbtCuadrado().setEnabled(false);
            interfaz.getPnlFiguras().getRbtRectangulo().setEnabled(false);
            interfaz.getPnlFiguras().getRbtParalelogramo().setEnabled(false);
            interfaz.getPnlFiguras().getRbtTrapecio().setEnabled(false);
            interfaz.getPnlFiguras().getRbtCirculo().setEnabled(false);
            interfaz.getPnlFiguras().getRbtTriangulo().setEnabled(false);
            interfaz.getPnlFiguras().getRbtElipse().setEnabled(false);
            interfaz.getPnlFiguras().getRbtCubo().setEnabled(true);
            interfaz.getPnlFiguras().getRbtEsfera().setEnabled(true);
            interfaz.getPnlFiguras().getRbtCilindro().setEnabled(true);
            interfaz.getPnlFiguras().getRbtCono().setEnabled(true);
            interfaz.getPnlFiguras().getRbtElipsoide().setEnabled(true);
            interfaz.getPnlFiguras().getRbtPrismaRect().setEnabled(true);
        }
       
        }
    
    private void borrar(){
        interfaz.getPnlDatos().getTxtLado().setText("");
        interfaz.getPnlDatos().getTxtBase1().setText("");
        interfaz.getPnlDatos().getTxtBase2().setText("");
        interfaz.getPnlDatos().getTxtAltura().setText("");
        interfaz.getPnlDatos().getTxtRadio1().setText("");
        interfaz.getPnlDatos().getTxtRadio2().setText("");
        interfaz.getPnlDatos().getTxtRadio3().setText("");
        interfaz.getPnlDatos().getTxtProfundidad().setText("");
    }
}
