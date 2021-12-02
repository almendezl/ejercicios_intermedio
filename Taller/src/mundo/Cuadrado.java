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
public class Cuadrado {
    private String textura;
    private Color color;
    private int lado;
    private final int id;
    //variable de la clase de la cual todos los objetos tienen una copia
    private  static int nroCuadrados = 0;
    
    public Cuadrado(String textura, Color color, int lado, int id){
        this.textura = textura;
        if(lado <=0)
            this.lado = 0;
        else 
            this.lado = lado;
        if(id <=0)
            this.id = 0;
        else
            this.id = id;
        this.color = color;
        
        nroCuadrados ++;
    }

    public String getTextura() {
        return textura;
    }

    public void setTextura(String textura) {
        this.textura = textura;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        if(lado <=0)
            this.lado = 0;
        else 
            this.lado = lado;
    }

    public int getId() {
        return id;
    }
    
    //para usar este metodo se escribe nombre de la clase, punto y el nombre del metodo
    public static int getNroCuadrados() {
        return nroCuadrados;
    }
    
    public double calcularArea(){
        return Math.pow(lado, 2);
    }
    
    public double calcularPerimetro(){
        return lado*4;
    }
}
