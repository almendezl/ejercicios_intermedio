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
public class Circulo extends Figura {
private double radius;
public Circulo(){
    super();
    super.addPunto(new Punto());
    this.radius = 0;
}
public Circulo(Punto origin, double radius, Color fillColor, Color lineColor){
    super();
    this.radius = radius >=0 ? radius : 0;
    super.addPunto(origin);
    super.setFillColor(lineColor);
    super.setLineColor(lineColor);
}
public Punto getPoint(){
    return (Punto) super.getPuntos().get(0);
}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return radius * 2* Math.PI;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getDiametro(){
        return 2 * radius;
    }

    @Override
    public String toString() {
        return "\nCIRCULO" + "\n**Radio-> " + radius + "\n**Perimetro-> "+ getPerimeter()+ "\n**Area-> "+ getArea()+
                "\n**Diametro-> "+getDiametro()+" "+super.toString();
    }
    
}
