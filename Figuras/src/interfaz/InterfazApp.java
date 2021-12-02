/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.*;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp {
    static Scanner datos = new Scanner (System.in);
    public static void main(String[] args) {
        System.out.println("BIENVENIDO AL SISTEMA DE FIGURAS");
        ArrayList <Figura> figuras = new ArrayList<Figura>();
        while(true){
            
            System.out.println("Seleccione la accion");
            System.out.println("\n1.Agregar un Circulo \n2.Agregar un Triangulo \n3.Agregar un Cuadrilatero \n4.Mostrar las figuras"
                    + "\n5.Salir");
           int opcion = datos.nextInt();
           switch(opcion){
               case 1:
                   System.out.println("Ingrese el radio:");
                   int radio = datos.nextInt();
                   System.out.println("Ingrese los colores de linea:");
                   Color col1 = llenarColor();
                   System.out.println("Ingrese los colores de relleno:");
                   Color col2 = llenarColor();
                   System.out.println("Ingrese el punto de referencia: ");
                   Punto p = pedirPunto();
                   Circulo circulo = new Circulo(p,radio,col1, col2);
                   figuras.add(circulo);
                   break;
               case 2:
                   Punto p1, p2, p3;
                   System.out.println("Ingrese el punto 1:");
                   p1 = pedirPunto();
                   System.out.println("Ingrese el punto 2:");
                   p2 = pedirPunto();
                   System.out.println("Ingrese el punto 3:");
                   p3 = pedirPunto();
                   System.out.println("Ingrese los colores de linea:");
                   Color col = llenarColor();
                   System.out.println("Ingrese los colores de relleno:");
                   Color c = llenarColor();
                   Triangulo triangulo = new Triangulo(p1, p2, p3, c, col);
                   figuras.add(triangulo);
                   break;
               case 3:
                   Punto pt1, pt2, pt3, pt4;
                   System.out.println("Ingrese el punto 1:");
                   pt1 = pedirPunto();
                   System.out.println("Ingrese el punto 2:");
                   pt2 = pedirPunto();
                   System.out.println("Ingrese el punto 3:");
                   pt3 = pedirPunto();
                   System.out.println("Ingrese el punto 4:");
                   pt4 = pedirPunto();
                   System.out.println("Ingrese los colores de linea:");
                   Color cl = llenarColor();
                   System.out.println("Ingrese los colores de relleno:");
                   Color cr = llenarColor();
                   Cuadrilatero cuad = new Cuadrilatero(pt1, pt2, pt3, pt4,cr, cl);
                   figuras.add(cuad);
                   break;
               case 4:
                   
                       System.out.println(figuras.toString());
                   
                   break;
               case 5:
                   System.out.println("*****Gracias por utilizar este programa!!! *****");
                   System.exit(0);
                   break;
           }
            
        }
    }
    //forula de brahmagupta para areas de cuadrilatero, pentagono, etc
    public static Color llenarColor(){
        System.out.println("Ingrese el rojo:");
        int rojo = datos.nextInt();
        System.out.println("Ingrese el verde:");
        int verde = datos.nextInt();
        System.out.println("Ingrese el azul:");
        int azul = datos.nextInt();
        Color color = new Color();
        color.setBlue(azul);
        color.setGreen(verde);
        color.setRed(rojo);
        return color;
    }
    public static Punto pedirPunto(){
        Punto p1 = new Punto();
        System.out.println("Ingrese la ubicacion en X:");
        double x = datos.nextDouble();
        System.out.println("Ingrese la ubicacion en Y:");
        double y = datos.nextDouble();
        p1.setX(x);
        p1.setY(y);
        return p1;
    }
}
