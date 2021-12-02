package mundo;

import javax.swing.JOptionPane;

public class Portafolio{
	
	private String nombre;
	private double cedula;
	
	private Ahorros ctaAhorro;
	private Sobregiro sbrgiro;

	public Portafolio(String nombre, int cedula) {
		
		this.nombre = nombre;
		this.cedula = cedula;
		
		ctaAhorro = new Ahorros(999);
		sbrgiro = new Sobregiro(500000);
	}
	
	public double consultarSalldoAhorros() {
		double operacion = ctaAhorro.getSaldo()-500;
		ctaAhorro.setSaldo(operacion);
		if (operacion<1000)
		{
			operacion=operacion+1000;
			JOptionPane.showMessageDialog(null,"Error! No es posible realizar esta operación","ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return operacion;	
	}
	
	public void retiroCajeroAhorros(double vlr) {
		ctaAhorro.retirar(vlr);
	}

	public void consignar(double vlr) {
		ctaAhorro.consignar(vlr);
	}

	public void sobregirar(double vlr) {
		sbrgiro.Sobregirar(vlr);
		ctaAhorro.consignar(vlr-3000);
	}

	public void cubrirSobregiro(double vlr) {
		ctaAhorro.retirar(vlr);
		sbrgiro.CubrirSobregiro(vlr);
		
	}
	
	public double consultarCupoSobreGiro() {
		return sbrgiro.getCupo();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCedula() {
		return cedula;
	}

	public void setCedula(double cedula) {
		this.cedula = cedula;
	}

	public Ahorros getCtaAhorro() {
		return ctaAhorro;
	}

	public void setCtaAhorro(Ahorros ctaAhorro) {
		this.ctaAhorro = ctaAhorro;
	}

	public Sobregiro getSbrgiro() {
		return sbrgiro;
	}

	public void setSbrgiro(Sobregiro sbrgiro) {
		this.sbrgiro = sbrgiro;
    }
	
}
