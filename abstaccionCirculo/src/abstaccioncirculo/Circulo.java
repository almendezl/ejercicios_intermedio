/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstaccioncirculo;

/**
 *
 * @author Angie Mendez
 */
public class Circulo {
    private double radio;
    private String color;
    private double diametro;
    
    
    public Circulo(double radio, String color){
        this.radio = radio>=0?radio:0;
        this.color = color;
        diametro = this.radio*2;
    }
    
   public double getRadio(){
       return radio;
   }
   public void setRadio(double radio){
       this.radio = radio>=0?radio:0;
       diametro = this.radio*2;
   }
    public double getDiametro(){
       return diametro;
   }
   public void setDiametro(double diametro){
       this.diametro = diametro>=0?diametro:0;
       radio= this.diametro/2;
   }
      public String getColor(){
       return color;
   }
   public void setColor(String color){
       this.color = color;
   }
   public double calcularArea(){
       return Math.PI*Math.pow(radio,2);
   }
   public double calcularPerimetro(){
       return 2*Math.PI*radio;
   }
   
}
