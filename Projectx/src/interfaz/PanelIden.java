package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelIden extends JPanel {
	
	private JTextField txtNombre;
	private JTextField textCedula;
	private JLabel lblNombre;
	private JLabel lblCedula;

	public PanelIden() {

		setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0), new TitledBorder("Información personal")));
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 35, 45, 20);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setText("Simulador");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setBounds(70, 35, 130, 20);
		add(txtNombre);

		lblCedula = new JLabel("Cédula");
		lblCedula.setBounds(230, 35, 45, 20);
		add(lblCedula);

		textCedula = new JTextField();
		textCedula.setText("0000000000");
		textCedula.setBounds(280, 35, 100, 20);
		add(textCedula);
		textCedula.setColumns(10);

		JButton btnOk = new JButton("Crear Portafolio");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String nam="";
				nam=txtNombre.getText();
				
				int ced=0;
				ced=Integer.parseInt( textCedula.getText() );
				Controlador.crearPortafolio(nam, ced);
				
				JOptionPane.showMessageDialog(null, "Portafolio Creado - Su numero de cuenta de ahorros es 999");
			}
		});
		btnOk.setBounds(410, 35, 160, 20);
		add(btnOk);

	}

}
