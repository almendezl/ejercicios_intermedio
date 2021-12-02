/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import mundo.Curso;
import mundo.Docente;
import mundo.Estudiante;

/**
 *
 * @author SG702-21
 */
public class Principal {
    
    /**
     * @param args the command line arguments
     */
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
       /* InterfazApp gui = new InterfazApp("Curso");
        gui.setVisible(true);
        
    }*/
        
        Principal p = new Principal();
        Curso curso=null;
        
        do{
            System.out.println("Seleccione: \n1. Crear curso\n2. Asignar docente\n3. Matricular estudiante\n4. Desmatricular estudiante\n5. Imprimir lista del curso\n6. Salir");
            int opcion = p.in.nextInt();
            p.in.nextLine();
            switch(opcion){
                case 1: 
                    System.out.println("Ingrese el nombre del curso: ");
                    String nombreCurso = p.in.nextLine();
                    curso = new Curso(nombreCurso, p.crearDocente());
                    break;
                case 2: 
                    if(curso!=null)
                        curso.setProfesor(p.crearDocente());
                    break;
                case 3: 
                    if(curso!=null)
                        curso.matricular(p.crearEstudiante());                    
                    break;
                case 4: 
                    if(curso!=null)
                        curso.desmatricular(p.crearEstudiante());
                    break;
                case 5: 
                    if(curso!=null)
                        System.out.println(curso.getEstudiantes().toString());
                    break;
                case 6: 
                    System.out.println("Esta seguro que desea salir (S/N)?");
                    if(p.in.nextLine().equalsIgnoreCase("S"))
                        System.exit(0);
            }
        }while(true);
    }
     
    private Estudiante crearEstudiante(){
        System.out.println("Ingrese el nombre del estudiante:");
        String nombreEstudiante = in.nextLine();
        System.out.println("Ingrese la identificación del estudiante:");
        String idEstudiante = in.nextLine();
        System.out.println("Ingrese la edad del estudiante:");
        int edadEstudiante = in.nextInt();
        in.nextLine();
        Estudiante e = new Estudiante(idEstudiante,nombreEstudiante,edadEstudiante);
        for(int i=0; i<3; i++){
            System.out.println("Ingrese la nota del corte " + (i+1) + " del estudiante :");
            e.setNotas(in.nextDouble(),i);
        }
        return e;
    }
        
    private Docente crearDocente(){
        System.out.println("Ingrese el nombre del profesor:");
        String nombreProfesor = in.nextLine();
        System.out.println("Ingrese la identificación del profesor:");
        String idProfesor = in.nextLine();
        System.out.println("Ingrese la edad del profesor:");
        int edad = in.nextInt();
        in.nextLine();
        System.out.println("Ingrese la dedicación del profesor:");
        String dedicacion = in.nextLine();
        
        Docente d = new Docente(idProfesor,nombreProfesor,edad,dedicacion);
        return d;               
    }
    
}
