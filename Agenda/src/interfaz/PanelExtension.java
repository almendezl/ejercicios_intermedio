/*
 *
 */

package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Jorge A. Arévalo A. - Docente Universidad Piloto de Colombia
 */
public class PanelExtension extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * El comando para el botón 1
     */
    private final String OPCION_1 = "opcion 1";

    /**
     * El comando para el botón 2
     */
    private final String OPCION_2 = "opcion 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Es la referencia a la interfaz de la aplicación
     */
    private InterfazAgenda principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es el botón 1
     */
    private JButton botonOpcion1;

    /**
     * Es el botón 2
     */
    private JButton botonOpcion2;
    
    /**
     * Lista de cantidad de citas
     */
    private JComboBox<Integer> comboCantCitas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye el panel con una referencia a la ventana principal de la aplicación
     * @param ia - Referencia a la ventana principal - ia!=null
     */
    public PanelExtension( InterfazAgenda ia ) {
        principal = ia;
        inicializar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Inicializa los componentes del panel <br>
     * <b>post: </b> Se inicializaron y se ubicaron los componentes del panel <br>
     */
    private void inicializar( ) {
        setBorder( new TitledBorder( "Puntos de Extensión" ) );
        setLayout( new FlowLayout( ) );
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        comboCantCitas = new JComboBox<Integer>();
        comboCantCitas.addItem(1);
        comboCantCitas.addItem(2);
        comboCantCitas.addItem(3);
        comboCantCitas.addItem(4);
        comboCantCitas.addItem(5);
        comboCantCitas.setSelectedItem(comboCantCitas.getComponent(0));
        add( botonOpcion1 );
        add(comboCantCitas);
        add( botonOpcion2 );
    }

    /**
     * Este método se llama cuando se presiona uno de los botones <br>
     * @param evento El evento del click en el botón - evento!=null
     */
    @Override
    public void actionPerformed( ActionEvent evento ) {
        String comando = evento.getActionCommand( );
        if( OPCION_1.equals( comando ) ) {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) ) {
            principal.reqFuncOpcion2(comboCantCitas.getSelectedIndex());
        }
    }

}
