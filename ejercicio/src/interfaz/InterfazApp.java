/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import mundo.*;
import java.util.Scanner;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp {

    public static void main(String[] args) {

        Scanner datos = new Scanner(System.in);
        Estudiante estudiantes[];
        int nroEstudiantes;

        System.out.println("Numero de estudiantes a ingresar: ");
        nroEstudiantes = datos.nextInt();
        estudiantes = new Estudiante[nroEstudiantes];
        for (int i = 0; i < estudiantes.length; i++) {
            String nomEst;
            String id;
            String progAcad;
            int tipoEst;
            int numCursos;
            Curso cursos[];

            System.out.println("Nombre del estudiante " + (i + 1) + " :");
            nomEst = datos.next();
            System.out.println("Ingrese el id del estudiante " + (i + 1) + " :");
            id = datos.next();
            System.out.println("El programa academico es de: \n1. para PREGRADO \n 2. para POSTGRADO");
            tipoEst = datos.nextInt();
            System.out.println("Nombre del programa academico que cursa: ");
            progAcad = datos.next();

            switch (tipoEst) {
                case 1:
                    System.out.println("Ingrese el numero de cursos: ");
                    numCursos = datos.nextInt();
                    if (numCursos >= 1 && numCursos <= 48) {
                        cursos = llenarCursos(numCursos);

                        estudiantes[i] = new NoGraduado(nomEst, id, progAcad, cursos);
                    } else {
                        System.out.println("Error numero de cursos");
                    }
                    break;
                case 2:
                    String tituloAcad;

                    System.out.println("Ingrese el nombre del titulo academico culminado :");
                    tituloAcad = datos.next();
                    System.out.println("Ingrese el numero de cursos: ");
                    numCursos = datos.nextInt();
                    if (numCursos >= 1 && numCursos <= 10) {
                        cursos = llenarCursos(numCursos);

                        estudiantes[i] = new Graduado(tituloAcad, nomEst, id, progAcad, cursos);
                    } else {
                        System.out.println("Error numero de cursos");
                    }
                    break;
                default:
                    System.out.println("Error de tipo de estudiante!!");
                    System.exit(0);
                    break;
            }
        }
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("\n"+estudiantes[i].toString());

        }

    }

    public static Curso[] llenarCursos(int nroCursos) {
        Curso cursos[] = new Curso[nroCursos];
        for (int i = 0; i < cursos.length; i++) {

            Scanner datos = new Scanner(System.in);
            String nomCurso;
            double nota;
            int nroCred;

            System.out.println("Ingrese el nombre del curso " + (i + 1) + " :");
            nomCurso = datos.next();
            System.out.println("Numero de creditos del curso " + (i + 1) + " :");
            nroCred = datos.nextInt();
            System.out.println("Nota obtenida en el curso " + (i + 1) + " :");
            nota = datos.nextDouble();
            cursos[i] = new Curso(nomCurso, nota, nroCred);

        }
        return cursos;
    }
}
