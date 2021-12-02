/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresionmultiple;

import java.util.Scanner;

/**
 *
 * @author Angie Mendez
 */
public class ImpresionMultiple {

    /**
     * @param args the command line arguments
     */
    /**
     * 
     * El siguiente programa imprime una frase dada por el usuario en multiples lineas
     */
    public static void main(String[] args) {
        boolean opcion = true;
        do {
            String frase[];
            String salida = "";

            Scanner datos = new Scanner(System.in);
            System.out.println("Ingresa una frase: ");
            frase = datos.nextLine().split(" ");
            for (int i = 0; i < frase.length; i++) {
                salida += frase[i] + "\n";
            }
            System.out.println(salida);
            System.out.println("** Ingrese -1 para salir **");
            opcion = !datos.next().equals("-1");
        } while (opcion);
    }
}
