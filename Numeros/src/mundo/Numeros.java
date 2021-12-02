
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class Numeros {
    
    public static final int TOT_NUMEROS = 10;
    private int numeros [];
    
    public Numeros(){
        numeros = new int [TOT_NUMEROS];
        for (int i = 0; i < TOT_NUMEROS; i++) {
            numeros[i] = 0;
        }
    }
    public int cantidadNumeros(){
        return  TOT_NUMEROS;
    }
    public void almacenarNumeros(int numeros[]){
        this.numeros = numeros;
    }
    public int [] darNumeros(){
        return numeros;
    }
    public double calcularPromedio(){
        int promedio = 0;
        for (int i = 0; i < TOT_NUMEROS; i++) {
            promedio += numeros[i];
        }
        return promedio/TOT_NUMEROS;
    }
    public int cantidadCeros (){
        int contar =0;
        for (int i = 0; i < TOT_NUMEROS; i++) {
            if(numeros[i] == 0)
                contar++;
        }
        return contar;
    }
    public int multiplosDeN(int n){
        int multiplos = 0;
        for (int i = 0; i < TOT_NUMEROS; i++) {
            if(numeros[i] % n == 0 && numeros[i] != 0){
                multiplos ++;
            }
        }
        return multiplos;
    }
    public int numerosPares(){
        int contarPares = 0;
        for (int i = 0; i < TOT_NUMEROS; i++) {
            if(numeros[i] % 2 == 0){
                contarPares ++;
            }
        }
        return contarPares;
    }
        public int numerosImpares(){
        int contarImpares = 0;
        for (int i = 0; i < TOT_NUMEROS; i++) {
            if(numeros[i] % 2 != 0){
                contarImpares ++;
            }
        }
        return contarImpares;
    }
        public int mcd(){
            int ref1 = numeros[0];
            int ref2 = numeros[TOT_NUMEROS-1];
            while(ref1 != ref2){
                if(ref1 > ref2){
                    ref1 -= ref2;
                }
                else{
                    ref2 -= ref1;
                }
            }
            return ref1;
        }
        public int mcm(){
            int mcm = 0;
            int ref1 = numeros [0];
            int ref2 = numeros[TOT_NUMEROS-1];
            mcm = (ref1 * ref2)/ mcd();
            return mcm;
        }
        public int numeroMayor(){
            int mayor = 0;
            for (int i = 0; i < TOT_NUMEROS; i++) {
                if(numeros[i] > mayor){
                    mayor = numeros[i];
                }
            }
            return mayor;
        }
        public int numeroMenor(){
            int menor = 1000;
            for (int i = 0; i < TOT_NUMEROS; i++) {
                if(numeros[i] < menor){
                    menor = numeros[i];
                } 
            }
            return menor;
        }
        public int[] numerosPrimos(){
            int cont = 0;
            int primos[] = new int [TOT_NUMEROS];
            for (int i = 0; i < TOT_NUMEROS; i++) {
                primos [i] = 0;
            }
            boolean primo = true;
            int ref = 2;
            for (int i = 0; i < TOT_NUMEROS; i++) {
                while(ref < numeros[i] && primo){
                    if(numeros[i] % ref == 0){
                        primo = false;
                    }
                ref ++;
            }
                if(primo && numeros [i] >= 2){
                    primos [cont] = numeros[i];
                    cont ++;
                }
                ref = 2;
                primo = true;
            }
            return primos;
        }
    
}
