/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usodeexcepciones3;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class UsoDeExcepciones3 {

    /**
     * @param args the command line arguments
     */
    public static void metodo1() throws Exception{
        metodo2();
    }
    public static void metodo2() throws Exception{
        metodo3();
    }
    public static void metodo3() throws Exception{
        throw new Exception("Excepcion amnejada en el metodo 3");
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            metodo1();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
            StackTraceElement[] traceElements = e.getStackTrace();
            String mensaje = "Seguimiento de eventos con getStackTrace: \n"+
                    "Clase - Archivo - Linea - Metodo\n";
            for (StackTraceElement element: traceElements) {
                mensaje += element.getClassName()+" - "+element.getFileName()+ " - "+ element.getLineNumber()+
                        " - "+ element.getMethodName()+ "\n";                
            }
            JOptionPane.showMessageDialog(null, mensaje, "seguimiento de eventos", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
