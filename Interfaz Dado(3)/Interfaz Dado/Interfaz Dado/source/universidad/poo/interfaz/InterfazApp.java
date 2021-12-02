package universidad.poo.interfaz;

import java.awt.*;
import javax.swing.*;

import universidad.poo.controlaldor.Controlador;
import universidad.poo.mundo.Dado;
import universidad.poo.window.Win;

public class InterfazApp extends JFrame
{   

//  Atributos de la clase
    private PanelBotones pnlBotones;
    private PanelDado pnlDado;
    private Dado dado;
    private Controlador ctrl;
    
//  Constructor
    public InterfazApp( Controlador ctrl ) 
    { 
   // Caracteristicas de la ventana. 	
      setTitle( "Implementación Dado." );   
      setSize( 500, 225 );      
      setResizable( false );
      this.setAlwaysOnTop(true);
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  	
   // Interga el Controlador
      this.ctrl = ctrl;
      
   // Instancia los paneles. 
      pnlBotones = new PanelBotones( ctrl ); 	  
      pnlDado	 = new PanelDado( );
   	  	
   // Organiza el panel principal.
      getContentPane( ).setLayout( new BorderLayout( ) );

      getContentPane( ).add( pnlBotones, BorderLayout.NORTH );
      getContentPane( ).add( pnlDado, BorderLayout.CENTER );
    
      ctrl.conectar(pnlBotones, pnlDado);
      ctrl.actualizar();
      
  //  Centrar ventana.
      Win.centerWindow( this );       
    }    
    

    
    
    
//  Ejecuci�n.		
    public static void main(String args[])
    { InterfazApp frmMain = new InterfazApp(new Controlador() );
      frmMain.setVisible( true );	  	  
    }
		
}