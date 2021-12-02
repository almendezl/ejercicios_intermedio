/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author SG702-21
 */
public class InterfazApp extends JFrame{
    /*Relaciones*/
    private PanelCrearCurso pnlCrearCurso;
    private PanelAsignarDocente pnlAsignarDocente;
    private PanelMatricularEstudiante pnlMatricularEstudiante;
    
    /*Atributo de tipo Controlador*/
    private Controlador ctrl;
    
    /*Constructor*/
    public InterfazApp (String title, Controlador ctrl){
      /*Propiedades de la interfaz*/
      super(title);
      Container c = getContentPane();
      c.setLayout(null);
      setBounds(100,100,600,500);  //setSize(600,500); //tamaño X,Y
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      /*Instanciar los paneles*/
      pnlCrearCurso = new PanelCrearCurso();
      pnlCrearCurso.setBounds(10, 10, 550, 50);
      
      pnlAsignarDocente = new PanelAsignarDocente();
      pnlAsignarDocente.setBounds(10, 60, 550, 150);
      
      pnlMatricularEstudiante = new PanelMatricularEstudiante();
      pnlMatricularEstudiante.setBounds(10, 220, 550, 200);
      
      /*Adicionar los paneles*/
      c.add(pnlCrearCurso);
      c.add(pnlAsignarDocente);
      c.add(pnlMatricularEstudiante);
      
      /*Integra el controlador y contecta objetos al controlador*/
      this.ctrl=ctrl;
      ctrl.conectar(pnlCrearCurso,pnlAsignarDocente,pnlMatricularEstudiante);
    }
}
