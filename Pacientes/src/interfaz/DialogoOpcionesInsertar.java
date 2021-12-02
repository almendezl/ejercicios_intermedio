/*
 *
 */

package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class DialogoOpcionesInsertar extends JDialog {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Referencia a la ventana principal de la aplicación
     */
    private InterfazCentralPacientes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    /**
     * Panel con las opciones
     */
    private PanelOpcionesInsertar panelOpciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor del diálogo
     * @param ventana Referencia a la ventana principal de la aplicación - ventana!=null
     */
    public DialogoOpcionesInsertar(InterfazCentralPacientes ventana) {
        super( ventana, true );
        principal = ventana;
        setLayout( new BorderLayout( ) );
        setResizable( false );
        setTitle( "Central de Pacientes" );
        setPreferredSize( new Dimension( 339, 197 ) );
        // Panel con las opciones
        panelOpciones = new PanelOpcionesInsertar( this );
        add( panelOpciones, BorderLayout.NORTH );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Cancela la adición del paciente cerrando el diálogo
     */
    public void cancelar() {
        dispose( );
    }

    /**
     * Muestra el diálogo para proseguir con la adición del paciente
     */
    public void continuarAdicionPaciente() {
        try {
            int forma = panelOpciones.darFormaInsercion( );
            int codigo = panelOpciones.darCodigoPaciente( );
            dispose( );
            principal.mostrarDialogoInsertarPaciente( forma, codigo );
        }
        catch( NumberFormatException e ) {
            JOptionPane.showMessageDialog( this, "El código del paciente con "
                    + "relación al cual se va a realizar la adición debe ser "
                    + "un valor numérico", "Adición Pacientes", 
                    JOptionPane.ERROR_MESSAGE );
        }
    }

}
