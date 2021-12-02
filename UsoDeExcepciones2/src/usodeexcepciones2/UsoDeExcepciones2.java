/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones2;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class UsoDeExcepciones2 {

    /**
     * @param args the command line arguments
     */
    public static void throwException() throws Exception{
        try{
            JOptionPane.showMessageDialog(null, "Metodo throwException", "Metodo", JOptionPane.INFORMATION_MESSAGE);
            throw new Exception();
        }
        catch(RuntimeException rte){
            JOptionPane.showMessageDialog(null, "Excepcion manejada en  throwException", "Excepcion", JOptionPane.INFORMATION_MESSAGE);
        }
        finally{
            JOptionPane.showMessageDialog(null, "Finally ejecutado en throwException", "Finally", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    public static void main(String[] args) {
        try{
            throwException();
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, "Excepcion amnejada en el main", "Exception", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    
}
