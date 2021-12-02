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
    
    public void setClave(String clave){
        this.clave = clave;
    }
            
    public void llenarCuadro(){
        for(int i=0; i<cuadro.length; i++)
            for(int j=0; j<cuadro[i].length; j++)
                cuadro[i][j] = (int)(Math.random()*10);        
    }
    
    public int[][] llenarCuadro(int tam){
        int matriz[][] = new int[tam][tam];
        for(int i=0; i<matriz.length; i++)
            for(int j=0; j<matriz[i].length; j++)
                matriz[i][j] = (int)(Math.random()*10);        
        return matriz;
    }
    
    public int[] descomponerClave(){
        int vector[] = new int[clave.length()];
        
        for(int i=0; i<vector.length; i++)
            vector[i] = clave.charAt(i);
        
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
    
    public String buscarHD(){
        int k;
        for(int i=0; i<cuadro.length; i++)
            for(int j=0; j<=cuadro[i].length-clave.length();j++){
                k=0;
                if(cuadro[i][j]==clave.charAt(k)){
                    while(k<clave.length())
                        if(cuadro[i][j+1]==clave.charAt(k+1)){
                            j++;
                            k++;
                        }
                        else
                            break;
                    if(k==clave.length())
                        return clave + " fue encontrado en [" + i + "][" + j +"]";
                }
            }
        return clave + " NO fue encontrado";                    
    }

    public String buscarVAb(){
        int k,l;
        for(int i=0; i<cuadro.length-clave.length(); i++)
            for(int j=0; j<=cuadro[i].length;j++){
                k=0;
                l=i;
                if(cuadro[l][j]==clave.charAt(k)){
                    while(k<clave.length())
                        if(cuadro[l+1][j]==clave.charAt(k+1)){
                            l++;
                            k++;
                        }
                        else
                            break;
                    if(k==clave.length())
                        return clave + " fue encontrado en [" + i + "][" + j +"]";
                }
            }
        return clave + " NO fue encontrado";                    
    }

}
