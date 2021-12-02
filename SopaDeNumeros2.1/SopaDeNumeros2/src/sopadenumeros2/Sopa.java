/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadenumeros2;

/**
 *
 * @author SG702-21
 */
public class Sopa {
    private int cuadro[][];
    private String clave;
    
    public Sopa(int tamanio){
        cuadro = new int [tamanio][tamanio];
        clave="";
    }
    
    public int[][] getCuadro(){
        return cuadro;
    }
    
    public void setCuadro(int [][]matriz){
        cuadro = matriz;
    }
    
    public String getClave(){
        return clave;
    }
    
    public void setClave(String dato){
        clave = dato;
    }
            
    public int[][] llenarCuadro(int tam){
        int matriz[][] = new int[tam][tam];
        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz[i].length; j++)
                matriz[i][j] = (int)(Math.random()*10);        
        return matriz;
    }
    
    public int[] descomponerClave(String dato){
        int vector[] = new int[dato.length()];
        
        for(int i=0; i<vector.length; i++)
            vector[i] = dato.charAt(i);
        
        return vector;
    }
    
    public String imprimirCuadro(){
        String salida="";
        for(int i=0; i<cuadro.length; i++){
            for(int j=0; j<cuadro[i].length; j++)
                salida += cuadro[i][j] + "\t";   
            salida += "\n";
        }
        return salida;
    }
    /*
    public String buscarH(){
        int claveVec[]= descomponerClave(clave);
        int contador;
        for(int i=0; i<cuadro.length; i++)
            for(int j=0; j<cuadro[i].length; j++)                
                do{
                    if(claveVec[0]!=cuadro[i][j])                    
                        break;
                    else
                        contador++;
    }
*/
}
