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
public class Arquero extends Jugador {

    private int golesRecibidos;

    public Arquero(int golesRecibidos, String nombreJugador, double[] estadisticas) {
        super(nombreJugador, estadisticas);
        this.golesRecibidos = golesRecibidos < 0 ? 0 : golesRecibidos;
        calcularEfectividad();
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos < 0 ? 0 : golesRecibidos;
    }

    @Override
    public void calcularEfectividad() {
        if (golesRecibidos == 0) {
            super.setEfectividad(100);
        } else {
            super.setEfectividad((super.getEstadisticas()[4] / golesRecibidos));
        }
        
    }

    @Override
    public String toString() {
        return "Arquero{" +super.toString()+ " Goles Recibidos ->" + golesRecibidos + '}';
    }
    

}
