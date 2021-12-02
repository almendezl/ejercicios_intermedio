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
public class Circulo extends Figuras {
    private int radio;
    private static int nroCirculos;

    public Circulo(String id, String textura, Color color, int radio) {
        super(id, textura, color);
        this.radio = radio<0?0:radio;
    }
   

    /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(int radio) {
        this.radio = radio<0?0:radio;
    }

    /**
     * @return the nroCirculos
     */
    public static int getNroCirculos() {
        return nroCirculos;
    }

    /**
     * @param aNroCirculos the nroCirculos to set
     */
    public static void setNroCirculos(int aNroCirculos) {
        nroCirculos = aNroCirculos;
    }

    @Override
    public String toString() {
        return "Circulo " + super.toString() + ", radio=" + radio;
    }

    
    
}
