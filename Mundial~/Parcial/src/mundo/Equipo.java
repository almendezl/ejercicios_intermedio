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
public class Equipo {

    private final String nomEquipo;
    private Jugador jugadores[];
    private Entrenador entrenador;

    public Equipo(String nomEquipo, Jugador[] jugadores, Entrenador entrenador) {
        this.nomEquipo = nomEquipo;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < jugadores.length; i++) {
            salida += "\n" + jugadores[i].toString();
        }

        return "Equipo{" + " Nombre del Equipo -> " + nomEquipo + " " + entrenador + "\n " + salida + '}';
    }

    public String nomTitular() {
        String salida = "";
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getEstadisticas()[0] == 1) {
                if (jugadores[i] instanceof Arquero) {
                    salida += jugadores[i].toString()+"\n";
                } else if (jugadores[i] instanceof Defensa) {
                    salida += jugadores[i].toString()+"\n";
                } else if (jugadores[i] instanceof Medio) {
                    salida += jugadores[i].toString()+"\n";
                } else if (jugadores[i] instanceof Delantero) {
                    salida += jugadores[i].toString()+"\n";
                }
            }
        }

        return "Equipo{" + " Nombre del Equipo -> " + nomEquipo + " " + entrenador + "\n" + salida ;

    }
}
