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
public class NoGraduado extends Estudiante {

    private int creditosAprobados;

    public NoGraduado(String nombre, String id, String programaAcademico, Curso[] cursos) {
        super(nombre, id, programaAcademico, cursos);
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i].getNota() >= 3 && cursos[i].getNota() <= 5) {
                this.creditosAprobados += cursos[i].getNroCreditos();
            }

        }
    }

    public int getCreditosAprobados() {
        return creditosAprobados;
    }

    public void setCreditosAprobados(int creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }

    public int calcularSem() {
        
        return 0;
    }

    @Override
    public double calcularPromedio() {
        double ponderado = 0;
        for (int i = 0; i < super.getCursos().length; i++) {
            if (super.getCursos()[i].getNota() >= 3 && super.getCursos()[i].getNota() <= 5) {
                ponderado += (super.getCursos()[i].getNota() * super.getCursos()[i].getNroCreditos());
            }
        }
        if (creditosAprobados == 0) {
            return 0;
        } else {
            return ponderado / creditosAprobados;
        }
    }

    @Override
    public String toString() {
        return "PREGRADO{ " + super.toString() + " Creditos Aprobados -> " + creditosAprobados + ", Semestre -> " + calcularSem() + '}';
    }

}
