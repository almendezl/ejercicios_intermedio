/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Random;

/**
 *
 * @author Angie Mendez
 */
public class GenerarPassword {

    private int numeros;
    private int letras;
    private int longitud;
    private String password;

    public GenerarPassword() {
        password = "";
        if ((this.numeros + this.letras) < 8) {
            longitud = 8;
            this.numeros = 4;
            this.letras = 4;
        } else {
            longitud = this.numeros + this.letras;
        }
    }

    public GenerarPassword(String numeros, String letras) throws NumberFormatException {
        password = "";
        setNumeros(numeros);
        setLetras(letras);
        if ((this.numeros + this.letras) < 8) {
            longitud = 8;
            this.numeros = 4;
            this.letras = 4;
        } else {
            longitud = this.numeros + this.letras;
        }

    }

    public String generarPassword() {
        Random generador = new Random();
        int num = numeros;
        int let = letras;
        while (num > 0 || let > 0) {
            int seleccion = generador.nextInt(2);
            if (seleccion < 1 && let > 0) {
                let--;
                int c = generador.nextInt(61);
                password += Character.toString((char) ('A' + c));
            } else if (num > 0) {
                num--;
                int d = generador.nextInt(10);
                password += String.valueOf(d);
            }
        }
        return password;
    }

    public int getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = Integer.parseInt(numeros);
    }

    public int getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = Integer.parseInt(letras);
    }

    public int getLongitud() {
        return longitud;
    }

}
