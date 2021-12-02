/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author SG702-21
 */
public class Curso {
    private final String nombre;
    private Docente profesor;
    private ArrayList <Estudiante> estudiantes;

    public Curso(String nombre, Docente profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
        estudiantes = new ArrayList<Estudiante>();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the profesor
     */
    public Docente getProfesor() {
        return profesor;
    }

    /**
     * @param profesor the profesor to set
     */
    public void setProfesor(Docente profesor) {
        this.profesor = profesor;
    }

    /**
     * @return the estudiantes
     */
    public ArrayList <Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * @param estudiantes the estudiantes to set
     */
    public void setEstudiantes(ArrayList <Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    public void matricular(Estudiante e){
        if(!estudiantes.contains(e))
            estudiantes.add(e);
    }
    
    public void desmatricular(Estudiante e){
        estudiantes.remove(e);
    }        
    
}
