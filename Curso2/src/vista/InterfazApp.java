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
 * @author SG702-21
 */
public class InterfazApp extends JFrame{
    //Relaciones
    private PanelCrearCurso pnlCrearCurso;
    private PanelAsignarDocente pnlAsignarDocente;
    
    //Constructor
    public InterfazApp (String title){
      //Propiedades de la interfaz
      super(title);
      Container c = getContentPane();
      c.setLayout(null);
      //setSize(600,400); //tamaño X,Y
      setBounds(100,100,600,400);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Instanciar los paneles
      pnlCrearCurso = new PanelCrearCurso();
      pnlCrearCurso.setBounds(10, 10, 550, 60);
      
      pnlAsignarDocente = new PanelAsignarDocente();
      pnlAsignarDocente.setBounds(10, 80, 550, 160);
      
      
      //Adicionar los paneles
      c.add(pnlCrearCurso);
      c.add(pnlAsignarDocente);
    }
}
