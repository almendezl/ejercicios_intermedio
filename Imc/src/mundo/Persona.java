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
public class Persona {

    private final String nombre;
    private int edad;
    private String DNI ="" ;
    private char sexo;
    private int peso;
    private double altura;
    /**
     * CONSTANTES
     */
    private final int PESO_IDEAL = -1;
    private final int DEB_PESO = 0;
    private final int SOBREPESO = 1;

    public Persona() {
        this.nombre = "";
        this.sexo = 'M';
        generaDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad >= 0 && edad <= 99 ? edad : 0;
        this.sexo = sexo == 'M' || sexo == 'm'?'M':'F';
        generaDNI();
    }

    public Persona(String nombre, int edad, char sexo, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad >= 0 && edad <= 99 ? edad : 0;
        this.sexo = sexo == 'M'|| sexo == 'm'?'M':'F';
        this.peso = peso >= 1 && peso <= 400 ? peso : 0;
        this.altura = altura >= 0.20 && altura <= 2.50 ? altura : 0.20;
        generaDNI();

    }

    public int calcularIMC() {
        if (peso / Math.pow(altura, 2) < 20) {
            return DEB_PESO;
        } else if (peso / Math.pow(altura, 2) >= 20 || peso / Math.pow(altura, 2) < 25) {
            return PESO_IDEAL;
        } else if (peso / Math.pow(altura, 2) > 25) {
            return SOBREPESO;
        }else return -2;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    private void comprobarSexo() {
        sexo = sexo == 'M' || sexo == 'm'?'M':'F';
    }

    private void generaDNI() {
        final int divisor = 23;
 
        //Generamos un número de 8 digitos
        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
        int res = numDNI - (numDNI / divisor * divisor);
        //Calculamos la letra del DNI
        char letraDNI = generaLetraDNI(res);
 
        //Pasamos el DNI a String
        DNI = Integer.toString(numDNI) + letraDNI;
     
    }
    private char generaLetraDNI(int res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
        return letras[res];
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad >= 0 && edad <= 99 ? edad : 0;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso >= 1 && peso <= 400 ? peso : 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura >= 0.20 && altura <= 2.50 ? altura : 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }

}
