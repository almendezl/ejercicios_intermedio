
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
public abstract class Jugador {

    private double[] estadisticas = new double[5];
    private final String nombreJugador;
    private double efectividad;

    public Jugador(String nombreJugador, double estadisticas[]) {

        this.nombreJugador = nombreJugador;
        for (int i = 0; i < estadisticas.length; i++) {
            this.estadisticas[i] = estadisticas[i] < 0 ? 0 : estadisticas[i];

        }
        
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public double[] getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(double[] estadisticas) {
        for (int i = 0; i < estadisticas.length; i++) {
            this.estadisticas[i] = estadisticas[i] < 0 ? 0 : estadisticas[i];

        }
    }

    public double getEfectividad() {
        return efectividad;
    }

    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }

    public abstract void calcularEfectividad();

    @Override
    public String toString() {
        String tit= estadisticas[0]==1.0?"SI":"NO";
        String salida="Numero de goles -> "+estadisticas[1] + "\t";
                salida+="Numero de recuperaciones -> "+estadisticas[2] + "\t";
                salida+="Numero de Asistencias -> "+estadisticas[3] + "\t";
                salida+="Numero de Minutos jugados -> "+estadisticas[4];
        return  " NombreJugador -> " + nombreJugador +" Titular -> "+tit+ " ,Estadisticas: " + salida+ ", Efectividad ->" + efectividad;
    }


}
