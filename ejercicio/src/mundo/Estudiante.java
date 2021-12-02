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
public abstract class Estudiante {

    private final String nombre;
    private final String id;
    private String programaAcademico;
    private Curso cursos[];

    public Estudiante(String nombre, String id, String programaAcademico, Curso cursos[]) {
        this.nombre = nombre;
        this.id = id;
        this.programaAcademico = programaAcademico;
        this.cursos = cursos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public abstract double calcularPromedio();

    //falta arreglar
    public int calcularPermanencia() {
        int creditos = 0;
        for (int i = 0; i < cursos.length; i++) {
            creditos += cursos[i].getNroCreditos();
        }
        if (creditos / 16 < 1) {
            return 1;
        } else {
            return creditos / 16;
        }
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < cursos.length; i++) {
            salida += "\n" + cursos[i].toString();

        }
        return "Estudiante: " + "Nombre -> " + nombre + ", id -> " + id + ", Programa Academico -> " + programaAcademico + ", Promedio -> " + calcularPromedio() + ", Permanencia -> "
                + calcularPermanencia() + ", Cursos ->" + salida;
    }

}
