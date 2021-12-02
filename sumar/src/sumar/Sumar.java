/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumar;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class Sumar {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
        double numero1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el numero 1"));
        double numero2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el numero 2"));
        
        JOptionPane.showMessageDialog(null, "El resultado de la suma es: "+ sumarNumeros(numero1, numero2));
    }
    
   public static double sumarNumeros(double numero1, double numero2){
       return numero1+numero2;
   }
    
}
