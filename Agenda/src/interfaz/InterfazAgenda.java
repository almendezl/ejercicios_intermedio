/*
 *
 */

package interfaz;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mundo.Agenda;
import mundo.Cita;
import mundo.CitaInexistenteExcepcion;
import mundo.CitaInvalidaExcepcion;
import mundo.Dia;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class InterfazAgenda extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Esta es la agenda que mantiene las citas
     */
    private Agenda agenda;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el panel donde se muestran las citas
     */
    private PanelCitas panelCitas;

    /**
     * Es el panel donde se muestran los datos de una cita
     */
    private PanelDatosCitas panelDatos;

    /**
     * Es el panel donde están los botones para ejecutar los puntos de extensión
     */
    private PanelExtension panelExtension;

    /**
     * Panel con una imagen decorativa
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye la interfaz de la aplicación con la agenda dada
     * @param agnd Es la agenda que se usará en la aplicación - agnd!=null
     */
    public InterfazAgenda( Agenda agnd ) {
        agenda = agnd;
        setLayout( new GridBagLayout( ) );
        GridBagConstraints gbc;
        gbc = new GridBagConstraints( 0, 0, 2, 1, 0, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        panelImagen = new PanelImagen( );
        add( panelImagen, gbc );
        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        panelCitas = new PanelCitas( this );
        Dia dia = agnd.buscarDia( new Date( ) );
        if( dia == null )
            dia = agenda.darPrimerDia( );
        panelCitas.cambiarDia( dia );
        add( panelCitas, gbc );
        gbc = new GridBagConstraints( 1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        panelDatos = new PanelDatosCitas( this );
        getContentPane( ).add( panelDatos, gbc );
        gbc = new GridBagConstraints( 0, 2, 2, 1, 1, 1, GridBagConstraints.CENTER, 
                GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        panelExtension = new PanelExtension( this );
        add( panelExtension, gbc );
        setTitle( "Agenda" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        pack( );
        centrarVentana( );
        setResizable( false );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Centra la ventana en la pantalla
     */
    private void centrarVentana( ) {
        Dimension dPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        Dimension dVentana = getSize( );
        int xEsquina = ( dPantalla.width / 2 ) - ( dVentana.width / 2 );
        int yEsquina = ( dPantalla.height / 2 ) - ( dVentana.height / 2 );
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Agrega una nueva cita <br>
     * @param fechaC Es la fecha en la que se va a crear la cita
     * @param descripcionC La descripción de la cita
     * @param horaC La hora a la que se programó la cita
     * @param duracionC Es la duración (en minutos) que tendrá la cita
     * @param prioridadC Es la prioridad de la cita - prioridadC pertenece a {1,3,5,7,9}
     */
    public void agregarCita( Date fechaC, String descripcionC, int horaC, 
            int duracionC, int prioridadC ) {
        try {
            agenda.agregarCita( fechaC, descripcionC, horaC, duracionC, prioridadC );            
            Dia d = agenda.buscarDia( fechaC );
            panelCitas.cambiarDia( d );
            panelDatos.limpiar( );
            JOptionPane.showMessageDialog( this, "Se agregó exitosamente la cita", 
                    "Cita agregada", JOptionPane.INFORMATION_MESSAGE );
        }
        catch( CitaInvalidaExcepcion e ) {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", 
                    JOptionPane.ERROR_MESSAGE );
        }        
    }

    /**
     * Muestra los datos completos de una cita en el panelDatos
     * @param fecha Es la fecha de la cita que se va a mostrar - fecha!=null
     * @param cita Es la cita que se debe mostrar - cita!=null
     */
    public void mostrarCita( Date fecha, Cita cita ) {
        panelDatos.limpiar( );
        panelDatos.mostrarCita( fecha, cita );
    }

    /**
     * Elimina una cita de un día
     * @param d El día del cual se va a eliminar la cita- d!=null
     * @param hora La hora a la que se encontraba la cita que se va a eliminar
     */
    public void eliminarCita( Dia d, int hora ) {
        try {
            agenda.eliminarCita(d,hora);
            if(d.darCitas( ).size( )==0)
                panelCitas.cambiarDia( agenda.darPrimerDia( ) );
            panelCitas.actualizar( );    
            panelDatos.limpiar( );
        }
        catch( CitaInexistenteExcepcion e ) {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", 
                    JOptionPane.ERROR_MESSAGE );
        }        
    }

    /**
     * Habilita la forma panelDatos para que se agregue una cita
     * @param fecha La fecha inicial para crear la cita - fecha!=null
     */
    public void habilitarFormaAgregar( Date fecha ) {
        panelDatos.limpiar( );
        panelDatos.prepararParaAgregar( fecha );
    }
    
    
    /**
     * Este método se encarga de salvar la información de la agenda, justo antes de cerrar la aplicación
     */
    @Override
    public void dispose( ) {
        try {
           agenda.guardarAgenda( );
            super.dispose( );
        }
        catch( Exception e ) {
            setVisible( true );
            int respuesta = JOptionPane.showConfirmDialog( this, "Problemas salvando la información de la agenda:\n" + e.getMessage( ) + "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION );
            if( respuesta == JOptionPane.YES_OPTION ) {
                super.dispose( );
            }
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Ejecuta el punto de Extensión 1
     */
    public void reqFuncOpcion1( ) {
        String respuesta = agenda.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de Extensión 2
     * @param nCitas Numero limite de citas para eliminar un día
     */
    public void reqFuncOpcion2(int nCitas) {
        String respuesta = agenda.metodo2(nCitas);
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", 
                JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos para la ejecución. No deben usarse
     */
    public static void main(String[] args) {
        try {
            Agenda agenda = new Agenda( "./data/datosAgenda.dat" );
            InterfazAgenda is = new InterfazAgenda( agenda );
            is.setVisible( true );
        }
        catch( Exception e ) {
            e.printStackTrace( );
        }
    }

}
