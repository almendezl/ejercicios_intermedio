package universidad.poo.controlaldor;

import universidad.poo.interfaz.PanelBotones;
import universidad.poo.interfaz.PanelDado;
import universidad.poo.mundo.Dado;


public class Controlador
{
 
 // Atributos de relaci�n
    PanelBotones pnlBotones;
    PanelDado pnlDado;
	
 // Atributos del modelo
    private Dado dado;
        
 // Constructor
    public Controlador()
    { // Instancia el mundo
         dado = new Dado();	 	    
    }

 // Conexi�n con objetos controlables 	
    public void conectar(PanelBotones pnlBotones, PanelDado pnlDado)
    { this.pnlBotones = pnlBotones;
      this.pnlDado = pnlDado;	
    }
	
 // Requerimientos funcionales
    public void hor() { dado.horizontal(); actualizar(); }
    public void ver() { dado.vertical(); actualizar(); }
    public void tra() { dado.transversal(); actualizar(); }
    

//  
    public void actualizar()
    { pnlDado.setI(dado.getIzq()+"");
      pnlDado.setF(dado.getFro()+"");
      pnlDado.setD(dado.getDer()+"");
      pnlDado.setP(dado.getPos()+"");
      pnlDado.setS(dado.getSup()+"");
      pnlDado.setA(dado.getInf()+"");
    }
	
	
}