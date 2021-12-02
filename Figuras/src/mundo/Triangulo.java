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
public class Triangulo extends Figura {

    private static int NPUNTOS = 3;

    public Triangulo() {
        super();
        for (int i = 0; i < NPUNTOS; i++) {
            super.addPunto(new Punto());
        }
    }

    public Triangulo(Punto point1, Punto point2, Punto point3, Color fillColor, Color lineColor) {
        super();
        super.setFillColor(fillColor);
        super.setLineColor(lineColor);
        super.addPunto(point1);
        super.addPunto(point2);
        super.addPunto(point3);
    }

    public Punto getPoint(int index) {
        return (Punto) super.getPuntos().get(index);
    }

    private double getSide(Punto p1, Punto p2) {
        double xValue = Math.pow(p1.getX() - p2.getX(), 2);
        double yValue = Math.pow(p1.getY() - p2.getY(), 2);
        return Math.sqrt(xValue + yValue);
    }

    @Override
    public double getPerimeter() {
        return getSide(getPoint(0), getPoint(1)) + getSide(getPoint(1), getPoint(2)) + getSide(getPoint(2), getPoint(1));
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - getSide(getPoint(0), getPoint(1))) * (s - getSide(getPoint(1), getPoint(2)))
                * (s - getSide(getPoint(0), getPoint(1))));
    }

    @Override
    public String toString() {
        return  "TRIANGULO" +  "\n**Perimetro-> " + getPerimeter() + "\n**Area-> " + getArea()
                + super.toString() ;
    }

}
