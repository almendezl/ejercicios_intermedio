/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculos;

import java.util.Scanner;

/**
 *
 * @author Angie Mendez
 * Programa para realizar calculos basicos como suma, resta, multiplicacion, division y modulo
 */
public class Calculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while(true){
        double numero1;
        double numero2;
        String opcion;
        Scanner datos = new Scanner (System.in);
        System.out.println("Ingrese el primer numero: ");
        numero1 = datos.nextDouble();
        System.out.println("Ingrese el ssegundo numero: ");
        numero2 = datos.nextDouble();
        
        System.out.println("Seleccione el calculo a realizar: \n+. Sumar \n- Restar \n*. Multiplicar \n/. Dividir \n%. Modulo. \ns Para salir ");
        opcion = datos.next();
        
        switch(opcion){
            case "+":
                System.out.println(numero1+numero2);
                break;
            case "-":
                System.out.println(numero1-numero2);
                break;
            case "*": 
                System.out.println(numero1*numero2);
                break;
            case "/": 
                if(numero2 == 0)
                    System.out.println("Error division por cero!");
                else
                    System.out.println(numero1/numero2);
                break;
            case "%":
                 if(numero2 == 0)
                    System.out.println("Error division por cero!");
                else
                    System.out.println(numero1%numero2);
                break;
            case "s": case "S":
                System.exit(0);
                break;
            default: System.out.println("Error de seleccion de operacion!!!");
        }
    }
    }
    
}
