/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import javax.swing.JOptionPane;

/**
 *
 * @author Angie Mendez
 */
public class PruebaNumeros {

    private final Numeros pruebaNumeros;

    public PruebaNumeros() {
        pruebaNumeros = new Numeros();
    }

    public void cambiarNumeros() {
        int entradas[] = new int[pruebaNumeros.cantidadNumeros()];
        for (int i = 0; i < pruebaNumeros.cantidadNumeros(); i++) {
            String nRef = JOptionPane.showInputDialog(null, "Ingrese el numero enteero entre 0 y 100",
                    "Ingreso de numeros", JOptionPane.QUESTION_MESSAGE);
            try {
                int num = Integer.parseInt(nRef);
                if (num < 0 || num > 100) {
                    JOptionPane.showMessageDialog(null, "El numero debe ser entre 0 y 100", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    entradas[i] = num;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El numero debe ser un entero", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            pruebaNumeros.almacenarNumeros(entradas);
        }
    }
    public int darCantidadNumeros(){
        return pruebaNumeros.cantidadNumeros();
    }
    public int[] darNumeros(){
        return pruebaNumeros.darNumeros();
    }
    public void mostrarPromedio(){
        JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron"+ mostrarNumeros() +
                "\nEl promedio es: "+ Integer.toString((int) pruebaNumeros.calcularPromedio()), "Promedio", JOptionPane.INFORMATION_MESSAGE);
    }
public void mostrarCantidadCeros(){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron"+ mostrarNumeros() +
                "La cantidad de ceros es: "+ Integer.toString((int) pruebaNumeros.cantidadCeros()), "Promedio", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarMultiplos(int x){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron: "+
            mostrarNumeros() +
            "La cantidad de multiplos de "+x+ " es: "+
            Integer.toString(pruebaNumeros.multiplosDeN(x)), 
            "Multiplos", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarPares(){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron : "+
            mostrarNumeros() +
            "La cantidad de numeros impares es: "+ Integer.toString(pruebaNumeros.numerosImpares()), 
            "Pares", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarImpares(){
     JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron : "+
            mostrarNumeros() +
            "La cantidad de numeros impares es: "+ Integer.toString(pruebaNumeros.numerosImpares()), 
            "Impares", JOptionPane.INFORMATION_MESSAGE);
}
public  void mostrarMCD(){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron : "+
            mostrarNumeros() +
            "El maximo comun divisor entre el primer y el ultimo numero es : "+
            Integer.toString(pruebaNumeros.mcd()), "MCD", JOptionPane.INFORMATION_MESSAGE);
}
public  void mostrarMCM(){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron : "+
            mostrarNumeros() +
            "El minimo comun multiplo entre el primer y el ultimo numero es : "+
            Integer.toString(pruebaNumeros.mcm()), "MCM", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarMayor(){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron: "+
            mostrarNumeros() +
            "El mayor de los numeros ingresados es : "+ Integer.toString(pruebaNumeros.numeroMayor()),
            "Numero Mayor", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarMenor (){
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron: "+
            mostrarNumeros() +
            "El menor de los numeros ingresados es : "+ Integer.toString(pruebaNumeros.numeroMenor()),
            "Numero Menor", JOptionPane.INFORMATION_MESSAGE);
}
public void mostrarPrimos (){
    int primos [] = new int [pruebaNumeros.cantidadNumeros()];
    int np =0 ;
    primos = pruebaNumeros.numerosPrimos();
    String strPrimos = " ";
    boolean seguir = true;
    while (seguir){
        for (int i = 0; i < primos.length; i++) {
            if(primos[i] > 1){
                strPrimos += primos [i] + " ";
                np++;
            }
            else
                seguir =false;
        }
    }
    JOptionPane.showMessageDialog(null, "Los numeros ingresados fueron "+
            mostrarNumeros() +
            "\nLa cantidad de numeros primos es : "+ np+
            "\nLos numeros primos del conjunto son: "+ strPrimos, 
            "Numeros primos", JOptionPane.INFORMATION_MESSAGE);
}
public String mostrarNumeros (){
    String strNumeros = " ";
    int nums [] = pruebaNumeros.darNumeros();
    for (int i = 0; i < nums.length; i++) {
        strNumeros += nums[i] + " ";
    }
    return strNumeros;
}
    public static void main(String[] args) {
        PruebaNumeros pn = new PruebaNumeros();
        boolean terminar  =  false;
        while (!terminar){
            int sel = Integer.parseInt(JOptionPane.showInputDialog("** PROGRAMA PARA HACER CALCULOS CON CONJUNTO"
                    + "DE NUMEROS"+
                    "\n 1. CAMBIAR NUMEROS \n2. CALCULAR PROMEDIO \n3. CANTIDAD DE CEROS \n4. MULTIPLOS DE X"+
                    "\n5. PARES \n6.IMPARES \n7. MCD \n8.MCM \n9.MAYOR \n10.MENOR \n11. NUEROS PRIMOS \n12. SALIR"));
        switch(sel){
            case 1:
                pn.cambiarNumeros();
                break;
            case 2:
                pn.mostrarPromedio();
                break;
            case 3:
                pn.mostrarCantidadCeros();
                break;
            case 4:
                int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valos a evaluar: "));
                pn.mostrarMultiplos(x);
                break;
            case 5:
                pn.mostrarPares();
                break;
            case 6:
                pn.mostrarImpares();
                break;
            case 7:
                pn.mostrarMCD();
                break;
            case 8:
                pn.mostrarMCM();
                break;
            case 9:
                pn.mostrarMayor();
                break;
            case 10:
                pn.mostrarMenor();
                break;
            case 11:
                pn.mostrarPrimos();
                break;
            case 12:
                terminar = true;
                JOptionPane.showMessageDialog(null, "Gracias por usar este programa", "Fin del programa", JOptionPane.INFORMATION_MESSAGE);
                break;
            default: 
                JOptionPane.showMessageDialog(null, "Ingreso no valido", "Error", JOptionPane.ERROR);
        }
        }
    }
}
