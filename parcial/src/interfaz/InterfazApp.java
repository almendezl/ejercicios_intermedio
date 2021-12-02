package interfaz;

import java.util.Scanner;
import mundo.*;

/**
 *
 * @author Angie Mendez
 */
public class InterfazApp {

    public static void main(String[] args) {
        System.out.println("** BIENVENIDO A LA PLATAFORMA DEL MUNDIAL **");
        Equipo equipos[];
        int nroEquipos;

        Scanner datos = new Scanner(System.in);
        System.out.println("Ingrese el numero de equipos: ");
        nroEquipos = datos.nextInt();
        equipos = new Equipo[nroEquipos];
        
        for (int i = 0; i < equipos.length; i++) {
            String nomEquipo;
            int nroJugadores;
            double parJugados;
            double parGanados;
            Entrenador entrenador;
            Jugador jugadores[];

            System.out.println("Ingrese el nombre del equipo "+(i+1)+" :");
            nomEquipo = datos.next();

            System.out.println("Ingrese el nobre del entrenador: ");
            String nomEntrenador = datos.next();

            System.out.println("Ingrese los partidos Jugados: ");
            parJugados = datos.nextDouble();

            System.out.println("Ingrese los partidos Ganados:");
            parGanados = datos.nextDouble();

            entrenador = new Entrenador(nomEntrenador, parJugados, parGanados);
            

            System.out.println("Ingrese el numero de Jugadores: ");
            nroJugadores = datos.nextInt();
            jugadores = new Jugador[nroJugadores];

            for (int j = 0; j < jugadores.length; j++) {
                System.out.println("Indique el tipo de jugador\n1. para Arquero \n2. para Defensa \n3. para Medio \n4. para Delantero");
                int tipoJug = datos.nextInt();
                System.out.println("Nombre del jugador " + (i + 1) + " :");
                String nomJugador = datos.next();
                double estadisticas[] = llenarEstadisticas();
                
                switch (tipoJug) {
                    case 1:
                        System.out.println("Goles recibidos: ");
                        int golesRec = datos.nextInt();
                        jugadores[j] = new Arquero(golesRec, nomJugador, estadisticas);
                        break;
                    case 2:
                        jugadores[j] = new Defensa(nomJugador, estadisticas);
                        break;
                    case 3:
                        jugadores[j] = new Medio(nomJugador, estadisticas);
                        break;
                    case 4:
                        jugadores[j] = new Delantero(nomJugador, estadisticas);
                        break;
                    default:
                        System.out.println("Error de seleccion de jugador!!");
                        System.exit(0);
                        break;
                }

            }

            equipos[i] = new Equipo(nomEquipo, jugadores, entrenador);
        }
        System.out.println("\n **PLANTILLA GENERAL** ");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i].toString());
        }
        System.out.println(" \n **PLANTILLA TITULAR** ");
        for (int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i].nomTitular());
            
        }
        }
     
    

    public static double[] llenarEstadisticas() {
        double estadisticas[] = new double[5];
        Scanner datos = new Scanner(System.in);

        System.out.println("El jugador es titular ? 1. para SI. 2. para NO ");
        double titular = datos.nextDouble();
        estadisticas[0] = titular;

        System.out.println("Numero de goles: ");
        double numGoles = datos.nextDouble();
        estadisticas[1] = numGoles;

        System.out.println("Numero de Recuperaciones:");
        double nroRec = datos.nextDouble();
        estadisticas[2] = nroRec;

        System.out.println("Numero de Asistencias:");
        double nroAsis = datos.nextDouble();
        estadisticas[3] = nroAsis;

        System.out.println("Minutos Jugados: ");
        double min = datos.nextDouble();
        estadisticas[4] = min;

        return estadisticas;
    }
}
