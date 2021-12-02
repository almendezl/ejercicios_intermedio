/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medidas;

import java.util.Scanner;

/**
 *
 * @author Angie Mendez Este programa convierte diferentes medidas de longitud
 */
public class Medidas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        System.out.println("** CONVERTIDOR DE MEDIDAS **");

        while(true){
            int opcion;
            double vlrConv;
            System.out.println("Seleccione la medida a convertir: \n1. Millas \n2.Kilometros \n3.Metros \n4.Pies"
                    + "\n5.Pulgadas \n6.Centimetros \n0.Para salir  ");
            opcion = Integer.parseInt(datos.next());
            if (opcion >0 && opcion <= 6) {
                System.out.println("Ingrese el valor a convertir: ");
                vlrConv = datos.nextDouble();
                switch(opcion){
                    case 1:
                        System.out.println("Kilometros ->" +(vlrConv*1.6093));
                        System.out.println("Metros ->"+ (vlrConv*1609.3));
                        System.out.println("Pies ->"+ (vlrConv*5279.855));
                        System.out.println("Pulgadas ->"+ (vlrConv*63358.267));
                        System.out.println("Centimetros ->"+ (vlrConv*160930.000244));
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("Millas ->"+ (vlrConv*0.62137));
                        System.out.println("Metros ->"+ (vlrConv*1000));
                        System.out.println("Pies ->"+ (vlrConv*3280.8399));
                        System.out.println("Pulgadas ->"+ (vlrConv*39370.0788));
                        System.out.println("Centimetros ->"+ (vlrConv*100000));
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("Millas ->"+ (vlrConv*0.00062137));
                        System.out.println("Kilometros ->"+ (vlrConv*0001));
                        System.out.println("Pies ->"+ (vlrConv*3.2808399));
                        System.out.println("Pulgadas ->"+ (vlrConv*39.3700788));
                        System.out.println("Centimetros ->"+ (vlrConv*100));
                        System.out.println("");
                        break;
                    case 4:
                        System.out.println("Millas ->"+ (vlrConv*0.0001893));
                        System.out.println("Kilometros ->"+ (vlrConv*0.0003048));
                        System.out.println("Metros ->"+ (vlrConv*0.3048));
                        System.out.println("Pulgadas ->"+ (vlrConv*12));
                        System.out.println("Centimetros ->"+ (vlrConv*30.48));
                        System.out.println("");
                        break;
                    case 5: 
                        System.out.println("Millas ->"+ (vlrConv*0.000015783254));
                        System.out.println("Kilometros ->"+ (vlrConv*0.000025349));
                        System.out.println("Metros ->"+ (vlrConv*0.02534));
                        System.out.println("Pies ->"+ (vlrConv*0.08333));
                        System.out.println("Centimetros ->"+ (vlrConv*2.51));
                        System.out.println("");
                        break;
                    case 6:
                        System.out.println("Millas ->"+ (vlrConv*0.000006218797));
                        System.out.println("Kilometros ->"+ (vlrConv*0.000004));
                        System.out.println("Metros ->"+ (vlrConv*0.004));
                        System.out.println("Pies ->"+ (vlrConv*0.032808386877));
                        System.out.println("Pulgadas ->"+ (vlrConv*0.3937008));
                        System.out.println("");
                        break;  
                }

            } else {
                System.exit(0);
                
            }
        } 

    }

}
