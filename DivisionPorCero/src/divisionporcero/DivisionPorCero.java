/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package divisionporcero;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class DivisionPorCero {

    /**
     * @param args the command line arguments
     */
    public static int cociente(int numerador, int denominador) throws ArithmeticException{
        return numerador/denominador;
    }
    public static void main(String[] args) {
        boolean continuar = true;
        do{
            try{
                int numerador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numerador entero: "));
                int denominador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un denominador entero: "));
                int resultado = cociente (numerador, denominador);
                JOptionPane.showMessageDialog(null, "El resultado es: "+ resultado, "Prueba de division", JOptionPane.INFORMATION_MESSAGE);
                continuar = false;
                
            }
            catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Excepcion: "+ nfe +
                        "\nDebe ingresar enteros. Por favor intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            catch(ArithmeticException ae){
                JOptionPane.showMessageDialog(null, "Excepcion: "+ ae +
                        "\nCero no es un denominador valido. Por vavor intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(continuar);
    }
    
}
