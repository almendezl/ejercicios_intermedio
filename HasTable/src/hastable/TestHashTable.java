/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastable;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 *
 * @author Angie Mendez
 */
public class TestHashTable {
    public static void main(String[] args) {
        Persona p1 = new Persona ("Pablo", 33,"Argentino");
        Persona p2 = new Persona ("Juan", 25,"Mexicano");
        Persona p3 = new Persona ("Pedro", 18,"Español");
        Hashtable<String, Persona> tabla = new Hashtable <String, Persona>();
        tabla.put(p1.getNombre(), p1);
        tabla.put(p2.getNombre(), p2);
        tabla.put(p3.getNombre(), p3);
        
        System.out.println(tabla.get("Pablo"));
        System.out.println(tabla.get("Juan"));
        System.out.println(tabla.get("Pedro"));
        System.out.println(tabla.get("Javier"));
        String aux;
        Enumeration<String> claves = tabla.keys();
        while(claves.hasMoreElements()){
            aux = claves.nextElement();
            System.out.println(aux+" = "+tabla.get(aux));
        }
    }
}
