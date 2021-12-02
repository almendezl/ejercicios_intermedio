package controlador;
import mundo.Portafolio;

public class Controlador {
	
	public static Portafolio portafolio = null; //Portafoolio a creaar
	
	public static void crearPortafolio(String nombre, int cedula){
		portafolio = new Portafolio(nombre , cedula);
		//Portafoolio creado por el boton
	}
	
}
	























//	public static void main(String[] args) {
		
//		System.out.println("El cupo de sobre giro:" + portafolio.getSbrgiro().getCupo());
//		
//		portafolio.consignar(500000);
//		System.out.println("El saldo de cuenta de ahorros es: " + portafolio.consultarSalldoAhorros());
//		portafolio.setNombre(null);
//		portafolio.retiroCajeroAhorros(200000);
//		System.out.println("el nuevo saldo de la cuenta de ahorros es: " + portafolio.consultarSalldoAhorros());
//		System.out.println("el saldo de la cuenta de  ahorros es:" + portafolio.getCtaAhorro().getSaldo());
		//portafolio.sobregirar(50000);
		//portafolio.consignar();
		//System.out.println("el saldo de la cuenta de ahorros es: " + portafolio.consultarSalldoAhorros());
		//System.out.println("el cupo del sobre giro es: "+ portafolio.getSbrgiro().getCupo());
		
//	}
//}
