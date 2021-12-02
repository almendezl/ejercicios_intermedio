package mundo;


public class Sobregiro {
	private double cupo = 0;

	public Sobregiro() {
	}

	public Sobregiro(double cupo) {
		this.cupo = cupo;
	}

	public void Sobregirar(double vlr) {
		double operr = cupo - vlr;
		cupo =  operr;
	}

	public void CubrirSobregiro(double vlr) {
		double operrc = cupo + vlr;
		cupo = operrc;
	}

	public double getCupo() {
		return cupo;
	}

	public void setCupo(double cupo) {
		this.cupo = cupo;
	}

}
