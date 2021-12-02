/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Scanner;
import stack.FixedCapacityStack;

/**
 *
 * @author Angie Mendez
 */
public class Interfaz {

    public static void main(String[] args) {
        try {
            Scanner datos = new Scanner(System.in);
            String operacion = datos.nextLine();
            String[] arr;
            arr = operacion.split(" ");
            int parentesis = 0;

            FixedCapacityStack<String> ops = new FixedCapacityStack();
            FixedCapacityStack<Double> vals = new FixedCapacityStack();

            for (String s : arr) {
                //for each porque no usaremos posiciones especificas
                if (s.equals("(")) {
                    parentesis++;
                } else if (s.equals("+")) {
                    ops.push(s);
                } else if (s.equals("-")) {
                    ops.push(s);
                } else if (s.equals("*")) {
                    ops.push(s);
                } else if (s.equals("/")) {
                    ops.push(s);
                } else if (s.equals("sqrt")) {
                    ops.push(s);
                } else if (s.equals(")")) {
                    parentesis++;
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) {
                        v = vals.pop() + v;
                    } else if (op.equals("-")) {
                        v = vals.pop() - v;
                    } else if (op.equals("*")) {
                        v = vals.pop() * v;
                    } else if (op.equals("/")) {
                        v = vals.pop() / v;
                    } else if (op.equals("sqrt")) {
                        v = Math.sqrt(v);
                    }
                    vals.push(v);
                } else {
                    vals.push(Double.parseDouble(s));
                }
            }
            if (parentesis % 2 == 1 || parentesis == 0 || (ops.size() != 0 || vals.size() != 1)) {//cuando no se ingresan parentesis completos de abre y cierra

                System.out.println("ERROR SINTAXIS");
            } else {
                System.out.println(vals.pop());
            }

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR SINTAXIS");
        }
        /**
         * El primero es por error si ingresan algo distinto a numeros lanza
         * esta excepcion cuando se ingresa por ejemplo ( 4 + ) o incompleto
         * porque la pila para hacer la operacion, cuando busca el otro operando
         * llega a una posicion N negativa es decir se sale del arreglo
         */
    }
}
