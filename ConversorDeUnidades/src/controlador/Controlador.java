/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.Contenedor;

/**
 *
 * @author Angie Mendez
 */
public class Controlador {
    private final Contenedor contenedor;
    
    public Controlador (){
        contenedor = new Contenedor();
    }
     public void iniciar() {
        contenedor.setTitle("Conversor De Unidades");
        contenedor.setVisible(true);
    }
}
