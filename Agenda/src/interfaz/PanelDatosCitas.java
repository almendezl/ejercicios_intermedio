/*
 *
 */

package interfaz;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import mundo.Cita;
import mundo.Dia;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelDatosCitas extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private static final String AGREGAR = "Agregar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazAgenda principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Etiqueta Fecha
     */
    private JLabel etiquetaFecha;

    /**
     * Etiqueta Hora
     */
    private JLabel etiquetaHora;

    /**
     * Etiqueta Duración
     */
    private JLabel etiquetaDuracion;

    /**
     * Etiqueta Prioridad
     */
    private JLabel etiquetaPrioridad;

    /**
     * Etiqueta Descripción
     */
    private JLabel etiquetaDescripcion;

    /**
     * Es el componente que permite seleccionar una fecha
     */
    private JDateChooser selectorFecha;

    /**
     * Es el combo box donde se seleccionan las horas
     */
    @SuppressWarnings("rawtypes")
    private JComboBox cbbHoras;

    /**
     * Es el combo box donde se seleccionan los minutos
     */
    @SuppressWarnings("rawtypes")
    private JComboBox cbbMinutos;

    /**
     * Es el campo para indicar la duración de la cita
     */
    private JTextField txtDuracion;

    /**
     * Es el radio button para seleccionar prioridad 1
     */
    private JRadioButton radio1;

    /**
     * Es el radio button para seleccionar prioridad 3
     */
    private JRadioButton radio3;

    /**
     * Es el radio button para seleccionar prioridad 5
     */
    private JRadioButton radio5;

    /**
     * Es el radio button para seleccionar prioridad 7
     */
    private JRadioButton radio7;

    /**
     * Es el radio button para seleccionar prioridad 9
     */
    private JRadioButton radio9;

    /**
     * Es el grupo que reúne a los radio buttons que se usan para seleccionar la prioridad
     */
    private ButtonGroup grupoPrioridad;

    /**
     * Es el campo donde se escribe la descripción de una cita
     */
    private JTextArea txtDescripcion;

    /**
     * Es el botón para agregar una cita
     */
    private JButton botonAgregar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel e inicializa sus componentes
     * @param ia Es una referencia a la clase principal de la interfaz
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PanelDatosCitas( InterfazAgenda ia ) {
        principal = ia;
        setBorder( new TitledBorder( "Cita" ) );
        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc;
        // FECHA
        etiquetaFecha = new JLabel( "Fecha" );
        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaFecha, gbc );
        selectorFecha = new JDateChooser( );
        selectorFecha.setEnabled( false );
        gbc = new GridBagConstraints( 1, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( selectorFecha, gbc );
        // Hora
        etiquetaHora = new JLabel( "Hora" );
        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaHora, gbc );
        cbbHoras = new JComboBox( );
        cbbHoras.setEnabled( false );
        gbc = new GridBagConstraints( 1, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( cbbHoras, gbc );
        cbbMinutos = new JComboBox( );
        cbbMinutos.setEnabled( false );
        gbc = new GridBagConstraints( 2, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( cbbMinutos, gbc );
        // Duracion
        etiquetaDuracion = new JLabel( "Duración (en minutos)" );
        gbc = new GridBagConstraints( 0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaDuracion, gbc );
        txtDuracion = new JTextField( );
        txtDuracion.setEnabled( false );
        gbc = new GridBagConstraints( 2, 2, 1, 1, 1, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtDuracion, gbc );
        // Prioridad
        etiquetaPrioridad = new JLabel( "Prioridad" );
        gbc = new GridBagConstraints( 0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaPrioridad, gbc );
        JPanel panelPrioridad = new JPanel( );
        radio1 = new JRadioButton( "1" );
        radio3 = new JRadioButton( "3" );
        radio5 = new JRadioButton( "5" );
        radio5.setSelected( true );
        radio7 = new JRadioButton( "7" );
        radio9 = new JRadioButton( "9" );
        radio1.setEnabled( false );
        radio3.setEnabled( false );
        radio5.setEnabled( false );
        radio7.setEnabled( false );
        radio9.setEnabled( false );
        grupoPrioridad = new ButtonGroup( );
        grupoPrioridad.add( radio1 );
        grupoPrioridad.add( radio3 );
        grupoPrioridad.add( radio5 );
        grupoPrioridad.add( radio7 );
        grupoPrioridad.add( radio9 );
        panelPrioridad.add( radio1 );
        panelPrioridad.add( radio3 );
        panelPrioridad.add( radio5 );
        panelPrioridad.add( radio7 );
        panelPrioridad.add( radio9 );
        gbc = new GridBagConstraints( 1, 3, 2, 1, 1, 0, GridBagConstraints.EAST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( panelPrioridad, gbc );
        // Descripción
        etiquetaDescripcion = new JLabel( "Descripción" );
        gbc = new GridBagConstraints( 0, 4, 1, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaDescripcion, gbc );
        txtDescripcion = new JTextArea( 5, 20 );
        txtDescripcion.setBorder( new LineBorder( Color.BLACK ) );
        txtDescripcion.setWrapStyleWord( true );
        txtDescripcion.setLineWrap( true );
        txtDescripcion.setEnabled( false );
        gbc = new GridBagConstraints( 0, 5, 3, 1, 0, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtDescripcion, gbc );
        // Botón Agregar
        botonAgregar = new JButton( "Agregar" );
        botonAgregar.setEnabled( false );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        gbc = new GridBagConstraints( 0, 6, 3, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonAgregar, gbc );
        // Llenar los comboBox
        for( int i = Dia.PRIMERA_HORA / 100; i < Dia.ULTIMA_HORA / 100; i++ ) {
            cbbHoras.addItem( new Integer( i ) );
        }
        for( int i = 0; i < 60; i++ ) {
            cbbMinutos.addItem( new Integer( i ) );
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Limpia todos los campos
     */
    public void limpiar( ) {
        selectorFecha.setDate( new Date( ) );
        cbbHoras.setSelectedIndex( 0 );
        cbbMinutos.setSelectedIndex( 0 );
        txtDescripcion.setText( "" );
        txtDuracion.setText( "" );
        radio5.setEnabled( true );
    }

    /**
     * Muestra los datos completos de una cita
     * @param fecha La fecha de la cita - fecha!=null
     * @param cita La cita que se va a mostrar - cita!=null
     */
    public void mostrarCita( Date fecha, Cita cita ) {
        selectorFecha.setDate( fecha );
        cbbHoras.setSelectedIndex( cita.darHora( ) / 100 - Dia.PRIMERA_HORA / 100 );
        cbbHoras.setEnabled( false );
        cbbMinutos.setSelectedIndex( cita.darHora( ) % 100 );
        cbbMinutos.setEnabled( false );
        txtDescripcion.setText( cita.darDescripcion( ) );
        txtDescripcion.setEnabled( false );
        txtDuracion.setText( "" + cita.darDuracion( ) );
        txtDuracion.setEnabled( false );
        switch( cita.darPrioridad( ) ) {
            case 1:
                radio1.setSelected( true );
                break;
            case 3:
                radio3.setSelected( true );
                break;
            case 5:
                radio5.setSelected( true );
                break;
            case 7:
                radio7.setSelected( true );
                break;
            case 9:
                radio9.setSelected( true );
                break;
            default:
                radio5.setSelected( true );
        }
        radio1.setEnabled( false );
        radio3.setEnabled( false );
        radio5.setEnabled( false );
        radio7.setEnabled( false );
        radio9.setEnabled( false );
        botonAgregar.setEnabled( false );
    }

    /**
     * Prepara el panel para que se ingresen los datos de una cita
     * @param fecha La fecha a la que se va a agregar la cita - fecha!=null
     */
    public void prepararParaAgregar( Date fecha ) {
        selectorFecha.setEnabled( true );
        selectorFecha.setDate( fecha );
        cbbHoras.setEnabled( true );
        cbbMinutos.setEnabled( true );
        txtDuracion.setEnabled( true );
        txtDescripcion.setEnabled( true );
        radio1.setEnabled( true );
        radio3.setEnabled( true );
        radio5.setEnabled( true );
        radio7.setEnabled( true );
        radio9.setEnabled( true );
        botonAgregar.setEnabled( true );
    }
    
    /**
     * Desactiva el panel de manera que no se puedan ingresar citas
     */
    private void desactivar() {
        limpiar( );
        selectorFecha.setEnabled( false );
        cbbHoras.setEnabled( false );
        cbbMinutos.setEnabled( false );
        txtDuracion.setEnabled( false );
        txtDescripcion.setEnabled( false );
        radio1.setEnabled( false );
        radio3.setEnabled( false );
        radio5.setEnabled( false );
        radio7.setEnabled( false );
        radio9.setEnabled( false );
        botonAgregar.setEnabled( false );
    }

    /**
     * Este método se llama cuando se hace click sobre el botón agregar
     * @param evento Es el evento del click sobre el botón - evento!=null
     */
    public void actionPerformed( ActionEvent evento ) {
        String comando = evento.getActionCommand( );
        if( AGREGAR.equals( comando ) ) {
            try {
                int duracion = Integer.parseInt( txtDuracion.getText( ) );
                Date fechaCita = selectorFecha.getDate( );
                int horas = ( ( Integer )cbbHoras.getSelectedItem( ) ).intValue( );
                int minutos = ( ( Integer )cbbMinutos.getSelectedItem( ) ).intValue( );
                int horaCita = horas * 100 + minutos;
                int prioridad = 0;
                if( radio1.isSelected( ) ) {
                    prioridad = 1;
                }
                else if( radio3.isSelected( ) ) {
                    prioridad = 3;
                }
                else if( radio5.isSelected( ) ) {
                    prioridad = 5;
                }
                else if( radio7.isSelected( ) ) {
                    prioridad = 7;
                }
                else if( radio9.isSelected( ) ) {
                    prioridad = 9;
                }
                String descripcion = txtDescripcion.getText( );
                principal.agregarCita( fechaCita, descripcion, horaCita, duracion, 
                        prioridad );
                desactivar( );
            }
            catch( NumberFormatException nfe ) {
                JOptionPane.showMessageDialog( this, "La duración debe ser un número" );
            }
        }
    }

}
