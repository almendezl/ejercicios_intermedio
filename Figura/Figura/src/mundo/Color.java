/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author SG702-21
 */
public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red>=0 && red <=255 ? red : 0;
        this.green = green>=0 && green <=255 ? green : 0;
        this.blue = blue>=0 && blue <=255 ? blue : 0;
    }   
    
    /**
     * @return the red
     */
    public int getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(int red) {
        this.red = red>=0 && red <=255 ? red : 0;
    }

    /**
     * @return the green
     */
    public int getGreen() {
        return green;
    }

    /**
     * @param green the green to set
     */
    public void setGreen(int green) {
        this.green = green>=0 && green <=255 ? green : 0;
    }

    /**
     * @return the blue
     */
    public int getBlue() {
        return blue;
    }

    /**
     * @param blue the blue to set
     */
    public void setBlue(int blue) {
        this.blue = blue>=0 && blue <=255 ? blue : 0;
    }

    @Override
    public String toString() {
        return "Color (rgb): " + red + ", " + green + ", " + blue;
    }
    
    
}
