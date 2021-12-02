/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
/**
 *
 * @author SG702-21
 */
public class PruebaPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona fulano = new Persona("123","Parra","Juan",new Fecha(2000,2,15));
        System.out.println(fulano);
        System.out.println(Math.abs(fulano.calcularEdad(new Fecha(2018,3,13))));
        
    }
    
}
