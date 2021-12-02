/**
 * 
 */
package world;

import java.util.ArrayList;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
public class Quadrilateral extends Shape {
    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor without parameters
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Quadrilateral() {
        super();
        addPoint(new Point());
        addPoint(new Point());
        addPoint(new Point());
        addPoint(new Point());
    }

    /**
     * Constructor with parameters
     * @param point1 First point of quadrilateral
     * @param point2 Second point of quadrilateral
     * @param point3 Third point of quadrilateral
     * @param point4 Fourth point of quadrilateral
     * @param fillColor Fill color of quadrilateral
     * @param lineColor Line color of quadrilateral
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Quadrilateral(Point point1, Point point2, Point point3, Point point4, Color fillColor, Color lineColor) {
        super();
        super.setFillColor(fillColor);
        super.setLineColor(lineColor);
        addPoint(point1);
        addPoint(point2);
        addPoint(point3);
        addPoint(point4);
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * @return the points
     */
    @Override
    public ArrayList<Point> getPoints() {
        return super.getPoints();
    }

    /**
     * Override method to calculate the perimeter of a quadrilateral
     * @return the perimeter of quadrilateral
     */
    @Override
    public double getPerimeter() {
        return getSide(getPoints().get(0), getPoints().get(1)) + getSide(getPoints().get(1), getPoints().get(2)) + 
                        getSide(getPoints().get(2), getPoints().get(3)) + getSide(getPoints().get(3), getPoints().get(0));
    }

    /**
     * Override method to calculate the area of a quadrilateral
     * @return the area of quadrilateral
     */
    @Override
    public double getArea() {
        return Math.sqrt(((getPerimeter() / 2) - getSide(getPoints().get(0), getPoints().get(1))) * 
                        ((getPerimeter() / 2) - getSide(getPoints().get(1), getPoints().get(2))) * 
                        ((getPerimeter() / 2) - getSide(getPoints().get(2), getPoints().get(3))) * 
                        ((getPerimeter() / 2) - getSide(getPoints().get(3), getPoints().get(0))));
    }

    /**
     * Method to calculate a side dimension using two points
     * @param p1 First point that define the side 
     * @param p2 Second point that define the side
     * @return the dimension of side
     */

    private double getSide(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2)+(Math.pow(p2.getY()-p1.getY(), 2)));
    }

    /**
     * Override method to show a message for option 1
     * @return a message for the option
     */
    @Override
    public String method1() {		
        return "La longitud de la primer diagonal es " + getSide(getPoints().get(0), getPoints().get(2)) +
                        "\nLa longitud de la segunda diagonal es " + getSide(getPoints().get(1), getPoints().get(3));
    }

    /**
     * Override method to show a message for option 2
     * @return a message for the option
     */
    @Override
    public String method2() {
        return (getSide(getPoints().get(0), getPoints().get(1)) == getSide(getPoints().get(1), getPoints().get(2)) && 
                        getSide(getPoints().get(1), getPoints().get(2)) == getSide(getPoints().get(2), getPoints().get(3)) && 
                        getSide(getPoints().get(2), getPoints().get(4)) == getSide(getPoints().get(3), getPoints().get(0)) ?
                        "El cuadrilatero es un cuadrado" : "El cuadrilatero no es un cuadrado");
    }

}
