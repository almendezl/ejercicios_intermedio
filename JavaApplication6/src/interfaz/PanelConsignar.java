package interfaz;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelConsignar extends JPanel {
	
	private JTextField textField;
	private JButton btnConsignar;
	private JLabel lblValor;

	public PanelConsignar() {
		
		setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Realizar Consignación" ) ) );
		setLayout(null);
		
		lblValor = new JLabel("Valor: $");
		lblValor.setBounds(10, 35, 45, 20);
		add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(70, 35, 130, 20);
		add(textField);
		textField.setColumns(10);
		
		btnConsignar = new JButton("Consignar");
		btnConsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double valorConsigna = 0;
				valorConsigna = Double.parseDouble(textField.getText());
				if (valorConsigna<0)
				{
					JOptionPane.showMessageDialog(null,"Error! No es posible consigna un saldo negativo","ERROR", JOptionPane.ERROR_MESSAGE);
				}else
				{
				Controlador.portafolio.consignar(valorConsigna);
				
				JOptionPane.showMessageDialog(null, "Consignación bien hecha");
				textField.setText("");
				}
				
			}
		});
		btnConsignar.setBounds(410, 35, 160, 20);
		add(btnConsignar);
	}
	
}
