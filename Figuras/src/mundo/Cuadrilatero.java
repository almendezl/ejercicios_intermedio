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
public class Cuadrilatero extends Figura {

    private static int NPUNTOS = 4;

    public Cuadrilatero() {
        super();
        for (int i = 0; i < NPUNTOS; i++) {
            super.addPunto(new Punto());
        }
    }

    public Cuadrilatero(Punto p1, Punto p2, Punto p3, Punto p4, Color fillColor, Color lineColor) {
        super();
        super.setFillColor(fillColor);
        super.setLineColor(lineColor);
        super.addPunto(p1);
        super.addPunto(p2);
        super.addPunto(p3);
        super.addPunto(p4);
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
        return getSide(getPoint(0), getPoint(1)) + getSide(getPoint(1), getPoint(2))
                + getSide(getPoint(2), getPoint(3)) + getSide(getPoint(3), getPoint(0));
    }

    @Override
    public double getArea() {
        double r1 = 4 * Math.pow(getSide(getPoint(0), getPoint(2)), 2)
                * Math.pow(getSide(getPoint(1), getPoint(3)), 2);
        double r2 = Math.pow(Math.pow(getSide(getPoint(1), getPoint(3)), 2)
                * Math.pow(getSide(getPoint(3), getPoint(0)), 2)
                - Math.pow(getSide(getPoint(0), getPoint(1)), 2)
                - Math.pow(getSide(getPoint(2), getPoint(3)), 2), 2);
        return (Math.sqrt(r1-r2))/2;
    }

    @Override
    public String toString() {
        return "CUADRILATERO" + "\n**Perimetro-> "+ getPerimeter()+ "\n**Area-> "+ getArea()+
                super.toString();
    }

}
