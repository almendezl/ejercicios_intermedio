/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Importar paquetes del mundo y de la vista*/
import mundo.*;
import vista.*;

/**
 *
 * @author SG702-21
 */
public class Controlador implements ActionListener{
    /*Atributos controlables de la vista*/
    private PanelCrearCurso pnlCrearCurso;
    private PanelAsignarDocente pnlAsignarDocente;
    private PanelMatricularEstudiante pnlMatricularEstudiante;
    
    /*Atributos del mundo*/
    private Curso curso;
    private Docente docente;
    private Estudiante estudiante;
    
    public Controlador(){
        
    }
    
    /*Conectar las referencias de los objetos a controlar en la vista*/
    public void conectar(PanelCrearCurso pnlCrearCurso,PanelAsignarDocente pnlAsignarDocente,PanelMatricularEstudiante pnlMatricularEstudiante){
        this.pnlCrearCurso=pnlCrearCurso;
        this.pnlAsignarDocente=pnlAsignarDocente;
        this.pnlMatricularEstudiante=pnlMatricularEstudiante;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
