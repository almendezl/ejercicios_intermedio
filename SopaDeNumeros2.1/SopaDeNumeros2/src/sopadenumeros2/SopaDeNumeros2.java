/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadenumeros2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author SG701-21
 */
public class SopaDeNumeros2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String clave;
        
        Sopa s = new Sopa(10);
        int matriz[][] = s.llenarCuadro(10);
        s.setCuadro(matriz);
        JOptionPane.showMessageDialog(null,s.imprimirCuadro());
        
        clave= JOptionPane.showInputDialog("Ingrese el número a buscar:");
        s.setClave(clave);
        
    }
    
}
