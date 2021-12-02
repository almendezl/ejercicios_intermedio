/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author SG702-21
 */
public class Estudiante extends Persona{
    private double notas[];

    public Estudiante(String identificacion, String nombre, int edad) {
        super(identificacion, nombre, edad);
        notas = new double [4];
    }

    /**
     * @param edad the edad to set
     */
    @Override
    public void setEdad(int edad) {
        this.edad = edad>=15?edad:15;
    }            
    
    /**
     * @return the notas
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(double[] notas) {
        boolean asignar = true;
        for(double n:notas)
            if(n<0.0||n>5.0){
                asignar = false;
                break;
            }
        if(asignar && notas[3]==notaFinal(notas))
            this.notas = notas;
    }
    
    public double getNotas(int corte){
        if(corte>=1&&corte<=4)
            return notas[corte-1];
        else
            return -1.0;
    }
    
    public void setNotas (double nota, int corte){
        if(corte>=1&&corte<=3)
            if(nota>=0.0&&nota<=5.0){
            notas[corte-1]=nota;
            notas[3]=notaFinal(notas);
            }
    }
    
    private double notaFinal(double []notas){
        return notas[0]*0.3+notas[1]*0.3+notas[2]*0.4;
    }
              
}
