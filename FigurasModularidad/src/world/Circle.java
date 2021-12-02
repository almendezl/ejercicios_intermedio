/**
 * 
 */
package world;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
public class Circle extends Shape {
    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** radius of circle */
    private double radius;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor without parameters
     */
    public Circle() {
        super();
        super.addPoint(new Point());
        this.radius = 0;
    }

    /**
     * Constructor with parameters
     * @param origin Origin point of circle
     * @param radius Radius of circle
     * @param fillColor Fill color for the shape
     * @param lineColor Line color for the shape
     */
    public Circle(Point origin, double radius, Color fillColor, Color lineColor) {
        super();
        super.setFillColor(fillColor);
        super.setLineColor(lineColor);
        super.addPoint(origin);
        this.radius = radius;
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Get the origin point
     * @return origin point of circle
     */
    public Point getPoint() {
        return super.getPoints().get(0);
    }

    /**
     * Get the radius of circle
     * @return radius of circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of circle
     * @param radius New radius of circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the diameter of circle
     * @return diameter of circle
     */
    public double getDiameter() {
        double diametro=2*radius;
        return diametro;
    }

    /**
     * Override method to calculate the perimeter of a circle
     * @return the perimeter of circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Override method to calculate the area of a circle
     * @return the area of circle
     */
    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    /**
     * Override method to show a message for option 1
     * @return a message for the option
     */
    @Override
    public String method1() {
        return "EL diametro del c�rculo es: " + (2 * radius);
    }

    /**
     * Override method to show a message for option 2
     * @return a message for the option
     */
    @Override
    public String method2() {
        return "Las coordenadas del centro del c�rculo son:\nX: " + getPoints().get(0).getX() + "\nY: " +
                        getPoints().get(0).getY();
    }

}
