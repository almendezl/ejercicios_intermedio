package universidad.poo.interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import universidad.poo.controlaldor.Controlador;

public class PanelBotones extends JPanel implements ActionListener
{
 // Atributos de la clase 	
    private JButton btnHor, btnVer, btnTra;
    
 // Atributos de relación
    private Controlador ctrl;
	
 // Constructor   
    public PanelBotones( Controlador ctrl )
    {   	
     // ..............................................( T, L, B, R )..........................................
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "  Giros " ) ) );
	 
     // Define el esquema de organización.   
        setLayout( new FlowLayout() );
	    
     // Integra el controlador. 
        this.ctrl = ctrl;
	    
     // Instancia los botones.   
        btnHor = new JButton( "Horizontal" );
        btnHor.setActionCommand( "Horizontal" );
        btnHor.addActionListener( this );
        
        btnVer = new JButton( "Vertical" );
        btnVer.setActionCommand( "Vertical" );
        btnVer.addActionListener( this );

        btnTra = new JButton( "Transversal" );
        btnTra.setActionCommand( "Transversal" );
        btnTra.addActionListener( this );
        
     // Agrega los botones al panel.   
    	add( btnHor );
	add( btnVer );
	add( btnTra );
	
    } 

    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( comando.equals( "Horizontal" ) )
        {   ctrl.hor();          
        }
        else if( comando.equals( "Vertical" ) )
        {   ctrl.ver();        
        }
        else if( comando.equals( "Transversal" ) )
        {   ctrl.tra();     
        }        
    }

}