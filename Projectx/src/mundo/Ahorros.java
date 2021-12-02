package mundo;

import javax.swing.JPanel;

public class Ahorros extends JPanel{
	private int numCta;
	private double saldo;

	public Ahorros() {
		
	}
	
	public Ahorros(int numCta) {
		this.numCta = numCta;
	}

	public void consignar(double vlr) {
		double oper = 0;
		oper = saldo+vlr;
		saldo = oper;
	}

	public void retirar(double vlr) {
		double operac = saldo - vlr - 2000 - (vlr * 4 / 1000);
		saldo = operac;
	}

	public int getNumCta() {
		return numCta;
	}

	public void setNumCta(int numCta) {
		this.numCta = numCta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
