/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class Password {
    private int longitud;
    private String contrasena;
    
    public Password(){
        
    }
    public Password(int longitud){
        setLongitud(longitud);
        
    }
    public boolean esFuerte(){
        if(buscarNumeros() >=5){
            if(buscarMayusculas() >=2){
                if(buscarMinusculas() >=1){
                    return true;
            }
        }
        }
        return false;
    }
    private int buscarMayusculas(){
        return 1;
    }
    private int buscarMinusculas(){
        return 1;
    }
    private int buscarNumeros(){
        char array[];
        array = contrasena.toCharArray();
        int numeros = 0;
        for (int i = 0; i < array.length; i++) {
            /**
             * usa el metodo character para determinar si es un digito
             */
            if(Character.isDigit(array[i]))
            numeros++;
        }
        return numeros;
    }
    
    public String generarPassword(){
        return "n";
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud >= 8 ? longitud : this.longitud; 
    }
    
}
