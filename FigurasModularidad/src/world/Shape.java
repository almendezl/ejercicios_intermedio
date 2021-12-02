/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.ArrayList;

/**
 *
 * @author Angie Mendez
 */
public class Shape implements IShape {
    private Color fillColor;
    private Color lineColor;
    private ArrayList<Point>points;
    
    public Shape(){
        fillColor = new Color();
        lineColor = new Color ();
        points = new ArrayList<Point>();
    }
    public Color getFillColor(){
        return fillColor;
    }
    public Color getLineColor(){
        return lineColor;
    }
    public void setFillColor (Color c){
        fillColor = c;
    }
    public void setFillColor(int red, int green, int blue){
        fillColor.setRed(red);
        fillColor.setGreen(green);
        fillColor.setBlue(blue);
    }
    public void setLineColor(Color c){
        lineColor = c;
    }
    public void setLineColor(int red, int green, int blue){
        lineColor.setRed(red);
        lineColor.setGreen(green);
        lineColor.setBlue(blue);
    }
    public ArrayList<Point> getPoints(){
        return points;
    }
    public void setPoints(ArrayList<Point> points){
        this.points = points;
    }
    public void addPoint(Point p){
        points.add(p);
    }
    public double getPerimeter(){
        return 0;
    }
    public double getArea(){
        return 0;
    }
    public String method1(){
        return null;
    }
    public String method2(){
        return null;
    }
}
