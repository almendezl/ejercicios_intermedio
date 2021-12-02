/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

import java.util.Scanner;

/**
 *
 * @author Angie Mendez El siguiente programa
 */
public class Notas {

    /**
     * @param args the command line arguments
     */
    static Scanner datos = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("** CALCULAR NOTAS **");
        
        while (true) {
            double notaF;
            notaF = (0.3 * pedirNota("1")) + (0.3 * pedirNota("2") + (0.4 * pedirNota("Final")));
            System.out.println("La nota final es: " + notaF);
            if(notaF>=3.0){
                System.out.println("Usted ha aprobado!!");
            }
            else 
                System.out.println("Usted ha reprobado");
            System.out.println("Ingrese \n S si desea salir");
            if (datos.next().equalsIgnoreCase("s")) {
                System.exit(0);
            }
        }
    }
    
    public static double pedirNota(String nota) {
        System.out.println("Ingrese la nota " + nota);
        double vlrNota;
        vlrNota = Double.parseDouble(datos.next());
        if (vlrNota >= 0 && vlrNota <= 5) {
            return vlrNota;
        } else {
            System.out.println("Nota incorrecta");
            System.exit(0);
            return -1;
        }
    }
    
}
