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
public class Curso {
    private final String nombre;
    private final double nota;
    private final int nroCreditos;

    public Curso(String nombre, double nota, int nroCreditos) {
        this.nombre = nombre;
        this.nota = nota>=0 && nota <=5 ? nota : 0;
        this.nroCreditos = nroCreditos>=1 && nroCreditos <=4 ? nroCreditos : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    public int getNroCreditos() {
        return nroCreditos;
    }

    @Override
    public String toString() {
        return "Curso{" + "Nombre curso -> " + nombre + ", Nota del curso -> " + nota + ", Numero de creditos -> " + nroCreditos ;
    }
    
    
}
