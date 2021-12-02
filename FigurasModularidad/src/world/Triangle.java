/**
 * 
 */
package world;

import java.util.ArrayList;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
public class Triangle extends Shape {
    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor without parameters
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Triangle() {
        super();
        addPoint(new Point());
        addPoint(new Point());
        addPoint(new Point());
    }

    /**
`	 * Constructor with parameters
     * @param point1 First point of triangle
     * @param point2 Second point of triangle
     * @param point3 Third point of triangle
     * @param fillColor Fill color of triangle
     * @param lineColor Line color of triangle
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Triangle(Point point1, Point point2, Point point3, Color fillColor, Color lineColor) {
        super();
        super.setFillColor(fillColor);
        super.setLineColor(lineColor);
        addPoint(point1);
        addPoint(point2);
        addPoint(point3);
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
     * Override method to calculate the perimeter of a triangle
     * @return the perimeter of triangle
     */
    @Override
    public double getPerimeter() {
        return getSide(getPoints().get(0), getPoints().get(1)) + getSide(
                        getPoints().get(1), getPoints().get(2)) + getSide(
                                        getPoints().get(2), getPoints().get(0));
    }

    /**
     * Override method to calculate the area of a triangle
     * @return the area of triangle
     */
    @Override
    public double getArea() {
        return Math.sqrt((getPerimeter()/2) * ((getPerimeter()/2) - getSide(getPoints().get(0), getPoints().get(1))) * 
                ((getPerimeter()/2) - getSide(getPoints().get(1), getPoints().get(2))) * ((getPerimeter()/2) - 
                getSide(getPoints().get(2), getPoints().get(0))));
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
        String tipo = "";
        tipo += (getSide(getPoints().get(0), getPoints().get(1)) == getSide(getPoints().get(1), getPoints().get(2)) &&
                        getSide(getPoints().get(1), getPoints().get(2)) == getSide(getPoints().get(2), getPoints().get(0)) ? 
                                        "Equilatero" : "");
        tipo += ((getSide(getPoints().get(0), getPoints().get(1)) == getSide(getPoints().get(1), getPoints().get(2)) && 
                        getSide(getPoints().get(1), getPoints().get(2)) != getSide(getPoints().get(2), getPoints().get(0))) || 
                        (getSide(getPoints().get(0), getPoints().get(1)) == getSide(getPoints().get(2), getPoints().get(0)) &&
                        getSide(getPoints().get(1), getPoints().get(2)) != getSide(getPoints().get(2), getPoints().get(0))) || 
                        (getSide(getPoints().get(1), getPoints().get(3)) == getSide(getPoints().get(2), getPoints().get(0)) && 
                        getSide(getPoints().get(1), getPoints().get(2)) != getSide(getPoints().get(0), getPoints().get(1))) ?
                        "Is�celes" : "") ;
        tipo += (getSide(getPoints().get(0), getPoints().get(1)) != getSide(getPoints().get(1), getPoints().get(2)) && 
                        getSide(getPoints().get(1), getPoints().get(2)) != getSide(getPoints().get(2), getPoints().get(0)) && 
                        getSide(getPoints().get(0), getPoints().get(1)) != getSide(getPoints().get(2), getPoints().get(0)) ? 
                        "Escaleno" : "");
        return "Seg�n la longitud de los lados el tri�ngulo es " + tipo;
    }

    /**
     * Override method to show a message for option 2
     * @return a message for the option
     */
    @Override
    public String method2() {
        return "El tri�ngulo tiene un factor de calidad de " + ((getSide(getPoints().get(1), getPoints().get(2)) + 
                        getSide(getPoints().get(2), getPoints().get(0)) - getSide(getPoints().get(0), getPoints().get(1))) * 
                        (getSide(getPoints().get(2), getPoints().get(0)) + getSide(getPoints().get(0), getPoints().get(1)) - 
                        getSide(getPoints().get(1), getPoints().get(2))) * (getSide(getPoints().get(0), getPoints().get(1)) +
                        getSide(getPoints().get(1), getPoints().get(2)) - getSide(getPoints().get(2), getPoints().get(0)))) / 
                        (getSide(getPoints().get(0), getPoints().get(1)) * getSide(getPoints().get(1), getPoints().get(2)) * 
                        getSide(getPoints().get(2), getPoints().get(0)));
    }

}
