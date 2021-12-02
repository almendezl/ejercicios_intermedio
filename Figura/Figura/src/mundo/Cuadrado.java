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
public class Cuadrado extends Figuras {
    private int lado;
    private static int nroCuadrados;

    public Cuadrado(String id, String textura, Color color, int lado) {
        super(id,textura,color);
        this.lado = lado<0?0:lado;
    }

    /**
     * @return the lado
     */
    public int getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado<0?0:lado;
    }
    
    /**
     * @return the nroCuadrados
     */
    public static int getNroCuadrados() {
        return nroCuadrados;
    }

    /**
     * @param aNroCuadrados the nroCuadrados to set
     */
    public static void setNroCuadrados(int aNroCuadrados) {
        nroCuadrados = aNroCuadrados;
    }   

    @Override
    public String toString() {
        return "Cuadrado " + super.toString() + ", lado=" + lado;
    }
    
    
}
