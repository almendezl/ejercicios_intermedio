/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandoexcepcionesencadenas;

/**
 *
 * @author Angie Mendez
 */
public class UsandoExcepcionesEncadenadas {

    /**
     * @param args the command line arguments
     */
    public static void metodo1() throws Exception{
         try{
             metodo2();
         }
         catch(Exception e){
             throw new Exception("Exception tratada en el metodo1 ",e);
         }
     }
     public static void metodo2() throws Exception{
         try{
             metodo3();
         }
         catch(Exception e){
             throw new Exception("Exception tratada en el metodo2 ",e);
         }
     }
     public static void metodo3() throws Exception{
         throw new Exception ("Exception tratada en el metodo 3");
     }
     
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            metodo1();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
