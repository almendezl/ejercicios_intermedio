package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelRetirar extends JPanel {

	private JTextField textField;
	private JButton btnConsignar;
	private JLabel lblValor;

	public PanelRetirar() {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Realizar Retiro")));
		setLayout(null);

		lblValor = new JLabel("Valor: $");
		lblValor.setBounds(10, 35, 45, 20);
		add(lblValor);

		textField = new JTextField();
		textField.setBounds(70, 35, 130, 20);
		add(textField);
		textField.setColumns(10);

		btnConsignar = new JButton("Retirar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double valorretiro = 0;
				valorretiro = Math.abs(Double.parseDouble(textField.getText()));
				
				if(Controlador.portafolio.getCtaAhorro().getSaldo()-valorretiro <= 0.0) {
					JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para retirar ese monto", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					
					Controlador.portafolio.retiroCajeroAhorros(valorretiro);
					JOptionPane.showMessageDialog(null, "Retiro bien hecho");
					textField.setText("");
				}
			}
		});
		btnConsignar.setBounds(410, 35, 160, 20);
		add(btnConsignar);
	}
}
