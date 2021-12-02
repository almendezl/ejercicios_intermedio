/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import mundo.Calculador;
import interfaz.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Angie Mendez
 */
public class Controlador implements ActionListener {
    
    //atributo de mundo
    private Calculador calculador;
    //atributo de la vista
    private InterfazApp interfaz;
    
    public Controlador(InterfazApp interfaz, Calculador calculador){
        this.calculador = calculador;
        this.interfaz = interfaz;
        actionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       // try{
            //manejo de errores
            //lo que se va a ejecutar
            String numero1 = this.interfaz.getNumero1();
            String numero2 = this.interfaz.getNumero2();
            //invocar el metodo sumar de la clase calculador del mundo
            int resultado = calculador.Sumar(numero1, numero2);
            interfaz.setResultado(resultado +"");
            
       // }
        //catch(){
            //posible error
            
        }

    private void actionListener(ActionListener e) {
        interfaz.btnSumar.addActionListener(e);
    }
    
                
    }
    
    
    

