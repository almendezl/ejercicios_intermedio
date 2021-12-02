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
public class Volumen {
    private double lado;
    private double base;
    private double profundidad;
    private double radio1;
    private double radio2;
    private double radio3;
    private double altura;
    
    public Volumen(){
        
    }

    public Volumen(double lado, double base, double profundidad, double radio1, double radio2, double radio3, double altura) {
        setLado(lado);
        setBase(base);
        setProfundidad(profundidad);
        setRadio1(radio1);
        setRadio2(radio2);
        setRadio3(radio3);
        setAltura(altura);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado > 0? lado: 0;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base > 0? base : 0;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad > 0? profundidad : 0;
    }

    public double getRadio1() {
        return radio1;
    }

    public void setRadio1(double radio1) {
        this.radio1 = radio1 > 0? radio1: 0;
    }

    public double getRadio2() {
        return radio2;
    }

    public void setRadio2(double radio2) {
        this.radio2 = radio2 > 0 ? radio2: 0; 
    }

    public double getRadio3() {
        return radio3;
    }

    public void setRadio3(double radio3) {
        this.radio3 = radio3 > 0? radio3 : 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura > 0? altura: 0;
    }
    public double cubo(){
        return Math.pow(lado, 3);
    }
    public double prismaRectangular(){
        return lado * base * profundidad;
    }
    public double cilindro(){
        return Math.PI * Math.pow(radio1, 2) * altura;
    }
    public double cono(){
        return Math.PI * Math.pow(radio1, 2) * altura / 3;
    }
    public double esfera(){
        return 4 * Math.PI * Math.pow(radio1, 3) / 3;
    }
    public double elipsoide(){
        return 4 * Math.PI * radio1 * radio2 * radio3 / 3;
    }
}
