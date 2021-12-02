/**
 * 
 */
package world;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
public class Point {
    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** X coordinate of point */
    private double x;

    /** Y coordinate of point */
    private double y;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor without parameters
     */
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Returns X coordinate
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns Y coordinate
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the X coordinate value
     * @param x New x coordinate value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the Y coordinate value
     * @param y New y coordinate value
     */
    public void setY(double y) {
        this.y = y;
    }

}
