/**
 * 
 */
package world;

/**
 * @author Jorge A. Arevalo A. - Docente de Planta - Universidad Piloto de Colombia
 *
 */
public class Color {
    // ---------------------------------------------------------------------------------------
    // Attributes
    // ---------------------------------------------------------------------------------------
    /** red color value */
    private int red;

    /** green color value */
    private int green;

    /** blue color value */
    private int blue;

    // ---------------------------------------------------------------------------------------
    // Constructors
    // ---------------------------------------------------------------------------------------
    /**
     * Constructor without parameters
     */
    public Color() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    /**
     * Constructor with parameters
     * @param red Red color portion
     * @param green Green color portion
     * @param blue Blue color portion
     */
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // ---------------------------------------------------------------------------------------
    // Methods
    // ---------------------------------------------------------------------------------------
    /**
     * Get red color portion
     * @return red color portion
     */
    public int getRed() {
        return red;
    }

    /**
     * Set red color portion
     * @param red Red color portion
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * Get green color portion
     * @return green color portion
     */
    public int getGreen() {
        return green;
    }

    /**
     * Set green color portion
     * @param green Green color portion
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * Get blue color portion
     * @return blue color portion
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Set blue color portion
     * @param blue Blue color portion
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

}
