package universidad.poo.interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PanelDado extends JPanel
{
 // Atributos de la clase 		
    private JTextField  txtS, txtI, txtF, txtD, txtP, txtA;
    
 // Constructor   
    public PanelDado( )
    {   	
	 // ..............................................( T, L, B, R )..........................................
	    setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "Caras del dado" ) ) );
	    setLayout( null );
	    	
		
		txtS = new JTextField( " S " );	
		txtI = new JTextField( " I " );
		txtF = new JTextField( " F " );
		txtD = new JTextField( " D " );
		txtP = new JTextField( " P " );
		txtA = new JTextField( " A " );
		
		txtS.setBounds(225, 20, 30, 30);
		txtI.setBounds(190, 55, 30, 30);
		txtF.setBounds(225, 55, 30, 30);
		txtD.setBounds(260, 55, 30, 30);
		txtP.setBounds(295, 55, 30, 30);
		txtA.setBounds(225, 90, 30, 30);
		
		
		add(txtS); txtS.setHorizontalAlignment( JTextField.CENTER  ); txtS.setEditable(false);
		add(txtI); txtI.setHorizontalAlignment( JTextField.CENTER  ); txtI.setEditable(false);
		add(txtF); txtF.setHorizontalAlignment( JTextField.CENTER  ); txtF.setEditable(false);
		add(txtD); txtD.setHorizontalAlignment( JTextField.CENTER  ); txtD.setEditable(false);
		add(txtP); txtP.setHorizontalAlignment( JTextField.CENTER  ); txtP.setEditable(false);
		add(txtA); txtA.setHorizontalAlignment( JTextField.CENTER  ); txtA.setEditable(false);
			
    } 

 // Métodos  
    public void setS ( String S ) { txtS.setText(S); }  
    public void setI ( String I ) { txtI.setText(I); }
    public void setF ( String F ) { txtF.setText(F); }
    public void setD ( String D ) { txtD.setText(D); }
    public void setP ( String P ) { txtP.setText(P); }
    public void setA ( String A ) { txtA.setText(A); }
}