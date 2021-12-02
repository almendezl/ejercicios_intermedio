/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.util.Scanner;
import mundo.*;
/**
 *
 * @author Angie Mendez
 */
public class InterfazApp {
    public static void main(String[] args) {
        //Crear variables para el cuadrado
        String text;
        Color color;
        int lado;
        int id;
        
        Scanner datos = new Scanner (System.in);
        Cuadrado[] cuad = new Cuadrado[5]; // crear el objeto cuadrado como arreglo de tamaño 5
        
        
        for (int i=0; i<cuad.length;i++){
            //pedir los datos al usuario de cada objeto cuadrado
            System.out.println("Ingrese la textura del cuadrado N° "+ (i+1));
            text = datos.next();
            System.out.println("Ingrese el codigo 1 de color del cuadrado N°"+(i+1));
            System.out.println("Ingrese el codigo 2 de color del cuadrado N°"+(i+1));
            System.out.println("Ingrese el codigo 3 de color del cuadrado N°"+(i+1));
            color = new Color(datos.nextInt(), datos.nextInt(),datos.nextInt());
            System.out.println("Ingrese el valor del lado del cuadrado N°" + (i+1));
            lado = datos.nextInt();
            System.out.println("Ingrese el id del cuadrado N° "+ (i+1));
            id = datos.nextInt();
            //almacenar los datos en el arreglo 
            cuad [i] = new Cuadrado(text,color ,lado,id);
        }
        
        //imprimir los datos almacenados en el arreglo
        for(int i=0; i<cuad.length;i++){
            System.out.println("\n");
            System.out.println("Cuadrado N°" + (i+1));
            System.out.println("Textura -->"+cuad[i].getTextura()+" \nColor -->" + cuad[i].getColor().identificarColor() + " \nLado -->" + cuad[i].getLado()+
                    "\nArea -->"+cuad[i].calcularArea()+"\nPerimetro -->"+cuad[i].calcularPerimetro()+"\nid -->"+cuad[i].getId()+"\nNumero total de cuadrados -->"+ Cuadrado.getNroCuadrados());
            
        }
        
        
        
        
    }
}
