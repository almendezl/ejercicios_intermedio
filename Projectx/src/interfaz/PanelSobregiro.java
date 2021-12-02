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

public class PanelSobregiro extends JPanel {



	private JTextField textField;
	private JLabel lblValor;
	private JButton btncubrir;
	
	private JTextField textField1;
	private JLabel lblValor1;
	private JButton btnsbre1;

	public PanelSobregiro() {
		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Realizar Sobregiro y Cubrimiento")));
		setLayout(null);
		
		//para sobregirar
		lblValor = new JLabel("Valor: $");
		lblValor.setBounds(10, 35, 45, 20);
		add(lblValor);

		textField = new JTextField();
		textField.setBounds(70, 35, 130, 20);
		add(textField);
		textField.setColumns(10);

		btncubrir = new JButton("Sobregirar");
		btncubrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double valorsobre = 0;
				valorsobre = Math.abs(Double.parseDouble(textField.getText()));
				
				//Validams que pueda sacar de sobregiro hacia la cuenta de los ahorros
				if(Controlador.portafolio.getSbrgiro().getCupo()-valorsobre<=0.00) {
					//fallar por fondos
					JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para sobregirar ese monto", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					Controlador.portafolio.sobregirar(valorsobre);
					JOptionPane.showMessageDialog(null, "Sobregiro bien hecho");
					textField.setText("");
				}
				
			}
		});
		btncubrir.setBounds(410, 35, 160, 20);
		add(btncubrir);
		
		
		
		//para cubrir
		lblValor1 = new JLabel("Valor: $");
		lblValor1.setBounds(10, 65, 45, 20);
		add(lblValor1);

		textField1 = new JTextField();
		textField1.setBounds(70, 65, 130, 20);
		add(textField1);
		textField1.setColumns(10);

		btnsbre1 = new JButton("Cubrir Sobregiro");
		btnsbre1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double valorcubrre = 0;
				valorcubrre = Math.abs(Double.parseDouble(textField1.getText()));
				double cupo=0;
				cupo=Controlador.portafolio.consultarCupoSobreGiro();
				if(cupo==5000000)
				{
					JOptionPane.showMessageDialog(null, "Cupo lleno", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else
				{
				//Validams que pueda retirar de los ahorrosantes de pasar a sobregiro
				if(Controlador.portafolio.getCtaAhorro().getSaldo()-valorcubrre<=0.00) { 
					//fallar por fondos
					JOptionPane.showMessageDialog(null, "No tiene saldo suficiente para realizar el cubrimiento", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					double mount=0;
					mount=valorcubrre+cupo;
					if(mount>500000)
					{
						JOptionPane.showMessageDialog(null, "Esta excediendo el cupo máximo, por favor ingrese un monto válido", "ERROR", JOptionPane.ERROR_MESSAGE);
					}else
					{
					Controlador.portafolio.cubrirSobregiro(valorcubrre);
					JOptionPane.showMessageDialog(null, "Cubrimiento bien hecho");
					textField1.setText("");}
					
				}}
				
				
			}
		});
		btnsbre1.setBounds(410, 65, 160, 20);
		add(btnsbre1);
	}

}
