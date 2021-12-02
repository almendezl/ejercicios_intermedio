/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morse;

import controlador.Controlador;
import mundo.Convertidor;
import vista.InterfazApp;

/**
 *
 * @author Angie Mendez
 */
public class Morse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InterfazApp interfaz = new InterfazApp();
        Convertidor convertidor = new Convertidor();
        Controlador controlador = new Controlador(interfaz, convertidor);
        controlador.iniciar();
        
        
    }
    
}
