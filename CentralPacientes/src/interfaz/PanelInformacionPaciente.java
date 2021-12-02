/*
 *
 */

package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import mundo.Paciente;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelInformacionPaciente extends JPanel {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Representa el genero del paciente
     */
    public static final String MASCULINO = "Masculino";

    /**
     * Representa el genero del paciente
     */
    public static final String FEMENINO = "Femenino";

    /**
     * Representa el genero del paciente
     */
    public static final String ALTA = "Alta";

    /**
     * Representa el genero del paciente
     */
    public static final String MEDIA = "Media";

    /**
     * Representa el genero del paciente
     */
    public static final String BAJA = "Baja";

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Texto para el nombre del paciente
     */
    private JTextField textoNombre;

    /**
     * Texto para el código del paciente
     */
    private JTextField textoCodigo;

    /**
     * Combo para las clínicas del paciente
     */
    @SuppressWarnings("rawtypes")
    private JComboBox comboClinicas;

    /**
     * Botón para el género del paciente
     */
    private JRadioButton botonMasculino;

    /**
     * Botón para el género del paciente
     */
    private JRadioButton botonFemenino;

    /**
     * Botón para la prioridad del paciente
     */
    private JRadioButton botonAlta;

    /**
     * Botón para la prioridad del paciente
     */
    private JRadioButton botonMedia;

    /**
     * Botón para la prioridad del paciente
     */
    private JRadioButton botonBaja;

    /**
     * Área para la información médica del paciente
     */
    private JTextArea areaInformacionMedica;

    /**
     * Grupo para los botones del género
     */
    private ButtonGroup grupo;

    /**
     * Grupo para los botones del género
     */
    private ButtonGroup grupoP;

    /**
     * Etiqueta para la clínica
     */
    private JLabel etiquetaClinica;

    /**
     * Etiqueta para el género
     */
    private JLabel etiquetaSexo;

    /**
     * Etiqueta para la prioridad
     */
    private JLabel etiquetaPrioridad;

    /**
     * Etiqueta para la historia
     */
    private JLabel etiquetaHistoriaClinica;

    /**
     * Etiqueta para el nombre
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta para el código
     */
    private JLabel etiquetaCodigo;

    /**
     * Barra de desplazamiento para la área de la historia
     */
    private JScrollPane barraDesplazamientoAreaHistoria;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del panel
     */
    @SuppressWarnings("rawtypes")
	public PanelInformacionPaciente() {
        setLayout( new GridBagLayout( ) );
        setBorder( new TitledBorder( "Información del Paciente" ) );
        // Nombre del paciente
        etiquetaNombre = new JLabel( "Nombre" );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaNombre, gbc );
        textoNombre = new JTextField( );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add( textoNombre, gbc );
        // Cédula del paciente
        etiquetaCodigo = new JLabel( "Código" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaCodigo, gbc );
        textoCodigo = new JTextField( );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        add( textoCodigo, gbc );
        // Clínica asignada al paciente
        etiquetaClinica = new JLabel( "Clínica" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaClinica, gbc );
        comboClinicas = new JComboBox( );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        add( comboClinicas, gbc );
        // Sexo del paciente
        etiquetaSexo = new JLabel( "Sexo" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaSexo, gbc );
        botonMasculino = new JRadioButton( MASCULINO );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        botonMasculino.setSelected( true );
        add( botonMasculino, gbc );
        botonFemenino = new JRadioButton( FEMENINO );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add( botonFemenino, gbc );
        grupo = new ButtonGroup( );
        grupo.add( botonMasculino );
        grupo.add( botonFemenino );
        // Prioridad del paciente
        etiquetaPrioridad = new JLabel( "Prioridad" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaPrioridad, gbc );
        botonAlta = new JRadioButton( ALTA );
        gbc = new GridBagConstraints( );
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        botonAlta.setSelected( true );
        add( botonAlta, gbc );
        botonMedia = new JRadioButton( MEDIA );
        gbc = new GridBagConstraints( );
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add( botonMedia, gbc );
        botonBaja = new JRadioButton( BAJA );
        gbc = new GridBagConstraints( );
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add( botonBaja, gbc );
        grupoP = new ButtonGroup( );
        grupoP.add( botonAlta );
        grupoP.add( botonMedia );
        grupoP.add( botonBaja );
        // Información médica del paciente
        etiquetaHistoriaClinica = new JLabel( "Información Médica" );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        add( etiquetaHistoriaClinica, gbc );
        areaInformacionMedica = new JTextArea( );
        areaInformacionMedica.setLineWrap( true );
        areaInformacionMedica.setWrapStyleWord( true );
        barraDesplazamientoAreaHistoria = new JScrollPane( areaInformacionMedica );
        barraDesplazamientoAreaHistoria.setPreferredSize( new Dimension( 200, 110 ) );
        gbc = new GridBagConstraints( );
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;
        add( barraDesplazamientoAreaHistoria, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cambia la información del combo de clínicas con la lista de clínicas en la lista dada
     * @param clinicas Nueva lista de clínicas. clinicas!=null
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void cambiarInformacionComboClinicas( ArrayList clinicas ) {
        comboClinicas.removeAllItems( );
        for( int cont = 0; cont < clinicas.size( ); cont++ ) {
            comboClinicas.addItem( clinicas.get( cont ) );
        }
        comboClinicas.setSelectedIndex( -1 );
    }

    /**
     * Habilita el área en la que se muestra la información médica del paciente
     * 
     */
    public void habilitarAreaInformacionMedica( ) {
        areaInformacionMedica.setEditable( true );
    }

    /**
     * Habilita todos los componentes del panel
     * 
     */
    public void habilitarComponentes( ) {
        textoCodigo.setEditable( true );
        textoNombre.setEditable( true );
        botonFemenino.setEnabled( true );
        botonMasculino.setEnabled( true );
        botonAlta.setEnabled(true);
        botonMedia.setEnabled(true);
        botonBaja.setEnabled(true);
        areaInformacionMedica.setEditable( true );
        comboClinicas.setEnabled( true );
    }

    /**
     * Deshabilita todos los componentes del panel
     * 
     */
    public void deshabilitarComponentes( ) {
        textoCodigo.setEditable( false );
        textoNombre.setEditable( false );
        botonFemenino.setEnabled( false );
        botonMasculino.setEnabled( false );
        botonAlta.setEnabled(false);
        botonMedia.setEnabled(false);
        botonBaja.setEnabled(false);
        areaInformacionMedica.setEditable( false );
        comboClinicas.setEnabled( false );
    }

    /**
     * Retorna el código del paciente que se va a insertar
     * @return El código del paciente a ser insertado
     * @throws NumberFormatException Si el cédula ingresada por el usuario no es un número
     */
    public int darCodigoPaciente() throws NumberFormatException {
        String cadena = textoCodigo.getText( );
        int ced = Integer.parseInt( cadena );
        return ced;
    }

    /**
     * Retorna el nombre del paciente que se va a insertar
     * @return El nombre del paciente que se va a insertar
     */
    public String darNombrePaciente() {
        return textoNombre.getText( );
    }

    /**
     * Retorna la clínica del paciente que se va a insertar
     * @return La clínica del paciente que se va a insertar
     */
    public String darClinicaPaciente() {
        return ( String )comboClinicas.getSelectedItem( );
    }

    /**
     * Retorna el sexo del paciente que se va a insertar
     * @return El sexo del paciente que se va a insertar
     */
    public int darSexoPaciente() {
        return botonFemenino.isSelected() ? Paciente.MUJER : Paciente.HOMBRE;
    }

    /**
     * Retorna la prioridad del paciente que se va a insertar
     * @return La prioridad del paciente que se va a insertar
     */
    public int darPrioridadPaciente() {
        return botonAlta.isSelected() ? Paciente.P_ALTA : botonMedia.isSelected() ?
        		Paciente.P_MEDIA : Paciente.P_BAJA;
    }

    /**
     * Retorna la información médica del paciente que se va a insertar
     * @return La información médica del paciente que se va a insertar
     */
    public String darInformacionMedicaPaciente() {
        return areaInformacionMedica.getText();
    }

    /**
     * Muestra la información del paciente
     * @param paciente Paciente del que se va a mostrar la información - paciente!=null
     */
    public void mostrarInformacionPaciente(Paciente paciente) {
        textoNombre.setText( paciente.darNombre( ) );
        textoCodigo.setText( Integer.toString( paciente.darCodigo( ) ) );
        areaInformacionMedica.setText( paciente.darInformacionMedica( ) );
        comboClinicas.setSelectedItem( paciente.darClinica( ) );

        if( paciente.darSexo( ) == Paciente.HOMBRE )
        {
            botonMasculino.setSelected( true );
        }
        else
        {
            botonFemenino.setSelected( true );
        }
    }

}
