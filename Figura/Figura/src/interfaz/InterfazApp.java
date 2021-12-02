/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import mundo.*;
import java.util.ArrayList;        
import java.util.Scanner;

/**
 *
 * @author SG702-21
 */
public class InterfazApp {
    private Color crearColor(){
        int r,g,b;
        r = (int)(Math.random()*256);
        g = (int)(Math.random()*256);
        b = (int)(Math.random()*256);
        
        return new Color(r,g,b);
    }
    
    public static void main(String args[]){
        InterfazApp iApp = new InterfazApp();
        ArrayList<Figuras> alFiguras = new ArrayList<Figuras>();        
        //ArrayList<Cuadrado> alCuadrado = new ArrayList<Cuadrado>();
        //ArrayList<Circulo> alCirculo = new ArrayList<Circulo>();
        Scanner in = new Scanner(System.in);
        
        while(true){
            System.out.println("\nSeleccione una opción: \n1. Adicionar un cuadrado \n2. Adicionar un circulo \n3. Imprimir lista de figuras \n4. Salir");
            String opcion = in.nextLine();
            switch(opcion){
                case "1": 
                    System.out.println("Identificador del cuadrado: ");
                    String idCua = in.nextLine();
                    System.out.println("Longitud del lado del cuadrado: ");
                    int lado = in.nextInt();
                    System.out.println("Textura del cuadrado: ");
                    String texturaCua = in.next();
                    Color colorCua = iApp.crearColor();
                    alFiguras.add(new Cuadrado(idCua,texturaCua,colorCua,lado));
                    break;
                case "3":
                    System.out.println("\nLa lista de figuras ingresados es:\n");
                    for(Figuras c:alFiguras)
                        System.out.println(c);
                    break;
                case "2": 
                    System.out.println("Identificador del circulo: ");
                    String idCir = in.nextLine();
                    System.out.println("Longitud del lado del circulo: ");
                    int radio = in.nextInt();
                    System.out.println("Textura del circulo: ");
                    String texturaCir = in.next();
                    Color colorCir = iApp.crearColor();
                    alFiguras.add(new Circulo(idCir,texturaCir,colorCir,radio));
                    break;
                /*case "4":
                    System.out.println("\nLa lista de circulos ingresados es:\n");
                    for(Circulo c:alCirculo)
                        System.out.println(c);
                    break;*/
                case "4": System.exit(0);
            }
        }
    }
}
