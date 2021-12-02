package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelConsultaSaldo extends JPanel {

	private JLabel lblSaldoAhorros = null;
	private JLabel lblCupoSobreGiro = null;

	public PanelConsultaSaldo() {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Saldo y consulta")));
		setLayout(null);
		
		lblSaldoAhorros = new JLabel("");
		lblSaldoAhorros.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoAhorros.setBounds(10, 25, 400, 20);
		lblSaldoAhorros.setForeground(new java.awt.Color(66, 149, 77));
		add(lblSaldoAhorros);
		
		lblCupoSobreGiro = new JLabel("");
		lblCupoSobreGiro.setHorizontalAlignment(SwingConstants.LEFT);
		lblCupoSobreGiro.setBounds(10, 55, 400, 20);
		lblCupoSobreGiro.setForeground(new java.awt.Color(66, 149, 77));
		add(lblCupoSobreGiro);
		
		
		//Boton hace que pinte letreros
		JButton btnConsultarSaldo = new JButton("Consultar Saldo y Cupo");
		btnConsultarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double saldo=0;
				saldo=Controlador.portafolio.consultarSalldoAhorros();
				if(saldo<=1000)
				{
					lblSaldoAhorros.setText("");
				}else
				{
				lblSaldoAhorros.setText("Saldo Ahorros: " + Controlador.portafolio.consultarSalldoAhorros());
				}
				lblCupoSobreGiro.setText("Cupo Sobregiro: " + Controlador.portafolio.consultarCupoSobreGiro());
			}
		});
		btnConsultarSaldo.setBounds(410, 40, 180, 20);
		add(btnConsultarSaldo);
	}
	
}
