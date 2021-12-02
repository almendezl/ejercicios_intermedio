/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SG702-21
 */
public class Fecha {
    private int anio;
    private int mes;
    private int dia;    
    
    public Fecha(int anio, int mes, int dia){
        if(anio<=0)
            this.anio=2000;
        else
            this.anio=anio;
        
        this.mes = mes>=1&&mes<=12?mes:1;
        this.dia = dia>=1&&dia<=diasDeMes(mes)?dia:1;                
    }
    
    public int diferencia(Fecha inicio){
        int anios, meses, dias;
        int prestaMes = 0, prestaAnio = 0;
        if(inicio.dia >= this.dia)
            dias = inicio.dia - this.dia;
        else{
            dias = (inicio.dia + 30) - this.dia;
            prestaMes = 1;
        }
        if((this.mes - prestaMes) > inicio.mes)
            meses = (this.mes - prestaMes) - inicio.mes;
        else{
            meses = (this.mes - prestaMes + 12) - inicio.mes;
            prestaAnio = 1;
        }
        anios = (this.anio - prestaAnio) - inicio.anio;
        
        return anios*365+meses*30+dias;
    }
    
    public int diasDeMes(int mes){
        int numDias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        return numDias[mes-1];
    }
    
    public boolean bisiesto(int anio){
        if(anio % 4 == 0)
            if(anio % 100 == 0 && anio % 400 != 0)
                return false;
            else
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
    
    //@Override
    public String toStrings(){
        return "(AAAA/M/D):" + anio + "/" + mes + "/" + dia;
        //return "Año: " + anio + " Mes: " + mes + " Dia: " + dia;
    }
}
