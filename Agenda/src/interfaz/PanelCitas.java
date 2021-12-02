/*
 *
 */

package interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import mundo.Cita;
import mundo.Dia;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelCitas extends JPanel implements ActionListener, 
        ListSelectionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private static final String AGREGAR = "Agregar";

    private static final String ELIMINAR = "Eliminar";

    private static final String ADELANTE = "Adelante";

    private static final String ATRAS = "Atrás";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es una referencia al día que se está mostrando
     */
    private Dia dia;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el objeto encargado de formatear las fechas
     */
    private SimpleDateFormat sdf;

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazAgenda principal;

    /**
     * Es el borde del panel
     */
    private TitledBorder borde;

    /**
     * Es la lista donde se muestran las citas
     */
    @SuppressWarnings("rawtypes")
    private JList listaCitas;

    /**
     * Es el botón para pasar al día anterior
     */
    private JButton botonAtras;

    /**
     * Es el botón para pasar al día siguiente
     */
    private JButton botonAdelante;

    /**
     * Es el botón para agregar una cita
     */
    private JButton botonAgregar;

    /**
     * Es el botón para eliminar una cita
     */
    private JButton botonEliminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel con la las referencias suministradas
     * @param ia Es una referencia a la clase principal de la interfaz - ia!=null
     */
    @SuppressWarnings("rawtypes")
    public PanelCitas( InterfazAgenda ia ) {
        principal = ia;
        Font fuente = new Font( "Courier", Font.BOLD, 14 );
        setPreferredSize( new Dimension( 350, 300 ) );
        sdf = new SimpleDateFormat( "EEEEEEEEE dd/MMM/yyyy" );
        borde = new TitledBorder( "" );
        setBorder( borde );
        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc;
        JScrollPane scroll = new JScrollPane( );
        listaCitas = new JList( );
        listaCitas.addListSelectionListener( this );
        scroll.getViewport( ).add( listaCitas );
        gbc = new GridBagConstraints( 0, 0, 4, 1, 0, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 5, 5 );
        add( scroll, gbc );
        JPanel panelAvance = new JPanel( );
        panelAvance.setLayout( new GridBagLayout( ) );
        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, 
                GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonAtras = new JButton( "<--" );
        botonAtras.setFont( fuente );
        botonAtras.setActionCommand( ATRAS );
        botonAtras.addActionListener( this );
        panelAvance.add( botonAtras, gbc );
        gbc = new GridBagConstraints( 3, 1, 1, 1, 0, 0, GridBagConstraints.EAST, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonAdelante = new JButton( "-->" );
        botonAdelante.setFont( fuente );
        botonAdelante.setActionCommand( ADELANTE );
        botonAdelante.addActionListener( this );
        panelAvance.add( botonAdelante, gbc );
        gbc = new GridBagConstraints( 0, 1, 4, 1, 0, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( panelAvance, gbc );
        gbc = new GridBagConstraints( 0, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonAgregar = new JButton( "Agregar Cita" );
        botonAgregar.setActionCommand( AGREGAR );
        botonAgregar.addActionListener( this );
        add( botonAgregar, gbc );
        gbc = new GridBagConstraints( 2, 2, 2, 1, 1, 0, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        botonEliminar = new JButton( "Eliminar Cita" );
        botonEliminar.setActionCommand( ELIMINAR );
        botonEliminar.addActionListener( this );
        add( botonEliminar, gbc );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cambia el día que se está mostrando
     * @param d El día que se va a mostrar - d!=null
     */
    public void cambiarDia( Dia d ) {
        dia = d;
        actualizar( );
    }

    /**
     * Actualiza las citas mostradas para el día actual y habilita o deshabilita los botones según sea necesario
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void actualizar( ) {
        if(dia==null) {
            botonAdelante.setEnabled( false );
            botonAtras.setEnabled( false );
            listaCitas.removeAll( );
            listaCitas.setListData( new ArrayList().toArray( ) );
            borde.setTitle( "No hay citas registradas en la agenda" );
            setBorder( null );
            setBorder( borde );
            return;
        }
        // Actualizar las citas
        listaCitas.setListData( dia.darCitas( ).toArray( ) );
        // Habilitar / Deshabilitar el botón para avanzar
        if( dia.darSiguiente( ) == null ) {
            botonAdelante.setEnabled( false );
        }
        else {
            botonAdelante.setEnabled( true );
        }
        // Habilitar / Deshabilitar el botón para retroceder
        if( dia.darAnterior( ) == null ) {
            botonAtras.setEnabled( false );
        }
        else {
            botonAtras.setEnabled( true );
        }
        // Actualizar la fecha mostrada en el borde
        borde.setTitle( sdf.format( dia.darFecha( ) ) );
        setBorder( null );
        setBorder( borde );
    }

    /**
     * Avanza la agenda al siguiente día con citas
     */
    private void avanzar( ) {
        if( dia.darSiguiente( ) != null ) {
            Dia d = dia.darSiguiente( );
            cambiarDia( d );
        }
    }

    /**
     * Regresa la agenda al anterior día con citas
     */
    private void regresar( ) {
        if( dia.darAnterior( ) != null ) {
            Dia d = dia.darAnterior( );
            cambiarDia( d );
        }
    }

    /**
     * Este método se ejecuta cuando se hace click sobre uno de los botones
     * @param evento El evento de click sobre un botón - evento!=null
     */
    @Override
    public void actionPerformed( ActionEvent evento ) {
        String comando = evento.getActionCommand( );
        if( ADELANTE.equals( comando ) ) {
            avanzar( );
        }
        else if( ATRAS.equals( comando ) ) {
            regresar( );
        }
        else if( ELIMINAR.equals( comando ) ) {
            if( listaCitas.getSelectedIndex( ) != -1 ) {
                Cita cita = ( Cita )listaCitas.getSelectedValue( );
                principal.eliminarCita( dia, cita.darHora( ) );
            }
        }
        else if( AGREGAR.equals( comando ) ) {
            if(dia==null)
                principal.habilitarFormaAgregar( new Date() );
            else
                principal.habilitarFormaAgregar( dia.darFecha( ) );
        }
    }

    /**
     * Este es el método que se llama cuando se cambia la cita seleccionada
     * @param e El evento del cambio en la cita seleccionado - evento!=null
     */
    @Override
    public void valueChanged( ListSelectionEvent e ) {
        Cita cita = ( Cita )listaCitas.getSelectedValue( );
        if( cita != null )
            principal.mostrarCita( dia.darFecha( ), cita );
    }

}
