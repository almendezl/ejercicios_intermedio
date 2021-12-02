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
public class Defensa extends Jugador {

    public Defensa(String nombreJugador, double[] estadisticas) {
        super(nombreJugador, estadisticas);
        calcularEfectividad();
    }

    @Override
    public void calcularEfectividad() {
        if (super.getEstadisticas()[4] == 0) {

        } else {
            super.setEfectividad(super.getEstadisticas()[2] / super.getEstadisticas()[4]);
        }
    }

    @Override
    public String toString() {
        return "Defensa{" +super.toString()+ '}';
    }


}
