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
public class Area {

    private double lado;
    private double base1;
    private double base2;
    private double altura;
    private double radio1;
    private double radio2;

    public Area() {

    }

    public Area(double lado, double base, double base2, double altura, double radio, double radio2) {
        setLado(lado);
        setBase1(base);
        setBase2(base2);
        setAltura(altura);
        setRadio1(radio);
        setRadio2(radio2);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado > 0 ? lado : 0;
    }

    public double getBase1() {
        return base1;
    }

    public void setBase1(double base1) {
        this.base1 = base1 > 0 ? base1 : 0;
    }

    public double getBase2() {
        return base2;
    }

    public void setBase2(double base2) {
        this.base2 = base2 > 0 ? base2 : 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura > 0 ? altura : 0;
    }

    public double getRadio1() {
        return radio1;
    }

    public void setRadio1(double radio1) {
        this.radio1 = radio1 > 0 ? radio1 : 0;
    }

    public double getRadio2() {
        return radio2;
    }

    public void setRadio2(double radio2) {
        this.radio2 = radio2 > 0 ? radio2 : 0;
    }

    public double cuadrado() {
        return Math.pow(lado, 2);
    }

    public double rectangulo() {
        return lado * base1;
    }

    public double paralelogramo() {
        return base1 * altura;
    }

    public double trapecio() {
        return (altura * (base1 + base2)) / 2;
    }

    public double circulo() {
        return Math.PI * Math.pow(radio1, 2);
    }

    public double triangulo() {
        return (base1 * altura) / 2;
    }

    public double elipse() {
        return Math.PI * radio1 * radio2;
    }

    public double cubo() {
        return 6 * Math.pow(lado, 2);
    }

    public double esfera() {
        return 4 * Math.PI * Math.pow(radio1, 2);
    }
}
