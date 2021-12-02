/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class Graduado extends Estudiante {
    private final String tituloAcademico;

    public Graduado(String tituloAcademico, String nombre, String id, String programaAcademico, Curso[] cursos) {
        super(nombre, id, programaAcademico, cursos);
        this.tituloAcademico = tituloAcademico;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    @Override
    public double calcularPromedio() {
        double ponderado = 0;
        int creditos = 0;
        for (int i = 0; i < super.getCursos().length; i++) {
            ponderado += (super.getCursos()[i].getNota()*super.getCursos()[i].getNroCreditos());
            creditos += super.getCursos()[i].getNroCreditos();
        }
        return ponderado/creditos;
        
    }

    @Override
    public String toString() {
        return "POSTGRADO{" + " Titulo Academico -> " + tituloAcademico + " "+super.toString()+ '}';
    }
    
}
