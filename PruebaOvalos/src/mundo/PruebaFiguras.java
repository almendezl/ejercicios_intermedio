/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class PruebaFiguras {
    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Escriba 1 para dibujar rectangulos"+"\nEscriba 2 para dibujar Ovalos");
        
        int opcion = Integer.parseInt(entrada);
        
        Figuras panel = new Figuras (opcion);
        JFrame aplicacion = new JFrame();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(panel);
        aplicacion.setSize(1000,1000);
        aplicacion.setVisible(true);
    }
}