/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binario2;

import java.util.Scanner;

/**
 *
 * @author Angie Mendez
 */
public class Binario2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


       				 String binario;
	        int decimal = 0;

	        System.out.println("Ingrese el numero binario");
	        Scanner datos = new Scanner(System.in);
	        binario = datos.next();
	        
	        for (int i = 0; i < binario.length() ; i++) {
	            if (binario.charAt(i) == '1') {
	                decimal += Math.pow(2, i);
	                
	            }else if(binario.charAt(i) != '0') {
	            	System.out.println("revise el numero ingresado"); System.exit(0);
	            }
	        }
	        System.out.println(decimal);
    }

}
