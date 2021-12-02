/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Angie Mendez
 */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;
    
    public Fecha(int dia, int mes, int anio){
        this.anio = anio;
        if (mes>0 && mes <=12)
            this.mes = mes;
        else
            this.mes = 0;
        this.dia = dia;
        
    }
    public int diferencia(Fecha inicio, Fecha fin){
        
        int d, m,a;
        d = fin.dia-inicio.dia;
        m = fin.mes-inicio.mes;
        a = fin.anio-inicio.anio;
        if (d>30){
            d += 30;
            m -= 1;
        }
        if(m>12){
            m += 12;
            a -= 1;
        }
        return a*365+3*30+d;
        
    }
    public boolean bisiesto(int anio){
        if(anio%4 == 0 && anio%100 !=0 && anio%400 !=0)
            return true;
        else
            return false;
    }
    public int getAnio(){
        return anio;
    }
    public void setAnio(int anio){
        this.anio = anio;
    }
    public int getMes(){
        return mes;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public int getDia(){
        return dia;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
        @Override
    public String toString(){
       return "Año: "+ anio+" Mes: "+mes +" Dia: "+ dia;
    }
}
