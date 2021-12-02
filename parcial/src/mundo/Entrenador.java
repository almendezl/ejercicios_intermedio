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
public class Entrenador {
    private final String nombreEntrenador;
    private double parJugados;
    private double parGanados;
    private double efectividad;

    public Entrenador(String nombreEntrenador, double parJugados, double parGanados) {
        this.nombreEntrenador = nombreEntrenador;
        this.parJugados = parJugados>0 &&parJugados>=parGanados?parJugados:0;
        this.parGanados = parGanados>0 && parGanados<=parJugados?parGanados:0;
        if(parJugados != 0){
        this.efectividad = 100*(this.parGanados/this.parJugados); 
        }
        else{
            this.efectividad = 100;
        }
    }

    public double getParJugados() {
        return parJugados;
    }

    public void setParJugados(double parJugados) {
        this.parJugados = parJugados>0 &&parJugados>=parGanados?parJugados:0;
    }

    public double getParGanados() {
        return parGanados;
    }

    public void setParGanados(double parGanados) {
        this.parGanados = parGanados>0 && parGanados<=parJugados?parGanados:0;
    }

    public double getEfectividad() {
        return efectividad;
    }

    @Override
    public String toString() {
        return "Nombre Entrenador -> " + nombreEntrenador + ", Partidos Jugados -> " + parJugados + ", Partidos Ganados -> " + parGanados + ", Efectividad -> " + efectividad + '}';
    }

    
    
    
}
