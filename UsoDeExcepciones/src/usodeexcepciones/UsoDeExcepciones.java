/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class UsoDeExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void throwException () throws Exception{
        try{
            JOptionPane.showMessageDialog(null, "Metodo throw Exception", "Metodo", JOptionPane.INFORMATION_MESSAGE);
            throw new Exception();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Excepcion manejada en throwException", "Finally", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void doesNotThrowException(){
        try{
            JOptionPane.showMessageDialog(null, "Metodo doesNotThrowException", "Metodo", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e,"Exception", JOptionPane.INFORMATION_MESSAGE);
            
        }
        finally{
            JOptionPane.showMessageDialog(null,"Finally ejecutando en ThrowException", "Finally", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String[] args) {
        try{
            throwException();
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Excepcion majenada en el main","Exception",JOptionPane.INFORMATION_MESSAGE);
        }
        doesNotThrowException();
    }
    
}
