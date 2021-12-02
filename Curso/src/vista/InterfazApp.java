/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp extends JFrame {
    private PanelCrearCurso pnlCrearCurso;
    private PanelAsignarDocente pnlAsignarDocente;
    private PanelMatricularEstudiante pnlMatricularEstudiante;

    public InterfazApp(String titulo) {
        super(titulo);
        Container c = getContentPane();
        c.setLayout(null);
        setBounds(100,100,600,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //instanciar los paneles
        pnlCrearCurso = new PanelCrearCurso();
        pnlCrearCurso.setBounds(10, 10,550,60);
        
        pnlAsignarDocente = new PanelAsignarDocente();
        pnlAsignarDocente.setBounds(10, 80, 550, 160);
        
        
        pnlMatricularEstudiante = new PanelMatricularEstudiante();
        pnlMatricularEstudiante.getPnlDatos().setBounds(10,270,550,160);
        //pnlMatricularEstudiante.getPnlNotas().setBounds(20,390,550,160);
        
        //agregar los paneles en el contenedor
        c.add(pnlCrearCurso);
        c.add(pnlAsignarDocente);
        c.add(pnlMatricularEstudiante.getPnlDatos());
       // c.add(pnlMatricularEstudiante.getPnlNotas());
    }
   
    
}
