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
public class Punto {
    private double x;
    private double y;
    public Punto(){
        this.x = 0;
        this.y = 0;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setX(double x){
        this.x = x;
    }

    @Override
    public String toString() {
        return  "x = " + x + "y = " + y;
    }
    
}
