/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author Angie Mendez
 */
public abstract class Figura {
    private Color fillColor;
    private Color lineColor;
    private ArrayList <Punto>puntos;
    
    public Figura(){
        fillColor = new Color();
        lineColor = new Color();
        puntos = new ArrayList<Punto>();
    }
    public Color getFillColor(){
        return fillColor;
    }
    public Color getLineColor(){
        return lineColor;
    }
    public ArrayList getPuntos(){
        return puntos;
    }
    public void setFillColor(Color color){
        fillColor = color;
    }
    public void setFillineColor(int red, int green, int blue){
        fillColor.setBlue(blue);
        fillColor.setGreen(green);
        fillColor.setRed(red);
    }
        public void setLineColor(int red, int green, int blue){
        lineColor.setBlue(blue);
        lineColor.setGreen(green);
        lineColor.setRed(red);
    }
    public void setLineColor(Color color){
        lineColor = color;
    }

    public void addPunto(Punto punto){
        puntos.add(punto);
    }
    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < puntos.size(); i++) {
            salida += "Punto "+(i+1)+" "+puntos.get(i).toString() + " \n";
            
        }
        return  "\n**Color de relleno**\n" + fillColor.toString() + "\n**Color de linea**\n" + lineColor.toString() + ", \n**Puntos** \n"  + salida+"\n";
    }
    
}

