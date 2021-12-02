/*
 *
 */

package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelJuego extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante que identifica que el usuario quiere ver las pistas de la ciudad
     */
    private static final String PISTAS = "PISTAS";

    /**
     * Constante que identifica que el usuario desea viajar
     */
    private static final String VIAJAR = "VIAJAR";

    /**
     * Acción asociada al botón para expedir una orden de captura
     */
    private static final String EXPEDIR_ORDEN_CAPTURA = "EXPEDIR_ORDEN_CAPTURA";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------
    /**
     * Etiqueta para la imagen de la ciudad
     */
    private JLabel lblImagen;
    /**
     * Botón para poder ver las opciones de viajar a otra ciudad
     */
    private JButton btnViajar;
    /**
     * Botón para poder ver las opciones de las pistas
     */
    private JButton btnPistas;
    /**
     * Botón para poder ver las opciones de orden de captura
     */
    private JButton btnOrdenCaptura;
    /**
     * Área de texto para mostrar la información del caso
     */
    private JTextArea areaCaso;
    /**
     * Scroll para mostrar la información del caso
     */
    private JScrollPane scrollCaso;
    /**
     * Scroll para mostrar la descripción de la ciudad
     */
    private JScrollPane scrollDescripcion;
    /**
     * Etiqueta para el nombre de la ciudad
     */
    private JLabel lblCiudadActual;
    /**
     * Cuadro de texto para la ciudad actual
     */
    private JTextField txtCiudadActual;
    /**
     * Etiqueta para los días faltantes
     */
    private JLabel lblDiasFaltantes;
    /**
     * Cuadro de texto para los días faltantes
     */
    private JTextField txtDiasFaltantes;
    /**
     * Área de texto para la descripción de la ciudad
     */
    private JTextArea areaDescripcion;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Ventana principal de la aplicación
     */
    private InterfazInterpol principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor por parámetros. Inicializa y coloca los componentes gráficos.
     * @param interpol Interfaz principal de la aplicación. Diferente de null.
     */
    public PanelJuego(InterfazInterpol interpol) {
        principal = interpol;
        setLayout(new GridBagLayout());
        lblImagen = new JLabel();
        lblImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.insets = new Insets(5, 5, 5, 5);
        add(lblImagen, constraint);
        areaDescripcion = new JTextArea();
        scrollDescripcion = new JScrollPane(areaDescripcion);
        areaDescripcion.setEditable(false);
        areaDescripcion.setLineWrap(true);
        scrollDescripcion.setPreferredSize(new Dimension(520, 50));
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.insets = new Insets(5, 5, 5, 5);
        add(scrollDescripcion, constraint);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        lblCiudadActual = new JLabel("Ciudad Actual: ");
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel.add(lblCiudadActual, constraint);
        txtCiudadActual = new JTextField();
        txtCiudadActual.setEditable(false);
        txtCiudadActual.setPreferredSize(new Dimension(100, 25));
        constraint = new GridBagConstraints();
        constraint.gridx = 1;
        constraint.gridy = 0;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel.add(txtCiudadActual, constraint);
        lblDiasFaltantes = new JLabel("Días Faltantes: ");
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel.add(lblDiasFaltantes, constraint);
        txtDiasFaltantes = new JTextField();
        txtDiasFaltantes.setEditable(false);
        txtDiasFaltantes.setPreferredSize(new Dimension(100, 25));
        constraint = new GridBagConstraints();
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel.add(txtDiasFaltantes, constraint);
        areaCaso = new JTextArea();
        scrollCaso = new JScrollPane(areaCaso);
        scrollCaso.setPreferredSize(new Dimension(100, 100));
        scrollCaso.setBorder(BorderFactory.createTitledBorder("Caso Actual:"));
        areaCaso.setEditable(false);
        areaCaso.setLineWrap(true);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        constraint.fill = GridBagConstraints.BOTH;
        constraint.insets = new Insets(5, 5, 5, 5);
        panel.add(scrollCaso, constraint);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 3;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        btnPistas = new JButton("Ver Pistas");
        btnPistas.setActionCommand(PISTAS);
        btnPistas.addActionListener(this);
        btnPistas.setPreferredSize(new Dimension(100, 25));
        btnPistas.setEnabled(false);
        panel.add(btnPistas, constraint);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 4;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        btnViajar = new JButton("Viajar");
        btnViajar.setActionCommand(VIAJAR);
        btnViajar.addActionListener(this);
        btnViajar.setPreferredSize(new Dimension(100, 25));
        btnViajar.setEnabled(false);
        panel.add(btnViajar, constraint);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 5;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        btnOrdenCaptura = new JButton("Expedir Orden de Captura");
        btnOrdenCaptura.setActionCommand(EXPEDIR_ORDEN_CAPTURA);
        btnOrdenCaptura.addActionListener(this);
        btnOrdenCaptura.setPreferredSize(new Dimension(100, 25));
        btnOrdenCaptura.setEnabled(false);
        panel.add(btnOrdenCaptura, constraint);
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 6;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 7;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 8;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 9;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 10;
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.fill = GridBagConstraints.BOTH;
        constraint.gridwidth = 2;
        constraint = new GridBagConstraints();
        constraint.gridx = 1;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        constraint.insets = new Insets(5, 10, 5, 10);
        constraint.fill = GridBagConstraints.BOTH;
        add(panel, constraint);
        setVisible(false);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cambia los componentes gráficos de acuerdo al estado del mundo.
     */
    public void actualizar() {
        setVisible(true);
        lblImagen.setIcon(new ImageIcon("./data/imagenes/" + 
                principal.darCiudadActual().darNombreCiudad() + ".jpg"));
        btnPistas.setEnabled(true);
        btnViajar.setEnabled(true);
        btnOrdenCaptura.setEnabled(true);
        areaDescripcion.setText(principal.darCiudadActual().darDescripcion());
        areaCaso.setText(principal.mostrarCaso());
        txtCiudadActual.setText(principal.darCiudadActual().darNombreCiudad());
        txtDiasFaltantes.setText("" + principal.darDiasFaltantes());
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals(PISTAS)) {
            principal.mostrarPistas();
        }
        else if(comando.equals(VIAJAR)) {
            principal.mostrarViajes();
        }
        else if(comando.equals(EXPEDIR_ORDEN_CAPTURA)) {
            principal.mostrarDialogoExpedirOrdenCaptura();
        }
    }

    /**
     * Cambia los días faltantes en la interfaz.
     */
    public void actualizarDiasFaltantes() {
        txtDiasFaltantes.setText( "" + principal.darDiasFaltantes());
    }

    /**
     * Oculta los botones de acuerdo al estado del mundo.
     */
    public void ocultarBotones() {
        btnPistas.setEnabled(false);
        btnViajar.setEnabled(false);
        btnOrdenCaptura.setEnabled(false);
    }

}
