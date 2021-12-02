package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

public class InterfazApp extends JFrame {
	
	private PanelIden panelIden;
	private PanelConsignar consignar;
	private PanelSobregiro panelSobregiro;
	private PanelConsultaSaldo saldo;
	private PanelRetirar retirar;
	
	private JPanel contentPane;
	private static Controlador controlador;

	public InterfazApp() {
		panelIden = new PanelIden();

		setTitle("Cuenta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelIden = new PanelIden();
		panelIden.setBounds(10, 10, 600, 90);
		contentPane.add(panelIden);

		consignar = new PanelConsignar();
		consignar.setBounds(10, 110, 600, 90);
		contentPane.add(consignar);
		
		retirar = new PanelRetirar();
		retirar.setBounds(10, 210, 600, 90);
		contentPane.add(retirar);
		
		panelSobregiro = new PanelSobregiro();
		panelSobregiro.setBounds(10, 310, 600, 100);
		contentPane.add(panelSobregiro);

		saldo = new PanelConsultaSaldo();
		saldo.setBounds(10, 420, 600, 100);
		contentPane.add(saldo);
		
	}

	//Principal
	public static void main(String[] args) {
		{
			InterfazApp frmMain = new InterfazApp();
			frmMain.setVisible(true);
			controlador = new Controlador();
		}
	}

}
