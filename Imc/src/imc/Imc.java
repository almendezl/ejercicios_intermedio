/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imc;

import java.util.Scanner;
import javax.swing.JOptionPane;
import mundo.Persona;

/**
 *
 * @author Angie Mendez
 */
public class Imc {

    public static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre;
        int edad;
        int peso;
        double altura;
        char sexo;
        nombre = JOptionPane.showInputDialog("Ingrese el nombre");
        edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad"));
        sexo = JOptionPane.showInputDialog(null, "Ingrese el sexo M -F ").charAt(0);
        peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el peso"));
        altura = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la altura"));

        Persona persona = new Persona(nombre, edad, sexo, peso, altura);
        String imc;
        if (persona.calcularIMC() == 0) {
            imc = "Debajo de su Peso ideal";
        } else if (persona.calcularIMC() == -1) {
            imc = "Peso Ideal";
        } else if (persona.calcularIMC() == 1) {
            imc = "Sobrepeso";
        }
        else
            imc = "Error";
        JOptionPane.showMessageDialog(null, persona.toString()+ "IMC: "+imc, "Informacion", JOptionPane.INFORMATION_MESSAGE);

    }
}
